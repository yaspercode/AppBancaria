package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Cuenta;

/**
 *
 * @author HP
 */
public class CuentaDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    //Si la credencial es valida me va a retornar true, si no false
    public boolean validarCuenta(Cuenta c){
        boolean esValida = false;
        try{
            con = MYSQLConexion.getConexion();
            if(con == null){
                JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión con la base de datos");
                return false;
            }
            String sql = "SELECT COUNT(*) AS Cantidad FROM cuenta WHERE numero_cuenta=? AND clave=?;";
            ps = con.prepareStatement(sql);
            ps.setString(1, c.getNumero_cuenta());
            ps.setInt(2, c.getClave());
            rs = ps.executeQuery();
            while (rs.next()) {
                int cantidad = rs.getInt("Cantidad");
                esValida= cantidad == 1;
            }
            rs.close();
            ps.close();
            con.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return esValida;
    }
    
}
