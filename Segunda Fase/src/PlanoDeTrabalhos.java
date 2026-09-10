import java.util.ArrayList;
import java.util.List;

public class PlanoDeTrabalhos {

    private double custoTotal;
    private double tempoTotal;
    private List<Passo> passos;

    public PlanoDeTrabalhos(List<Passo> ps){
        for(Passo p : ps){
            passos.add(p);
            this.custoTotal += p.getCustoPasso();
            this.tempoTotal += p.getTempoPasso();
        }
    }

    public PlanoDeTrabalhos(PlanoDeTrabalhos pt){
        this.custoTotal = pt.getCustoTotal();
        this.tempoTotal = pt.getTempoTotal();
        this.setPassos(pt.getPassos());
    }

    public double getCustoTotal() {
        return custoTotal;
    }

    public void setCustoTotal(double custoTotal) {
        this.custoTotal = custoTotal;
    }

    public double getTempoTotal() {
        return tempoTotal;
    }

    public void setTempoTotal(double tempoTotal) {
        this.tempoTotal = tempoTotal;
    }

    public List<Passo> getPassos() {
        return new ArrayList<>(this.passos);
    }

    public void setPassos(List<Passo> p) {
        this.passos = new ArrayList<>(p);
    }

    public int numeroPassos(){
        return passos.size();
    }

    public static PlanoDeTrabalhos parse(String s){
        String[] ps = s.split(":");
        List<Passo> aux = new ArrayList<>();
        for (String p : ps) aux.add(Passo.parse(p));
        return new PlanoDeTrabalhos(aux);
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        for (Passo p : passos)
            sb.append(p.toFile()).append(":");
        return sb.toString();
    }
}
