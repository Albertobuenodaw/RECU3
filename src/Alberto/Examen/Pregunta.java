package Alberto.Examen;

public class Pregunta {
    private int idPregunta;
    private String pregunta;
    private int aciertos;
    private int fallos;
    private int idCategoria;

    public Pregunta(int idPregunta, String pregunta, int aciertos, int fallos, int idCategoria) {
        this.idPregunta = idPregunta;
        this.pregunta = pregunta;
        this.aciertos = aciertos;
        this.fallos = fallos;
        this.idCategoria = idCategoria;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "idPregunta=" + idPregunta +
                ", pregunta='" + pregunta + '\'' +
                ", aciertos=" + aciertos +
                ", fallos=" + fallos +
                ", idCategoria=" + idCategoria +
                '}';
    }
}
