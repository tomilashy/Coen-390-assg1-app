package com.example.myfirstapp;

import java.util.Random;

/**
 * Created by Tawfiq on 1/13/2017.
 */
public class Assignment {
    private static int assID = 0; //static ID increments with every new assignment created
    private String assignmentTitle; //title of assignment
    private int assignmentGrade; //grade of assignment
    private  String assignmentLetter;

    //private constructor. Increments ID.
    private Assignment(String title, int grade) {
        assignmentTitle = title;
        assignmentGrade = grade;
        assID++;
        viewGrade(grade);
    }
    public static void resetID(){assID=1;};

    //returns an Assignment instance with random values
    static public Assignment generateRandomAssignment() {
        Random rnd = new Random();
        String tempTitle = "Assignment " + assID;
        int tempGrade = rnd.nextInt(100) + 1;

        return new Assignment(tempTitle, tempGrade);
    }

    public void viewGrade(int tempGrade) {
        if (tempGrade > 79) {
            assignmentLetter = "A";
        } else if (tempGrade > 69 && tempGrade<80) {
            assignmentLetter = "B";
        } else if (tempGrade > 59 && tempGrade<70) {
            assignmentLetter = "C";
        } else if (tempGrade > 49 && tempGrade<60) {
            assignmentLetter = "D";
        } else if (tempGrade >= 0 &&tempGrade < 50) {
            assignmentLetter = "F";
        }
    }

    //****get methods*****//
    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public int getAssignmentGrade() {

        return assignmentGrade;
    }

    public String getAssignmentLetterGrade() {
        return assignmentLetter;
    }
}
