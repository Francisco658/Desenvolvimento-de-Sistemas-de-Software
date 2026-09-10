package SubSistemaGestaoTecnicos;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubSistemaGestaoTecnicosFacade {

    private int countIDT;
    private Map<String,Tecnico> tecnicos;

    public SubSistemaGestaoTecnicosFacade(int count, Map<String,Tecnico> ts){
        this.countIDT = count;
        for (Tecnico t : ts.values())
            this.tecnicos.put(t.getIdTecnico(),t);
    }

    public boolean adicionaTecnico(String passwordT) {
        int before = tecnicos.size();
        String id = "t" + (countIDT++);
        tecnicos.put(id,new Tecnico(id,passwordT));
        int after = tecnicos.size();
        boolean res = !(after == before);
        return res;
    }

    public boolean validaTecnico(String idTecnico, String passwordT){

        boolean existe = tecnicos.containsKey(idTecnico);
        boolean res = false;
        if (existe) {
            Tecnico tecnico = tecnicos.get(idTecnico);
            Tecnico tecnicoC = new Tecnico(idTecnico,passwordT);
            res = tecnico.equals(tecnicoC);
        }
        return res;
    }

    public List<Tecnico> getTecnicos(){
        List<Tecnico> aux = new ArrayList<>();
        for(Tecnico t : tecnicos.values()){
            aux.add(t);
        }
        return aux;
    }

    public void atualizaEstado(String idTecnico, String estadoT){
        Tecnico t = tecnicos.get(idTecnico);
        t.setEstadoT(estadoT);
    }
}
