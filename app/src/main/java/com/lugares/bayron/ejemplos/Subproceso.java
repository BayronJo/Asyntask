package com.lugares.bayron.ejemplos;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class Subproceso extends AsyncTask<Integer,Integer,String> {
    Context context;
    TextView lblTexto;
    Button btnProceso;

    public Subproceso(Context context, TextView lblTexto, Button btnProceso) {
        this.context = context;
        this.lblTexto = lblTexto;
        this.btnProceso = btnProceso;
    }


    //antes de la ejecucion
    @Override
    protected void onPreExecute() {
        btnProceso.setEnabled(false);
        super.onPreExecute();
    }

    //Metodo para decir que se va a hacer en segundo Plano
    //... significan que es una lista
    @Override
    protected String doInBackground(Integer... integers) {
        for(int i=0;i<=10;i++){

            try {
                //publica el progreso que se ejecuta en este metodo
                publishProgress(i);
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Finalizado";
    }

    //Cuando se Actualiza Proceso
    @Override
    protected void onProgressUpdate(Integer... values) {
        lblTexto.setText("Numero "+ values[0]);
        super.onProgressUpdate(values);
    }

    //Cuando se Finaliza el Proceso
    @Override
    protected void onPostExecute(String s) {
        lblTexto.setText(s);
        btnProceso.setEnabled(true);
        super.onPostExecute(s);
    }
}
