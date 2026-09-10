import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import SubSistemaGestaoFuncionarios.*;
import SubSistemaGestaoTecnicos.*;
import SubSistemaGestaoGestores.*;


public class GesCentroReparacoesLNFacade implements IGesCentroReparacoesLN {

    private int countIDR;
    private Map<String, Equipamento> equipamentos;
    private Map<Long, Cliente> clientes;
    private Map<String, Registo> registos;
    private SubSistemaGestaoFuncionariosFacade funcionariosFacade;
    private SubSistemaGestaoTecnicosFacade tecnicosFacade;
    private SubSistemaGestaoGestoresFacade gestoresFacade;

    public GesCentroReparacoesLNFacade(){
        this.equipamentos = Parser.parseEquipamento();
        this.clientes = Parser.parseCliente();
        this.funcionariosFacade = Parser.parseFuncionario();
        this.tecnicosFacade = Parser.parseTecnico();
        this.gestoresFacade = Parser.parseGestor();
        this.registos = Parser.parseRegisto();
        this.countIDR = Parser.parseCount();
    }

    public void toFile(){
        try{
            PrintWriter pwe = new PrintWriter("equipamentos.txt");
            PrintWriter pwcl = new PrintWriter("clientes.txt");
            PrintWriter pwf = new PrintWriter("funcionarios.txt");
            PrintWriter pwg = new PrintWriter("gestores.txt");
            PrintWriter pwt = new PrintWriter("tecnicos.txt");
            PrintWriter pwr = new PrintWriter("registos.txt");
            PrintWriter pwco = new PrintWriter("count.txt");
            for (Equipamento e : equipamentos.values())
                pwe.print(e.toFile());
            for (Cliente cl : clientes.values())
                pwcl.print(cl.toFile());
            for (Funcionario f : funcionariosFacade.getFuncionarios())
                pwf.print(f.toFile());
            for (Gestor g : gestoresFacade.getGestores())
                pwg.print(g.toFile());
            for (Tecnico t : tecnicosFacade.getTecnicos())
                pwt.print(t.toFile());
            for (Registo r : registos.values()) {
                if (r instanceof RegistoNormal)
                    pwr.print(((RegistoNormal) r).toFile());
                else if (r instanceof RegistoExpresso)
                    pwr.print(((RegistoExpresso) r).toFile());
            }
            pwco.write(countIDR);
            pwe.flush();
            pwe.close();
            pwcl.flush();
            pwcl.close();
            pwf.flush();
            pwf.close();
            pwg.flush();
            pwg.close();
            pwt.flush();
            pwt.close();
            pwr.flush();
            pwr.close();
            pwco.flush();
            pwco.close();
        }catch(FileNotFoundException ex){System.out.println("erro");}

    }

    public List<String> showListGestorReparacoes(int mes) {
        List<String> res = new ArrayList<>();
        Collection<Registo> registosValues = registos.values();

        for (Tecnico t : tecnicosFacade.getTecnicos()) {
            StringBuilder sb = new StringBuilder();
            double count = 0;
            double custoTotal = 0;
            double desvioTotal = 0;
            sb.append(t.getIdTecnico());
            for (Registo r : registosValues) {
                if (r instanceof RegistoNormal
                        && r.getTecnicoReparacao().equals(t.getIdTecnico())
                        && r.getDataEntrega().getMonth().equals(Month.of(mes))) {
                    count++;
                    custoTotal+=((RegistoNormal) r).getCustoTotal();
                    desvioTotal+=((RegistoNormal) r).getCustoAdicional();
                }
            }
            sb.append(";").append(count).append(";").append(custoTotal / count).append(";").append(desvioTotal / count);
            res.add(sb.toString());
        }
        return res;
    }

