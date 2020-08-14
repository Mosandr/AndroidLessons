package com.example.studentsdb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import data.DatabaseHandler;
import model.Student;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseHandler databaseHandler = new DatabaseHandler(this);
        databaseHandler.addStudent( new Student("Math", "Andriy", "Mosol", "5"));
        databaseHandler.addStudent( new Student("Physics", "Anton", "Petrov", "4.5"));
        databaseHandler.addStudent( new Student("Economy", "Petr", "Alekseev", "4.7"));
        databaseHandler.addStudent( new Student("Philosophy", "Anna", "Korenina", "4.3"));

        Student st = databaseHandler.getStudent(1);
        st.setSurname("Mosol");
        st.setName("Andriy");
        st.setFaculty("Math&Physics");
        databaseHandler.updateSudent(st);


        List<Student> studentsList = databaseHandler.getAllStudents();
        for (Student student: studentsList){
        Log.d ("StudentsInfo",""+ student.toString());
        }

        Log.d ("StudentsInfo",""+ databaseHandler.getStudentsCount());
    }
}
