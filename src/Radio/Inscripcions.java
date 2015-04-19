package Radio;

import java.util.Scanner;

/**
*
* @author Silvia, Llorenç, Jose
*/
public class Inscripcions {

// Creació d'una instància de DadesConcurs
DadesConcurs dadesConcurs = new DadesConcurs();

/** Afegeix concursant a l'estructura de dades
* @param dadesConcurs és la instància on es guarden les dades dels concursants
* @param dades es la variable per les dades dels concursants
*/
/*
public void comencarAmbNovesDades(DadesConcurs dadesConcurs, String[][]dades){
    for(int i=0; i<dadesConcurs.dadesPersonals.length; i++){
        int resultat = afegirParticipant(dades[i][DADES_DNI], dades[i][DADES_COGNOMS], dades[i][DADES_NOM], dades[i][DADES_TELF]);
        if(((i<numConcursants) && resultat==RESP_OK)){
            System.out.println("Inserció realitzada correctament");
        }else if(i==9 && resultat==RESP_DNI_EXISTENT){
            System.out.println("Inserció rebutjada correctament");
        }else if(i>=numConcursants && resultat==RESP_MAXIM_INSCRITS){
            System.out.println("Inserció rebutjada correctament");
        }else{
            System.out.println("Error! inserció incorrecta! Això no havia de sortir!");
        }
    }
}
*/
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
    public static final String DNICARACTERS = "TRWAGMYFPDXBNJZSQVHLCKE";
    public static final int MIDATELEFONIDNI = 9;
    public int comptador = 0;
    String nom, cognom, DNI, telefon, puntuacio, capcalera, mostrarDades, continuar;;
    
    /**
     * Funció que recull la informacio dins un array bidimensional. Per cada
     * posicio ficam quatre dades, el DNI, el nom, el cognom i el telefon.
     * Una vegada insertat ho mostram perque l'usuari digui si es correcte o
     * no. En cas de que no ho sigui torna a repetir l'introduccio de dades.
     * En cas de que digui que si, ens demana si volem insertat un nou participant.
     * En el cas afirmatiu torna a començar pero amb la seguent posicio del array.
     * En cas negatiu, s'acaba la funcio.
     * 
     * @return dadesParticipants
     */
    //Metode per afegir les dades dins una matriu.
    public String [][] arrayCaptura(){
        Scanner lector = new Scanner(System.in);
        String [][] dadesParticipants = new String [MAXIM_CONCURSANTS][4];
        boolean sortir = false;
        String resposta;
        while ((sortir == false)&&(comptador<MAXIM_CONCURSANTS)){
            int j = 0;
            System.out.println("===================================");
            System.out.println("Introduim les dades del participant ("+(comptador+1)+")");
            System.out.println("--------------------------------");
            //Introduim els metode de les dades a cada columna. 
            boolean ok = false;
            while(!ok){
                dadesParticipants[comptador][j]= comprovarDNI();
                DNI = dadesParticipants[comptador][j];
                dadesParticipants[comptador][j+1]= demanarNom();
                nom = dadesParticipants[comptador][j+1];
                dadesParticipants[comptador][j+2]= demanarCognom();
                cognom = dadesParticipants[comptador][j+2];
                dadesParticipants[comptador][j+3]= comprovarTelefon();
                telefon = dadesParticipants[comptador][j+3];
                System.out.println("--------------------------------");
                String total = mostrarDades(DNI, nom, cognom, telefon);
                System.out.println(total);
                System.out.println("--------------------------------");
                System.out.println("¿Son correctes aquestes dades?[si-no]");
                System.out.print("Resposta: ");
                resposta = lector.nextLine();
                if (resposta.equals("si")){
                    ok = true;
                }
            }
            //Mostram les inscripcions que queden per arribar al maxim.
            System.out.println("Queden "+(MAXIM_CONCURSANTS - (comptador+1) + " inscripcions lliures.")); 
            System.out.println("===================================");
            comptador++;  
            //Demanam si volem insertar mes usuaris.
            System.out.print("Vols inscriure un altre particiant?\n"
                + "si o no: ");
            continuar = lector.nextLine();
            if (continuar.equals("no")){
                sortir = true;
            }
        }
        return dadesParticipants;
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
            if ((DNI.length()== MIDATELEFONIDNI)&&(DNI.matches("[0-9]{8}[A-Z]"))){
                dniCorrecte = true;
            } else {
                System.out.println("El valor introduit es incorrecte, torna a intenter-ho");
            }
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
            if ((telefonNet.length()== MIDATELEFONIDNI)&&(telefonNet.matches("[0-9]*"))){
                telefonCorrecte = true;
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
        nom = "";
        Scanner lector = new Scanner(System.in); 
        boolean correcteNom = false;
        System.out.print("Nom: ");
        nom = lector.nextLine();
        //comprovam que els caracters siguin els permesos.
        while (!correcteNom){
            if (nom.matches("[a-zA-Z ]*")){
                correcteNom = true;
                } else {
                System.out.println("El nom es incorrecte, nomes es permeten lletres.");
                }
        }
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
        cognom = "";
        Scanner lector = new Scanner(System.in); 
        boolean correcteCognom = false;
        System.out.print("Cognom: ");
        cognom = lector.nextLine();
        //comprovam que els caracters siguin els permesos.
        while (!correcteCognom){
            if (cognom.matches("[a-zA-Z ]*")){
                correcteCognom = true;
                } else {
                System.out.println("El cognom es incorrecte, nomes es permeten lletres.");
                }
        }
        return cognom;
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
        System.out.print("Puntuacio, entre 1 i 4 digits: ");
        puntuacio = lector.nextLine();
        //comprovam que els caracters siguin els permesos.
        while (!correctePuntuacio){
            if (puntuacio.matches("[0-9.]*")){
                if(puntuacio.length()==1){
                    puntuacio = "000" + puntuacio;
                }else if(puntuacio.length()==2){
                    puntuacio = "00" + puntuacio;
                } else{
                    puntuacio = "0" + puntuacio;
                }
                correctePuntuacio = true;
                } else {
                System.out.println("La puntuacio es incorrrecte, nomes numeros.");
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

