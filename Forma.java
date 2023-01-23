import java.util.Scanner;
public class Forma {

    private String nombre;


    public Forma(String nombre) {
        this.nombre = nombre;
    }
    public String toString(){
        return nombre;
    }

    public double area() {
        return 0;
    }
}

class Esfera extends Forma {

    private double radio;

    public Esfera(double radio) {
        super("Esfera");
        this.radio = radio;
    }
    @Override
    public String toString() {
        return "Esfera";
    }
    @Override
    public double area() {
        return (4 * (Math.PI) * (Math.pow(radio, 2)));
    }
}

class Rectangulo extends Forma {

    private double longitud;
    private double ancho;

    public Rectangulo(double longitud, double ancho) {
        super("Rectangulo");

        this.longitud = longitud;
        this.ancho = ancho;
    }

    @Override
    public String toString() {
        return "Rectangulo";
    }
    @Override
    public double area() {
        return (longitud * ancho);
    }
}

class Cilindro extends Forma {

    private double radio;
    private double altura;

    public Cilindro(double radio, double altura) {
        super("Cilindro");

        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Cilindro";
    }
    @Override
    public double area() {
        return (Math.PI) * (Math.pow(radio, 2) * altura);
    }
}

class Pintura {

    private double cobertura;

        public Pintura(double cobertura){
            this.cobertura = cobertura;
        }
        public double getPintura (Forma forma) {
            return forma.area() / (cobertura);
        }
    }

class MAIN {
    public static void main(String[] args) {

        Pintura pintura = new Pintura(250);

        Rectangulo rectangulo = new Rectangulo(20, 35);
        System.out.println("El Area del Rectangulo es: " + pintura.getPintura(rectangulo));

        Esfera esfera = new Esfera(15);
        System.out.println("El Area de la Esfera es: " + pintura.getPintura(esfera));

        Cilindro cilindro = new Cilindro(10, 30);
        System.out.println("El Area del Cilindro es: " + pintura.getPintura(cilindro));

    }
}