package SA.zona_fit;

import SA.zona_fit.modelo.Cliente;
import SA.zona_fit.servicio.IClienteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

//@SpringBootApplication
public class ZonaFitApplication implements CommandLineRunner {

	@Autowired
	private IClienteServicio clienteServicio;

	private static final Logger logger = LoggerFactory.getLogger(ZonaFitApplication.class);

	String nl = System.lineSeparator();
	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion");
		//levantar la fabrica de spring
		SpringApplication.run(ZonaFitApplication.class, args);
		logger.info("Aplicacion finalizada!");
	}

	@Override
	public void run(String... args) throws Exception {
		zonaFitApp();
	}

	private void zonaFitApp(){
		boolean salir = false;
		Scanner input = new Scanner(System.in);
		while (!salir){
			var opcion = mostrarMenu(input);
			salir = ejecutarOpciones(input,opcion);
			logger.info(nl);

		}
	}

	private int mostrarMenu(Scanner input){
		logger.info("""
		\n *** Aplicacion Zona Fit ***
	1. Listar Clientes.
	2. Buscar Cliente por Id.
	3. Agregar Cliente.
	4. Modificar Cliente.
	5. Eliminar Cliente.
	6. Salir.
	Elige una opcion:\s""");
		return Integer.parseInt(input.nextLine());
	}

	private boolean ejecutarOpciones(Scanner input, int opcion){
		var salir = false;
		switch (opcion){
			case 1: {
				logger.info(nl + "--- Listado de Clientes ---" + nl);
				List<Cliente> clientes = clienteServicio.listarClientes();
				clientes.forEach(cliente -> logger.info(cliente.toString() + nl));
			} break;
			case 2: {
				logger.info(nl + "--- Buscar Cliente por Id ---" + nl);
				logger.info("Id de Cliente a buscar: ");
				var idCliente = Integer.parseInt(input.nextLine());
				Cliente cliente = clienteServicio.buscarClientePorId(idCliente);
				if (cliente != null){
					logger.info("Cliente econtrado: " + cliente + nl);
				} else{
					logger.info("Cliente No encontrado: " + cliente + nl);
				}
			} break;
			case 3: {
				logger.info(nl + "--- Agregar nuevo cliente --- " + nl);
				logger.info("Ingresa el nombre: ");
				String nombre = input.nextLine();
				logger.info("Ingresa el apellido: ");
				String apellido = input.nextLine();
				logger.info("Ingresa el valor de la membresia: ");
				int membresia = Integer.parseInt(input.nextLine());

				Cliente clienteNuevo = new Cliente();
				clienteNuevo.setNombre(nombre);
				clienteNuevo.setApellido(apellido);
				clienteNuevo.setMembresia(membresia);

				clienteServicio.guardarCliente(clienteNuevo);
				logger.info("Cliente agregado: " + clienteNuevo);
			} break;
			case 4: {
				logger.info(nl + "--- Modificacion de Clientes ---" + nl);
				logger.info("Ingresa el Id:");
				var idCliente = Integer.parseInt(input.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idCliente);
				if(cliente != null){
					logger.info("Ingresa el nombre: ");
					String nombre = input.nextLine();
					logger.info("Ingresa el apellido: ");
					String apellido = input.nextLine();
					logger.info("Ingresa el valor de la membresia: ");
					int membresia = Integer.parseInt(input.nextLine());

					cliente.setNombre(nombre);
					cliente.setApellido(apellido);
					cliente.setMembresia(membresia);

					clienteServicio.guardarCliente(cliente);
					logger.info("Cliente agregado: " + cliente);
				}
			} break;
			case 5:	{
				logger.info(nl + "--- Eliminar Cliente ---" + nl);
				logger.info("Ingresa el Id: ");
				var idEliminar = Integer.parseInt(input.nextLine());
				var cliente = clienteServicio.buscarClientePorId(idEliminar);
				if (cliente != null){
					clienteServicio.eliminarCliente(cliente);
					logger.info("Cliente eliminado: " + cliente);
				} else{
					logger.info("Cliente no encontrado...");
				}
			} break;
			case 6:	{
				logger.info("Finalizando ejecucion....." + nl + nl);
				salir = true;
			} break;
			default: {
				logger.info(nl + "Opcion no valida, vuelve a probar..." + nl);
			}
		}
		return salir;
	}
}
