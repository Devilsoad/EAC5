package Radio;

import static Radio.Inscripcions.MAXIM_CONCURSANTS;

/**
 *
 * @author Jose, Silvia.
 */
public class Puntuacio {
    Inscripcions inscripcions = new Inscripcions();
    String nom, cognom, DNI, telefon, puntuacio, capcalera, mostrarDades
            ,continuar;
    int comptador;
    int j = 0;
    /**
     * Funcio que permet insertar una nova dada, puntuacio, on li donarem
     * el valor 0 a tot l'array.
     */
    public void inicialitzarPunts (){
        String [][] dadesIniciConcurs = new String [MAXIM_CONCURSANTS][5];
        dadesIniciConcurs = arrayDadesParticipants();
        for(int i = 0;i< dadesIniciConcurs.length;i++){
            dadesIniciConcurs[i][j+4] = "0";
        }
    }   
    /**
     * Funcio que serveix per ficar punts a cada ronda que pasa.
     */
    public void ficarPunts(){
        String [][] dadesRonda = new String [MAXIM_CONCURSANTS][5];
        dadesRonda = arrayDadesParticipantsJugant();
        for(int i = 0;i<dadesRonda.length;i++){
            System.out.println("Puntuacio del participant"+dadesRonda[i][j+1]
            +dadesRonda[i][j+2]);
            dadesRonda[i][j+4]=inscripcions.demanarPuntuacio();
        }
    }
    
    public void llistarDadesPuntuacions() {
        String [][] arrayLlistatPunts = new String [MAXIM_CONCURSANTS][5];
        arrayLlistatPunts = dadesRonda();
        capcalera = String.format("%-11s %-15s %-22s %-11s %-10","DNI","NOM","COGNOM","TELEFON","PUNTS"); 
        System.out.println(capcalera);
        String arrayFormatPunts;
        for (int i = 0;i < arrayLlistatPunts.length;i++){
            DNI = arrayLlistatPunts[i][j];
            nom = arrayLlistatPunts[i][j+1];
            cognom = arrayLlistatPunts[i][j+2];
            telefon = arrayLlistatPunts[i][j+3];
            puntuacio = arrayLlistatPunts[i][j+4];
            arrayFormatPunts= String.format("%-11s %-15s %-22s %-11s %10s",DNI,nom,cognom,telefon,puntuacio);
            System.out.println(arrayFormatPunts);
        }
}


//Treim les dades per formatetjar-les.
    public void formatLlistaPresentador(){
        String [][] dadesParticipants = new String [MAXIM_CONCURSANTS][4];
        String [] arrayMostrar = new String [MAXIM_CONCURSANTS];
        dadesParticipants = inscripcions.arrayCaptura();
        
    }


}

