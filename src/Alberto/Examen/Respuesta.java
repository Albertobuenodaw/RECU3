package Alberto.Examen;

public class Respuesta {
    private int idPregunta;
    private String respuesta;
    private int correcta;

    public Respuesta(int idPregunta, String respuesta, int correcta) {
        this.idPregunta = idPregunta;
        this.respuesta = respuesta;
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return "Respuesta{" +
                "idPregunta=" + idPregunta +
                ", respuesta='" + respuesta + '\'' +
                ", correcta=" + correcta +
                '}';
    }
}
