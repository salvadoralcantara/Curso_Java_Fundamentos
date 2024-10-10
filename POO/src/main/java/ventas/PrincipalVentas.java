package ventas;

public class PrincipalVentas {
    public static void main(String[] args) {
        System.out.println("*** Sistema de ventas ***");
        var producto1 = new Producto("zapatos",20.00);
        var producto2 = new Producto("Camisa", 5.00);

        var orden1 = new Orden();
        orden1.agregarProducto(producto1);
        orden1.agregarProducto(producto2);
        System.out.println(orden1);

    }
}
