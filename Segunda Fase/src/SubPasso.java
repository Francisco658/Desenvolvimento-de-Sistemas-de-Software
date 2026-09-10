import java.util.ArrayList;
import java.util.List;

public class SubPasso {
    private double custo;
    private double tempo;


    public SubPasso(double custo, double tempo) {
        this.custo = custo;
        this.tempo = tempo;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "SubPasso{" +
                "custo=" + custo +
                ", tempo=" + tempo +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        SubPasso subPasso = (SubPasso) object;
        return java.lang.Double.compare(subPasso.custo, custo) == 0
                && java.lang.Double.compare(subPasso.tempo, tempo) == 0;
    }

    public static SubPasso parse(String s){
        String[] atributos = s.split("..");
        return new SubPasso(Double.parseDouble(atributos[0]),Double.parseDouble(atributos[1]));
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(custo).append("..");
        sb.append(tempo);
        return sb.toString();
    }

}