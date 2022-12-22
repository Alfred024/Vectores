package com.vectores.demo2;

public class Vector {
    int i,j,k,size;
    int x=0,y=0;

    public Vector(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
        size = 3;
    }

    /*Procedimientos que devuelven un vector*/
    //(Producto vectorial)
    String getProcedimiento(Vector v2, Vector res, char operacion){
        String procedimiento = "(";

        if(operacion == '-' || operacion == '+' || operacion == '·'){
            procedimiento+= "("+Vector.this.i+"i"+operacion+v2.i+"i), (";
            procedimiento+= Vector.this.j+"j "+operacion+ v2.j+"j), (";
            procedimiento+= Vector.this.k+"k "+operacion+ v2.k+"k) = ";
            procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
        }
        //producto vectorial
        if(operacion == 'p'){
            int vuelta = 0;
            while (++vuelta < 3){

            }

            operacion = '·';
            procedimiento+= "("+Vector.this.j+operacion+v2.k+")-("+Vector.this.k+operacion+v2.j+") = "+res.i+"i\n";
            procedimiento+= Vector.this.i+operacion+v2.k+")-("+Vector.this.k+operacion+v2.i+") = "+res.j+"j\n";
            procedimiento+= Vector.this.i+operacion+v2.j+")-("+Vector.this.j+operacion+v2.i+") = "+res.k+"k\n";
            procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
            //Método para calcular el tamaño del número más grande (de la clomuna actual)
            //Método para agregar los tamaños que haga falta para completar la longitud de
        }
        return procedimiento;
    }

    int getSpaces(Vector v2, int vuelta){
        int espacios;

        if( (((Vector.this.i)+"").length()) > (((v2.i)+"").length()) ){
            espacios = ((Vector.this.i)+"").length();
        }else{
            espacios = ((v2.i)+"").length();
        }
        return 0;
    }


    /*Procedimientos que devuelven un double*/
    //(Área sobre vectores, Ángulo sobre vectores)
    String getProcedimiento(Vector res, String operacion){
        String procedimiento = "(";
        if(operacion == "m" ){
            procedimiento+= "√("+ res.i + "²" + " + " + res.j + "²" + " + " + res.k + "²" +")\n";
            procedimiento+="Magnitud: " +res.magnitudVector()+"";
        }
        if(operacion == "a"){
            //área  entre vectores
        }
        if(operacion == "d"){
            //ángulo entre vectores
        }
        return procedimiento;
    }

    Vector sumaVectores(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = v2.i + Vector.this.i;
        res.j = v2.j + Vector.this.j;
        res.k = v2.k + Vector.this.k;
        return res;
    }

    //El orden de los vectores sí afecta el resultado final
    Vector restaVectores(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = Vector.this.i - v2.i;
        res.j = Vector.this.j - v2.j;
        res.k = Vector.this.k - v2.k;
        return res;
    }

    Vector multiVector(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = Vector.this.i * v2.i;
        res.j = Vector.this.j * v2.j;
        res.k = Vector.this.k * v2.k;

        return res;
    }

    double magnitudVector(){
        Vector vector = new Vector(i,j,k);
        if(vector.size == 2){
            return Math.sqrt(Math.pow(vector.i,2) + Math.pow(vector.j,2));
        }else{
            return Math.sqrt(Math.pow(vector.i,2) + Math.pow(vector.j,2) + Math.pow(vector.k,2));
        }
    }

    Vector productoVectorial(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = (Vector.this.j*v2.k) - (Vector.this.k*v2.j);
        res.j = (Vector.this.i*v2.k) - (Vector.this.k*v2.i);
        res.k = (Vector.this.i*v2.j) - (Vector.this.j*v2.i);
        return  res;
    }

    double areaParalelogramo(Vector v2){
        Vector vectorProducto = productoVectorial(v2);
        double areaVector = vectorProducto.magnitudVector();
        return areaVector;
    }

    double anguloEntreVectores(Vector v2,int idRadioButton){
        Vector aux = Vector.this.multiVector(v2);
        double numerador = aux.i+aux.j+aux.k;
        double denominador = Vector.this.magnitudVector()*v2.magnitudVector();
        System.out.println("Num: "+numerador);
        System.out.println("Den: "+denominador);
        double res = (Math.acos(numerador/denominador));
        if(idRadioButton == 2131231226){
            return res;
        }else{
            return res*57.3;
        }

    }

    String showRes(Vector vectorResultante){
        return "< "+vectorResultante.i+"i, "+vectorResultante.j+"j, "+vectorResultante.k+"k >";
    }
}
