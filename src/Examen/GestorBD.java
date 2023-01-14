package Examen;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorBD {
    private Connection myConnection;
    private String url = "jdbc:mariadb://localhost:3306/final2";
    private String user = "root";
    private String password = "root";

    public GestorBD(){
        this.myConnection = null;

        try {
            System.out.println("Connecting to database...");
            Class.forName("org.mariadb.jdbc.Driver");
            myConnection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /*todasCategorias: Método que devuelve un ArrayList con todas las categorías
    de la base de datos que tienen alguna pregunta*/
    public ArrayList<String> todasCategorias(){
        List<String> l = new ArrayList<String>();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT distinct categorias.categoria FROM categorias, preguntas where preguntas.idcategoria = categorias.idcategoria");
            while (rs.next()){
                l.add(rs.getString("categoria"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<String>) l;
    }


    /*preguntasDeCategoria: Método que recibe una categoría (por ejemplo, “Literatura”)
    y devuelve un ArrayList con todas las Pregunta’s (completas) de dicha categoría.*/
    public ArrayList<Pregunta> preguntasDeCategoria(String categoria){
        List<Pregunta> l = new ArrayList<Pregunta>();


        Statement st = null;
        ResultSet rs = null;
        Statement st2 = null;
        ResultSet rs2 = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM preguntas inner join categorias on preguntas.idcategoria " +
                    "= categorias.idcategoria WHERE categorias.categoria = '" + categoria + "';");
            while (rs.next()){
                ArrayList<Respuesta> posiblesRespuestas = new ArrayList<Respuesta>();
                st2 = myConnection.createStatement();
                rs2 = st2.executeQuery("select respuestas.idpregunta, respuestas.respuesta, respuestas.correcta from respuestas, preguntas, categorias \n" +
                        "where categorias.idcategoria  = preguntas.idcategoria  and preguntas.idpregunta  = respuestas.idpregunta \n" +
                        "and categorias.categoria = '" + categoria + "' and preguntas.idpregunta = "+ rs.getInt("idpregunta") + ";");
                while(rs2.next()){
                    //System.out.println(rs2.getString("correcta"));

                    posiblesRespuestas.add(new Respuesta(rs2.getInt("idpregunta"), rs2.getString("respuesta"), rs2.getInt("correcta")));
                }
                Pregunta p = new Pregunta(rs.getInt("idpregunta"), rs.getString("pregunta"), posiblesRespuestas, this.getIndiceCorrecto(posiblesRespuestas));
                l.add(p);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Pregunta>) l;
    }

    private int getIndiceCorrecto(ArrayList<Respuesta> list){
        for(int i = 0; i<list.size();i++){
            if(list.get(i).getCorrecta() == 1){
                return i;
            }
        }
        return -1;
    }

    public ArrayList<Pregunta> preguntasAlAzar(ArrayList<String> list, int n){
        ArrayList<ArrayList<Pregunta>> todos = new ArrayList<ArrayList<Pregunta>>();
        for(int i = 0; i<list.size();i++){
            todos.add(this.preguntasDeCategoria(list.get(i)));
        }
        //System.out.println(todos.toString());
        //System.out.println(todos.get(1).toString());

        ArrayList<Pregunta> result = new ArrayList<Pregunta>();
        for(int i=0;i<n;i++){
            int aleatorio1 = (int) (Math.random() * (todos.size()) + 0);
            int aleatorio2 = (int) (Math.random() * (todos.get(aleatorio1).size()) + 0);
            System.out.println(aleatorio1);
            System.out.println(aleatorio2);
            result.add(todos.get(aleatorio1).get(aleatorio2));
            todos.get(aleatorio1).remove(aleatorio2);
        }
        return result;
    }

    public ArrayList<Respuesta> getRespuestasDePregunta(String pregunta){
        ResultSet rs;
        Statement st;
        ArrayList<Respuesta> resultado = new ArrayList<Respuesta>();

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT respuestas.* FROM respuestas, preguntas WHERE\n" +
                    "respuestas.idpregunta = preguntas.idpregunta and preguntas.pregunta  = '" + pregunta + "'; ");
            while (rs.next()){
                Respuesta r = new Respuesta(rs.getInt("idpregunta"), rs.getString("respuesta"), rs.getInt("correcta"));
                resultado.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    /*guardarAcierto(), Metodo que recibe una Pregunta que se acaba de acertar y refleja este suceso en la BD*/
    public boolean guardarAcierto(Pregunta p){
        ResultSet rs;
        Statement st;


        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("update preguntas set aciertos = aciertos+1 where idpregunta  = " + p.getIdPregunta() + ";");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    public boolean guardarFallo(Pregunta p){
        ResultSet rs;
        Statement st;


        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("update preguntas set fallos = fallos+1 where idpregunta  = " + p.getIdPregunta() + ";");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

    }


    public HashMap<String, Integer> crearMapaRespuestasCorrectas(){
        Statement st = null;
        ResultSet rs = null;
        HashMap<String, Integer> resultado = new HashMap<String, Integer>();

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("select idcategoria, aciertos from preguntas group by idcategoria order by idcategoria;");
            while (rs.next()){
                System.out.println(rs.getString("idcategoria"));
                resultado.put(rs.getString("idcategoria"), rs.getInt("aciertos"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;

    }


    public ArrayList<Double> estadisticas(HashMap<String,Integer> map){
        ArrayList<Double> resultadoList = new ArrayList<Double>();
        ArrayList<HashMap<String, Integer>> totalList = new ArrayList<HashMap<String, Integer>>();

        Statement st;
        ResultSet rs;


        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("select idcategoria, (aciertos+fallos) as total\n" +
                    "from preguntas group by idcategoria order by idcategoria;");
            while (rs.next()){
                HashMap<String, Integer> total = new HashMap<String, Integer>();
                total.put(rs.getString("idcategoria"), rs.getInt("total"));
                totalList.add(total);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println(map.toString());
        System.out.println(totalList.toString());
        //totalList.get(0).get("C4");

        int counter = 0;

        for (Map.Entry<String, Integer> i: map.entrySet()){
            for(int j = 0; j<totalList.size();j++){
                for (Map.Entry<String, Integer> k: totalList.get(j).entrySet()){
                    if(k.getKey().toString().equals(i.getKey().toString())){
                        double resultado = i.getValue()*100;
                        resultado = resultado / k.getValue();
                        System.out.println(resultado);

                        if (resultado >= 50){
                            resultadoList.add(resultado);
                        }
                    }
                }
            }
        }


        //System.out.println(map.toString());

        return resultadoList;

    }

    public void cerrarBD(){
        if (myConnection != null){
            try {
                myConnection.close();
                System.out.println("Desconectado!");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("ERROR");
            }
        }
    }



    public static void main(String[] args) {
        GestorBD manager = new GestorBD();
       // System.out.println(manager.todasCategorias().toString());
        //System.out.println(manager.preguntasDeCategoria("Cine").toString());
        ArrayList<String> categorias = new ArrayList<String>();
        categorias.add("Cine");
        //categorias.add("Ingles");
        //categorias.add("Calculo");

        //System.out.println(manager.preguntasAlAzar(categorias, 2).toString());

       // System.out.println(manager.preguntasAlAzar(categorias,2));
        //Pregunta p = new Pregunta(5, "Pregunta con id5");
        //System.out.println(manager.guardarAcierto(p));
        //System.out.println(manager.guardarFallo(p));
        //System.out.println(manager.crearMapaRespuestasCorrectas().toString());
        HashMap<String, Integer> prueba = manager.crearMapaRespuestasCorrectas();

        System.out.println(manager.estadisticas(prueba));
        //Pregunta p1 = new Pregunta(5,"Mi pregunta");
        //p1.getIdPregunta();

        //System.out.println(manager.preguntasDeCategoria("Geografia").toString());

    }
}
