package zona_fit.datos;

import zona_fit.conexion.Conexion;
import zona_fit.dominio.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO implements IClienteDAO{
    @Override
    public List<Cliente> ListarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        PreparedStatement ps;
        ResultSet rs;
        Connection con = Conexion.getConnection();
        var sql = "SELECT * FROM cliente Order BY id";

        try{
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){ //.next() recorre todos los registros desde el inicio, si no hay registro regresa false
                var cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                clientes.add(cliente);
            }
        } catch (Exception e) {
            System.out.println("Error al listar clientes: " + e.getMessage());
        } finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conenxion: " + e.getMessage());
            }
        }
        return clientes;
    }

    @Override
    public Boolean buscarClientePorId(Cliente cliente) {
        PreparedStatement ps;
        ResultSet rs;
        var con = Conexion.getConnection();
        var sql = "SELECT * FROM cliente WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, cliente.getId()); // 1 es el indice del parametro y .getId obtiene el valor de ese indice
            rs = ps.executeQuery();
            // se verifica con .next() si hay un objeto al cual llenar
            if (rs.next()){
                cliente.setNombre( rs.getString("nombre"));
                cliente.setApellido(rs.getString("apellido"));
                cliente.setMembresia(rs.getInt("membresia"));
                return true;
            }

        }catch (Exception e){
            System.out.println("Error al buscar Cliente: " + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conenxion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Boolean agregarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        String sql = "INSERT INTO cliente(nombre, apellido, membresia) " + " VALUES(?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1,cliente.getNombre());
            ps.setString(2,cliente.getApellido());
            ps.setInt(3,cliente.getMembresia());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al agregar registro cliente..." + e.getMessage());
        }
        finally {
            try{
                con.close();
            } catch (Exception e){
                System.out.println("Error al cerrar la conenxion" + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Boolean modificarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        var sql = "UPDATE cliente SET nombre=?, apellido=?, membresia=? " +
                "WHERE id = ?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApellido());
            ps.setInt(3, cliente.getMembresia());
            ps.setInt(4, cliente.getId());
            ps.execute();
            return true;
        }catch (Exception e){
            System.out.println("Error al modificar registro cliente: " + e.getMessage());
        } finally {
            try {
                con.close();
            }catch (Exception e){
                System.out.println("Error al cerrar la conenxion: " + e.getMessage());
            }
        }
        return false;
    }

    @Override
    public Boolean eliminarCliente(Cliente cliente) {
        PreparedStatement ps;
        Connection con = Conexion.getConnection();
        String sql = "DELETE FROM cliente WHERE id = ?";
        try {
        ps = con.prepareStatement(sql);
        ps.setInt(1, cliente.getId());
        ps.execute();
        return true;
        } catch (Exception e) {
            System.out.println("Error al eliminar cliente: " + e.getMessage());
        }finally {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error al cerrar conenxion: " + e.getMessage());
            }
        }
        return false;
    }
}
