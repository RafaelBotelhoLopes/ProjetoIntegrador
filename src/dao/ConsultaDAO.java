
package dao;

import model.ObjConsulta;


public class ConsultaDAO {
    public static void inserir(ObjConsulta con) {
        String sql = "INSERT INTO consultas "
                + " ( data consulta, codPaciente, codFuncionario, codLaudo ) "
                + " VALUES ( "
                + " '" + con.getData_consulta()+        "' , "
                + " '" + con.getPaciente()+             "' , "
                + " '" + con.getFuncionario()+          "' , "
                + "  " + con.getLaudo()+                "    "                
                + " );";
}
    public static void editar(ObjConsulta con) {
        String sql = "UPDATE consultas SET "
                + " data consulta = " + con.getData_consulta()+   " , "
                + " paciente = " + con.getPaciente()+             " , "
                + " funcionario = " + con.getFuncionario()+       "' , "
                + " laudo = " + con.getLaudo()+                   "    "                
                + " );";
}
    public static void excluir(ObjConsulta con) {
        String sql = "delete from consultas where codigo = " + con.getCodigo();
        Conexao.executar(sql);

    }
}
