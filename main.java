import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class main {

    private static Map<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1,"Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2,"Estás bañandote en la playa"));
        ubicaciones.put(3, new Ubicacion(3,"Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4,"Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5,"Estás en un bosque"));

        ubicaciones.get(1).addExit("O" , 2);
        ubicaciones.get(1).addExit("E" , 3);
        ubicaciones.get(1).addExit("S" , 4);
        ubicaciones.get(1).addExit("N" , 5);
        ubicaciones.get(0).addExit("Q" , 0);

        ubicaciones.get(2).addExit("N" , 5);
        ubicaciones.get(0).addExit("Q" , 0);

        ubicaciones.get(3).addExit("O" , 1);
        ubicaciones.get(0).addExit("Q" , 0);

        ubicaciones.get(4).addExit("N" ,1);
        ubicaciones.get(4).addExit("O" ,2);
        ubicaciones.get(0).addExit("Q" , 0);

        ubicaciones.get(5).addExit("S" , 1);
        ubicaciones.get(5).addExit("O" , 2);
        ubicaciones.get(0).addExit("Q" , 0);


        int ubc = 1;
        while(true) {
            System.out.println(ubicaciones.get(ubc).getDescripcion());
            if(ubc == 0) {
                break;
            }
            Map<String, Integer> exits = ubicaciones.get(ubc).getExits();
            System.out.println("Sálidas disponibles: ");

            for (String exit : exits.keySet()) {
                System.out.println(exit + ", ");
            }
            String direcion = sc.nextLine().toUpperCase();

            if (exits.containsKey(direcion)) {
                ubc = exits.get(direcion);
            }else {
                System.out.println("No puede ir a esa dirección");
            }
        }

    }
}
