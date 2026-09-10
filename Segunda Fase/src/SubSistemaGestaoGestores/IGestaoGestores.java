package SubSistemaGestaoGestores;

import SubSistemaGestaoFuncionarios.Funcionario;

import java.util.List;

public interface IGestaoGestores {

    boolean adicionaGestor(String passwordG);

    boolean validaGestor(String idGestor, String passwordG);

    List<Gestor> getGestores();
}
