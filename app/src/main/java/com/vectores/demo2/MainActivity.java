package com.vectores.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText x,y,z,x2,y2,z2;
    private TextView resView, operationView;
    private Spinner spinner1;

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

        resView = (TextView)findViewById(R.id.txt_res);
        operationView = (TextView)findViewById(R.id.operationLabel);

        spinner1 = (Spinner)findViewById(R.id.mainSpinner);
        String operaciones[] = {"Suma", "Resta", "Multiplicación", "Magnitud","Producto vectorial","Área sobre vectores A B"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_operaciones, operaciones);
        spinner1.setAdapter(adapter);
    }

    public void changeActivity(View view){
        String operacion = spinner1.getSelectedItem().toString();
        Intent nextActivity = new Intent(this, proceduresActivity.class);
        nextActivity.putExtra("key",getProcedimientoView(getVectorA(), getVectorB(), operacion));
        startActivity(nextActivity);
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
        String operacion = spinner1.getSelectedItem().toString();

        if(operacion.equals("Suma")){
            operationView.setText("Suma de vectores A+B");
            suma(vector1, vector2);
        }
        if(operacion.equals("Resta")){
            operationView.setText("Resta de vectores A-B");
            resta(vector1, vector2);
        }
        if(operacion.equals("Multiplicación")){
            operationView.setText("Multiplicación de vectores A*B");
            multiplicaion(vector1, vector2);
        }
        if(operacion.equals("Magnitud")){
            operationView.setText("Magnitud de vector AB");
            magnitudVector(vector1, vector2);
        }
        if(operacion.equals("Producto vectorial")){
            operationView.setText("Producto vectorial A*B");
            productoVectorial(vector1, vector2);
        }
        if(operacion.equals("Área sobre vectores A B")){
            operationView.setText("Área sobre vectores A B");
            areaEntreVectores(vector1, vector2);
        }

    }

    public String getProcedimientoView(Vector v1, Vector v2, String operacion){
        String signoOperacion="";
        Vector res = null;
        if(operacion.equals("Suma")){
            signoOperacion = "+";
            res = v1.sumaVectores(v2);
        }
        if(operacion.equals("Resta")){
            signoOperacion = "-";
            res = v1.restaVectores(v2);
        }
        if(operacion.equals("Multiplicación")){
            signoOperacion = "·";
            res = v1.multiVector(v2);
        }

        String procedimiento = v1.getProcedimiento(v2, res, signoOperacion);
        return procedimiento;
    }

    /*Métodos operacioes*/
    public void suma(Vector v1, Vector v2){
        Vector resultante = v1.sumaVectores(v2);
        String resSuma = v1.showRes(resultante);
        resView.setText(resSuma);
    }
    public void resta(Vector v1, Vector v2){
        Vector resultante = v1.restaVectores(v2);
        String resResta = v1.showRes(resultante);
        resView.setText(resResta);
    }
    public void multiplicaion(Vector v1, Vector v2){
        Vector resultante = v1.multiVector(v2);
        String resMulti = (resultante.i+resultante.j+resultante.k)+"";
        resView.setText(resMulti);
    }
    public void magnitudVector(Vector v1, Vector v2){
        double magnitud=0;
        /*if(vectorVacio(v1) && !vectorVacio(v2)){
            magnitud = v2.magnitudVector();
        }
        if(vectorVacio(v2) && !vectorVacio(v1)){
            magnitud = v1.magnitudVector();
        }*/
        if(!vectorVacio(v1) && !vectorVacio(v2)){
            Vector vectorAB = v1.restaVectores(v2);
            magnitud = vectorAB.magnitudVector();
        }
        String resText = magnitud+"";
        resView.setText(resText);
    }
    public void productoVectorial(Vector v1, Vector v2){
        Vector resultante = v1.productoVectorial(v2);
        String resResta = v1.showRes(resultante);
        resView.setText(resResta);
    }
    public void areaEntreVectores(Vector v1, Vector v2){
        double area = 0;
        area = v1.areaParalelogramo(v2);
        String resText = area+"";
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