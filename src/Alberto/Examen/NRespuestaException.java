package Alberto.Examen;

import java.sql.SQLOutput;

public class NRespuestaException extends Exception {
    public NRespuestaException(){
        System.err.print("ERROR: Nº de respuesta no válido");
    }
}
