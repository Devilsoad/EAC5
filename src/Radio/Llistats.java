package Radio;

import static Radio.Inscripcions.MAXIM_CONCURSANTS;

/**
 *
 * @author Jose
 */
public class Llistats {
    String nom, cognom, DNI, telefon, puntuacio, capcalera, mostrarDades
            ,continuar,DNICercat;
    int comptador;
    
    //Treim les dades per formatetjar-les i mostrar-les(1.3).
    public void formatLlistaPresentadorInicial(){
        String [] arrayOrdenacioPerDNI = new String [MAXIM_CONCURSANTS];
        String [][] dadesFinalsParticipants = new String [MAXIM_CONCURSANTS][5];
        System.out.println("---------------------------------");
        capcalera = String.format("%-11s %-15s %-22s %-11s","DNI","NOM","COGNOM","TELEFON"); 
        System.out.println(capcalera);
        for (int i = 0;i < dadesFinalsParticipants.length;i++){
            int j = 0;
            DNI = dadesFinalsParticipants[i][j];
            nom = dadesFinalsParticipants[i][j+1];
            cognom = dadesFinalsParticipants[i][j+2];
            telefon = dadesFinalsParticipants[i][j+3];
            arrayOrdenacioPerDNI[i]= String.format("%-11s %-15s %-22s %-11s",DNI,nom,cognom,telefon);
        }
        String aux;
        //Feim l'ordenacio per DNI.
        for (int i = 1;i < comptador;i++){
            for (int j = 0;j < comptador-1;j++){
                if(arrayOrdenacioPerDNI[j].compareTo(arrayOrdenacioPerDNI[j+1])>0){
                    aux = arrayOrdenacioPerDNI[j];
                    arrayOrdenacioPerDNI[j]=arrayOrdenacioPerDNI[j+1];
                    arrayOrdenacioPerDNI[j+1]=aux;
                } 
            }       
        }
        //Mostram les dades ja ordenades.
        for (int i = 0;i < comptador;i++){
            System.out.println(arrayOrdenacioPerDNI[i]);
        }    
    }
    //Treim les dades per formatetjar-les i mostrar-les(1.3).
    public void formatLlistaTwitterInicial(){
        String [] arrayOrdenacioPerCognoms = new String [MAXIM_CONCURSANTS];
        String [][] dadesFinalsParticipants = new String [MAXIM_CONCURSANTS][5];
        System.out.println("---------------------------------");
        capcalera = String.format("%-15s %-22s","NOM","COGNOM"); 
        System.out.println(capcalera);
        for (int i = 0;i < dadesFinalsParticipants.length;i++){
            int j = 0;
            nom = dadesFinalsParticipants[i][j+1];
            cognom = dadesFinalsParticipants[i][j+2];
            arrayOrdenacioPerCognoms[i]= String.format("%-22s %-15s",cognom,nom);
        }
        String aux;
        //Feim l'ordenacio per cognoms.
        for (int i = 1;i < comptador;i++){
            for (int j = 0;j < comptador-1;j++){
                if(arrayOrdenacioPerCognoms[j].compareTo(arrayOrdenacioPerCognoms[j+1])>0){
                    aux = arrayOrdenacioPerCognoms[j];
                    arrayOrdenacioPerCognoms[j]=arrayOrdenacioPerCognoms[j+1];
                    arrayOrdenacioPerCognoms[j+1]=aux;
                } 
            }       
        }
        //Mostram les dades ja ordenades.
        for (int i = 0;i < comptador;i++){
            System.out.println(arrayOrdenacioPerCognoms[i]);
        }    
    }
    
