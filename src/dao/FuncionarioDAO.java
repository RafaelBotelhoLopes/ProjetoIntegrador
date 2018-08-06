package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.ObjCargo;
import model.ObjCidade;

import model.ObjFuncionario;

public class FuncionarioDAO {

    public static void inserir(ObjFuncionario fun) {

        String data = "" + fun.getNascimento().getYear() + "-" + (fun.getNascimento().getMonth() + 1) + "-" + fun.getNascimento().getDate();

        String sql = "INSERT INTO funcionarios "
                + " ( nome, sexo, cpf, rg, estado_civil, telefone, escolaridade, endereco, nacionalidade, nascimento, codCidade ) "
                + " VALUES ( "
                + " '" + fun.getNome() + "' , "
                + " '" + fun.getSexo() + "' , "
                + " '" + fun.getCpf() + "' , "
                + " '" + fun.getRg() + "' , "
                + " '" + fun.getEstado_civil() + "' , "
                + " '" + fun.getTelefone() + "' , "
                + " '" + fun.getEscolaridade() + "' , "
                + " '" + fun.getEndereco() + "' , "
                + " '" + fun.getNacionalidade() + "' , "
                + " '" + data + "' ,  "
                + "  " + fun.getCidade().getCodigo() + "    "
                + " );";

        Conexao.executar(sql);
    }

    public static void editar(ObjFuncionario fun) {
        String sql = "UPDATE funcionario SET "
                + " nome = '" + fun.getNome() + "' , "
                + " sexo = '" + fun.getSexo() + "' , "
                + " cpf = '" + fun.getCpf() + "' , "
                + " rg = '" + fun.getRg() + "' , "
                + " estado_civil = '" + fun.getEstado_civil() + "' , "
                + " telefone = '" + fun.getTelefone() + "' , "
                + " escolaridade = '" + fun.getEscolaridade() + "' , "
                + " endereco = '" + fun.getEndereco() + "' , "
                + " nacionalidade = '" + fun.getNacionalidade() + "' , "
                + " nascimento = '" + fun.getNascimento() + "' , "
                + " codCidade = '" + fun.getCidade().getCodigo() + "    "
                + " WHERE codigo = " + fun.getCodigo();

        Conexao.executar(sql);

    }

    public static void excluir(ObjFuncionario fun) {
        String sql = "DELETE FROM funcionario " + fun.getCodigo();
        Conexao.executar(sql);

    }

    public static List<ObjFuncionario> getFuncionarios() {
        List<ObjFuncionario> lista = new ArrayList<>();
        String sql = "SELECT f.codigo, c.codigo, f.nome, c.nome, "
                + " f.endereco, f.telefone, DATE_FORMAT(f.nascimento, '%d') AS DIA, DATE_FORMAT(f.nascimento, '%m') AS MES, DATE_FORMAT(f.nascimento, '%Y') AS ANO  , "
                + " f.sexo, f.cpf, f.rg, f.estado_civil, f.escolaridade, f.nacionalidade, k.codigo, k.nome    "
                + " FROM funcionario f                                "
                + " INNER JOIN cidades c ON f.codCidade = c.codigo "
                + " INNER JOIN cargos k ON f.codCargo = k.codigo "
                + " ORDER BY f.nome";
        ResultSet rs = Conexao.consultar(sql);
        try {
            rs.first();
            
            ObjCargo cargo = new ObjCargo();
            cargo.setCodigo(rs.getInt(16));
            cargo.setNome(rs.getString(17));
            
            ObjCidade cidade = new ObjCidade();
            cidade.setCodigo(rs.getInt(2));
            cidade.setNome(rs.getString(4));

            Date nascimento = new Date(rs.getInt(9), (rs.getInt(8) - 1), rs.getInt(7));

            ObjFuncionario fun = new ObjFuncionario();
            fun.setCodigo(rs.getInt(1));
            fun.setNome(rs.getString(3));
            fun.setTelefone(rs.getString(6));
            fun.setEndereco(rs.getString(5));
            fun.setNascimento(nascimento);
            fun.setRg(rs.getString(12));
            fun.setCpf(rs.getString(11));
            fun.setSexo(rs.getString(10));
            fun.setEscolaridade(rs.getString(14));
            fun.setEstado_civil(rs.getString(13));
            fun.setNacionalidade(rs.getString(15));
            fun.setCidade(cidade);

            lista.add(fun);

        } catch (Exception e) {

        }

        return lista;
    }

}
