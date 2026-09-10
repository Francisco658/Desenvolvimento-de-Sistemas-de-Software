package SubSistemaGestaoFuncionarios;

public class Funcionario {
    private long nifFuncionario;
    private String passwordF;

    public Funcionario(long nifFuncionario, String passwordF) {
        this.nifFuncionario = nifFuncionario;
        this.passwordF = passwordF;
    }


    public long getNifFuncionario() {
        return nifFuncionario;
    }

    public void setNifFuncionario(long nifFuncionario) {
        this.nifFuncionario = nifFuncionario;
    }

    public String getPasswordF() {
        return passwordF;
    }

    public void setPasswordF(String passwordF) {
        this.passwordF = passwordF;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Funcionario{" +
                "nifFuncionario=" + nifFuncionario +
                ", passwordF='" + passwordF + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Funcionario that = (Funcionario) object;
        return nifFuncionario == that.nifFuncionario && java.util.Objects.equals(passwordF, that.passwordF);
    }

    public String toFile() {
        StringBuilder sb = new StringBuilder();
        sb.append(nifFuncionario).append(";");
        sb.append(passwordF);
        return sb.toString();
    }

}