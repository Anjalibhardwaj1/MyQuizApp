package com.example.myquizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This  quiz app calculates the total amount of right answers.
 */

public class MainActivity extends AppCompatActivity {
    String answer = "Hello World";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the submit button is clicked.
     */
    public void submitAnswers(View view) {

        //Checks if Java Checkbox is Checked in Question 1
        CheckBox javaCheckBox = findViewById(R.id.Java_Option);
        boolean clickedJava = javaCheckBox.isChecked();

        //Checks if Kotlin Checkbox is Checked in Question 1
        CheckBox kotlinCheckBox = findViewById(R.id.Kotlin_Option);
        boolean clickedKotlin = kotlinCheckBox.isChecked();

        //Checks if C# Checkbox is Checked in Question 1
        CheckBox csharpCheckBox = findViewById(R.id.C_Sharp_Option);
        boolean clickedCSharp = csharpCheckBox.isChecked();

        //Checks if python Checkbox is Checked in Question 1
        CheckBox pythonCheckBox = findViewById(R.id.Python_Option);
        boolean clickedPython = pythonCheckBox.isChecked();

        //Checks if True RadioButton is Checked in Question 2
        RadioButton trueButton = findViewById(R.id.True_Option);
        boolean clickedTrue = trueButton.isChecked();

        //Gets what is written in the text field in Question 3 and converts to string
        EditText textField = findViewById(R.id.Text_Field);
        String userResult = textField.getText().toString();

        //Checks if Option 1 RadioButton is Checked in Question 4
        RadioButton optionOne = findViewById(R.id.Option_One_Button);
        boolean clickedOptionOne = optionOne.isChecked();

        //Sets the value returned from the totalPointsCalculated method to the points variable.
        int points = totalPointsCalculated(clickedJava, clickedKotlin, clickedTrue, userResult, clickedOptionOne, clickedCSharp, clickedPython);

        //Shows the user their total points via toast message.
        Toast.makeText(getApplicationContext(), "You Scored: " + points + " out of 4 points", Toast.LENGTH_LONG).show();

        //Displays if you are wrong or right for question 1.
        displayAnswerQOne(clickedJava, clickedKotlin, clickedCSharp, clickedPython);

        //Displays if you are wrong or right for question 2.
        displayAnswerQTwo(clickedTrue);

        //Displays if you are wrong or right for question 3.
        displayAnswerQThree(userResult);

        //Displays if you are wrong or right for question 4.
        displayAnswerQFour(clickedOptionOne);

    }

    /**
     * This method calculates the total amount of correct answers.
     * @return total points scored as an integer
     */
    private int totalPointsCalculated(boolean clickedJava, boolean clickedKotlin, boolean clickedTrue, String userResult, boolean clickedOptionOne, boolean clickedCSharp, boolean clickedPython){
        int points = 0;

        if ((clickedJava && clickedKotlin) && (!(clickedCSharp) && !(clickedPython))) {
            points = points + 1;
        }

        if (clickedTrue) {
            points = points + 1;
        }

        if (userResult.equalsIgnoreCase(answer)) {
            points = points + 1;
        }

        if (clickedOptionOne) {
            points = points + 1;
        }

        return points;
    }

    /**
     * This method displays if the user is right or wrong for Question 1.
     */
    public void displayAnswerQOne(boolean clickedJava, boolean clickedKotlin, boolean clickedCSharp, boolean clickedPython) {
        if ((clickedJava && clickedKotlin) && (!(clickedCSharp) && !(clickedPython))) {
            TextView firstAnswer = findViewById(R.id.Answer_1);
            firstAnswer.setTextColor(Color.parseColor("#32CD32"));
            firstAnswer.setText(R.string.Right);

        } else {
            TextView firstAnswer = findViewById(R.id.Answer_1);
            firstAnswer.setTextColor(Color.parseColor("#DC143C"));
            firstAnswer.setText(R.string.Wrong);
        }
    }

    /**
     * This method displays if the user is right or wrong for Question 2.
     */
    public void displayAnswerQTwo(boolean clickedTrue) {
        if (clickedTrue) {
            TextView firstAnswer = findViewById(R.id.Answer_2);
            firstAnswer.setTextColor(Color.parseColor("#32CD32"));
            firstAnswer.setText(R.string.Right);

        } else {
            TextView firstAnswer = findViewById(R.id.Answer_2);
            firstAnswer.setTextColor(Color.parseColor("#DC143C"));
            firstAnswer.setText(R.string.Wrong);
        }
    }

    /**
     * This method displays if the user is right or wrong for Question 3.
     */
    public void displayAnswerQThree(String userResult) {
        if (userResult.equalsIgnoreCase(answer)) {
            TextView firstAnswer = findViewById(R.id.Answer_3);
            firstAnswer.setTextColor(Color.parseColor("#32CD32"));
            firstAnswer.setText(R.string.Right);

        } else {
            TextView firstAnswer = findViewById(R.id.Answer_3);
            firstAnswer.setTextColor(Color.parseColor("#DC143C"));
            firstAnswer.setText(R.string.Wrong);
        }
    }

    /**
     * This method displays if the user is right or wrong for Question 4.
     */
    public void displayAnswerQFour(boolean clickedOptionOne) {
        if (clickedOptionOne) {
            TextView firstAnswer = findViewById(R.id.Answer_4);
            firstAnswer.setTextColor(Color.parseColor("#32CD32"));
            firstAnswer.setText(R.string.Right);

        } else {
            TextView firstAnswer = findViewById(R.id.Answer_4);
            firstAnswer.setTextColor(Color.parseColor("#DC143C"));
            firstAnswer.setText(R.string.Wrong);
        }
    }

}
