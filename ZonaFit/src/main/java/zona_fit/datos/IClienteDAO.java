package zona_fit.datos;

import zona_fit.dominio.Cliente;

import java.util.List;

public interface IClienteDAO {
    List<Cliente> ListarClientes();
    Boolean buscarClientePorId(Cliente cliente);
    Boolean agregarCliente(Cliente cliente);
    Boolean modificarCliente(Cliente cliente);
    Boolean eliminarCliente(Cliente cliente);
}
