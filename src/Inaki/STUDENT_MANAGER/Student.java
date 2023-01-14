package Inaki.STUDENT_MANAGER;

import java.sql.Date;
import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private String city;
    private String telephone;
    private Date fechaNacmto;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getTelephone() {
        return telephone;
    }

    public Date getFechaNacmto() {
        return fechaNacmto;
    }

    public int getDegreeCode() {
        return degreeCode;
    }

    private int degreeCode;
    private Degree degree;


    public Student(String id, String name, String city, String telephone, String fechaNacmto, int degreeCode){
        this.id = id;
        this.name = name;
        this.city = city;
        this.telephone = telephone;
        this.fechaNacmto = Date.valueOf(fechaNacmto);
        this.degreeCode = degreeCode;
    }

    public Student(String id, String name, String city, String telephone, String fechaNacmto, Degree degree){
        this.id = id;
        this.name = name;
        this.city = city;
        this.telephone = telephone;
        this.fechaNacmto = Date.valueOf(fechaNacmto);
        this.degree = degree;
    }


    public Student(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Tell me the info of the student: ");
        System.out.println("ID: ");
        this.id = sc.next();
        System.out.println("Name: ");
        this.name = sc.next();
        System.out.println("City: ");
        this.city = sc.next();
        System.out.println("Phone: ");
        this.telephone = sc.next();
        System.out.println("Birth date: ");
        this.fechaNacmto = Date.valueOf(sc.next());
        System.out.println("Degree code: ");
        this.degreeCode = sc.nextInt();
    }

    @Override
    public String toString(){
        String message;
        message = "\nID: " + this.id + "\nName: " + this.name + "\nCity: " + this.city +
                "\nPhone: " + this.telephone + "\nBirth date: " + this.fechaNacmto +
                "\nDegree code: " + this.degreeCode;
        return message;
    }

    public static void main(String[] args) {
        Student s = new Student();
        System.out.println(s.toString());
    }
}


