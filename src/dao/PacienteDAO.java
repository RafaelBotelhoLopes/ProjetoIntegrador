
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjCidade;
import model.ObjPaciente;


public class PacienteDAO {

    public static void inserir(ObjPaciente cli) {
        String sql = "INSERT INTO pacientes "
                + " ( nome, telefone, endereco, nascimento, rg, sexo, codCidade ) "
                + " VALUES ( "
                + " '" + cli.getNome() +               "' , "
                + " '" + cli.getTelefone() +           "' , "
                + " '" + cli.getEndereco() +           "' , "
                + " '" + cli.getNascimento() +               "' , "
                + "  " + cli.getCidade().getCodigo() + "    "
                + " );";

        Conexao.executar(sql);
    }

    public static void editar(ObjPaciente cli) {
        String sql = "UPDATE clientes SET "
                + " nome = '" + cli.getNome() +                    "' , "
                + " endereco = '" + cli.getTelefone()   +          "' , "
                + " telefone = '" + cli.getNascimento()  +           "' , "
                + " tipo = '" + cli.getRg() +                    "' , "
                + " tipo = '" + cli.getSexo() +                    "' , "
                + " codCidade = '" + cli.getCidade().getCodigo() + "    "
                + " WHERE codigo = " + cli.getCodigo();

        Conexao.executar(sql);
    }

    public static void excluir(ObjPaciente cli) {
        String sql = "DELETE FROM paciente " + cli.getCodigo();
        Conexao.executar(sql);

    }

    public static List<ObjPaciente> getPaciente() {
        List<ObjPaciente> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, d.codigo,  c.nome, d.nome, "
                + " c.endereco, c.telefone   "
                + " FROM paciente c                                "
                + " INNER JOIN cidades d ON c.codCidade = d.codigo "
                + " WHERE c.tipo = ''   "
                + " ORDER BY c.nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {

            try {

                while (rs.next()) {
                    ObjPaciente cli = new ObjPaciente();
                    cli.setCodigo( rs.getInt(1));
                    cli.setNome(rs.getString(3));
                    cli.setTelefone(rs.getString(5));
                    cli.setEndereco(rs.getString(6));
                    cli.setNascimento(rs.getString(6));
                    cli.setRg(rs.getString(6));
                    cli.setCodigo(rs.getString(6));
                    ObjCidade cid = new ObjCidade();
                    cid.setCodigo( rs.getInt(2));
                    cid.setNome( rs.getString(4));
                    cli.setCidade( cid );
                    lista.add( cli );
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
                + " FROM clientes c                                "
                + " INNER JOIN cidades d ON c.codCidade = d.codigo "
                + " WHERE c.codigo  = " + codigo 
                + " ORDER BY c.nome";
         ResultSet rs = Conexao.consultar(sql);
         try{
             rs.first();
             
             ObjCidade cidade = new ObjCidade();
             cidade.setCodigo(rs.getInt( 2 ));
             cidade.setNome(rs.getString( 4 ));
             String tipo = rs.getString( 7 );
             
             if( tipo.equals("") ) {
                 ObjPaciente cli = new ObjPaciente();
                 cli.setCodigo(rs.getInt( 1 ));
                 cli.setNome( rs.getString( 3 ));
                 cli.setEndereco(rs.getString( 5 ));
                 cli.setTelefone(rs.getString( 6 ));
                 cli.setTipo(tipo);
                 cli.setCidade( cidade );
                 cliente = cli;
             }
             if( tipo.equals( ObjCliente.PESSOA_FISICA)) {
             ObjClienteFisico cf = new ObjClienteFisico(); {
             cf.setCodigo(rs.getInt( 1 ));
             cf.setNome(rs.getString( 3 ));
             cf.setEndereco(rs.getString( 5 ));
             cf.setTelefone(rs.getString( 6 ));
             cf.setCidade(cidade);
             cf.setTipo(tipo);
             cf.setCpf(rs.getString( 8 ));
             cf.setRg(rs.getString( 9 ));
             paciente = cf;
             
                 
             }
             }
             
            
         }catch (Exception e){ 
         
         }
        
        return paciente;
         }
    }