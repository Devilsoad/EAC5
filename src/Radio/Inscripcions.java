package Radio;

import java.util.Scanner;

/**
*
* @author Silvia, Jose
*/
public class Inscripcions {

    // Creacio d'una instancia de DadesConcurs
    DadesConcurs dadesConcurs = new DadesConcurs();
    Llistats llistats = new Llistats ();
    
    /**
     * Nombre maxim de concursants
     */
    static int MAXIM_CONCURSANTS = 15;
    /**
     * Nombre de camps que emmagatzemarem per concursant
     */
    static int CAMPS_CONCURSANTS = 4;
    /**
     * Identificador del camp DNI (posicio dins la matriu)
     */
    static int DADES_DNI = 0;
    /**
     * Identificador del camp COGNOMS (posicio dins la matriu)
     */
    static int DADES_COGNOMS = 1;
    /**
     * Identificador del camp NOM (posicio dins la matriu)
     */
    static int DADES_NOM = 2;
    /**
     * Identificador del camp TELEFON (posicio dins la matriu)
     */
    static int DADES_TELF = 3;
    /**
     * Vector de les lletres d'un dni ordenades d'acord amb l'index usat en el calcul 
     * de la lletra del dni
     */
    
    /**
     * Identificador de l'ordre dels concursant usant el criteri DNI
     */
    static int INDEX_DNI = 0;
    /**
     * Identificador de l'ordre dels concursant usant el criteri COGNOMS
     */
    static int INDEX_COGNOMS = 2;
    /**
     * Identificador de l'ordre dels concursant usant el criteri PUNTS
     */    
    static int INDEX_PUNTS = 1;
    /**
     * Valor que indica quants index hi haurÃƒ  a l'aplicaciÃƒÂ³
     */
    static int DIM_INDEXOS=3;

    
    public static final String DNICARACTERS = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static final int MIDATELEFONIDNI = 9;
    public int comptador = 0;
    String nom, cognom, DNI, telefon, puntuacio, capcalera, mostrarDades, continuar;
   
    
    
    /**
     * Funcio que recull la informacio dins un array bidimensional. Per cada
     * posicio ficam quatre dades, el DNI, el nom, el cognom i el telefon.
     * Una vegada insertat ho mostram perque l'usuari digui si es correcte o
     * no. En cas de que no ho sigui torna a repetir l'introduccio de dades.
     * En cas de que digui que si, ens demana si volem insertat un nou participant.
     * En el cas afirmatiu torna a comencar pero amb la seguent posicio del array.
     * En cas negatiu, s'acaba la funcio.
     * 
     * @return dadesParticipants
     */
    //Metode per afegir les dades dins una matriu.
    public String [][] arrayCaptura(){
        Scanner lector = new Scanner(System.in);
        
        boolean sortir = false;
        String resposta;
        while ((!sortir)&&(dadesConcurs.numConcursants<MAXIM_CONCURSANTS)){
            
            System.out.println("===================================");
            System.out.println("Introduim les dades del participant "
                    + "("+(dadesConcurs.numConcursants+1)+")");
            System.out.println("--------------------------------");
            //Introduim els metode de les dades a cada columna. 
            boolean ok = false;
            while(!ok){
                dadesConcurs.dadesPersonals[dadesConcurs.numConcursants][DADES_DNI]= comprovarDNI();
                DNI = dadesConcurs.dadesPersonals[dadesConcurs.numConcursants][DADES_DNI];
                dadesConcurs.dadesPersonals[dadesConcurs.numConcursants][DADES_NOM]= demanarNom();
                nom = dadesConcurs.dadesPersonals[dadesConcurs.numConcursants][DADES_NOM];
                dadesConcurs.dadesPersonals[dadesConcurs.numConcursants][DADES_COGNOMS]= demanarCognom();
                cognom = dadesConcurs.dadesPersonals[dadesConcurs.numConcursants][DADES_COGNOMS];
                dadesConcurs.dadesPersonals[dadesConcurs.numConcursants][DADES_TELF]= comprovarTelefon();
                telefon = dadesConcurs.dadesPersonals[dadesConcurs.numConcursants][DADES_TELF];
                System.out.println("--------------------------------");
                String total = mostrarDades(DNI, nom, cognom, telefon);
                System.out.println(total);
                System.out.println("---------------------------------------");
                System.out.println("Â¿Son correctes aquestes dades?[si-no]");
                System.out.print("Resposta: ");
                resposta = lector.nextLine();
                ok = resposta.equalsIgnoreCase("si");
               
            }
            //Mostram les inscripcions que queden per arribar al maxim.
            System.out.println("Queden "+(MAXIM_CONCURSANTS - (dadesConcurs.numConcursants+1) + " inscripcions lliures.")); 
            System.out.println("===================================");
            dadesConcurs.numConcursants++;  
            //Demanam si volem insertar mes usuaris.
            System.out.print("Vols inscriure un altre particiant?\n"
                + "si o no: ");
            resposta = lector.nextLine();
            
            sortir = resposta.equalsIgnoreCase("no");
        }
        return dadesConcurs.dadesPersonals;
    }
    /**
     * Cerca la posiciÃ³n DNI dins del vector de dades 
     * @return la posiciÃ³ del concursant identificat amb el DNI
     */
    public String[] arrayCercatDNI(){
        
        String [] arrayCercat = new String [4];
        
        introduirDNI();
        int posicio =0;
        boolean cercat = false;
        
        while (posicio<dadesConcurs.numConcursants&&!cercat){
            if (DNI.equals(dadesConcurs.dadesPersonals[posicio][DADES_DNI]) ){
                arrayCercat =dadesConcurs.dadesPersonals[posicio];
                
                cercat=true;
            }
            if (!cercat){
                posicio++;
            }
        }
        
        return arrayCercat;
    }
    /**
     * Si el DNI no hi Ã©s crea un menÃº en el que es pot tornar a introduir o 
     * anar al menÃº principal
     */
    public void DniNoTrobat(){
        Scanner lector = new Scanner(System.in);
        int opcio = 0;
        boolean correcte = false;
        System.out.println("===================================\n"
                + "El DNI no s'ha trobat, pot escollir entre aquestes"
                + " dues opcions\n"
                + "-----------------------");
        System.out.println ("(1) Tornar-ho a introduir:  ");
        System.out.println ("(2) Anar al menÃº principal:  ");
        System.out.println ("Â¿Quina opcio vol?:");
        opcio = lector.nextInt(); 
            
        do {
            switch(opcio){
                case 1:
                    correcte=true;
                    break;
                case 2:
                    Principal.main (null);
                    break;
                default:
                    System.out.println("Opcio incorrecte. 1 o 2 ");
                    System.out.println("-----------------------");
                    System.out.print("Â¿Quina opcio vol?: ");
                    lector.next();
            break;
            }
        } while (!correcte);
    }
    
