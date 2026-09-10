import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Passo {


    private List<SubPasso> sequenciaDeSubPassos;
    private double custoPasso;
    private double tempoPasso;

    public Passo(List<SubPasso> s) {
        for (SubPasso sp : s) {
            this.sequenciaDeSubPassos.add(sp);
            custoPasso+=sp.getCusto();
            tempoPasso+=sp.getTempo();
        }
    }

    public double getCustoPasso() {
        return custoPasso;
    }

    public double getTempoPasso() { return tempoPasso; }

    public void setSequenciaDeSubPassos(List<SubPasso> sequenciaDeSubPassos) {
        this.sequenciaDeSubPassos = sequenciaDeSubPassos;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Passo{" +
                "sequenciaDeSubPassos=" + sequenciaDeSubPassos +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passo passo = (Passo) o;
        return Objects.equals(sequenciaDeSubPassos, passo.sequenciaDeSubPassos);
    }

    public static Passo parse(String s){
        String[] subPs = s.split("_");
        List<SubPasso> aux = new ArrayList<>();
        for (String subP : subPs) aux.add(SubPasso.parse(subP));
        return new Passo(aux);
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        for(SubPasso sp : sequenciaDeSubPassos)
            sb.append(sp.toFile()).append("_");
        return sb.toString();
    }

}