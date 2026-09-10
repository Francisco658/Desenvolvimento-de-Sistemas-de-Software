import java.time.LocalDateTime;
import java.util.Objects;

public class RegistoExpresso extends Registo{

    private double custoExpresso;
    private double duracaoExpresso;

    public RegistoExpresso(String idRegisto, String estadoR, LocalDateTime dataRececao, LocalDateTime dataEntrega,
                           LocalDateTime dataConclusao, long funcionarioRececao, long funcionarioEntrega,
                           String tecnicoOrcamento, String tecnicoReparacao, String idEquipamento, long nifCliente,
                           double custoExpresso, double duracaoExpresso) {
        super(idRegisto, estadoR, dataRececao, dataEntrega, dataConclusao, funcionarioRececao, funcionarioEntrega,
                tecnicoOrcamento, tecnicoReparacao, idEquipamento, nifCliente);
        this.custoExpresso = custoExpresso;
        this.duracaoExpresso = duracaoExpresso;
    }

    public double getCustoExpresso() {
        return custoExpresso;
    }

    public void setCustoExpresso(double custoExpresso) {
        this.custoExpresso = custoExpresso;
    }

    public double getDuracaoExpresso() {
        return duracaoExpresso;
    }

    public void setDuracaoExpresso(double duracaoExpresso) {
        this.duracaoExpresso = duracaoExpresso;
    }

    @Override
    public String toString() {
        return "RegistoExpresso{" +
                "custoExpresso=" + custoExpresso +
                ", duracaoExpresso=" + duracaoExpresso +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RegistoExpresso that = (RegistoExpresso) o;
        return Double.compare(that.custoExpresso, custoExpresso) == 0 && Double.compare(that.duracaoExpresso, duracaoExpresso) == 0;
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
        sb.append(this.custoExpresso).append(";");
        sb.append(this.duracaoExpresso).append(";");
        return sb.toString();
    }

}
