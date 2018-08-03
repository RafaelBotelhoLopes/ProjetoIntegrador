package model;

public class ObjLaudo {
    private int codigo;
    private String diagnostico;
    private String data_consulta;
    private ObjPaciente paciente;
    private ObjFuncionario funcionario;

    public ObjPaciente getPaciente() {
        return paciente;
    }

    public void setPaciente(ObjPaciente paciente) {
        this.paciente = paciente;
    }

    public ObjFuncionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(ObjFuncionario funcionario) {
        this.funcionario = funcionario;
    }
    
    

    public String getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }
    

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }
}
