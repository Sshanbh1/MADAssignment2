package com.example.inclass02;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_shape;
    private TextView tv_result;
    private Button button_calculate;
    private Button button_clear;
    private ImageView iv_triangle;
    private ImageView iv_circle;
    private ImageView iv_square;
    private EditText et_length1;
    private EditText et_length2;
    private String selectedShape;
    private float length1 = 0;
    private float length2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("Area Calculator");

        et_length1 = findViewById(R.id.et_length1);
        et_length2 = findViewById(R.id.et_length2);
        tv_result = findViewById(R.id.tv_result);
        tv_shape = findViewById(R.id.tv_shape);
        button_calculate = findViewById(R.id.button_calculate);
        button_clear = findViewById(R.id.button_clear);
        iv_triangle = findViewById(R.id.iv_triangle);
        iv_square = findViewById(R.id.iv_square);
        iv_circle = findViewById(R.id.iv_circle);

        tv_shape.setText("Select a Shape.");

        button_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearButton();
            }
        });

        iv_triangle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedShape = "triangle";
                tv_shape.setText("Triangle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.VISIBLE);
            }
        });

        iv_circle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedShape = "circle";
                tv_shape.setText("Circle");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);
            }
        });

        iv_square.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedShape = "square";
                tv_shape.setText("Square");
                et_length1.setVisibility(View.VISIBLE);
                et_length2.setVisibility(View.INVISIBLE);
            }
        });

        button_calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tempLen1 = et_length1.getText().toString();

                String tempLen2 = et_length2.getText().toString();

                if(tempLen1.equals("") || !isNumeric(tempLen1)){
                    et_length1.setError("Please Enter a Appropriate Value");
                } else {
                    length1 = Float.parseFloat(tempLen1);
                }
                if(tempLen2.equals("") || !isNumeric(tempLen2)){
                    et_length2.setError("Please Enter a Appropriate Value");
                } else {
                    length2 = Float.parseFloat(tempLen2);
                }

                if(selectedShape == null){
                    selectedShape = "none";
                }

                switch (selectedShape) {
                    case "triangle":
                        double triangle_result = 0.5*length1*length2;
                        tv_result.setText(triangle_result + "");
                        break;
                    case "square":
                        double sqr_result = Math.pow(length1, 2);
                        tv_result.setText(sqr_result + "");
                        break;
                    case "circle":
                        double circle_result = 3.14*Math.pow(length1 ,2);
                        tv_result.setText(circle_result + "");
                        break;
                    default:
                        tv_result.setText("Please select a Shape and try again.");
                        break;
                }
            }
        });
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

    public void clearButton() {
        et_length1.setVisibility(View.VISIBLE);
        et_length2.setVisibility(View.VISIBLE);
        et_length1.setText("");
        et_length2.setText("");
        tv_result.setText("");
        tv_shape.setText("Select a Shape");
        selectedShape = "none";
    }
}
