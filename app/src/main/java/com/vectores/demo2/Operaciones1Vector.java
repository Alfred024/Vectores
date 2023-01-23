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


public class Operaciones1Vector extends AppCompatActivity {
    private EditText x,y,z;
    private TextView resView, operationView;
    private Spinner spinner1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_operaciones1_vector);

        x = (EditText)findViewById(R.id.ejeA);
        y = (EditText)findViewById(R.id.ejeB);
        z = (EditText)findViewById(R.id.ejeC);

        resView = (TextView)findViewById(R.id.txt_resB);
        operationView = (TextView)findViewById(R.id.operationLabelB);

        spinner1 = (Spinner)findViewById(R.id.mainSpinnerB);
        String operaciones[] = {"Longitud vector", "Cosenos directores", "Multiplicación de vector por x"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_operaciones, operaciones);
        spinner1.setAdapter(adapter);
    }

    public void changeActivity(View view){
        String operacion = spinner1.getSelectedItem().toString();
        Intent nextActivity = new Intent(this, proceduresActivity.class);
        nextActivity.putExtra("key",getProcedimientoView(getVector(), operacion));
        startActivity(nextActivity);
    }

    Vector getVector(){
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

    boolean vectorVacio(EditText x, EditText y, EditText z){
        return x.getText().toString().isEmpty() && y.getText().toString().isEmpty() && z.getText().toString().isEmpty();
    }

    public void calcularButton(View view){
        Vector vector1 = getVector();
        String operacion = spinner1.getSelectedItem().toString();

        if(operacion.equals("Longitud vector")){
            operationView.setText("Longitud (módulo) de vector");
            magnitud(vector1);
        }
        if(operacion.equals("Cosenos directores")){
            operationView.setText("Cosenos directores");
            cosenosDirs(vector1);
        }
        if(operacion.equals("Multiplicación de vector por x")){
            operationView.setText("Multiplicación de vector por x");
            multiplicaion(vector1);
        }

    }

    public String getProcedimientoView(Vector v1, String operacion){
        Procedimientos objProcedimientos = new Procedimientos(v1);
        char signoOperacion = ' ', signoOperacion2;
        String procedimiento="", procedimiento2="";
        Vector res = null;

        double resUnidad;
        if(operacion.equals("Longitud vector")){
            signoOperacion = '*';
            //res = v1.sumaVectores(v2);
        }
        if(operacion.equals("Cosenos directores")){
            signoOperacion = '-';
            //res = v1.restaVectores(v2);
        }
        if(operacion.equals("Multiplicación de vector por x")){
            signoOperacion = '·';
            //res = v1.multiVector(v2);
        }
        procedimiento = objProcedimientos.getProcedimiento(v1, signoOperacion)+procedimiento2;
        return procedimiento;
    }

    public void magnitud(Vector v1){
        double resultante = v1.magnitudVector();
        //String resSuma = v1.showRes(resultante);
        resView.setText(resultante+"");
    }
    public void cosenosDirs(Vector v1){
        /*Vector resultante = v1.restaVectores(v2);
        String resResta = v1.showRes(resultante);
        resView.setText(resResta);*/
    }
    public void multiplicaion(Vector v1){
        /*Vector resultante = v1.multiVector(v2);
        String resMulti = "";
        resView.setText(resMulti);*/
    }
}
