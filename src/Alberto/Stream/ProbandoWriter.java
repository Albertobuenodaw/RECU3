package Alberto.Stream;

import java.io.*;

public class ProbandoWriter {
    public static void main(String[] args) {
        try {

            FileWriter wr = new FileWriter("Writer.txt");

            wr.write("Esto es una prueba para un ejercicio. Location");
            wr.flush();
            wr.close();


            FileReader reader = new FileReader("Writer.txt");
            int c=0;
            while (c != -1){
                 c = (reader.read());
                System.out.print((char)c);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
