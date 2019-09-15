package com.example.myfirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    List<Course> Courses=new ArrayList<Course>();;
    Context context;
    View view1;
    ViewHolder viewHolder1;
    TextView textView;
    Random rnd = new Random();

    public RecyclerViewAdapter(Context context1, List<Course> Courses1){

        Courses = Courses1;
        context = context1;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textView;

        public ViewHolder(View v){

            super(v);

            textView = v.findViewById(R.id.courses_textview);
        }
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        view1 = LayoutInflater.from(context).inflate(R.layout.recyclerview_layout,parent,false);

        viewHolder1 = new ViewHolder(view1);

        return viewHolder1;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
               holder.textView.setText(Text(position));
    }

    @Override
    public int getItemCount(){

        return Courses.size();
    }
    interface Average {
        // An abstract function
        int AVG(ArrayList x);
    }


    // display text in numbers
    public String Text(int position){
        String text = Courses.get(position).getCourseTitle() + "\t\t           Average: -";
        final ArrayList<Assignment> assignments = Courses.get(position).getAssignments();
        for (int i = 0; i < assignments.size(); i++) {
            if (i == 0) {
                Average average = new Average() {
                    @Override
                    public int AVG(ArrayList lists) {
                        int sum = 0;
                        for (int a = 0; a < assignments.size(); a++) {
                            sum += assignments.get(a).getAssignmentGrade();
                        }
                        return sum / assignments.size();
                    }
                };

                text = text.split("-")[0]+ average.AVG(assignments) + "\n\n";
            }

            text += assignments.get(i).getAssignmentTitle() + "\t\t\t\t" + assignments.get(i).getAssignmentGrade() + "\n";

        }
        return text;
    }
}