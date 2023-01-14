package PHOTOGRAPHERS;

public class Photographer {
    private int photographerId;
    private String name;
    private boolean awarded;

    public Photographer(int photographerId, String name, boolean awarded) {
        this.photographerId = photographerId;
        this.name = name;
        this.awarded = awarded;
    }

    @Override
    public String toString() {
        return "Photographer{" +
                "photographerId=" + photographerId +
                ", name='" + name + '\'' +
                ", awarded=" + awarded +
                '}' + "\n";
    }

    public int getPhotographerId() {
        return photographerId;
    }

    public String getName() {
        return name;
    }

    public boolean isAwarded() {
        return awarded;
    }

    public static void main(String[] args) {

    }
}


