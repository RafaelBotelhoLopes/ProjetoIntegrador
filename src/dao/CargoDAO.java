package dao;

import model.ObjCargo;

public class CargoDAO {
    public static void inserir(ObjCargo car) {
        String sql = "INSERT INTO cargos "
                + " ( data_consulta, codPaciente, codFuncionario, codLaudo ) "
                + " VALUES ( "
                + " '" + car.getNome()+        "' , "
                + " '" + car.getSalario()+             "' , "
                + "  " + car.getSetor().getCodigo()+          "'  "
                + " );";
        Conexao.executar(sql);
}
    public static void editar(ObjCargo car) {
        String sql = "UPDATE cargos SET "
                + " '" + car.getNome()+        "' , "
                + " '" + car.getSalario()+             "' , "
                + " '" + car.getSetor().getCodigo()+          "' , "
                + " WHERE codigo = " + car.getCodigo();

        Conexao.executar(sql);
    
    }
    public static void excluir(ObjCargo car) {
        String sql = "DELETE FROM cargos " + car.getCodigo();
        Conexao.executar(sql);
}
}
