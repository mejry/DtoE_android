package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
 EditText text;
 Button convert;
 RadioButton euro,dinar;
 TextView affiche;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text= findViewById(R.id.montant);
        convert=findViewById(R.id.click);
        euro=findViewById(R.id.euro);
        dinar=findViewById(R.id.dinar);
        affiche=findViewById(R.id.affiche);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = text.getText().toString();
                if (input.isEmpty()) {
                    affiche.setText("Please enter a number");
                    return;
                }
                try {
                    Float number = Float.parseFloat(input);

                    if (euro.isChecked()) {
                        affiche.setText((number * 3) + "");
                    }
                    if (dinar.isChecked()) {
                        affiche.setText((number / 3) + "");
                    }
                }catch (NumberFormatException e) {
                    affiche.setText("Invalid input. Please enter a valid number.");
                }
            }
        });

    }
}