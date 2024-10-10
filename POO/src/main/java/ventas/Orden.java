package ventas;

import java.util.Arrays;

public class Orden {
    private final int idOrden;
    private Producto[] productos;
    private int contadorProductos;

    private static int contadorOrdenes;
    private static final int MAX_PRODUCTOS = 10;

    public Orden(){
        this.idOrden = ++Orden.contadorOrdenes;
        this.productos = new Producto[Orden.MAX_PRODUCTOS];
    }

    public void agregarProducto(Producto producto){
        if (this.contadorProductos < Orden.MAX_PRODUCTOS) {
            this.productos[this.contadorProductos++] = producto;
        }else{
            System.out.println("Se ha superado el maximo de productos de : " +
                    Orden.MAX_PRODUCTOS);
        }
    }

    public double calcularTotal(){
        double total = 0;
        for (var i = 0; i < this.contadorProductos; i++){
            var producto = productos[i];
            total += producto.getPrecio();
        }
        return  total;
    }

    public Orden(int idOrden, Producto[] productos, int contadorProductos) {
        this.idOrden = idOrden;
        this.productos = productos;
        this.contadorProductos = contadorProductos;
    }

    @Override
    public String toString() {
        return "Orden{" +
                "idOrden=" + idOrden +
                ", productos=" + Arrays.toString(productos) +
                ", contadorProductos=" + contadorProductos +
                ", Total=" + calcularTotal() +
                '}';
    }
}
