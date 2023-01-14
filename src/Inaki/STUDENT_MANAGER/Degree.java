package Inaki.STUDENT_MANAGER;
public class Degree {
    private int degreeCode;
    private String title;
    private int hours;

    public Degree(int degreeCode, String title, int hours){
        this.degreeCode = degreeCode;
        this.title = title;
        this.hours = hours;
    }

    @Override
    public String toString(){
        String message;
        message = "\nDegree code: " + this.degreeCode + "\nTitle: " + this.title + "\nHours: " + this.hours;
        return message;
    }

    public int getDegreeCode() {
        return degreeCode;
    }

    public String getTitle() {
        return title;
    }

    public int getHours() {
        return hours;
    }

    public static void main(String[] args) {

    }
}

