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

        //Checks if True RadioButton is Checked in Question 2
        RadioButton trueButton = findViewById(R.id.True_Option);
        boolean clickedTrue = trueButton.isChecked();

        //Checks if something is written in the text field in Question 3
        EditText textField = findViewById(R.id.Text_Field);
        boolean hasNotWritten = isEmpty(textField);

        //Checks if Option 1 RadioButton is Checked in Question 4
        RadioButton optionOne = findViewById(R.id.Option_One_Button);
        boolean clickedOptionOne = optionOne.isChecked();

        //Sets the value returned from the totalPointsCalculated method to the points variable.
        int points = totalPointsCalculated(clickedJava, clickedKotlin, clickedTrue, hasNotWritten, clickedOptionOne);

        //Shows the user their total points via toast message.
        Toast.makeText(getApplicationContext(), "You Scored: " + points + " out of 4 points", Toast.LENGTH_LONG).show();

        //Displays if you are wrong or right for question 1.
        displayAnswerQOne(clickedJava, clickedKotlin);

        //Displays if you are wrong or right for question 2.
        displayAnswerQTwo(clickedTrue);

        //Displays if you are wrong or right for question 3.
        displayAnswerQThree(hasNotWritten);

        //Displays if you are wrong or right for question 4.
        displayAnswerQFour(clickedOptionOne);

    }

    /**
     * This method calculates the total amount of correct answers.
     * @return total points scored as an integer
     */
    private int totalPointsCalculated(boolean clickedJava, boolean clickedKotlin, boolean clickedTrue, boolean hasNotWritten, boolean clickedOptionOne){
        int points = 0;

        if (clickedJava && clickedKotlin) {
            points = points + 1;
        }

        if (clickedTrue) {
            points = points + 1;
        }

        if (!hasNotWritten) {
            points = points + 1;
        }

        if (clickedOptionOne) {
            points = points + 1;
        }

        return points;
    }

    /**
     * This method checks if there are characters written on the text field.
     * @return true if text field is empty, false if something is written in the text field.
     */
    private boolean isEmpty(EditText textField) {
        return textField.getText().toString().trim().length() == 0;
    }

    /**
     * This method displays if the user is right or wrong for Question 1.
     */
    public void displayAnswerQOne(boolean clickedJava, boolean clickedKotlin) {
        if (clickedJava && clickedKotlin) {
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
    public void displayAnswerQThree(boolean hasNotWritten) {
        if (!hasNotWritten) {
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
