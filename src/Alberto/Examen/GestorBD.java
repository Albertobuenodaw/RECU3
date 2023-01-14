package Alberto.Examen;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorBD {
    private Connection myConnection;
    private String url= "jdbc:mariadb//localhost::3306/PruebaEjercicio";
    private String user = "root";
    private String password = "root";

    private Statement st;
    private  ResultSet rs;


    public GestorBD() {
        System.out.println("Conectando a la Base de Datos...");
        System.out.println("..-");
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            myConnection = DriverManager.getConnection(url,user,password);
            System.out.println("Conectado exitosamente.");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> todasCategorias (){
        List <String> todasCategorias = new ArrayList<String>();
        try {
            st=myConnection.createStatement();
            rs=st.executeQuery("SELECT * FROM CATEGORIA");
            while (rs.next()){
                if(!todasCategorias.contains(rs.getString("idCategoria")))
                todasCategorias.add(rs.getString("idCategoria"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return todasCategorias;
    }

    public List<String> preguntasDeCategoria(String categoria){
        List <String> preguntas = new ArrayList<String>();
        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM preguntas;");
            while(rs.next()){
                if(categoria == rs.getString("categoria")){
                    preguntas.add(rs.getString("pregunta"));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return preguntas;
    }

    public List <String> preguntasAlAzar(List <String> categorias, int n){
        List <String> preguntasAzar = new ArrayList<String>();
        List <String> preguntasDecategoria ;
        List <String> preguntasDeListaCategorias = null;
        int indicePreguntasAzar;

            for(int i=0; i<categorias.size(); i++){
                preguntasDecategoria = preguntasDeCategoria(categorias.get(i));
                preguntasDeListaCategorias.addAll(preguntasDecategoria);
            }
            for (int i=0; i<n; i++){
                indicePreguntasAzar= (int) (Math.random()*preguntasDeListaCategorias.size());
                preguntasAzar.add(preguntasDeListaCategorias.get(indicePreguntasAzar));
            }

        return preguntasAzar;
    }

    public boolean guardarAciertos (String pregunta){

        return true;
    }
    public void close(){
        try {
            myConnection.close();
            System.out.println("Desconectando");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