     /**
     * Comprova la variable del DNI introduit si es la mateixa que cualque DNI
     * introduit dins l'array.
     * 
     * @param DNI
     * @param totsDNI
     * @return false
     */
    //Metode per comprovar que no es repeteix el DNI.
    public boolean compararDNI(String DNI, String [] totsDNI){
        for(int i=0;i<totsDNI.length;i++){
            if(DNI.equals(totsDNI[i])){
                return true;
            } 
        }
        return false;
    }  
    /**
     * Introdueix dins una variable 8 nombres i 1 lletra majuscula.
     * Comprova que la mida sigui la correcte i que les posicions, les que es
     * demanen. En cas de no estar be, se ha de tornar a introduir.
     * 
     * @return DNI
     */
    //Metode per introduir el DNI.
    public String introduirDNI(){
        DNI = "";
        boolean dniCorrecte = false;
        while (!dniCorrecte){
            System.out.print("Introdueix els 8 numeros, i la lletra en majuscula del DNI: ");
            Scanner lector = new Scanner(System.in);
            DNI = lector.nextLine();
            //comprovam que els caracters siguin els permesos.
            dniCorrecte = (DNI.length()== MIDATELEFONIDNI)&&(DNI.matches("[0-9]{8}[A-Z]"));
                
            if (!dniCorrecte)
                System.out.println("El valor introduit es incorrecte, torna a intentar-ho");
        }
        return DNI;
    }
    /**
     * Mostra el resultat de la comprovacio de la introduccio del DNI i del
     * calcul de la lletra. Si es tot correcte ho diu.
     * 
     * @return stringDNI
     */
    //Metode per comprovar que el DNI es correcte.
    private String comprovarDNI(){
        String stringDNI = introduirDNI();
        boolean correcteDNI = calcularDNI(stringDNI);
        if (correcteDNI == true){
            System.out.println("El DNI " + stringDNI + " es correcte.");
        }
        return stringDNI;
    }
    /**
     * Fa el calcul de la lletra del DNI introduit, fa el residu del nombre i
     * comprova si la lletra coincideix amb la mateixa lletra de la variable fitxa.
     * 
     * @param comDNI
     * @return false
     */
    //Metode per calcular la lletra del DNI i comprovar-ho.
    public boolean calcularDNI(String comDNI){
        String numeros =(comDNI.substring(0, 8));
        int numerosInt = Integer.parseInt(numeros);
        char lletraDNI = comDNI.charAt(8);  
        int residu = numerosInt % 23;
        char lletra = DNICARACTERS.charAt(residu);
        //comprovam que els caracters siguin els permesos.
        if ((numeros.length() == 8)&&(lletraDNI == lletra)){
            return true;
        } else {
            System.out.println("El DNI introduit es incorrecte.");
            comprovarDNI();
            return false;
        }
    }
    /**
     * Introdium el telefon, comprova si hi ha caracters especials per poder
     * llevar-los i que quedin les 9 xifres juntes. Si queden 9 xifres mostra
     * que es correcte, si no errada.
     * 
     * @return telefonNet
     */
    //Metode per comprovar que el telefon es correcte.
    public String comprovarTelefon(){
        boolean telefonCorrecte = false;
        String telefonBrut = " ";
        String telefonNet = " ";
        while(!telefonCorrecte){
            System.out.print("Introdueix el telefon: ");
            Scanner lector = new Scanner(System.in);
            telefonBrut = lector.nextLine();
            //Llevam els caracters (-| |.), per deixar el numeros net.
            telefonNet = telefonBrut.replaceAll("[-|.| ]", "");
            if (telefonCorrecte =(telefonNet.length()== MIDATELEFONIDNI)&&(telefonNet.matches("[0-9]*"))){
                System.out.println("El telefon introduit(" + telefonNet + ") es correcte.");
            } else {
                System.out.println("El telefon introduit es incorrecte, torna a intentar-ho.");
            } 
        }
        return telefonNet;
    }
    /**
     * Demanam el nom a l'usuari, feim la comprovacio que siguin lletres, si ho
     * son deim que es correcte, si no errada.
     * 
     * @return nom
     */
    //Metode per demanar el nom.
    public String demanarNom(){
    boolean correctenom;
        do{
            nom = "";
            Scanner lector = new Scanner(System.in);            
            System.out.print("Nom: ");
            nom = lector.nextLine();
            correctenom =nom.matches("[a-zA-Z*]+");
            if (!correctenom){
                System.out.println("El NOM introduit es incorrecte, torna a intentar-ho.");    
            }    
        }while (!correctenom);
        
        return nom;
        }
    /**
     * Demanam el cognom a l'usuari, feim la comprovacio que siguin lletres, si ho
     * son deim que es correcte, si no errada.
     * 
     * @return cognom
     */
    //Metode per demanar el cognom.
    public String demanarCognom(){
        boolean correcteCognom;
        do{
            cognom = "";
            Scanner lector = new Scanner(System.in); 
            
            System.out.print("Cognom: ");
            cognom = lector.nextLine();
            correcteCognom =cognom.matches("[a-zA-Z*]+");
            if (!correcteCognom)
                System.out.println("El COGNOM introduit es incorrecte, torna a intentar-ho."); 
                
        }while (!correcteCognom);
        
        return cognom;
    }
    /**
     * Substitueix el nom del concursant per el nom nou introduit
     * @param posicio 
     * @return dadesConcurs.dadesPersonals
     */
    public String[][] modificarNom(int posicio){
        
        dadesConcurs.dadesPersonals[posicio][DADES_NOM]=demanarNom();   
        System.out.println("El "+dadesConcurs.dadesPersonals[posicio][DADES_NOM]);//anular
        
        return dadesConcurs.dadesPersonals;
    }
     /**
     * Substitueix el cognom del concursant per el cognom nou introduit
     * @param posicio 
     */
    public void modificarCognom(int posicio){
        demanarCognom();
        dadesConcurs.dadesPersonals[posicio][DADES_COGNOMS]=cognom;        
    }
     /**
     * Substitueix el telÃ¨fon del concursant per el telÃ¨fon nou introduit
     * @param posicio 
     */
    public void modificarTelefon(int posicio){
        comprovarTelefon();
        dadesConcurs.dadesPersonals[posicio][DADES_TELF]=telefon;        
    }
    
