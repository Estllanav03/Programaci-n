import java.util.Scanner;

 public class Main {

     private static Scanner sc = new Scanner(System.in);
     private static TelefonoMovil telefonoMovil = new TelefonoMovil("987654321");

     public static void main(String[] args) {


         phoneOptions();
         //buscarContacto();
         boolean runMenu = true;
         int pressedButton = 0;

         while (runMenu) {
             System.out.println("Selecione la opción que desea realizar: ");
             pressedButton = sc.nextInt();
             sc.nextLine();
             System.out.println();

             switch (pressedButton) {
                 case 0:
                     System.out.println("Salir");
                     runMenu = false;
                     break;

                 case 1:
                     telefonoMovil.printContact();
                     break;

                 case 2:
                     addContact();
                     break;

                 case 3:
                    modificarContacto();
                     break;


                 case 4:
                     deleteContact();
                     break;


                 case 5:
                     buscarContacto();
                     break;

                 case 6:
                     phoneOptions();
                     break;
             }
         }

     }

     public static void phoneOptions() {

         System.out.println("Introduce un número: \n" +
                 "\t 0. Salir. \n" +
                 "\t 1. Mostrar contactos\n" +
                 "\t 2. Añadir nuevo contacto.\n" +
                 "\t 3. Modificar contacto.\n" +
                 "\t 4. Borrar Contacto.\n" +
                 "\t 5. Buscar Contacto.\n" +
                 "\t 6. Mostrar Opciones.");
     }

     public static void buscarContacto() {

         System.out.println("Introduce el nombre del contacto: ");
         String contactName = sc.nextLine();

         contactName = contactName.substring(0, 1).toUpperCase() + contactName.substring(1).toLowerCase();
         Contacto contacto = telefonoMovil.queryContact(contactName);

         if (contacto != null) {
             System.out.println("Nombre: " + contacto.getName() + " Número: " + contacto.getPhoneNumber());
         }else{
             System.out.println(contactName + " no ha sido encontrado en la agenda de contactos");
         }
     }

     public static void addContact() {

         System.out.println("Introduce un nombre para el contacto: ");
         String contactName = sc.nextLine();

         contactName = contactName.substring(0, 1).toUpperCase() + contactName.substring(1).toLowerCase();
         Contacto contact = telefonoMovil.queryContact(contactName);

         if (contact == null) {
             System.out.println("Introduce el número de telefono: ");
             String phoneNumber = sc.nextLine();

             Contacto newContact = Contacto.createContact(contactName, phoneNumber);

             if (telefonoMovil.addNewContact(newContact)) ;
             {
                 System.out.println("Nombre del contacto: " + contactName + ": " + "Número de telefono: " + phoneNumber +
                         " Ha sido guardado en la agenda de contactos");
             }
         }
         else {
             System.out.println(contactName + " No se ha podido agregar en la agenda de contactos.");
         }
     }

     public static void modificarContacto(){

         System.out.println("Introduce el nombre del contacto para modificar: ");
         String oldContactName = sc.nextLine();

         oldContactName = oldContactName.substring(0,1).toUpperCase() + oldContactName.substring(1).toLowerCase();
         Contacto oldContact = telefonoMovil.queryContact(oldContactName);

         if(oldContact != null) {
             System.out.println("Introduce el nombre para el nuevo contacto");
             String newContactName = sc.nextLine();

            newContactName = newContactName.substring(0,1).toUpperCase() + newContactName.substring(1).toLowerCase();
             System.out.println("Introduce el número de telefono: ");

             String phoneNumber = sc.nextLine();
             Contacto newContact = Contacto.createContact(newContactName, phoneNumber);

             if(telefonoMovil.updateContact(oldContact, newContact)) {
                 System.out.println("El contacto ha sido actualizado correctamente.");
             }
         }

         else{
             System.out.println(oldContactName + " No se ha podido actualizar correctamente.");
         }
     }

     public static void deleteContact(){

         System.out.println("Introduce el nombre del contacto para eliminar: ");
         String contactName = sc.nextLine();

         contactName = contactName.substring(0,1).toUpperCase() + contactName.substring(1).toLowerCase();
         Contacto contactoEliminar = telefonoMovil.queryContact(contactName);
         telefonoMovil.removeContact(contactoEliminar);
            System.out.println("El contacto ha sido eliminado correctamente.");
     }

     public static void mostrarContacto(){
         telefonoMovil.printContact();
     }

 }