import java.util.ArrayList;
import java.util.List;

public class Cliente {

    private Long nifCliente;
    private String email;
    private List<String> equipamentos;

    public Cliente(long nifCliente, String email, List<String> eqs) {
        this.nifCliente = nifCliente;
        this.email = email;
        this.equipamentos = new ArrayList<>(eqs);
    }

    public long getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(long nifCliente) {
        this.nifCliente = nifCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getEquipamentos() {
        return new ArrayList<>(this.equipamentos);
    }

    public void setEquipamentos(List<String> equipamentos) {
        this.equipamentos = equipamentos;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Cliente{" +
                "nifCliente=" + nifCliente +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Cliente cliente = (Cliente) object;
        return nifCliente == cliente.nifCliente && java.util.Objects.equals(email, cliente.email);
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(nifCliente).append(";");
        sb.append(email).append(";");
        for (String e : equipamentos)
            sb.append(e).append(",");
        return sb.toString();
    }

}