package com.scasc.clase02;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //variables
    private EditText etNumero;
    private int numero;
    private String cadena;
    Toast notificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        //Instrucciones
        etNumero=findViewById(R.id.etNumero);
        numero= (int) (Math.random()*100000);
        cadena=String.valueOf(numero);
        notificacion=Toast.makeText(this,cadena, Toast.LENGTH_LONG);
        notificacion.show();
    }

    public void verificar(View vista){
        if(etNumero.getText().toString().equals(String.valueOf(numero))){
            notificacion=Toast.makeText(this,"Acertaste el numero", Toast.LENGTH_LONG);
        }else{
            notificacion=Toast.makeText(this,"Numero equivocado", Toast.LENGTH_LONG);
        }
        notificacion.show();
        System.out.println(vista.toString());
    }
}