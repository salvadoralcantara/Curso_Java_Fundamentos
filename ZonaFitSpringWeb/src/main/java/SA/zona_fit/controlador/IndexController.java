package SA.zona_fit.controlador;

import SA.zona_fit.modelo.Cliente;
import SA.zona_fit.servicio.IClienteServicio;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import lombok.Data;
import org.primefaces.PrimeFaces;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import org.slf4j.Logger;

@Component //  Indica que esta clase es un componente de Spring, permitiendo que sea gestionada por la fábrica de beans de Spring Boot.
@Data // Genera automáticamente los métodos getters/setters, toString, y equals/hashCode.
@ViewScoped // Mantiene los datos mientras la vista esté cargada (útil para aplicaciones de una sola página con JSF).
public class IndexController {

    @Autowired  // Inyecta la dependencia del servicio que maneja los datos de los clientes.
    IClienteServicio clienteServicio;
    private List<Cliente> clientes;
    private Cliente clienteSeleccionado;
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);

    @PostConstruct //  Se ejecuta después de que Spring crea la instancia de la clase.
    public void init(){
        cargarDatos();
    }

    public void cargarDatos(){
        this.clientes = this.clienteServicio.listarClientes();
        this.clientes.forEach(cliente -> logger.info(cliente.toString())); // Registra cada cliente en la bitácora del sistema (log.info(...)).
    }

    public void agregarCliente(){
        this.clienteSeleccionado = new Cliente();
    }

    public void guardarCliente(){
        logger.info("cliente a guardar: " + this.clienteSeleccionado);
        //agregar:
        if (this.clienteSeleccionado.getId() == null){
            this.clienteServicio.guardarCliente(this.clienteSeleccionado);
            this.clientes.add(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente Agregado"));
        }
        // Actualizar clientes:
        else{
            this.clienteServicio.guardarCliente(this.clienteSeleccionado);
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage("Cliente actualizados"));
        }
// Ocultar la ventana modal
        PrimeFaces.current().executeScript("PF('ventanaModalCliente').hide()");
// Actualizar la tabla usando ajax
        PrimeFaces.current().ajax().update("forma-clientes:mensajes",
                "forma-clientes:clientes-tabla");
// Reset del objeto cliente seleccionado
        this.clienteSeleccionado = null;
    }

    public void eliminarCliente(){
        logger.info("Cliente eliminado: " + this.clienteSeleccionado);
        this.clienteServicio.eliminarCliente(this.clienteSeleccionado);

        //Elimina el registro de la lista clientes:
        this.clientes.remove(this.clienteSeleccionado);
        //Reset del objeto del cliente seleccionado
        this.clienteSeleccionado = null;
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Cliente Eliminado"));
        PrimeFaces.current().ajax().update("forma-clientes:mensajes",
                "forma-clientes:clientes-tabla");


        this.clienteSeleccionado = null;
    }
}