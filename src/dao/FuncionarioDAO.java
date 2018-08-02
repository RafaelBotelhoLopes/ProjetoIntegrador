
package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.ObjFuncionario;

public class FuncionarioDAO {
    public static void inserir(ObjFuncionario fun) {
        String sql = "INSERT INTO funcionarios "
                + " ( nome, sexo, cpf, rg, estado_civil, telefone, escolaridade, endereco, nacionalidade, nascimento, codCidade ) "
                + " VALUES ( "
                + " '" + fun.getNome() +               "' , "
                + " '" + fun.getSexo() +           "' , "
                + " '" + fun.getCpf() +           "' , "
                + " '" + fun.getRg() +               "' , "
                + " '" + fun.getEstado_civil () +               "' , "
                + " '" + fun.getTelefone() +               "' , "
                + " '" + fun.getEscolaridade() +               "' , "
                + " '" + fun.getEndereco() +               "' , "
                + " '" + fun.getNacionalidade() +               "' , "
                + " '" + fun.getNascimento() +               "' , "
                + "  " + fun.getCidade().getCodigo() + "    "
                + " );";
    
    
    Conexao.executar(sql);
    }

    public static void editar(ObjFuncionario fun) {
        String sql = "UPDATE funcionario SET "
                + " nome = '" + fun.getNome() +                    "' , "
                + " sexo = '" + fun.getSexo()   +          "' , "
                + " cpf = '" + fun.getCpf()  +           "' , "
                + " estado_civil = '" + fun.getEstado_civil() +                    "' , "
                + " telefone = '" + fun.getTelefone() +                    "' , "
                + " escolaridade = '" + fun.getEscolaridade() +                    "' , "
                + " endereco = '" + fun.getEndereco() +                    "' , "
                + " nacionalidade = '" + fun.getNacionalidade() +                    "' , "
                + " nascimento = '" + fun.getNascimento() +                    "' , "
                + " codCidade = '" + fun.getCidade().getCodigo() + "    "
                + " WHERE codigo = " + fun.getCodigo();

        Conexao.executar(sql);
    
    }

 public static void excluir(ObjFuncionario fun) {
        String sql = "DELETE FROM funcionario " + fun.getCodigo();
        Conexao.executar(sql);

    }

    public static List<ObjFuncionario> getFuncionario() {
        List<ObjFuncionario> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, d.codigo,  c.nome, d.nome, "
                + " c.endereco, c.telefone   "
                + " FROM paciente c                                "
                + " INNER JOIN cidades d ON c.codCidade = d.codigo "
                + " WHERE c.tipo = ''   "
                + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);
    }