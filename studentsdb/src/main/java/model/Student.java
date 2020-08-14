package model;

public class Student {
    private int id;
    private String faculty;
    private String surname;
    private String name;
    private String average_mark;

    public Student() {
    }

    public Student(int id, String faculty, String surname, String name, String average_mark) {
        this.id = id;
        this.faculty = faculty;
        this.surname = surname;
        this.name = name;
        this.average_mark = average_mark;
    }

    public Student(String faculty, String surname, String name, String average_mark) {
        this.faculty = faculty;
        this.surname = surname;
        this.name = name;
        this.average_mark = average_mark;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAverage_mark() {
        return average_mark;
    }

    public void setAverage_mark(String average_mark) {
        this.average_mark = average_mark;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", faculty='" + faculty + '\'' +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", average_mark=" + average_mark +
                '}';
    }
}
