package Inaki.Examen;

public class Respuesta {
    private int idPregunta;
    private String respuestaTexto;
    private int correcta;

    public Respuesta(int idPregunta, String respuestaTexto, int correcta) {
        this.idPregunta = idPregunta;
        this.respuestaTexto = respuestaTexto;
        this.correcta = correcta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public String getRespuestaTexto() {
        return respuestaTexto;
    }

    public int getCorrecta() {
        return correcta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "idPregunta=" + idPregunta +
                ", respuestaTexto='" + respuestaTexto + '\'' +
                ", correcta=" + correcta +
                '}'+"\n";
    }


}
