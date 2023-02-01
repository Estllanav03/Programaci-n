import com.sun.prism.es2.ES2ResourceFactory;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Estudiante implements Comparable<Estudiante>{

    public static int length;
    public String nombre;
    public int edad;
    public int altura;

    public Estudiante(String nombre, int edad, int altura) {

        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    public String getNombre() {
        return nombre;
    }
    public int getAltura() {
        return altura;
    }
    public int getEdad() {
        return edad;
    }

    public void setNombre() {
        this.nombre = nombre;
    }
    public void setAltura() {
        this.altura = altura;
    }
    public void setEdad() {
        this.edad = edad;
    }

    public String toString(){
        String nae="";
        nae = "Nombre:\t" + nombre+"\tAltura:\t" + altura + "\tedad:  " + edad;
        return nae;
    }

    @Override
   public int compareTo (Estudiante o ) {

        int resultado = 0;

        if(this.altura > o.altura) {
            resultado = -1;
        }else if(this.altura < o.altura){
            resultado = 1;
        }else{
            if(this.edad < o.edad){
                resultado = 1;
            }else if(this.edad > o.edad){
                resultado = -1;
            }
        }
        return resultado;
            }
        }

class Programaa{
    public static void main(String[] args){
        Estudiante[] estudiantes=new Estudiante[5];
        estudiantes[0] = new Estudiante("Patri", 12, 170);
        estudiantes[1] = new Estudiante("Manuel", 43, 173);
        estudiantes[2] = new Estudiante("Javier", 72, 189);
        estudiantes[3] = new Estudiante("Alicia", 52, 168);
        estudiantes[4] = new Estudiante("Alberto", 35, 189);


        Arrays.sort(estudiantes);

        for(int i = 0; i < estudiantes.length; i++){
            System.out.println(estudiantes[i].getNombre() +  " - Altura: " + estudiantes[i].getAltura()  +" - Edad: "  + estudiantes[i].getEdad());
        }




    }
}
