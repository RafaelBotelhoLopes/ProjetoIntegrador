package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCidade;
import model.ObjPaciente;

public class PacienteDAO {

    public static void inserir(ObjPaciente pac) {
        String data = "" + pac.getNascimento().getYear() + "-" + (pac.getNascimento().getMonth() + 1) + "-" + pac.getNascimento().getDate();
        String sql = "INSERT INTO pacientes "
                + " ( nome, telefone, endereco, nascimento, rg, sexo, estado_civil, codCidade ) "
                + " VALUES ( "
                + " '" + pac.getNome() + "' , "
                + " '" + pac.getTelefone() + "' , "
                + " '" + pac.getEndereco() + "' , "
                + " '" + data + "' ,  "
                + " '" + pac.getRg() + "' , "
                + " '" + pac.getSexo() + "' , "
                + " '" + pac.getEstado_civil() + "' , "
                + "  " + pac.getCidade().getCodigo() + "    "
                + " );";

        Conexao.executar(sql);
    }

    public static void editar(ObjPaciente pac) {
        String sql = "UPDATE clientes SET "
                + " nome = '" + pac.getNome() + "' , "
                + " telefone = '" + pac.getTelefone() + "' , "
                + " endereco = '" + pac.getEndereco() + "' , "
                + " nascimento = '" + pac.getNascimento() + "' , "
                + " rg = '" + pac.getRg() + "' , "
                + " sexo = '" + pac.getSexo() + "' , "
                + " estado_civil = '" + pac.getEstado_civil() + "' , "
                + " codCidade = '" + pac.getCidade().getCodigo() + "    "
                + " WHERE codigo = " + pac.getCodigo();

        Conexao.executar(sql);
    }

    public static void excluir(ObjPaciente pac) {
        String sql = "DELETE FROM paciente " + pac.getCodigo();
        Conexao.executar(sql);

    }

    public static List<ObjPaciente> getPaciente() {
        List<ObjPaciente> lista = new ArrayList<>();
        String sql = "SELECT p.codigo, c.codigo, p.nome, c.nome, "
                + " p.endereco, p.telefone,   "
                + " DATE_FORMAT(p.nascimento, '%d') AS DIA, DATE_FORMAT(p.nascimento, '%m') AS MES, DATE_FORMAT(p.nascimento, '%Y') AS ANO  ,   "
                + " p.rg,    "
                + " p.estado_civil, p.sexo   "
                + " FROM paciente p                                "
                + " INNER JOIN cidades c ON p.codCidade = c.codigo "
                + " ORDER BY p.nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {

            try {
                ObjCidade cidade = new ObjCidade();
                cidade.setCodigo(rs.getInt(2));
                cidade.setNome(rs.getString(4));

                Date nascimento = new Date(rs.getInt(9), (rs.getInt(8) - 1), rs.getInt(7));
                while (rs.next()) {
                    ObjPaciente pac = new ObjPaciente();
                    pac.setCodigo(rs.getInt(1));
                    pac.setNome(rs.getString(3));
                    pac.setTelefone(rs.getString(6));
                    pac.setEndereco(rs.getString(5));
                    pac.setNascimento(nascimento);
                    pac.setRg(rs.getString(10));
                    pac.setSexo(rs.getString(12));
                    pac.setEstado_civil(rs.getString(11));
                    ObjCidade cid = new ObjCidade();
                    pac.setCidade(cid);
                    lista.add(pac);
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }

        return lista;

    }

    public static Object getPacienteByCodigo(int codigo) {
        Object paciente = null;
        String sql = "SELECT p.codigo, c.codigo, p.nome, c.nome, "
                + " p.endereco, p.telefone,   "
                + " DATE_FORMAT(p.nascimento, '%d') AS DIA, DATE_FORMAT(p.nascimento, '%m') AS MES, DATE_FORMAT(p.nascimento, '%Y') AS ANO  ,   "
                + " p.rg,    "
                + " p.estado_civil, p.sexo   "
                + " FROM paciente p                                "
                + " INNER JOIN cidades c ON p.codCidade = c.codigo "
                + " WHERE p.codigo  = " + codigo
                + " ORDER BY p.nome";
        ResultSet rs = Conexao.consultar(sql);
        try {
            rs.first();

            ObjCidade cidade = new ObjCidade();
                cidade.setCodigo(rs.getInt(2));
                cidade.setNome(rs.getString(4));

            Date nascimento = new Date(rs.getInt(9), (rs.getInt(8) - 1), rs.getInt(7));

            ObjPaciente pac = new ObjPaciente();
                    pac.setCodigo(rs.getInt(1));
                    pac.setNome(rs.getString(3));
                    pac.setTelefone(rs.getString(6));
                    pac.setEndereco(rs.getString(5));
                    pac.setNascimento(nascimento);
                    pac.setRg(rs.getString(10));
                    pac.setSexo(rs.getString(12));
                    pac.setEstado_civil(rs.getString(11));
                    ObjCidade cid = new ObjCidade();
                    pac.setCidade(cid);
            paciente = pac;

        } catch (Exception e) {

        }

        return paciente;
    }
}
