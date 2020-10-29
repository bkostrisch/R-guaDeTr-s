package com.example.reguadetres;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1;
    EditText number2;
    EditText number3;
    TextView finalresult;
    RadioButton direta;
    RadioButton inversa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number1 = (EditText) findViewById(R.id.number1);
        number2 = (EditText) findViewById(R.id.number2);
        number3 = (EditText) findViewById(R.id.number3);
        finalresult = (TextView) findViewById(R.id.finalresult);
        direta = (RadioButton) findViewById(R.id.directradio);
        inversa = (RadioButton) findViewById(R.id.inverseradio);


        ImageButton btn_exit = (ImageButton) findViewById(R.id.btn_exit);
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(), EndingScene.class));
                finish();
            }
        });

        ImageButton result = (ImageButton) findViewById(R.id.result);
        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){

                try {
                    if (direta.isChecked()) {

                        finalresult.setText(Float.toString(Float.parseFloat(number2.getText().toString()) * Float.parseFloat(number3.getText().toString()) / Float.parseFloat(number1.getText().toString())));

                    } else if (inversa.isChecked()) {

                        finalresult.setText(Float.toString(Float.parseFloat(number1.getText().toString()) * Float.parseFloat(number2.getText().toString()) / Float.parseFloat(number3.getText().toString())));

                    }
                } catch (Exception e){
                    Toast.makeText(MainActivity.this, "Por favor, insira os números!", Toast.LENGTH_SHORT).show();
                }
            }

        });

        ImageButton clean = (ImageButton) findViewById(R.id.btn_clean);
        clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finalresult.setText("");
                number1.setText("");
                number2.setText("");
                number3.setText("");

            }
        });


    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();
        ImageView diretamente = (ImageView) findViewById(R.id.directitle);
        ImageView inversamente = (ImageView) findViewById(R.id.inversetitle);
        ImageView direct = (ImageView) findViewById(R.id.direct);
        ImageView inverse1 = (ImageView) findViewById(R.id.inverse1);
        ImageView inverse2 = (ImageView) findViewById(R.id.inverse2);


        switch(view.getId()) {
            case R.id.inverseradio:
                if (checked)
                    diretamente.setVisibility(View.INVISIBLE);
                    direct.setVisibility(View.INVISIBLE);
                    inversamente.setVisibility(View.VISIBLE);
                    inverse1.setVisibility(View.VISIBLE);
                    inverse2.setVisibility(View.VISIBLE);
                    break;
            case R.id.directradio:
                if (checked)
                    diretamente.setVisibility(View.VISIBLE);
                    direct.setVisibility(View.VISIBLE);
                    inversamente.setVisibility(View.INVISIBLE);
                    inverse1.setVisibility(View.INVISIBLE);
                    inverse2.setVisibility(View.INVISIBLE);
                    break;
            }
        }
    }