package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Transferencia;
import model.Cuenta;

/**
 *
 * @author HP
 */
public class TransferenciaDAO {
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    List<Transferencia> lista;
    Transferencia t;
    //Método para listar todas las transferencias
    public List<Transferencia> listar(String numero_cuenta){
        lista = new ArrayList<>();
        try{
            con = MYSQLConexion.getConexion();
            if(con == null){
                JOptionPane.showMessageDialog(null, "No se puedo establecer la conexión con la base de datos");
                return lista;
            }
            String sql = "SELECT t.fecha, t.tipo_transferencia, t.total\n" +
            "FROM Cuenta c\n" +
            "JOIN transferencia t ON c.id_cuenta = t.id_cuenta_origen OR c.id_cuenta = t.id_cuenta_destino\n" +
            "WHERE c.numero_cuenta = '"+numero_cuenta+"'\n" +
            "ORDER BY t.fecha DESC;";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                t = new Transferencia();
                t.setFecha(rs.getString(1));
                t.setTipoTransferencia(rs.getString(2));
                t.setTotal(rs.getDouble(3));
                lista.add(t);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return lista;
    }
    
    
    //Método para agregar una nueva transferencia
    public void agregarTransferencia(Transferencia transferencia) throws SQLException {
        con = MYSQLConexion.getConexion();
        String query = "INSERT INTO Transferencia (id_transferencia, id_cuenta_origen, id_cuenta_destino, cantidad, fecha, descripcion) VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setInt(1, transferencia.getIdTransferencia());
            statement.setInt(2, transferencia.getCuentaOrigen().getIdCuenta());
            statement.setInt(3, transferencia.getCuentaDestino().getIdCuenta());
            statement.setDouble(4, transferencia.getTotal());
            statement.setString(5, transferencia.getFecha());
            statement.setString(6, transferencia.getDescripcion());

            statement.executeUpdate();
        }
    }
    
    // Método para actualizar el saldo de una cuenta después de realizar una transferencia
    public void actualizarSaldo(Cuenta cuenta, double nuevoSaldo) throws SQLException {
        con = MYSQLConexion.getConexion();
        String query = "UPDATE Cuenta SET saldo = ? WHERE id_cuenta = ?";

        try (PreparedStatement statement = con.prepareStatement(query)) {
            statement.setDouble(1, nuevoSaldo);
            statement.setInt(2, cuenta.getIdCuenta());

            statement.executeUpdate();
        }
    }
}
