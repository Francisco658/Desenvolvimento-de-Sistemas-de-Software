import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.*;
import SubSistemaGestaoFuncionarios.*;
import SubSistemaGestaoTecnicos.*;
import SubSistemaGestaoGestores.*;

public class Parser {

    public static Map<String,Equipamento> parseEquipamento(){
        List<String> linhas = lerFicheiro("equipamentos.txt");
        Map<String,Equipamento> equipamentoMap = new HashMap<>();
        for (String linha : linhas)
            equipamentoMap.put(linha,new Equipamento(linha));
        return equipamentoMap;
    }

    public static Map<Long,Cliente> parseCliente(){
        List<String> linhas = lerFicheiro("clientes.txt");
        Map<Long,Cliente> clienteMap = new HashMap<>();
        for (String linha : linhas) {
            String[] atributos = linha.split(";");
            String[] lista = atributos[2].split(",");
            List<String> aux = new ArrayList<>(Arrays.asList(lista));
            clienteMap.put(Long.parseLong(atributos[0]),new Cliente(Long.parseLong(atributos[0]),atributos[1],aux));
        }
        return clienteMap;
    }

    public static SubSistemaGestaoFuncionariosFacade parseFuncionario(){
        List<String> linhas = lerFicheiro("funcionarios.txt");
        Map<Long,Funcionario> fs = new HashMap<>();
        for (String linha : linhas) {
            String[] atributos = linha.split(";");
            fs.put(Long.parseLong(atributos[0]),new Funcionario(Long.parseLong(atributos[0]),atributos[1]));
        }
        return new SubSistemaGestaoFuncionariosFacade(fs);
    }

    public static SubSistemaGestaoGestoresFacade parseGestor(){
        List<String> linhas = lerFicheiro("gestores.txt");
        Map<String,Gestor> gs = new HashMap<>();
        int count = Integer.parseInt(linhas.get(0));
        linhas.remove(0);
        for (String linha : linhas) {
            String[] atributos = linha.split(";");
            gs.put(atributos[0],new Gestor(atributos[0],atributos[1]));
        }
        return new SubSistemaGestaoGestoresFacade(count,gs);
    }

    public static SubSistemaGestaoTecnicosFacade parseTecnico() {
        List<String> linhas = lerFicheiro("tecnicos.txt");
        Map<String,Tecnico> ts = new HashMap<>();
        int count = Integer.parseInt(linhas.get(0));
        linhas.remove(0);
        for (String linha : linhas) {
            String[] atributos = linha.split(";");
            ts.put(atributos[0],new Tecnico(atributos[0],atributos[1],atributos[2]));
        }
        return new SubSistemaGestaoTecnicosFacade(count,ts);
    }

    public static Map<String,Registo> parseRegisto(){
        List<String> linhas = lerFicheiro("registos.txt");
        Map<String,Registo> rs = new HashMap<>();
        for (String linha : linhas){
            String[] atributos = linha.split(";");
            if (atributos[0].startsWith("rn"))
                rs.put(atributos[0],new RegistoNormal(atributos[0],atributos[1],
                        LocalDateTime.parse(atributos[2]),LocalDateTime.parse(atributos[3]),
                        LocalDateTime.parse(atributos[4]),Long.parseLong(atributos[5]),
                        Long.parseLong(atributos[6]),atributos[7],atributos[8],atributos[9],
                        Long.parseLong(atributos[10]),Orcamento.parse(atributos[11]),
                        LocalDateTime.parse(atributos[12])));
            else if(atributos[0].startsWith("re"))
                rs.put(atributos[0],new RegistoExpresso(atributos[0],atributos[1],
                        LocalDateTime.parse(atributos[2]),LocalDateTime.parse(atributos[3]),
                        LocalDateTime.parse(atributos[4]),Long.parseLong(atributos[5]),
                        Long.parseLong(atributos[6]),atributos[7],atributos[8],atributos[9],
                        Long.parseLong(atributos[10]),Double.parseDouble(atributos[11]),
                        Double.parseDouble(atributos[12])));
        }
        return rs;
    }

    public static int parseCount(){
        List<String> linhas = lerFicheiro("count.txt");
        return Integer.parseInt(linhas.get(0));
    }

    public static List<String> lerFicheiro(String nomeFich) {
        List<String> lines;
        try { lines = Files.readAllLines(Paths.get(nomeFich), StandardCharsets.UTF_8); }
        catch(IOException exc) { lines = new ArrayList<>(); }
        return lines;
    }
}
