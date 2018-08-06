
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import model.ObjConsulta;
import model.ObjFuncionario;
import model.ObjLaudo;
import model.ObjPaciente;


public class ConsultaDAO {
    public static void inserir(ObjConsulta con) {
        String sql = "INSERT INTO consultas "
                + " ( data_consulta, codPaciente, codFuncionario, codLaudo ) "
                + " VALUES ( "
                + " '" + con.getData_consulta()+        "' , "
                + " '" + con.getPaciente().getCodigo()+             "' , "
                + " '" + con.getFuncionario().getCodigo()+          "' , "
                + "  " + con.getLaudo().getCodigo()+                "    "                
                + " );";
}
    public static void editar(ObjConsulta con) {
        String sql = "UPDATE consultas SET "
                + " data_consulta = " + con.getData_consulta()+   " , "
                + " codPaciente = " + con.getPaciente().getCodigo()+             " , "
                + " codFuncionario = " + con.getFuncionario().getCodigo()+       "' , "
                + " codLaudo = " + con.getLaudo().getCodigo()+                   "    "                
                + " );";
}
    public static void excluir(ObjConsulta con) {
        String sql = "delete from consultas where codigo = " + con.getCodigo();
        Conexao.executar(sql);

    }
    public static List<ObjConsulta> getConsulta() {
        List<ObjConsulta> lista = new ArrayList<>();
        String sql = "SELECT c.codigo, p.codigo, f.codigo, l.codigo,"
                + " DATE_FORMAT(c.data_consulta, '%d') AS DIA, DATE_FORMAT(c.data_consulta, '%m') AS MES, DATE_FORMAT(c.data_consulta, '%Y') AS ANO  ,   "
                + " FROM consultas c                                "
                + " INNER JOIN pacientes p ON c.codPaciente = p.codigo "
                + " INNER JOIN funcionarios f ON c.codFuncionario = f.codigo "
                + " INNER JOIN laudos l ON c.codLaudo = l.codigo "
                + " ORDER BY p.nome";
        ResultSet rs = Conexao.consultar(sql);

        if (rs != null) {

            try {
                ObjConsulta con = new ObjConsulta();
                con.setCodigo(rs.getInt(1));
                
                ObjFuncionario fun = new ObjFuncionario();
                fun.setCodigo(3);
                
                ObjPaciente pac = new ObjPaciente();
                pac.setCodigo(2);
                
                ObjLaudo lau = new ObjLaudo();
                lau.setCodigo(4);
                
                Date data_consulta = new Date(rs.getInt(7), (rs.getInt(6) - 1), rs.getInt(5));                
                
                lista.add(con);
                

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
        return lista;
    }    
}


