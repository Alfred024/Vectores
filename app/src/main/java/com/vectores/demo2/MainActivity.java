package com.vectores.demo2;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText x,y,z;
    private TextView resView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = (EditText)findViewById(R.id.ejeX);
        y = (EditText)findViewById(R.id.ejeY);
        z = (EditText)findViewById(R.id.ejeZ);

        resView = (TextView)findViewById(R.id.txt_res);
    }

    /*El método está creado, pero es necesario indicarle que se ejecute*/
    public void magnitudVector(View view){
        String x1 = x.getText().toString();
        String y1 = y.getText().toString();
        String z1 = z.getText().toString();

        int xNum = Integer.parseInt(x1);
        int yNum = Integer.parseInt(y1);
        int zNum = Integer.parseInt(z1);

        Vector v1 = new Vector(xNum, yNum, zNum);
        double magnitud = v1.determinanteVector(v1);
        String resText = magnitud+"";
        resView.setText(resText);
    }

}


/*
* Toast: Notificación emergente que aparecerá en la pantalla/activity
* que se está ejecutando sin bloquear las funciones de la app, por lo que
* la pantalla que se está ejecutando permanecerá activa.
*
* El Toast no acepta interacción, por lo que al tocarlo no sucederá
* nada.
*
* Estructura de un Toast para generar notificación emergente:
*   (Context contexto, String mensaje, int duración).show();
* el contexto hace referencia a la clase donde se mostrará el
* activity
* */

//Métodos que se ejecutan al momento de crear una app
/*
@Override
    Método que crea la actividad a ejecutar (viene por default)
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
}
    Toast: Enseña un mensaje mediante una capa

    Existe un método intermedio "onRestart" el cual ejecutará la aplicación pausada ("onPause")

    @Override
    Iniciará aquella actividad que creó el método onCr eate
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_SHORT).show();
        // La actividad está a punto de hacerse visible.
    }

    @Override
    Permitirá visualizar el activity
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "OnResume", Toast.LENGTH_SHORT).show();
        // La actividad se ha vuelto visible (ahora se "reanuda").
    }

    //Hasta este pnuto, el actuvity se está ejecutando

    @Override
    Se ejecuta cuando se pasa el activity a segundo plano, como cuando sales de la app
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "OnPause", Toast.LENGTH_SHORT).show();
        // Enfocarse en otra actividad  (esta actividad est� a punto de ser "detenida").
    }

    @Override
    //Oculatará el activity
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "OnStop", Toast.LENGTH_SHORT).show();
        // La actividad ya no es visible (ahora est� "detenida")
    }

    @Override
    //Se ejecuta cuando la app se cierra
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "OnDestroy", Toast.LENGTH_SHORT).show();
        // La actividad est� a punto de ser destruida.
    }
*/