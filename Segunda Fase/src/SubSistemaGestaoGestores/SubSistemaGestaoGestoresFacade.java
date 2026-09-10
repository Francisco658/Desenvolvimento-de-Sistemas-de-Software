package SubSistemaGestaoGestores;

import SubSistemaGestaoFuncionarios.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SubSistemaGestaoGestoresFacade {

    private int countIDG;
    private Map<String,Gestor> gestores;

    public SubSistemaGestaoGestoresFacade(int count,Map<String, Gestor> gs) {
        this.countIDG = count;
        for (Gestor g : gs.values())
            this.gestores.put(g.getIdGestor(),g);
    }

    public boolean adicionaGestor(String passwordG) {
        int before = gestores.size();
        String id = "g" + (countIDG++);
        gestores.put(id,new Gestor(id,passwordG));
        int after = gestores.size();
        boolean res = !(after == before);
        return res;
    }

    public boolean validaGestor(String idGestor, String passwordG){

        boolean existe = gestores.containsKey(idGestor);
        boolean res = false;
        if (existe) {
            Gestor gestor = gestores.get(idGestor);
            Gestor gestorC = new Gestor(idGestor,passwordG);
            res = gestor.equals(gestorC);
        }
        return res;
    }

    public List<Gestor> getGestores(){
        List<Gestor> aux = new ArrayList<>();
        for(Gestor g : gestores.values()){
            aux.add(g);
        }
        return aux;
    }


}
