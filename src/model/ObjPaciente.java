package model;

import java.util.Date;

public class ObjPaciente {
    private int codigo;
    private Date data;

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
    private String nome, sexo, endereco, rg, estado_civil, nascimento, telefone;
    private ObjCidade cidade;
    
    public ObjPaciente(){

}
    public ObjPaciente(String nome) {
        this.nome = nome;
    }

    
    public ObjPaciente(int codigo, String nome, String endereco, String telefone, String estado_civil, String nascimento, String tipo, ObjCidade cidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
        this.estado_civil = estado_civil;
        this.nascimento = nascimento;
        this.sexo = sexo;
        this.cidade = cidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getEstado_civil() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil = estado_civil;
    }    

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    public void nascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public ObjCidade getCidade() {
        return cidade;
    }

    public void setCidade(ObjCidade cidade) {
        this.cidade = cidade;
    }
    
    
    
    
}
