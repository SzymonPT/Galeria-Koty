package com.example.galeriakoty;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.galeriakoty.R;

public class MainActivity extends AppCompatActivity {
    int numer = 0;
    private Button poprzedni;
    private Button nastepny;
    private ImageView imageView;
    private Switch sw;
    private LinearLayout tlo;
    private EditText wpisywany_numer_zdjecia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        poprzedni = findViewById(R.id.poprzedni);
        nastepny = findViewById(R.id.nastepny);
        imageView = findViewById(R.id.Zdjecie);
        sw = findViewById(R.id.sw);
        tlo = findViewById(R.id.main);
        wpisywany_numer_zdjecia = findViewById(R.id.jakie_zd);


        int[] tablica_zd = new int[4];
        tablica_zd[0] = R.drawable.kot1;
        tablica_zd[1] = R.drawable.kot2;
        tablica_zd[2] = R.drawable.kot3;
        tablica_zd[3] = R.drawable.kot4;
        nastepny.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(numer<3){
                            numer++;
                        }
                        else{
                            numer=0;
                        }
                        imageView.setImageResource(tablica_zd[numer]);
                    }
                }
        );

        wpisywany_numer_zdjecia.addTextChangedListener(
                new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                    }

                    @Override
                    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                        if(!charSequence.toString().isEmpty()){
                            numer = Integer.parseInt(charSequence.toString());
                            if(numer>=1 && numer <= 4){
                                imageView.setImageResource(tablica_zd[numer-1]);
                            }
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable editable) {

                    }
                }
        );

        poprzedni.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(numer>0){
                            numer--;
                        }
                        else{
                            numer=3;
                        }
                        imageView.setImageResource(tablica_zd[numer]);
                    }
                }
        );

        sw.setOnCheckedChangeListener(
                new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                        if(b){
                            tlo.setBackgroundColor(Color.parseColor("#1565c0"));
                        }
                        else{
                            tlo.setBackgroundColor(Color.parseColor("#00796B"));
                        }
                    }
                }
        );



    }
}