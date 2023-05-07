package dao;
import java.sql.*;
/**
 *
 * @author HP
 */
public class MYSQLConexion {
    public static Connection getConexion(){
        Connection con=null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://localhost/app_bancaria";
            String usr="root";
            String psw="*SoloLeveling20*";
            con= DriverManager.getConnection(url,usr,psw);
            System.out.println("Conexión exitosa");
        } catch(ClassNotFoundException ex){
            System.out.println("No se encontro Driver");
        } catch(SQLException ex){
            System.out.println("Error con la base de datos");
        }
        return con; 
    }
}
