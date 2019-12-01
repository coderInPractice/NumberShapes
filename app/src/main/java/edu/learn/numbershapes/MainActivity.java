package edu.learn.numbershapes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    class NumberShapes{
        int num;
        public boolean isSqaure(){
            double squarRoot = Math.sqrt(num);

            if(squarRoot== Math.floor(squarRoot)){
                return true;
            }else
                return false;

        }

        public boolean isTriangular(){
            int x = 1;

            int triangularNumber = 1;

            while (triangularNumber < num) {

                x++;
                triangularNumber = triangularNumber + x;
            }

            if (triangularNumber == num) {
                return true;
            } else {
                return false;
            }

        }
    }

    public void checkNumber(View view) {
        EditText text = (EditText) findViewById(R.id.inputText);
        String usrInput = text.getText().toString();

        NumberShapes number = new NumberShapes();
        number.num = Integer.parseInt(usrInput);
        String message = "";

        if (usrInput.isEmpty()) {
            message = "Please enter a number";
        } else {

            if (number.isSqaure() && number.isTriangular()) {
                message = "it is both square and triangular number";
            } else if (number.isTriangular()) {
                message = "it is a triangular number";
            } else if (number.isSqaure()) {
                message = "it is a square number";
            } else {
                message = "it is neither square nor triangular number";
            }
        }
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
