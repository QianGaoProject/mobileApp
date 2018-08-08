package com.example.qian.day1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    String studentId[] = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "12", "13", "14", "15", "16"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Random r = new Random();
        int j = r.nextInt(studentId.length);

        //System.out.println(studentId[j]);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView textElement=(TextView)findViewById(R.id.this_is_id_name);
//        textElement.append("\n List student id: ");
//        //textElement.setText(studentId[j]+"");
//        for (String a:studentId
//             ) {
//            textElement.append(","+a);
//        }

    }

    //    static int count =0;
//    public void doSomething(View view) {
//         TextView textView = findViewById(R.id.count);
//
//         count++;
//         textView.setText("\n\n"+count);
//    }
    public void getStudentID(View view) {
        TextView textView = findViewById(R.id.random_studentId);
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(1, "Aref"));
        studentList.add(new Student(2, "Qian"));
        studentList.add(new Student(3, "Alex"));
        studentList.add(new Student(4, "Jing"));
        studentList.add(new Student(5, "Kiu"));
        studentList.add(new Student(6, "John"));
        studentList.add(new Student(7, "Alan"));
        int random = (int) (Math.random() * studentList.size());
        Student s = studentList.get(random);

        textView.setText("id: " + s.id + " name:" + s.name);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag", "In onStart");
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag", "In onPause");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag", "In onStop");
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag", "In onDestory");
    }

}

class Student {
    int id;
    String name;

    public Student(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
