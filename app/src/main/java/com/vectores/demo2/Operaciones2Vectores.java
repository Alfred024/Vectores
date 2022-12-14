package com.vectores.demo2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Operaciones2Vectores extends AppCompatActivity {
    private EditText x,y,z,x2,y2,z2;
    private TextView resView, operationView;
    private Spinner spinner1;
    private RadioButton brRadianes, brGrados;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones2_vectores);

        brRadianes = (RadioButton) findViewById(R.id.buttonRadianes);
        brRadianes.setVisibility(View.INVISIBLE);
        brGrados = (RadioButton) findViewById(R.id.buttonGrados);
        brGrados.setVisibility(View.INVISIBLE);

        x = (EditText)findViewById(R.id.ejeX);
        y = (EditText)findViewById(R.id.ejeY);
        z = (EditText)findViewById(R.id.ejeZ);
        x2 = (EditText)findViewById(R.id.ejeX2);
        y2 = (EditText)findViewById(R.id.ejeY2);
        z2 = (EditText)findViewById(R.id.ejeZ2);

        resView = (TextView)findViewById(R.id.txt_res);
        operationView = (TextView)findViewById(R.id.operationLabel);

        spinner1 = (Spinner)findViewById(R.id.mainSpinner);
        String operaciones[] = {"Suma", "Resta", "Multiplicación",
                "Magnitud","Producto vectorial","Área sobre vectores","Ángulo entre vectores"};
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
        if(xA.isEmpty()){ xA = "0";}
        String yA = y.getText().toString();
        if(yA.isEmpty()){ yA = "0";}
        String zA = z.getText().toString();
        if(zA.isEmpty()){ zA = "0";}

        int xNum = Integer.parseInt(xA);
        int yNum = Integer.parseInt(yA);
        int zNum = Integer.parseInt(zA);
        Vector vector = new Vector(xNum, yNum, zNum);
        return vector;
    }
    Vector getVectorB(){
        String xB = x2.getText().toString();
        if(xB.isEmpty()){ xB = "0";}
        String yB = y2.getText().toString();
        if(yB.isEmpty()){ yB = "0";}
        String zB = z2.getText().toString();
        if(zB.isEmpty()){ zB = "0";}

        int xNum = Integer.parseInt(xB);
        int yNum = Integer.parseInt(yB);
        int zNum = Integer.parseInt(zB);
        Vector vector = new Vector(xNum, yNum, zNum);
        return vector;
    }
    boolean vectorVacio(EditText x, EditText y, EditText z){
        return x.getText().toString().isEmpty() && y.getText().toString().isEmpty() && z.getText().toString().isEmpty();
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
            magnitud(vector1, vector2);
        }
        if(operacion.equals("Producto vectorial")){
            operationView.setText("Producto vectorial A*B");
            productoVectorial(vector1, vector2);
        }
        if(operacion.equals("Área sobre vectores")){
            operationView.setText("Área sobre vectores A B");
            areaEntreVectores(vector1, vector2);
        }

        if(operacion.equals("Ángulo entre vectores")){
            operationView.setText("Ángulo entre vectores A B");
            brGrados.setVisibility(View.VISIBLE);
            brRadianes.setVisibility(View.VISIBLE);
            if(brGrados.isChecked()){
                anguloEntreVectores(vector1,vector2,brGrados.toString());
            }
            if(brRadianes.isChecked()){
                anguloEntreVectores(vector1,vector2,brRadianes.toString());
            }
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
        if(operacion.equals("Magnitud")){

        }
        if(operacion.equals("Producto vectorial")){

        }
        if(operacion.equals("Área sobre vectores A B")){

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
    public void magnitud(Vector v1, Vector v2){
        double magnitud=0;
        /*if(vectorVacio(x,y,z) && !vectorVacio(x2,y2,z2)){
            magnitud = v2.magnitudVector();
        }
        if(!vectorVacio(x,y,z) && vectorVacio(x2,y2,z2)){
            magnitud = v1.magnitudVector();
        }*/
        if(!vectorVacio(x,y,z) && !vectorVacio(x2,y2,z2)){
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
    public void anguloEntreVectores(Vector v1, Vector v2, String ope){
        double angulo = v1.anguloEntreVectores(v2, ope);
        String resText = angulo+"";
        resView.setText(resText);
    }
}