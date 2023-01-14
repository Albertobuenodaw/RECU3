package Alberto.Examen;

public class Categoria {
    private String idCategoria;
    private String textoCategoria;

    public Categoria(String idCategoria, String textoCategoria) {
        this.idCategoria = idCategoria;
        this.textoCategoria = textoCategoria;
    }
    @Override
    public String toString() {
        return "Categoria{" +
                "idCategoria='" + idCategoria + '\'' +
                ", textoCategoria='" + textoCategoria + '\'' +
                '}';
    }
}
