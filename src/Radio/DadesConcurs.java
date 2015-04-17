/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Radio;

/**
 *
 * @author Jose
 */
public class DadesConcurs {
        /**
     * Variables globals de l'apliciaciÃ³
     */   
    public String[][] dadesPersonals = new String[15][4];  //Dadaes de la inscrpciÃ³
    public int[] puntuacions = new int[14];   //Puntucaions obtingudes
    public int numConcursants = 0;  //NÃºmero de concursants inscrits
    public int limitEliminats;  //PossiciÃ³ on es troba el primer concursant eliminat en diferents rondes
    public int limitEliminatsRondaActual; //PossiciÃ³ on es troba el primer concursant eliminat a la ronda actual
    public int[][] indexos = new int[3][15]; //indexos per ordenar les dades
        
    /**
     * Variables globals per configurar els llistats
     */
    public String[] capcaleres = {"DNI", "COGNOMS", "NOM", "TELF", "PUNTS"};
    public String[] formatCapaleres = {"   %-8s ", "   %-33s ", "   %-19s ", "   %-12s ", " %-2s"};
    public String[] formatCamps = {"%-11s ", "%-36s ", "%-22s ", "%-15s", "%3d"};
}

