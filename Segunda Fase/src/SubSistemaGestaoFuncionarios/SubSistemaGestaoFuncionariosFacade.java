package SubSistemaGestaoFuncionarios;

import java.util.*;

public class SubSistemaGestaoFuncionariosFacade implements IGestaoFuncionarios{

    private Map<Long,Funcionario> funcionarios;

    public SubSistemaGestaoFuncionariosFacade(Map<Long, Funcionario> fs) {
        for (Funcionario f : fs.values())
            this.funcionarios.put(f.getNifFuncionario(),f);
    }

    public boolean adicionaFuniconario(Long nifF, String passwordF) {
        int before = funcionarios.size();
        funcionarios.put(nifF,new Funcionario(nifF,passwordF));
        int after = funcionarios.size();
        boolean res = !(after == before);
        return res;
    }

    public boolean validaFuncionario(Long nifF, String passwordF){
        boolean existe = funcionarios.containsKey(nifF);
        boolean res = false;
        if (existe) {
            Funcionario funcionario = funcionarios.get(nifF);
            Funcionario funcionarioC = new Funcionario(nifF,passwordF);
            res = funcionario.equals(funcionarioC);
        }
        return res;
    }

    public List<Funcionario> getFuncionarios(){
        List<Funcionario> aux = new ArrayList<>();
        for(Funcionario f : funcionarios.values()){
            aux.add(f);
        }
        return aux;
    }
}
