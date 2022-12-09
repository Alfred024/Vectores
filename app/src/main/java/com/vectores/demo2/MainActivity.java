package com.vectores.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText x,y,z,x2,y2,z2;
    private TextView resView;
    private RadioButton sumaRB, restaRB, multiRB, magnitudRB;
    

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        x = (EditText)findViewById(R.id.ejeX);
        y = (EditText)findViewById(R.id.ejeY);
        z = (EditText)findViewById(R.id.ejeZ);
        x2 = (EditText)findViewById(R.id.ejeX2);
        y2 = (EditText)findViewById(R.id.ejeY2);
        z2 = (EditText)findViewById(R.id.ejeZ2);

        sumaRB = (RadioButton)findViewById(R.id.suma);
        restaRB = (RadioButton)findViewById(R.id.resta);
        multiRB = (RadioButton)findViewById(R.id.multi);
        magnitudRB = (RadioButton)findViewById(R.id.magnitud);

        resView = (TextView)findViewById(R.id.txt_res);
    }

    Vector getVectorA(){
        String xA = x.getText().toString();
        String yA = y.getText().toString();
        String zA = z.getText().toString();

        int xNum = Integer.parseInt(xA);
        int yNum = Integer.parseInt(yA);
        int zNum = Integer.parseInt(zA);
        Vector vector = new Vector(xNum, yNum, zNum);
        return vector;
    }
    Vector getVectorB(){
        String xB = x2.getText().toString();
        String yB = y2.getText().toString();
        String zB = z2.getText().toString();

        int xNum = Integer.parseInt(xB);
        int yNum = Integer.parseInt(yB);
        int zNum = Integer.parseInt(zB);
        Vector vector = new Vector(xNum, yNum, zNum);
        return vector;
    }
    boolean vectorVacio(Vector vector){
        return vector.i == 0 && vector.j == 0 && vector.k == 0;
    }

    public void calcularButton(View view){
        Vector vector1 = getVectorA();
        Vector vector2 = getVectorB();
        if(sumaRB.isChecked() == true){
            suma(vector1, vector2);
        }
        if(restaRB.isChecked() == true){
            resta(vector1, vector2);
        }
        if(multiRB.isChecked() == true){
            multiplicaion(vector1, vector2);
        }
        if(magnitudRB.isChecked() == true){
            magnitudVector(vector1, vector2);
        }
    }

    public void suma(Vector v1, Vector v2){
        Vector resultante = v1.sumaVectores(v2);
        String resSuma = "< "+resultante.i+"i ,"+resultante.j+"j ,"+resultante.k+"k >";
        resView.setText(resSuma);
    }
    public void resta(Vector v1, Vector v2){
        Vector resultante = v1.restaVectores(v2);
        String resResta = "< "+resultante.i+"i ,"+resultante.j+"j ,"+resultante.k+"k >";
        resView.setText(resResta);
    }
    public void multiplicaion(Vector v1, Vector v2){
        String resMulti = v1.multiVector(v2)+"";
        resView.setText(resMulti);
    }
    public void magnitudVector(Vector v1, Vector v2){
        double magnitud=0;
        if(vectorVacio(v1) && !vectorVacio(v2)){
            magnitud = v2.magnitudVector();
        }
        if(vectorVacio(v2) && !vectorVacio(v1)){
            magnitud = v1.magnitudVector();
        }
        if(!vectorVacio(v1) && !vectorVacio(v2)){
            Vector vectorAB = v1.restaVectores(v2);
            magnitud = vectorAB.magnitudVector();
        }
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