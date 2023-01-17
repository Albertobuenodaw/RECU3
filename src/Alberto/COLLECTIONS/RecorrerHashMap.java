package Alberto.COLLECTIONS;
import java.util.*;

public class RecorrerHashMap {
    public static  void main (String [] args){
        List<String> lista = new ArrayList<String>();
        Map<Integer, String> mapa = new HashMap<Integer, String>();
        Integer indice = 1;

        //rellenamos
        //arraylist
        lista.add("Alberto");
        lista.add("Alberto");
        lista.add("Javier");
        lista.add("Unai");
        lista.add("Sergio");
        lista.add("Gorka");

        //hashMap
        for (int i=0; i<lista.size(); i++){
            mapa.put(indice, lista.get(i));

            indice++;
        }

        //recorremos el hashmap
        //1-forEach
//        mapa.forEach(
//                (id, nombre)
//                -> {
//                    System.out.println("Id:" + id + " Nombre:" + nombre);
//                    System.out.println(nombre+" es el mejor.");
//                }
//
//        );


        //2-for get.Value get.Key
//        for(Map.Entry<Integer,String> registro : mapa.entrySet()){
//            System.out.println("Id:"+ registro.getKey()+" Nombre:"+registro.getValue());
//        }

        //3-iterator
//        Iterator<Map.Entry<Integer,String>> it = mapa.entrySet().iterator();
//        while (it.hasNext()){
//            System.out.println("Nombre ->"+(String)it.next().getValue());
//        }
    }

}
