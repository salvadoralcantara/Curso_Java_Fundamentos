package SA.zona_fit.gui;

import SA.zona_fit.modelo.Cliente;
import SA.zona_fit.servicio.ClienteServicio;
import SA.zona_fit.servicio.IClienteServicio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@Slf4j
//@Component
public class ZonaFitForma extends JFrame {
    private JPanel panelPrincipal;
    private JTable clientesTabla;
    private JScrollPane scrollPane1;
    private JTextField textFieldNombre;
    private JTextField textFieldApellido;
    private JTextField textFieldMembresia;
    private JButton guardarButton;
    private JButton eliminarButton;
    private JButton limpiarCamposButton;
    IClienteServicio clienteServicio;
    private DefaultTableModel tablaModeloClientes;
    private Integer idCliente;

    @Autowired
    public ZonaFitForma(ClienteServicio clienteServicio){
        this.clienteServicio = clienteServicio;
        iniciarForma();
        guardarButton.addActionListener(e -> guardarCliente());
        clientesTabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                cargarClienteSeleccionado();
            }
        });
        limpiarCamposButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                limpiarFormulario();
            }
        });
        eliminarButton.addActionListener(e -> eliminarCliente());
    }


    private void iniciarForma(){
        add(panelPrincipal);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(900,700);
        setLocationRelativeTo(null);

    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

        this.tablaModeloClientes = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column) { // No se puede editar la tabla directamente.
                return false;
            }
        };
        String[] columnasCabecera = {"ID", "Nombre", "Apellido", "Edad"};
        this.tablaModeloClientes.setColumnIdentifiers(columnasCabecera);
        this.clientesTabla = new JTable(tablaModeloClientes);
        // Permite la seleccion de un solo renglon
        this.clientesTabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // Agregacion de lista de clientes a la tabla
        listarClientes();
    }

    private void listarClientes(){
        this.tablaModeloClientes.setRowCount(0);
        var clientes = this.clienteServicio.listarClientes();
        clientes.forEach(cliente -> {
            Object[] renglonCliente = {
                    cliente.getId(),
                    cliente.getNombre(),
                    cliente.getApellido(),
                    cliente.getMembresia()
            };
            this.tablaModeloClientes.addRow(renglonCliente);
        });
    }

    private void guardarCliente() {
        if (textFieldNombre.getText().equals("")) {
            mostrarMensaje("El nombre es requerido");
            textFieldNombre.requestFocusInWindow();
            return;
        }
        if (textFieldMembresia.getText().equals("")) {
            mostrarMensaje("El valor de la Membresía es requerido");
            textFieldMembresia.requestFocusInWindow();
            return;
        }

        try {
            // Recupera los valores de los campos
            var nombre = textFieldNombre.getText();
            var apellido = textFieldApellido.getText();
            var membresia = Double.parseDouble(textFieldMembresia.getText()); // <-- Acepta acepta flotantes

            // Objeto cliente
            var cliente = new Cliente();
            cliente.setNombre(nombre);
            cliente.setApellido(apellido);
            cliente.setMembresia((int) membresia); // Cambia el numero por un int si hace falta

            this.clienteServicio.guardarCliente(cliente); // se encarga de guardar en la DB

            if (this.idCliente == null) {
                mostrarMensaje("Cliente guardado con éxito");
            } else {
                mostrarMensaje("Cliente actualizado con éxito");
            }

            limpiarFormulario();
            listarClientes();

        } catch (NumberFormatException e) {
            mostrarMensaje("El valor de la Membresía debe ser numérico.");
            textFieldMembresia.requestFocusInWindow();
        }
    }



    private void cargarClienteSeleccionado(){
    var renglon = clientesTabla.getSelectedRow();
    if(renglon != -1){ // -1 significa que no se ha seleccionado ningun renglon
        var id = clientesTabla.getModel().getValueAt(renglon, 0).toString();
        this.idCliente = Integer.parseInt(id);
        var nombre = clientesTabla.getModel().getValueAt(renglon, 1).toString();
        this.textFieldNombre.setText(nombre);
        var apellido = clientesTabla.getModel().getValueAt(renglon, 2).toString();
        this.textFieldApellido.setText(apellido);
        var membresia = clientesTabla.getModel().getValueAt(renglon, 3).toString();
        this.textFieldMembresia.setText(membresia);
    }
}

    private void eliminarCliente() {
    var renglon = clientesTabla.getSelectedRow();
    if (renglon != -1){
        var idClienteStr = clientesTabla.getModel().getValueAt(renglon,0).toString();
        this.idCliente = Integer.parseInt(idClienteStr);
        var cliente = new Cliente();
        cliente.setId(this.idCliente);
        clienteServicio.eliminarCliente(cliente);
        mostrarMensaje("Cliente con " + this.idCliente + " eliminado con exito");
        limpiarFormulario();
        listarClientes();
    } else {
        mostrarMensaje("Seleccione un cliente para eliminar");
    }
    }

    private void mostrarMensaje(String mensaje){
        JOptionPane.showMessageDialog(this, mensaje);
    }

    private void limpiarFormulario(){
        textFieldNombre.setText("");
        textFieldApellido.setText("");
        textFieldMembresia.setText("");
        this.idCliente = null;
        // Deseleccionamos el registro seleccionado de la tabla
        this.clientesTabla.getSelectionModel().clearSelection();
    }
}
