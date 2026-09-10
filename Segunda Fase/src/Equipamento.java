public class Equipamento {

    private String idEquipamento;

    public Equipamento(String idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    public String getIdEquipamento() {
        return idEquipamento;
    }

    public void setIdEquipamento(String idEquipamento) {
        this.idEquipamento = idEquipamento;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Equipamento{" +
                "idEquipamento='" + idEquipamento + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Equipamento that = (Equipamento) object;
        return java.util.Objects.equals(idEquipamento, that.idEquipamento);
    }

    public String toFile(){
        return idEquipamento;
    }
}