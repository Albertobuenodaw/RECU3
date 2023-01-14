package PHOTOGRAPHERS;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhotographerManager {
    private Connection myConnection;

    private static String url = "jdbc:mariadb://localhost:3306/swingexercise2";
    private static String user = "root";
    private static String password = "root";

    public PhotographerManager(){
        myConnection = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            myConnection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Photographer> allPhotographers(){
        Statement st;
        ResultSet rs;
        List<Photographer> l = new ArrayList<Photographer>();
        Photographer p;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM Photographers;");
            while (rs.next()){
                p = new Photographer(rs.getInt("PhotographerId"), rs.getString("Name"), rs.getBoolean("Awarded"));
                l.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Photographer>) l;
    }

    public ArrayList<Picture> picturesOfPhotographer(Photographer p){
        List<Picture> result = new ArrayList<Picture>();
        Picture pic = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("select * from Pictures where PhotographerId = " + p.getPhotographerId() + ";");
            while (rs.next()){
                pic = new Picture(rs.getInt("PictureId"), rs.getString("Title"), rs.getDate("Date"),
                        rs.getString("File"), rs.getInt("Visits"), p);
                result.add(pic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (ArrayList<Picture>) result;
    }

    public ArrayList<Picture> picturesOfPhotographerName(String photographerName){
        List<Picture> result = new ArrayList<Picture>();

        Picture pic = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("select * \n" +
                    "from Pictures inner join Photographers\n" +
                    "on Pictures.PhotographerId = Photographers.PhotographerId \n" +
                    "where Photographers.Name = '" + photographerName + "';");
            while (rs.next()){
                pic = new Picture(rs.getInt("PictureId"), rs.getString("Title"), rs.getDate("Date"),
                        rs.getString("File"), rs.getInt("Visits"));
                result.add(pic);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return (ArrayList<Picture>) result;
    }

    public static void main(String[] args) {
        PhotographerManager manager = new PhotographerManager();
        //System.out.println(manager.allPhotographers().toString());
        System.out.println(manager.picturesOfPhotographer(manager.allPhotographers().get(2)).toString());
    }


}
