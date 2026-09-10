import java.util.ArrayList;
import java.util.List;

public class Orcamento {

    private double custoAdicional;
    private double tempoAdicional;
    private PlanoDeTrabalhos planoDeTrabalhos;

    public Orcamento(double custoAdicional, double tempoAdicional, PlanoDeTrabalhos planoDeTrabalhos) {
        this.custoAdicional = custoAdicional;
        this.tempoAdicional = tempoAdicional;
        this.planoDeTrabalhos = new PlanoDeTrabalhos(planoDeTrabalhos);
    }

    public double getCustoAdicional() {
        return custoAdicional;
    }

    public void setCustoAdicional(double custoAdicional) {
        this.custoAdicional = custoAdicional;
    }

    public double getTempoAdicional() {
        return tempoAdicional;
    }

    public void setTempoAdicional(double tempoAdicional) {
        this.tempoAdicional = tempoAdicional;
    }

    public PlanoDeTrabalhos getPlanoDeTrabalhos() {
        return planoDeTrabalhos;
    }

    public void setPlanoDeTrabalhos(PlanoDeTrabalhos planoDeTrabalhos) {
        this.planoDeTrabalhos = new PlanoDeTrabalhos(planoDeTrabalhos);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Orcamento{" +
                "custoAdicional=" + custoAdicional +
                ", tempoAdicional=" + tempoAdicional +
                ", planoDeTrabalhos=" + planoDeTrabalhos +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Orcamento orcamento = (Orcamento) object;
        return java.lang.Double.compare(orcamento.custoAdicional, custoAdicional) == 0
                && java.lang.Double.compare(orcamento.tempoAdicional, tempoAdicional) == 0
                && java.util.Objects.equals(planoDeTrabalhos, orcamento.planoDeTrabalhos);
    }

    public void atulizaCusto(double custo){
        this.custoAdicional += custo;
    }

    public double getCustoTotal(){
        return this.planoDeTrabalhos.getCustoTotal() + custoAdicional;
    }

    public double getTempoTotal(){
        return this.planoDeTrabalhos.getTempoTotal() + tempoAdicional;
    }

    public int numeroPassos(){
        return planoDeTrabalhos.numeroPassos();
    }

    public static Orcamento parse(String s){
        String[] atributos = s.split(",");
        return new Orcamento(Double.parseDouble(atributos[0]),Double.parseDouble(atributos[1]),
                PlanoDeTrabalhos.parse(atributos[2]));
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(custoAdicional).append(",");
        sb.append(tempoAdicional).append(",");
        sb.append(planoDeTrabalhos.toFile());
        return sb.toString();
    }
}

