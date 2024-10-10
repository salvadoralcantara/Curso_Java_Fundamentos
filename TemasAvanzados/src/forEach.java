public class forEach {
    public static void main(String[] args) {
        int edades[] = {22,13,55,43,21};

        // edad va obteniendo los valores del arreglo uno por uno
        for(int edad: edades){ // recorre el arreglo por medio de la direccion sin usar un indice
            System.out.println("Las edades son: " + edad); //no se puede usar un indice para eso esta el for normal
        }
    }
}
