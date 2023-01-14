package Examen;

public class Categoria {
    private int idCategoria;
    private String textoCategoria;

    public Categoria(int idCategoria, String textoCategoria) {
        this.idCategoria = idCategoria;
        this.textoCategoria = textoCategoria;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria=" + idCategoria +
                ", textoCategoria='" + textoCategoria + '\'' +
                '}';
    }
}
