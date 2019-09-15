package com.example.myfirstapp;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class GradesViewer extends AppCompatActivity {

    Context context;
    RecyclerView recyclerView;
    RelativeLayout relativeLayout;
    RecyclerView.Adapter recyclerViewAdapter;
    RecyclerView.Adapter recyclerGradeAdapter;
    RecyclerView.LayoutManager recylerViewLayoutManager;
    List<Course> courses = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grades_viewer);
        //back button
        assert getSupportActionBar() != null;   //null check
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);   //show back button


        //recycle view added
        context = getApplicationContext();
        relativeLayout = findViewById(R.id.relativelayout1);
        recyclerView = findViewById(R.id.recyclerview1);
        recylerViewLayoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(recylerViewLayoutManager);
        Course course;
        for (int j = 0; j < 5; j++) {
            course= Course.generateRandomCourse();

            while (!course.hasAssignment()){
                course.reduceID();
                course= Course.generateRandomCourse();

            }

            courses.add(course);

        }

        Course.resetID();
        recyclerViewAdapter = new RecyclerViewAdapter(context, courses);

        recyclerView.setAdapter(recyclerViewAdapter);
        //divider line
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.user_menu, menu);
//        return super.onCreateOptionsMenu(menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                //Write your logic here
                this.finish();
                return true;
            case R.id.show_grade:
                if (item.isChecked()) {
                    item.setChecked(false);
                    recyclerViewAdapter = new RecyclerViewAdapter(context, courses);
                    recyclerView.setAdapter(recyclerViewAdapter);
                } else {
                    item.setChecked(true);
                    recyclerGradeAdapter = new RecyclerGradeAdapter(context, courses);
                    recyclerView.setAdapter(recyclerGradeAdapter);

                }

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
