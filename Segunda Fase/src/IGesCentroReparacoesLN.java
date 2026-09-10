import java.util.List;

public interface IGesCentroReparacoesLN {

    List<String> showListGestorEntregas(int mes);

    List<String> showListGestorRececoes(int mes);

    List<String> showListGestorReparacoes(int mes);

    List<String> showListGestorReparacoesExaustiva(int mes);

    RegistoNormal criaRegistoNormal(long nifC, long nifF, String idE);

    RegistoExpresso criaRegistoExpresso(long nifC, long nifF, String idE, double ce, double te);

    boolean armazenaRegisto(Registo r);

    boolean verificaPossibilidadeServicoExpresso();

    List<Registo> geraListaDeRegistosPendentes();

    void associaOrcamento(Orcamento o, String idRegisto);

    List<Registo> geraListaRegistosNormaisUrgencia();

    void atualizaEstadoR(String idRegisto, String Estado);

    void atualizaCusto(String idRegisto, double custo);

    SubPasso criaSubPasso(double custo, double tempo);

    Passo criaPasso(List<SubPasso> sequenciaDeSubPassos);

    PlanoDeTrabalhos criaPlanoDeTrabalhos(List<Passo> passos);

    Orcamento criaOrcamento(PlanoDeTrabalhos plano);

    boolean eliminaRegisto(String idRegisto);

    void registaEntrega(String idRegisto, long nifFuncionario);

    void registaConclusaoReparacao(String idRegisto, String idTecnico);

    boolean adicionaFuniconario(Long nifF, String passwordF);

    boolean validaFuncionario(Long nifF, String passwordF);

    boolean adicionaGestor(String passwordG);

    boolean validaGestor(String idGestor, String passwordG);

    boolean adicionaTecnico(String passwordT);

    boolean validaTecnico(String idTecnico, String passwordT);

    void atualizaEstadoT(String idTecnico, String estadoT);

}
