public class ClasesAbstracta {
    public static void main(String[] args) {
       var rectagulo1 = new Rectangulo();
       rectagulo1.dibujarFigura();

       FiguraGeometrica figuraGeometrica1 = new Rectangulo();
       figuraGeometrica1.dibujarFigura();


    }
}

//No se pueden instanciar las clases abstract solo sus hijas
abstract class FiguraGeometrica{

    public abstract void dibujarFigura();
}

class Rectangulo extends FiguraGeometrica{
    public void dibujarFigura(){
        System.out.println("se dibujar Rectangulo");
    }
}
