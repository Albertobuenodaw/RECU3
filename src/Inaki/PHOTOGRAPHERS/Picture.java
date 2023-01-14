package Inaki.PHOTOGRAPHERS;

import java.sql.Date;

public class Picture {
    private int pictureId;
    private String title;
    private Date date;
    private String file;
    private int visits;
    private Photographer photographer;

    public Picture(int pictureId, String title, Date date, String file, int visits, Photographer photographer) {
        this.pictureId = pictureId;
        this.title = title;
        this.date = date;
        this.file = file;
        this.visits = visits;
        this.photographer = photographer;
    }

    public String getTitle() {
        return title;
    }

    public Picture(int pictureId, String title, Date date, String file, int visits) {
        this.pictureId = pictureId;
        this.title = title;
        this.date = date;
        this.file = file;
        this.visits = visits;
    }

    @Override
    public String toString() {
        return "Picture{" +
                "pictureId=" + pictureId +
                ", title='" + title + '\'' +
                ", date=" + date +
                ", file='" + file + '\'' +
                ", visits=" + visits +
                ", photographer=" + photographer +
                '}';
    }
}
