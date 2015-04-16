package ConcursInterficie;

import static Concurs.Principal.DNICARACTERS;
import static Concurs.Principal.MIDATELEFONIDNI;
import java.util.Scanner;

/**
 *
 * @author Jose
 */
public class Entrada {
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
        String DNI = "";
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
        String nom = "";
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
        String cognom = "";
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
        String puntuacio = "";
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
}
