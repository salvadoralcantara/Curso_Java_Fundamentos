package zona_fit.presentacion;

import zona_fit.dominio.Cliente;
import zona_fit.datos.ClienteDAO;

import java.util.Scanner;

public class ZonaFitApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcion = 0;
        var salir = !false;
        
        while (salir){
            System.out.printf("*** Menu Zona Fit App ***\n" +
                    "Opciones: \n" +
                    "       1. Mostrar Lista.\n" +
                    "       2. Buscar.\n" +
                    "       3. Agregar.\n" +
                    "       4. Modificar.\n" +
                    "       5. Eliminar.\n" +
                    "       6. Salir.\n");

            System.out.printf("Ingresa el numero de una opcion: ");
            opcion = input.nextInt();
            ClienteDAO clienteDao = new ClienteDAO();

            switch (opcion){
                case 1:
                    System.out.println("--- Listado Clientes ---");
                    var clienteLista = clienteDao.ListarClientes();
                    clienteLista.forEach(System.out::println);
                break;
                case 2:
                    System.out.println("--- Buscar Cliente ---");
                    System.out.print("Ingresa el numero de ID del cliente: ");
                    var idBuscar = input.nextInt();
                    var clienteBuscar = new Cliente(idBuscar);
                    var clientBuscado = clienteDao.buscarClientePorId(clienteBuscar);
                    if (clientBuscado){
                        System.out.print("Cliente encontrado: " + clienteBuscar);
                    }else {
                        System.out.println("Cliente no encontrado: " + clienteBuscar);
                    }
                    break;
                case 3:
                    System.out.println("--- Agregar Cliente ---");
                    System.out.println("* Ingresa los datos del nuevo Cliente *");
                    input.nextLine(); //limpia buffer de input
                    System.out.print("Nombre: ");
                    String nombreAgregar = input.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoAgregar = input.nextLine();
                    System.out.print("Precio de membresia: ");
                    int membresiaAgregar = input.nextInt();

                    Cliente clienteAgregar = new Cliente(nombreAgregar,apellidoAgregar, membresiaAgregar);
                    var clienteAgregado = clienteDao.agregarCliente(clienteAgregar);
                    if (clienteAgregado){
                        System.out.println("Cliente agregado: " + clienteAgregar);
                    } else {
                        System.out.println("Cliente no pudo ser agregado...");
                    }
                    break;
                case 4:
                    System.out.println("--- Modificar Clientes ---");
                    System.out.print("Id: ");
                    int id = input.nextInt();
                    input.nextLine(); //limpia buffer de input
                    System.out.print("Nombre: ");
                    String nombreModificar = input.nextLine();
                    System.out.print("Apellido: ");
                    String apellidoModificar = input.nextLine();
                    System.out.print("Precio de membresia: ");
                    int membresiaModificar= input.nextInt();

                    Cliente clienteModificacion = new Cliente(id, nombreModificar, apellidoModificar, membresiaModificar);
                    var clienteModificado = clienteDao.modificarCliente(clienteModificacion);
                    if(clienteModificado){
                        System.out.println("Cliente modificado: "+ clienteModificacion);
                    }else {
                        System.out.println("El cliente no se pudo modificar...");
                    }
                    break;
                case 5:
                    System.out.println("--- Eliminar Clientes ---");
                    System.out.print("Id: ");
                    var idEliminar = input.nextInt();

                    var clienteEliminar = new Cliente(idEliminar);
                    var clienteEliminado = clienteDao.eliminarCliente(clienteEliminar);
                    if (clienteEliminado){
                        System.out.println("Cliente eliminado con exito.");
                    }
                    break;
                case 6:
                    salir = false;
                    System.out.println("Hasta pronto...");
                    break;
                default:
                    System.out.println("Opcion no valida...");
            }
        }
    }
}
