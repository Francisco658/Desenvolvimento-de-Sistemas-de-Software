package SubSistemaGestaoFuncionarios;

import java.util.List;

public interface IGestaoFuncionarios {

    boolean adicionaFuniconario(Long nifF, String passwordF);

    boolean validaFuncionario(Long nifF, String passwordF);

    List<Funcionario> getFuncionarios();



}