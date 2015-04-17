package Radio;

/**
 *
 * @author Jose
 */
public class Principal {
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
    String nom, cognom, DNI, telefon, puntuacio;
    public static void main(String[] args) {
        
        Principal programa = new Principal();
        programa.inici();                
    }   
    /**
     * Metode per iniciar l'aplicacio
     */
    public void inici() {
       
      
    }
    
}
