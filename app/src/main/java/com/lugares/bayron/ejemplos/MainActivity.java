package com.lugares.bayron.ejemplos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Declaramos las variables
    TextView lbltexto;
    Button btnProceso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inicializamos las variables
        lbltexto = findViewById(R.id.lblTexto);
        btnProceso = findViewById(R.id.btnProceso);

        btnProceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contador();
            }
        });
    }

    private void Contador(){
                                              //Parametros del Asyntask
        new Subproceso(this,lbltexto,btnProceso).execute(10);
    }
}