    //Treim les dades per formatetjar-les i mostrar-les(2.3).
    public void formatLlistaRonda(){
        String [] mostrarRonda = new String [MAXIM_CONCURSANTS];
        String [][] dadesFinalsParticipants = new String [MAXIM_CONCURSANTS][5];
        System.out.println("---------------------------------");
        capcalera = String.format("%-11s %-15s %-22s %-11s %8s","DNI","NOM","COGNOM","TELEFON","PUNTS"); 
        System.out.println(capcalera);
        for (int i = 0;i < dadesFinalsParticipants.length;i++){
            int j = 0;
            DNI = dadesFinalsParticipants[i][j];
            nom = dadesFinalsParticipants[i][j+1];
            cognom = dadesFinalsParticipants[i][j+2];
            telefon = dadesFinalsParticipants[i][j+3];
            puntuacio = dadesFinalsParticipants[i][j+4];
            mostrarRonda[i]= String.format("%-11s %-15s %-22s %-11s",DNI,nom,cognom,telefon,puntuacio);
            System.out.println(mostrarRonda[i]); 
        }    
    }
    //Treim les dades per formatetjar-les i mostrar-les(2.5).
    public void formatLlistaEliminats(){
        String [] arrayOrdenacioPerPuntuacio = new String [MAXIM_CONCURSANTS];
        String [][] dadesFinalsParticipants = new String [MAXIM_CONCURSANTS][5];
        System.out.println("---------------------------------");
        capcalera = String.format("%8s %-15s %-22s","PUNTS","NOM","COGNOM"); 
        System.out.println(capcalera);
        for (int i = 0;i < dadesFinalsParticipants.length;i++){
            int j = 0;
            nom = dadesFinalsParticipants[i][j+1];
            cognom = dadesFinalsParticipants[i][j+2];
            puntuacio = dadesFinalsParticipants[i][j+4];
            arrayOrdenacioPerPuntuacio[i]= String.format("%8s %-22s %-15s",puntuacio,cognom,nom);
        }
        String aux;
        //Feim l'ordenacio per puntuacio.
        for (int i = 1;i < comptador;i++){
            for (int j = 0;j < comptador-1;j++){
                if(arrayOrdenacioPerPuntuacio[j].compareTo(arrayOrdenacioPerPuntuacio[j+1])>0){
                    aux = arrayOrdenacioPerPuntuacio[j];
                    arrayOrdenacioPerPuntuacio[j]=arrayOrdenacioPerPuntuacio[j+1];
                    arrayOrdenacioPerPuntuacio[j+1]=aux;
                } 
            }       
        }
        //Mostram les dades ja ordenades.
        for (int i = 0;i < comptador;i++){
            System.out.println(arrayOrdenacioPerPuntuacio[i]);
        }    
    }
    //Treim les dades per formatetjar-les i mostrar-les(2.5).
    public void formatLlistaSegueixen(){
        String [] arrayOrdenacioPerPuntuacio = new String [MAXIM_CONCURSANTS];
        String [][] dadesFinalsParticipants = new String [MAXIM_CONCURSANTS][5];
        System.out.println("---------------------------------");
        capcalera = String.format("%8s %-15s %-22s","PUNTS","NOM","COGNOM"); 
        System.out.println(capcalera);
        for (int i = 0;i < dadesFinalsParticipants.length;i++){
            int j = 0;
            nom = dadesFinalsParticipants[i][j+1];
            cognom = dadesFinalsParticipants[i][j+2];
            puntuacio = dadesFinalsParticipants[i][j+4];
            arrayOrdenacioPerPuntuacio[i]= String.format("%8s %-22s %-15s",puntuacio,cognom,nom);
        }
        String aux;
        //Feim l'ordenacio per puntuacio.
        for (int i = 1;i < comptador;i++){
            for (int j = 0;j < comptador-1;j++){
                if(arrayOrdenacioPerPuntuacio[j].compareTo(arrayOrdenacioPerPuntuacio[j+1])>0){
                    aux = arrayOrdenacioPerPuntuacio[j];
                    arrayOrdenacioPerPuntuacio[j]=arrayOrdenacioPerPuntuacio[j+1];
                    arrayOrdenacioPerPuntuacio[j+1]=aux;
                } 
            }       
        }
        //Mostram les dades ja ordenades.
        for (int i = 0;i < comptador;i++){
            System.out.println(arrayOrdenacioPerPuntuacio[i]);
        }    
    }
    
}