    public List<String> showListGestorRececoes(int mes) {
        List<String> res = new ArrayList<>();
        Collection<Registo> registosValues = registos.values();
        for (Funcionario f : funcionariosFacade.getFuncionarios()) {
            StringBuilder sb = new StringBuilder();

            sb.append(f.getNifFuncionario());
            for (Registo r : registosValues) {
                if (r.getFuncionarioRececao()==(f.getNifFuncionario())
                        && r.getDataRececao().getMonth().equals(Month.of(mes))) {
                    sb.append(";");
                    sb.append(r.getIdRegisto());
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public List<String> showListGestorEntregas(int mes) {
        List<String> res = new ArrayList<>();
        Collection<Registo> registosValues = registos.values();
        for (Funcionario f : funcionariosFacade.getFuncionarios()) {
            StringBuilder sb = new StringBuilder();

            sb.append(f.getNifFuncionario());
            for (Registo r : registosValues) {
                if (r.getFuncionarioEntrega()==(f.getNifFuncionario())
                        && r.getDataEntrega().getMonth().equals(Month.of(mes))) {
                    sb.append(";");
                    sb.append(r.getIdRegisto());
                }
            }
            res.add(sb.toString());
        }
        return res;
    }

    public List<String> showListGestorReparacoesExaustiva(int mes) {
        List<String> res = new ArrayList<>();
        Collection<Registo> registosValues = registos.values();

        for (Tecnico t : tecnicosFacade.getTecnicos()) {
            StringBuilder sb = new StringBuilder();
            int count = 0;
            sb.append(t.getIdTecnico());
            for (Registo r : registosValues) {
                if (r.getTecnicoReparacao().equals(t.getIdTecnico())
                        && r.getDataEntrega().getMonth().equals(Month.of(mes))) {
                    sb.append(";");
                    sb.append(r.getIdRegisto());
                    if(r instanceof RegistoNormal)
                        count+=((RegistoNormal) r).numeroPassos();
                }
            }
            sb.append(";").append(count).append(" Passos");
            res.add(sb.toString());
        }
        return res;
    }

    public RegistoNormal criaRegistoNormal(long nifC, long nifF, String idE) {
        return new RegistoNormal("rn" + (countIDR++), "PendenteDeOrcamento", LocalDateTime.now(),
                null, null, nifF, 0, "", "", idE,
                nifC, null,null);
    }

    public RegistoExpresso criaRegistoExpresso(long nifC, long nifF, String idE, double ce, double te) {
        return new RegistoExpresso("re" + (countIDR++), "PendenteDeReparacao", LocalDateTime.now(),
                null, null, nifF,0, "", "", idE,
                nifC, ce, te);
    }

    public boolean armazenaRegisto(Registo r) {
        int before = registos.size();
        registos.put(r.getIdRegisto(), r);
        int after = registos.size();
        boolean res = !(after == before);
        return res;
    }

    public boolean verificaPossibilidadeServicoExpresso() {
        boolean flag = false;
        for (Tecnico t : tecnicosFacade.getTecnicos()){
            if (t.getEstadoT().equals("Livre")) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    public List<Registo> geraListaDeRegistosPendentes() {
        List<Registo> res = new ArrayList<>();
        for(Registo r : registos.values())
            if (r.getEstadoR().equals("PendenteDeOrcamento"))
                res.add(r);
        Collections.sort(res);
        return res;
    }

    public void associaOrcamento(Orcamento o, String idRegisto) {
        Registo registo = registos.get(idRegisto);
        if (registo instanceof RegistoNormal) {
            RegistoNormal aux = (RegistoNormal) registo;
            aux.setOrcamento(o);
            aux.setDataOrcamento(LocalDateTime.now());
        }
    }

    public List<Registo> geraListaRegistosNormaisUrgencia() {
        List<Registo> res = new ArrayList<Registo>();
        for(Registo r : registos.values()) {
            if (r.getEstadoR().equals("ReparacaoSuspensa"))
                res.add(r);
        }
        if (res.size() == 0){
            for(Registo r : registos.values()) {
                if (r.getEstadoR().equals("PendenteDeReparacao"))
                    res.add(r);
            }
        }
        Collections.sort(res);
        return res;
    }

    public void atualizaEstadoR(String idRegisto, String estado) {
        Registo registo = registos.get(idRegisto);
        registo.setEstadoR(estado);
    }

    public void atualizaCusto(String idRegisto, double custo) {
        Registo registo = registos.get(idRegisto);
        if (registo instanceof RegistoNormal) {

            RegistoNormal aux = (RegistoNormal) registo;
            aux.atualizaCusto(custo);
        }
    }

    public SubPasso criaSubPasso(double custo, double tempo){
        return new SubPasso(custo,tempo);
    }

    public Passo criaPasso(List<SubPasso> sequenciaDeSubPassos){
        return new Passo(sequenciaDeSubPassos);
    }

    public PlanoDeTrabalhos criaPlanoDeTrabalhos(List<Passo> passos){
        return new PlanoDeTrabalhos(passos);
    }

    public Orcamento criaOrcamento(PlanoDeTrabalhos plano){
        return new Orcamento(0,0,plano);
    }

    public boolean eliminaRegisto(String idRegisto){
        int before = registos.size();
        registos.remove(idRegisto);
        int after = registos.size();
        boolean res = !(before==after);
        return res;
    }

    public void registaEntrega(String idRegisto, long nifFuncionario) {
        Registo registo = registos.get(idRegisto);
        registo.setFuncionarioEntrega(nifFuncionario);
        registo.setDataEntrega(LocalDateTime.now());
        registo.setEstadoR("Entregue");
    }

    public void registaConclusaoReparacao(String idRegisto, String idTecnico){
        Registo registo = registos.get(idRegisto);
        registo.setTecnicoOrcamento(idTecnico);
        registo.setDataConclusao(LocalDateTime.now());
        registo.setEstadoR("Concluido");
    }

    public void verificaTempo(){
        for(Registo r : registos.values()){
            if(r.getDataConclusao().plusDays(90).isBefore(LocalDateTime.now())
                    && r.getEstadoR().equals("Concluido"))
                r.setEstadoR("Abandonado");
            if(r instanceof RegistoNormal
                    && ((RegistoNormal) r).getDataOrcamento().plusDays(30).isBefore(LocalDateTime.now())
                    && r.getEstadoR().equals("PendenteDeConfirmacao"))
                r.setEstadoR("Arquivado");
        }
    }

    public boolean adicionaFuniconario(Long nifF, String passwordF){
        return funcionariosFacade.adicionaFuniconario(nifF,passwordF);
    }

    public boolean validaFuncionario(Long nifF, String passwordF){
        return funcionariosFacade.validaFuncionario(nifF,passwordF);
    }

    public boolean adicionaGestor(String passwordG){
        return gestoresFacade.adicionaGestor(passwordG);
    }

    public boolean validaGestor(String idGestor, String passwordG) {
        return gestoresFacade.validaGestor(idGestor,passwordG);
    }

    public boolean adicionaTecnico(String passwordT) {
        return tecnicosFacade.adicionaTecnico(passwordT);
    }

    public boolean validaTecnico(String idTecnico, String passwordT) {
        return tecnicosFacade.validaTecnico(idTecnico,passwordT);
    }

    public void atualizaEstadoT(String idTecnico, String estadoT) {
        tecnicosFacade.atualizaEstado(idTecnico,estadoT);
    }


}