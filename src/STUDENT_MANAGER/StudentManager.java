package STUDENT_MANAGER;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private Connection myConnection;
    private static String url = "jdbc:mariadb://localhost:3306/StudentManager";
    private static String user = "root";
    private static String password = "root";

    public StudentManager(){
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

    public ArrayList<Student> studentList(){
        List<Student> l = new ArrayList<Student>();
        Statement st = null;
        ResultSet rs = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM Students");
            while (rs.next()){
                Student s = new Student(rs.getString("Id"), rs.getString("Name"), rs.getString("City"),
                        rs.getString("Telephone"), rs.getString("FechaNacmto"), rs.getInt("DegreeCode"));
                l.add(s);


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (ArrayList<Student>) l;
    }

    public Student searchStudent(String id){
        Statement st = null;
        ResultSet rs = null;
        Student s = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM Students WHERE Id = '" + id + "';");
            while (rs.next()){
                s = new Student(rs.getString("Id"), rs.getString("Name"), rs.getString("City"),
                        rs.getString("Telephone"), rs.getString("FechaNacmto"), rs.getInt("DegreeCode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return s;
    }

    public void removeStudent(String id){
        Statement st = null;
        ResultSet rs = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("DELETE FROM Students WHERE Id = '" + id + "';");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertStudent(Student s){
        Statement st = null;
        ResultSet rs = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("INSERT INTO Students VALUES ('" + s.getId() + "', '" + s.getName() + "', '"
                    + s.getCity() + "', '" + s.getTelephone() + "', '" + s.getFechaNacmto() + "', " + s.getDegreeCode() + ");");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modifyStudent(String id, Student s){
        Statement st = null;
        ResultSet rs = null;

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("DELETE FROM Students WHERE Id = '" + id + "';");
            rs = st.executeQuery("INSERT INTO Students VALUES ('" + s.getId() + "', '" + s.getName() + "', '" + s.getCity() + "', '" + s.getTelephone() + "', '" + s.getFechaNacmto() + "', " + s.getDegreeCode() + ");");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Degree> allDegrees(){
        Statement st = null;
        ResultSet rs = null;
        ArrayList<Degree> degreeList = new ArrayList<Degree>();

        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM Degrees;");
            while (rs.next()){
                Degree d = new Degree(rs.getInt("CodDegree"), rs.getString("Title"), rs.getInt("Hours"));

                degreeList.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return degreeList;
    }

    public Degree searchDegree(int degreeCode) {
        Statement st = null;
        ResultSet rs = null;

        Degree d = null;
        try {
            st = myConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM Degrees WHERE CodDegree = " + degreeCode + ";");
            while (rs.next()) {
                d = new Degree(rs.getInt("CodDegree"), rs.getString("Title"), rs.getInt("Hours"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return d;
    }

    public void finish(){
        if (myConnection != null){
            try {
                myConnection.close();
                System.out.println("Disconnected!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        //System.out.println(manager.studentList().toString());
        //System.out.println(manager.searchStudent("1212").toString());
        //manager.removeStudent("121212");
        //Student s = new Student();
        //manager.insertStudent(s);
        //System.out.println(manager.searchStudent(s.getId()));
        //manager.modifyStudent("1212", s);
        //System.out.println(manager.allDegrees().toString());
        System.out.println(manager.searchDegree(2).toString());
        manager.finish();
    }
}
