import java.lang.ref.SoftReference;
import java.util.ArrayList;

public class Contacto {

    private String name;
    private String phoneNumber;

    private Contacto(String name, String phoneNumber) {

        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    //GETTERS
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    //SETTERS
    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    //CONTRUCTOR
    public static Contacto createContact(String name, String phoneNumber){
        return new Contacto(name, phoneNumber);
    }
}

