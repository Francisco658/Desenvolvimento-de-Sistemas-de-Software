package SubSistemaGestaoTecnicos;

import java.util.List;

public interface IGestaoTecnicos {

    boolean adicionaTecnico(String passwordT);

    boolean validaTecnico(String idTecnico, String passwordT);

    List<Tecnico> getTecnicos();

    void atualizaEstado(String idTecnico, String estadoT);
}
