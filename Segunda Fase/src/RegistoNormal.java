import java.time.LocalDateTime;

public class RegistoNormal extends Registo{

    private Orcamento orcamento;
    private LocalDateTime dataOrcamento;

    public RegistoNormal(String idRegisto, String estadoR, LocalDateTime dataRececao, LocalDateTime dataEntrega,
                         LocalDateTime dataConclusao, long funcionarioRececao, long funcionarioEntrega,
                         String tecnicoOrcamento, String tecnicoReparacao, String idEquipamento, long nifCliente,
                         Orcamento orcamento, LocalDateTime dataOrcamento) {
        super(idRegisto, estadoR, dataRececao, dataEntrega, dataConclusao, funcionarioRececao, funcionarioEntrega,
                tecnicoOrcamento, tecnicoReparacao, idEquipamento, nifCliente);
        this.orcamento = orcamento;
        this.dataOrcamento = dataOrcamento;
    }

    public Orcamento getOrcamento() {
        return orcamento;
    }

    public void setOrcamento(Orcamento orcamento) {
        this.orcamento = orcamento;
    }

    public LocalDateTime getDataOrcamento() {
        return dataOrcamento;
    }

    public void setDataOrcamento(LocalDateTime dataOrcamento) {
        this.dataOrcamento = dataOrcamento;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "RegistoNormal{" +
                "orcamento=" + orcamento +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        RegistoNormal that = (RegistoNormal) object;
        return java.util.Objects.equals(orcamento, that.orcamento);
    }


    public void atualizaCusto(double custo){
        this.orcamento.atulizaCusto(custo);
    }

    public double getCustoTotal(){
        return this.orcamento.getCustoTotal();
    }

    public double getTempoTotal(){
        return this.orcamento.getTempoTotal();
    }

    public double getCustoAdicional(){
        return this.orcamento.getCustoAdicional();
    }

    public double getTempoAdicional(){
        return this.orcamento.getTempoAdicional();
    }

    public int numeroPassos(){
        return this.orcamento.numeroPassos();
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.getIdRegisto()).append(";");
        sb.append(this.getEstadoR()).append(";");
        sb.append(this.getDataRececao().toString()).append(";");
        sb.append(this.getDataEntrega().toString()).append(";");
        sb.append(this.getDataConclusao().toString()).append(";");
        sb.append(this.getFuncionarioRececao()).append(";");
        sb.append(this.getFuncionarioEntrega()).append(";");
        sb.append(this.getTecnicoOrcamento()).append(";");
        sb.append(this.getTecnicoReparacao()).append(";");
        sb.append(this.getIdEquipamento()).append(";");
        sb.append(this.getNifCliente()).append(";");
        sb.append(this.orcamento.toFile()).append(";");
        sb.append(this.dataOrcamento.toString()).append(";");
        return sb.toString();
    }

}