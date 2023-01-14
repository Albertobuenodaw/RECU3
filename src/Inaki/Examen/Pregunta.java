package Inaki.Examen;

import java.util.ArrayList;

public class Pregunta {
    private int idPregunta;
    private String textoPregunta;
    private ArrayList<Respuesta> respuestas;
    private int indiceRespuestaCorrecta;

    public Pregunta(int idPregunta, String textoPregunta, ArrayList<Respuesta> respuestas, int indiceRespuestaCorrecta){
        this.idPregunta = idPregunta;
        this.textoPregunta = textoPregunta;
        this.respuestas = respuestas;
        this.indiceRespuestaCorrecta = indiceRespuestaCorrecta;
    }

    public Pregunta(int idPregunta, String textoPregunta){
        this.idPregunta = idPregunta;
        this.textoPregunta = textoPregunta;
    }

    @Override
    public String toString(){
        String message;
        message = this.textoPregunta;
        return message;
    }



    public int getIdPregunta() {
        return idPregunta;
    }

    public String getTextoPregunta(){
        return this.textoPregunta;
    }

}
