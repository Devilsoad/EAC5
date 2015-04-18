package Radio;

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
}