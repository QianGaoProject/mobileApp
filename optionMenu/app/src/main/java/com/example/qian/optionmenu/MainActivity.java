package com.example.qian.optionmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int selectedItemId = item.getItemId();


        switch(selectedItemId){
            case R.id.getRandomStudentId: {
              getStudentID();

                return true;
            }
            case R.id.getRandomStudentWithInfomation: {
                getStudentInfoID();
                return true;
            }
                default: return super.onOptionsItemSelected(item);
        }

    }
    public void getStudentID() {
        TextView textView = findViewById(R.id.random_studentId);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "Aref" , "777 saint laurant"));
        studentList.add(new Student(2, "Qian" ,  "8574 Ryu"));
        studentList.add(new Student(3, "Alex",  "234 ertert"));
        studentList.add(new Student(4, "Jing",  "234 Rydfgu"));
        studentList.add(new Student(5, "Kiu",  "545 dfgdfg"));
        studentList.add(new Student(6, "John",  "65 etrert"));
        studentList.add(new Student(7, "Alan",  "76 Louis"));
        int random = (int) (Math.random() * studentList.size());
        Student s = studentList.get(random);

        textView.setText("Id: " + s.id );
    }
    public void getStudentInfoID() {
        TextView textView = findViewById(R.id.random_studentId);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "Aref" , "777 saint laurant"));
        studentList.add(new Student(2, "Qian" ,  "8574 Ryu"));
        studentList.add(new Student(3, "Alex",  "234 ertert"));
        studentList.add(new Student(4, "Jing",  "234 Rydfgu"));
        studentList.add(new Student(5, "Kiu",  "545 dfgdfg"));
        studentList.add(new Student(6, "John",  "65 etrert"));
        studentList.add(new Student(7, "Alan",  "76 Louis"));
        int random = (int) (Math.random() * studentList.size());
        Student s = studentList.get(random);

        textView.setText("Id: " + s.id+ "Name: "+s.name+"Address: "+s.address );
    }
}
class Student{
    int id;
    String name;
    String address;
    public Student(int id, String name ,String address) {
        super();
        this.id = id;
        this.name = name;
        this.address=address;
    }
        }
