import java.time.LocalDateTime;
import java.util.Objects;

public abstract class Registo implements Comparable<Registo>{

    private String idRegisto;
    private String estadoR;
    private LocalDateTime dataRececao;
    private LocalDateTime dataEntrega;
    private LocalDateTime dataConclusao;
    private long funcionarioRececao;
    private long funcionarioEntrega;
    private String tecnicoOrcamento;
    private String tecnicoReparacao;
    private String idEquipamento;
    private long nifCliente;


    public Registo(String idRegisto, String estadoR, LocalDateTime dataRececao, LocalDateTime dataEntrega,
                   LocalDateTime dataConclusao, long funcionarioRececao, long funcionarioEntrega,
                   String tecnicoOrcamento, String tecnicoReparacao, String idEquipamento, long nifCliente) {
        this.idRegisto = idRegisto;
        this.estadoR = estadoR;
        this.dataRececao = dataRececao;
        this.dataEntrega = dataEntrega;
        this.dataConclusao = dataConclusao;
        this.funcionarioRececao = funcionarioRececao;
        this.funcionarioEntrega = funcionarioEntrega;
        this.tecnicoOrcamento = tecnicoOrcamento;
        this.tecnicoReparacao = tecnicoReparacao;
        this.idEquipamento = idEquipamento;
        this.nifCliente = nifCliente;
    }

    public int compareTo(Registo r) {
        return this.dataRececao.compareTo(r.getDataRececao());
    }

    public String getIdRegisto() {
        return idRegisto;
    }

    public void setIdRegisto(String idRegisto) {
        this.idRegisto = idRegisto;
    }

    public String getEstadoR() {
        return estadoR;
    }

    public void setEstadoR(String estadoR) {
        this.estadoR = estadoR;
    }

    public LocalDateTime getDataRececao() {
        return dataRececao;
    }

    public void setDataRececao(LocalDateTime dataRececao) {
        this.dataRececao = dataRececao;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void setDataConclusao(LocalDateTime dataConclusao) {
        this.dataConclusao = dataConclusao;
    }

    public long getFuncionarioRececao() {
        return funcionarioRececao;
    }

    public void setFuncionarioRececao(long funcionarioRececao) {
        this.funcionarioRececao = funcionarioRececao;
    }

    public long getFuncionarioEntrega() {
        return funcionarioEntrega;
    }

    public void setFuncionarioEntrega(long funcionarioEntrega) {
        this.funcionarioEntrega = funcionarioEntrega;
    }

    public String getTecnicoOrcamento() {
        return tecnicoOrcamento;
    }

    public void setTecnicoOrcamento(String tecnicoOrcamento) {
        this.tecnicoOrcamento = tecnicoOrcamento;
    }

    public String getTecnicoReparacao() {
        return tecnicoReparacao;
    }

    public void setTecnicoReparacao(String tecnicoReparacao) {
        this.tecnicoReparacao = tecnicoReparacao;
    }

    public String getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(String idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public long getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(long nifCliente) {
        this.nifCliente = nifCliente;
    }

    @Override
    public String toString() {
        return "Registo{" +
                "idRegisto='" + idRegisto + '\'' +
                ", estadoR='" + estadoR + '\'' +
                ", dataRececao=" + dataRececao +
                ", dataEntrega=" + dataEntrega +
                ", dataConclusao=" + dataConclusao +
                ", funcionarioRececao=" + funcionarioRececao +
                ", funcionarioEntrega=" + funcionarioEntrega +
                ", tecnicoOrcamento='" + tecnicoOrcamento + '\'' +
                ", tecnicoReparacao='" + tecnicoReparacao + '\'' +
                ", idEquipamento='" + idEquipamento + '\'' +
                ", nifCliente=" + nifCliente +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Registo registo = (Registo) o;
        return Objects.equals(idRegisto, registo.idRegisto);
    }

}
