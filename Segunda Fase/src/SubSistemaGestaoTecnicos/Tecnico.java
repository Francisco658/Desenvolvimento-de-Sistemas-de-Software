package SubSistemaGestaoTecnicos;

public class Tecnico {

    private String idTecnico;
    private String passwordT;
    private String estadoT;

    public Tecnico(String idTecnico, String passwordT) {
        this.idTecnico = idTecnico;
        this.passwordT = passwordT;
        this.estadoT = "Livre";
    }

    public Tecnico(String idTecnico, String passwordT, String estadoT) {
        this.idTecnico = idTecnico;
        this.passwordT = passwordT;
        this.estadoT = estadoT;
    }

    public String getIdTecnico() {
        return idTecnico;
    }

    public void setIdTecnico(String idTecnico) {
        this.idTecnico = idTecnico;
    }

    public String getPasswordT() {
        return passwordT;
    }

    public void setPasswordT(String passwordT) {
        this.passwordT = passwordT;
    }

    public String getEstadoT() {
        return estadoT;
    }

    public void setEstadoT(String estadoT) {
        this.estadoT = estadoT;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Tecnico{" +
                "idTecnico='" + idTecnico + '\'' +
                ", passwordT='" + passwordT + '\'' +
                ", estadoT='" + estadoT + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Tecnico tecnico = (Tecnico) object;
        return java.util.Objects.equals(idTecnico, tecnico.idTecnico)
                && java.util.Objects.equals(passwordT, tecnico.passwordT);
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(idTecnico).append(";");
        sb.append(passwordT).append(";");
        sb.append(estadoT);
        return sb.toString();
    }

}