    /**
     * Demanam la puntuacio del concursant. Ha de ser de 1 a 4 digits, 
     * si no es dins aquets mostra una errada, siho es depenent del nombre que
     * fiquen omplirem la resta amb zeros.
     * 
     * @return puntuacio
     */
    //Metode per demanar la puntuacio.
    public String demanarPuntuacio(){
        puntuacio = "";
        Scanner lector = new Scanner(System.in); 
        boolean correctePuntuacio = false;
        System.out.print("Puntuacio, entre 0 i 3.");
        puntuacio = lector.nextLine();
        //comprovam que els caracters siguin els permesos.
        while (!correctePuntuacio){
            if (puntuacio.matches("[0-3.]*")){
                correctePuntuacio = true;
                } else {
                System.out.println("La puntuacio es incorrrecte, entre 0 i 3.");
                }
        }
        return puntuacio;
    }     
    /**
     * Funcio que serveix per juntar 4 dades String dins una, afagint un parell
     * de noms perque s'entengui la dada que surt.
     * 
     * @param DNI
     * @param nom
     * @param cognom
     * @param telefon
     * @return concursant
     */
    public String mostrarDades(String DNI, String nom, String cognom, String telefon){
        String concursant;
        concursant = ("DNI:"+DNI+"  nom:"+nom +"  cognom:"+cognom+"  telefon:"+telefon);
        return concursant;
    }
}