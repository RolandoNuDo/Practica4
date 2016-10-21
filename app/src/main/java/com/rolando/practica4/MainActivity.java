package com.rolando.practica4;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText dinero;
    Button calcular;
    TextView mostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dinero = (EditText) findViewById(R.id.editText);
        calcular = (Button) findViewById(R.id.btnCalcular);
        mostrar = (TextView) findViewById(R.id.txtResultado);
        calcular.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnCalcular:
                String strDinero = dinero.getText().toString().trim();
                if (!strDinero.isEmpty()){
                    double dinero = Double.parseDouble(strDinero);
                    double aux;
                    int cien =(int) dinero / 100;
                    aux = dinero - (cien * 100d);
                    int cincuenta = (int) aux/50;
                    aux = aux - (cincuenta * 50);
                    int veinte =(int) aux / 20;
                    aux = aux - (veinte * 20);
                    int cinco = (int) aux/5;
                    aux = aux - (cinco * 5);
                    int dos = (int) aux/2;
                    aux = aux - (dos * 2);
                    int uno = (int) aux/1;
                    aux = aux - uno;
                    aux = (aux * 100d)+.01;
                    double check = aux;
                    int centavosCincuenta =(int) (aux / 50d);
                    aux = aux - (centavosCincuenta*50);
                    int centVeinte = (int)(aux / 20d);
                    aux = aux - (centVeinte*20);
                    int centDiez = (int)(aux/10d);





                    mostrar.setText("Billetes de $100: "+cien+"\nBilletes de $50: "+cincuenta+"\nBilletes de $20: "+veinte+"\nMonedas de $5: "+cinco
                    + "\nMonedas de $2: "+dos+"\nMonedas de $1: "+uno+"\nMonedas de 50c: "+centavosCincuenta+"\nMonedas de 20c: "+centVeinte+
                    "\nMonedas de 10c: "+centDiez);
                    mostrar.setVisibility(View.VISIBLE);

                }else{
                    mostrar.setText("Escribe una cantidad de dinero");
                    mostrar.setVisibility(View.VISIBLE);
                }

        }

    }
}
