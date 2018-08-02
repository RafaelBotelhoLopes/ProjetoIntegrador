
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCidade;
import model.ObjConsulta;
import model.ObjPaciente;


public class PacienteDAO {

    public static void inserir(ObjPaciente pac) {
        String sql = "INSERT INTO pacientes "
                + " ( nome, telefone, endereco, nascimento, rg, sexo, estado civil, codCidade, codConsulta ) "
                + " VALUES ( "
                + " '" + pac.getNome() +               "' , "
                + " '" + pac.getTelefone() +           "' , "
                + " '" + pac.getEndereco() +           "' , "
                + " '" + pac.getNascimento() +         "' , "
                + " '" + pac.getRg() +                 "' , "
                + " '" + pac.getSexo() +               "' , "
                + " '" + pac.getEstado_civil() +       "' , "
                + "  " + pac.getCidade().getCodigo() + "    "
                + "  " + pac.getConsulta().getCodigo() + "    "
                + " );";

        Conexao.executar(sql);
    }

    public static void editar(ObjPaciente pac) {
        String sql = "UPDATE clientes SET "
                + " nome = '" + pac.getNome() +                    "' , "
                + " telefone = '" + pac.getTelefone()+                    "' , "
                + " endereco = '" + pac.getEndereco()+          "' , "
                + " nascimento = '" + pac.getNascimento()  +           "' , "
                + " rg = '" + pac.getRg() +                    "' , "
                + " sexo = '" + pac.getSexo() +                        "' , "
                + " estado civil = '" + pac.getEstado_civil()+         "' , "
                + " codCidade = '" + pac.getCidade().getCodigo() + "    "
                + " codConsulta = '" + pac.getConsulta().getCodigo() + "    "
                + " WHERE codigo = " + pac.getCodigo();

        Conexao.executar(sql);
    }

    public static void excluir(ObjPaciente pac) {
        String sql = "DELETE FROM paciente " + pac.getCodigo();
        Conexao.executar(sql);

    }

    public static List<ObjPaciente> getPaciente() {
        List<ObjPaciente> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, d.codigo,  c.nome, d.nome, "
                + " c.endereco, c.telefone,   "
                + " c.nascimento,   "
                + " c.rg,    "
                + " c.estado civil, c.sexo   "
                + " FROM paciente c                                "
                + " INNER JOIN cidades d ON c.codCidade = d.codigo "
                + " INNER JOIN consultas e ON c.codConsulta = e.codigo "
                + " WHERE c.tipo = ''   "
                + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {

            try {

                while (rs.next()) {
                    ObjPaciente pac = new ObjPaciente();
                    pac.setCodigo( rs.getInt(1));
                    pac.setNome(rs.getString(2));
                    pac.setTelefone(rs.getString(3));
                    pac.setEndereco(rs.getString(4));
                    pac.setNascimento(rs.getString(5));
                    pac.setRg(rs.getString(6));
                    pac.setSexo(rs.getString(7));
                    pac.setEstado_civil(rs.getString(8));
                    ObjCidade cid = new ObjCidade();
                    ObjConsulta con = new ObjConsulta();
                    pac.setCodigo( rs.getInt(2));
                    pac.setNome( rs.getString(4));
                    pac.setCidade( cid );
                    pac.setConsulta( con );
                    lista.add( pac );
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }

        }

        return lista;

    }
    public static Object getPacienteByCodigo( int codigo ){
        Object paciente = null;
         String sql = "SELECT c.codigo, d.codigo,  c.nome, d.nome, "
                + " c.endereco, c.telefone   "
                + " c.nascimento,   "
                + " c.rg,    "
                + " c.estado civil, c.sexo   "
                + " FROM clientes c                                "
                + " INNER JOIN cidades d ON c.codCidade = d.codigo "
                + " INNER JOIN consultas e ON c.codConsulta = e.codigo "
                + " WHERE c.codigo  = " + codigo 
                + " ORDER BY c.nome";
         ResultSet rs = Conexao.consultar(sql);
         try{
             rs.first();
             
             ObjCidade cidade = new ObjCidade();
             cidade.setCodigo(rs.getInt( 1 ));
             cidade.setNome(rs.getString( 2 ));
             String tipo = rs.getString(  );
             
             if( tipo.equals("") ) {
                 ObjPaciente pac = new ObjPaciente();
                 pac.setCodigo(rs.getInt( 1 ));
                 pac.setNome( rs.getString( 2 ));
                 pac.setTelefone(rs.getString( 3 ));
                 pac.setEndereco(rs.getString( 4 ));
                 pac.setNascimento(rs.getString( 5 ));
                 pac.setRg(rs.getString( 6 ));
                 pac.setSexo(rs.getString( 7 ));
                 pac.setEstado_civil(rs.getString( 8 ));
                 pac.setCidade( cidade );
                 paciente = pac;
            }
             
            
         }catch (Exception e){ 
         
         }
        
        return paciente;
         }
    }