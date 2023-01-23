package com.vectores.demo2;

public class Vector {
    int i,j,k,size;
    int x=0,y=0;

    //Hacer una clase procedimientos que herede los atributos de la clase Vector para que pueda trabajar con ellos

    public Vector(int i, int j, int k) {
        this.i = i;
        this.j = j;
        this.k = k;
        size = 3;
    }

    //OPERACIONES MÉTODOS
    Vector sumaVectores(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = v2.i + Vector.this.i;
        res.j = v2.j + Vector.this.j;
        res.k = v2.k + Vector.this.k;
        return res;
    }

    Vector restaVectores(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = Vector.this.i - v2.i;
        res.j = Vector.this.j - v2.j;
        res.k = Vector.this.k - v2.k;
        return res;
    }

    //MUltiplicación o Producto escolar
    Vector multiVector(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = Vector.this.i * v2.i;
        res.j = Vector.this.j * v2.j;
        res.k = Vector.this.k * v2.k;
        return res;
    }

    Vector vectorCon2Puntos(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = v2.i - Vector.this.i;
        res.j = v2.j - Vector.this.j;
        res.k = v2.k - Vector.this.k;
        return res;
    }

    double proyeccionVectorAsobreB(Vector v2){
        Vector res = this.multiVector(v2);
        double prodEsc = res.i+res.j+res.k;
        double magnitudVec2 = v2.magnitudVector();
        double proyRes = prodEsc/magnitudVec2;
        return  redondeo2decimales(proyRes);
    }

    double magnitudVector(){
        Vector vector = new Vector(i,j,k);
        if(vector.size == 2){
            return Math.sqrt(Math.pow(vector.i,2) + Math.pow(vector.j,2));
        }else{
            return Math.sqrt(Math.pow(vector.i,2) + Math.pow(vector.j,2) + Math.pow(vector.k,2));
        }
    }

    double productoEscalar(Vector v2){
        return (this.i*v2.i)+(this.j*v2.j)+(this.k*v2.k);
    }

    Vector productoVectorial(Vector v2){
        Vector res = new Vector(0,0,0);
        res.i = (Vector.this.j*v2.k) - (Vector.this.k*v2.j);
        res.j = ((Vector.this.i*v2.k) - (Vector.this.k*v2.i))*-1;
        res.k = (Vector.this.i*v2.j) - (Vector.this.j*v2.i);
        return  res;
    }

    double areaEntreVectores(Vector v2, int idRadioButton){
        Vector vectorProducto = productoVectorial(v2);
        double areaVector = vectorProducto.magnitudVector();
        if(idRadioButton == 2131231226){
            return redondeo2decimales(areaVector/2);
        }else{
            return redondeo2decimales(areaVector);
        }
    }

    double anguloEntreVectores(Vector v2,int idRadioButton){
        Vector aux = Vector.this.multiVector(v2);
        double numerador = aux.i+aux.j+aux.k;
        double denominador = Vector.this.magnitudVector()*v2.magnitudVector();
        double res = (numerador/denominador);
        //(Math.acos(numerador/denominador))
        if(idRadioButton == 2131231226){
            return redondeo2decimales(res);
        }else{
            //Este resultado lo da mal
            return redondeo2decimales(Math.acos(res));
        }
    }

    String showRes(Vector vectorResultante){
        return "< "+vectorResultante.i+"i, "+vectorResultante.j+"j, "+vectorResultante.k+"k >";
    }
    double redondeo2decimales(double num){
        return Math.round(num*100.0)/100.0;
    }
}
