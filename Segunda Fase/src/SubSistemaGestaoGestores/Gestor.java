package SubSistemaGestaoGestores;

import java.util.Objects;

public class Gestor {

    private String idGestor;
    private String passwordG;

    public Gestor(String idGestor, String passwordG) {
        this.idGestor = idGestor;
        this.passwordG = passwordG;
    }

    public String getIdGestor() {
        return idGestor;
    }

    public void setIdGestor(String idGestor) {
        this.idGestor = idGestor;
    }

    public String getPasswordG() {
        return passwordG;
    }

    public void setPasswordG(String passwordG) {
        this.passwordG = passwordG;
    }

    @Override
    public String toString() {
        return "Gestor{" +
                "idGestor='" + idGestor + '\'' +
                ", passwordG='" + passwordG + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gestor gestor = (Gestor) o;
        return Objects.equals(idGestor, gestor.idGestor) && Objects.equals(passwordG, gestor.passwordG);
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(idGestor).append(";");
        sb.append(passwordG);
        return sb.toString();
    }

}
