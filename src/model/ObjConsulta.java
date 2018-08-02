package model;

import java.util.Date;

public class ObjConsulta {
    
    private int codigo;
    private Date data_consulta;
    private ObjConsulta consulta;

    public int getCodigo() {
        return codigo;
    }

    public ObjConsulta getConsulta() {
        return consulta;
    }

    public void setConsulta(ObjConsulta consulta) {
        this.consulta = consulta;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Date getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(Date data_consulta) {
        this.data_consulta = data_consulta;
    }
    
}
