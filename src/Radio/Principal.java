package Radio;

import static Radio.Inscripcions.MAXIM_CONCURSANTS;
import java.util.Scanner;
/**
 *
 * @author Jose, Llorenç, Silvia
 */
public class Principal {
    // Creació d'una instància de DadesConcurs
    DadesConcurs dadesConcurs = new DadesConcurs();
    String nom, cognom, DNI, telefon, puntuacio, capcalera, mostrarDades
            ,continuar,DNICercat;
    int comptador;
    Inscripcions inscripcions = new Inscripcions();
    
    public static void main(String[] args) {
        
        Principal programa = new Principal();
        programa.inici();                
    }   
    public void inici() {
       Scanner lector = new Scanner(System.in);
        int opcio = 0;
        boolean correcte = false;
        System.out.println("===================================\n"
                + "Benvinguts al concurs de Radio IOC\n"
                + "===================================\n"
                + "Es troba al menu principal, pot escollir entre aquestes"
                + " dues opcions\n"
                + "-----------------------\n"
                + "(1) Gestio d'inscripcions\n"
                + "(2) Gestio de qualificacions\n"
                + "-----------------------");
        while(!correcte){
            System.out.print("¿Quina opcio vol?:");
            opcio = lector.nextInt();
            //comprova que sigui correcte el nombre.
            if((opcio==1)||(opcio==2)){
                correcte = true;
            }else{
                System.out.println("Opcio incorrecte. 1 o 2.");
                System.out.println("-----------------------");
                correcte = false;
            }
        }
        switch(opcio){
            case 1:
                menuInscripcions();
            break;
            case 2:
                menuQualificacions();
            break;
        }
    }
    /**
     * Mostra el menu de les inscripcions.
     * Cada opcio te un nombre asignat, l'usuari ha d'escollir una de les opcions.
     * En cas de que el nombre no sigui correcte torna a demanar-ho,
     * en cas afirmatiu selecciona el menu corresponent.
     */  
    //Menu Inscripcions
    public void menuInscripcions(){
        Scanner lector = new Scanner(System.in);
        int opcio=0;
        boolean correcte = false;
        System.out.println("===================================\n"
                + "Es troba al menu d'inscripcions, pot escollir entre aquestes"
                + " tres opcions\n"
                + "-----------------------\n"
                + "(1) Inscripcio de nous concursants\n"
                + "(2) Modificacio de concursants\n"
                + "(3) Llistat dels concursants\n"
                + "-----------------------");
        //Comprovam que la opcio esta dins les disponibles.
        while(!correcte){
            System.out.print("¿Quina opcio vol?:");
            opcio = lector.nextInt();  
            if((opcio==1)||(opcio==2)||(opcio==3)){
                correcte = true;
            }else{
                System.out.println("Opcio incorrecte. 1, 2 o 3.");
                System.out.println("-----------------------");
                correcte = false;
            }
        }
        //seleccionam amb un switch la opcio escollida.
        switch(opcio){
            case 1:
                inscripcions.arrayCaptura();   
                formatLlistaPresentador();
                inici();
            break;
            case 2:
                menuModificar();
                inici();
            break;
            case 3:
                inici();
            break;
            default:
                
            break;
        }
    }
    /**
     * Mostra el menu de les qualificacions.
     * Cada opcio te un nombre asignat, l'usuari ha d'escollir una de les opcions.
     * En cas de que el nombre no sigui correcte torna a demanar-ho,
     * en cas afirmatiu selecciona el menu corresponent.
     */
    //Menu Qualificacions
    public void menuQualificacions(){
        Scanner lector = new Scanner(System.in);
        int opcio=0;
        boolean correcte = false;
        System.out.println("===================================\n"
                + "Es troba al menu de qualificacions, pot escollir entre aquestes"
                + " cinc opcions\n"
                + "-----------------------\n"
                + "(1) Iniciar el concurs\n"
                + "(2) Puntuar una ronda\n"
                + "(3) Llistar qualificacions ronda\n"
                + "(4) Finalitzar ronda\n"
                + "(5) Llistar qualificacions pel Twitter\n"
                + "-----------------------");
        while(!correcte){
            System.out.print("¿Quina opcio vol?:");
            opcio = lector.nextInt();  
            if((opcio==1)||(opcio==2)||(opcio==3)||(opcio==4)||(opcio==5)){
                correcte = true;
            }else{
                System.out.println("Opcio incorrecte. 1,2,3,4 o 5.");
                System.out.println("-----------------------");
                correcte = false;
            }
        }
        switch(opcio){
            case 1:
                
            break;
            case 2:
          
            break;
            case 3:
          
            break;
            case 4:
          
            break;
            case 5:
          
            break;
            default:
                
            break;
        }    
    }
    //Menu modificar
    public void menuModificar(){
        Scanner lector = new Scanner(System.in);
        String [] arrayCercat = new String [4];
        int opcio = 0;
        boolean correcte = false;
        /* Mostram el menu i cridam a la funcio que cerca el DNI i retorna
        un array amb les dades d'aquest DNI.*/
        System.out.println("===================================\n"
                + "Es troba al menu de modificacions, quin DNI vol modificar?");
        System.out.print("DNI: ");
        arrayCercat = inscripcions.arrayCercatDNI();
        System.out.print(arrayCercat[comptador]); 
        System.out.println("===================================\n"
                + "Es troba al menu de modificacions, pot escollir entre aquestes"
                + " tres opcions\n"
                + "-----------------------");
        System.out.println("DNI: "+DNICercat);
        System.out.println("(1) Modificacio del nom: "+arrayCercat[comptador+1]);
        System.out.println("(2) Modificacio dels cognoms: "+arrayCercat[comptador+2]);
        System.out.println("(3) Modificacio del telefon: "+arrayCercat[comptador+3]);
        System.out.println("-----------------------");
        // Comprovam que la opcio estigui entre les 3 disponibles.
        while(!correcte){
            System.out.print("¿Quina opcio vol?:");
            opcio = lector.nextInt();  
            if((opcio==1)||(opcio==2)||(opcio==3)){
                correcte = true;
            }else{
                System.out.println("Opcio incorrecte. 1, 2 o 3.");
                System.out.println("-----------------------");
                correcte = false;
            }
        }
        // Escull l'opcio que se ha introduit.
        switch(opcio){
            case 1:
                inici();
            break;
            case 2:
                inici();
            break;
            case 3:
                inici();
            break;
            default:
                
            break;
        }
    }
    
    
    //Menu llistats
    
    //Llista al Twitter dels inscrits.
    public void llistaInicialConcursants(){
        System.out.println("===================================\n"
                + "Publicacio de la llista de participants pel Twitter\n"
                + "===================================");
        formatLlistaTwitter();
        
    }
    //Treim les dades per formatetjar-les.
    public void formatLlistaPresentador(){
        String [][] dadesParticipants = new String [MAXIM_CONCURSANTS][4];
        String [] arrayMostrar = new String [MAXIM_CONCURSANTS];
        dadesParticipants = inscripcions.arrayCaptura();
        capcalera = String.format("%-11s %-15s %-22s %-11s","DNI","NOM","COGNOM","TELEFON"); 
        System.out.println(capcalera);
        for (int i = 0;i < dadesParticipants.length;i++){
            int j = 0;
            DNI = dadesParticipants[i][j];
            nom = dadesParticipants[i][j+1];
            cognom = dadesParticipants[i][j+2];
            telefon = dadesParticipants[i][j+3];
            arrayMostrar[i]= String.format("%-11s %-15s %-22s %-11s",DNI,nom,cognom,telefon);
            System.out.println(arrayMostrar[i]);
        } 
    }
}
