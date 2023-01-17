package Alberto.Stream;

import java.io.*;

public class ProbandoBufferedReader {
    public static void main (String [] args){

        try {
            BufferedReader br = new BufferedReader(new FileReader("texto.txt"));
                System.out.println(br.readLine());

            BufferedWriter wr = new BufferedWriter(new FileWriter("OtroTexto.txt"));
            wr.write("br.readLine()");
            wr.flush();


            br.close();
            wr.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
