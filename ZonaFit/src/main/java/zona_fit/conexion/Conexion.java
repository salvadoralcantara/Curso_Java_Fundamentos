package zona_fit.conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    public static Connection getConnection(){
        Connection conexion = null;
        var baseDatos = "zona_fit_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "admin"; //dependera del password asignado en mysql en cada maquina de forma local.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        }catch (Exception e){
            System.out.println("Error al conentarse a la DB: " + e.getMessage());
        }
            return conexion;
    }

    public static void main(String[] args) {
        System.out.println("Prueba Conexion a db: \n");
        var prueba = Conexion.getConnection();
        if (prueba == null){
            System.out.println("Conexion fallida");
        }else {
            System.out.println("Conexion exitosa");

        }    }
}
