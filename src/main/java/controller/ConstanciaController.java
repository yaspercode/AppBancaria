package controller;

import dao.TransferenciaDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.DatosFormulario;
import model.Transferencia;
import view.frmConstancia;
import view.frmMenu;

/**
 *
 * @author HP
 */
public class ConstanciaController implements ActionListener{
    private frmConstancia formularioConstancia;
    private frmMenu formularioMenu;
    private DatosFormulario datosFormulario;
    private TransferenciaDAO transferenciaDAO = new TransferenciaDAO();
    private Transferencia transferencia;

    public ConstanciaController(frmConstancia formularioConstancia) {
        this.formularioConstancia = formularioConstancia;
        this.formularioConstancia.setResizable(false);//Desabilirar el cambio de tamaño
        this.formularioConstancia.setLocationRelativeTo(null);//Establece en el centro
        this.formularioConstancia.btnInicio.addActionListener(this);
        datosFormulario = DatosFormulario.getInstance();
        rellenarDatos();
    }
    
    public void rellenarDatos(){
        //Obtener los datos de memoria 
        formularioConstancia.txtCuentaOrigen.setText(datosFormulario.getNumeroCuentaOrigen());
        formularioConstancia.txtCuentaDestino.setText(datosFormulario.getNumeroCuentaDestino());
        int idCuentaOrigen = datosFormulario.getIdCuentaOrigen();
        //Obtener la ultima transación
        transferencia = new Transferencia();
        //Obtener el último dato de la id de la cuenta de origen
        transferencia = transferenciaDAO.getOneTransferencia(idCuentaOrigen);
        //Obtener fecha
        formularioConstancia.lbFecha.setText(transferencia.getFecha());
        //Obtener monto
        formularioConstancia.lbMonto.setText("S/. "+transferencia.getTotal()+"");
        //Obtener id de la Transferencia
        formularioConstancia.txtNumeroOperacion.setText(transferencia.getIdTransferencia()+"");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(formularioConstancia.btnInicio)){
            formularioMenu = new frmMenu();
            formularioMenu.setVisible(true);
            this.formularioConstancia.dispose();
        }
    }
    
    
}
