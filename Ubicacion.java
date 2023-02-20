import java.util.HashMap;
import java.util.Map;

public class Ubicacion {

    private final int id;
    private final String descripcion;
    private final Map<String, Integer> exits;

    public Ubicacion(int id, String descripcion){

        this.id = id;
        this.descripcion = descripcion;
        this.exits = new HashMap<>();
        this.exits.put("Q", 0);
    }

    public void addExit(String direcion, int idUbicacion) {
        exits.put(direcion, idUbicacion);
    }

    public int getLocationID() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Map<String, Integer> getExits() {
        return this.exits;
    }
}
