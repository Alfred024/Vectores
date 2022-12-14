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

    /*Podemos hacer una clase procedimientos pra trabajar estos individualemnte de las operaciones*/
    String getProcedimiento(Vector v2, Vector res, String operacion){
        String procedimiento = "(";
        procedimiento+= Vector.this.i+"i"+operacion+v2.i+"i), (";
        procedimiento+= Vector.this.j+"j "+operacion+ v2.j+"j), (";
        procedimiento+= Vector.this.k+"k "+operacion+ v2.k+"k) = ";
        procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >";
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
        if(idRadioButton == 2131231227){
            return res;
        }else{
            return res*57.3;
        }

    }

    String showRes(Vector vectorResultante){
        return "< "+vectorResultante.i+"i, "+vectorResultante.j+"j, "+vectorResultante.k+"k >";
    }
}
