package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText campEdit;
    TextView textValor;
    Button btnOk;
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campEdit = findViewById(R.id.campEdit);
        textValor = findViewById(R.id.campText);
        btnOk = findViewById(R.id.btn);

        sp = getSharedPreferences(getString(R.string.key), Context.MODE_PRIVATE);
        String resultado = sp.getString(getString(R.string.key), "");
        textValor.setText("Valor: " + resultado);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                editor = sp.edit();
                editor.putString(getString(R.string.key), campEdit.getText().toString());
                editor.apply();
                textValor.setText("Valor: " + campEdit.getText().toString());

            }
        });
    }
}