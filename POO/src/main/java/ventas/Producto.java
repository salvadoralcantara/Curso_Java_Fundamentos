package ventas;

public class Producto {
    private final int idProducto;
    private static int contadorProductos;

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio){
        //incremento a idProducto antes de asignarlo a idProducto
        this.idProducto = ++Producto.contadorProductos;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getIdProducto() {
        return idProducto;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + this.idProducto +
                ", nombre='" + this.nombre + '\'' +
                ", precio=" + this.precio +
                '}';
    }
}
