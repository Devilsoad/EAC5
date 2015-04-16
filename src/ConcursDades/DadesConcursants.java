package ConcursDades;

/**
 *
 * @author Jose
 */
public class DadesConcursants {
    
    public String mostrarDades(String DNI, String nom, String cognom, String telefon){
        String concursant;
        concursant = ("DNI"+DNI+", nom:"+nom +", cognom:"+cognom+", telefon:"+telefon);
        
        return concursant;
}
    
}
