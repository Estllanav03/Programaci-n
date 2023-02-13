import java.lang.ref.SoftReference;
import java.util.ArrayList;

    class TelefonoMovil {

        public String myNumber;
        public ArrayList<Contacto> myContacts = new ArrayList<Contacto>();


        public TelefonoMovil(String myNumber){
            this.myNumber = myNumber;
            this.myContacts = new ArrayList<Contacto>();
        }

        //MÉTODO FIND CONTACT -
        private int findContact(Contacto contacto) {
            return myContacts.indexOf(contacto);
        }

        private int findContact(String contactName) {
            for(int i = 0; i < myContacts.size(); i++) {
                Contacto contacto = myContacts.get(i);
                if(contacto.getName().equals(contactName)){
                return i;
                }
            }
            return -1;
        }

        //MÉTODO ADD NEW CONTACT -
        public boolean addNewContact(Contacto contacto){
            int contactIndex = findContact(contacto);
            if(contactIndex >= 0) {
                System.out.println("El contacto ya existe");
                return false;
            }
            this.myContacts.add(contacto);
            System.out.println("El contacto no existe");
            return true;
        }

        //MÉTODO UPDATE CONTACT -
        public boolean updateContact(Contacto oldContact, Contacto newContact){
            int oldContactIndex = findContact(oldContact);
            if(oldContactIndex < 0) {
                System.out.println(oldContact.getName() + " El contacto no ha sido encontrado");
                return false;

            } else if(findContact(newContact.getName()) >= 0){
                System.out.println(newContact.getName() + " El contacto ya existe en la agenda");
                return false;
            }

            this.myContacts.remove(oldContactIndex);
            this.myContacts.add(oldContactIndex, newContact);
            System.out.println(oldContact.getName() + " : " + oldContact.getPhoneNumber() + " el contacto ha sido actualizado correctamente " +
            newContact.getName() + " : " + newContact.getPhoneNumber());

            return true;
        }

        //MÉTODO REMOVE CONTACT -
        public boolean removeContact(Contacto contactoToRemove){
            int contactIndex = findContact(contactoToRemove);
            if(contactIndex < 0){
                System.out.println("El contacto no ha sido encontrado");
                return false;
            }
            this.myContacts.remove(contactIndex);
            System.out.println("El contacto ha sido borrado correctamente");
            return true;
        }

        //MÉTODO QUERY CONTACT -
        public Contacto queryContact(String name){
            int nameIndex = findContact(name);
            if(nameIndex >= 0){
                return (this.myContacts.get(nameIndex));
            }
            return null;
        }

        //MÉTODOS PRINT CONTACTS -
        public void printContact(){
            System.out.println("Lista de Contactos: \n");
            for(int i = 0; i < this.myContacts.size(); i++){
                Contacto contacto = this.myContacts.get(i);
                System.out.println((i + 1) + ". " + contacto.getName() + " ->" + contacto.getPhoneNumber());
            }
        }

}





