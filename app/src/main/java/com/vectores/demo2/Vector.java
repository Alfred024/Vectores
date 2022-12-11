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

    public Vector(int i, int j) {
        this.i = i;
        this.j = j;
        size = 2;
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

    double multiVector(Vector v2){
        Vector res = new Vector(0,0,0);
        double resProductoVectores;
        res.i = Vector.this.i * v2.i;
        res.j = Vector.this.j * v2.j;
        res.k = Vector.this.k * v2.k;

        resProductoVectores = res.i + res.j + res.k;
        return resProductoVectores;
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
    /*void determinanteVector(Vector vector, int numDecimales){
        String res="";
        double resNum;
        if(vector.size == 2){
            resNum = Math.pow(vector.i,2) + Math.pow(vector.j,2);
        }else{
            resNum = Math.pow(vector.i,2) + Math.pow(vector.j,2)+ Math.pow(vector.k,2);
        }

        if(tieneDecimales(resNum)){
            resNum = Math.sqrt(resNum);
            res= (int)resNum+"";
        }else{
            res= "√"+((int)resNum)+"";
        }
        System.out.println("Determinante: "+res);
    }*/

    //Si tiene más de 4 ceros a partir del punto decimal, consideraremos como que no tiene decimales
    boolean tieneDecimales(double num){
        int index=0;
        String numCadena = num+"";
        do{
            index++;
        }while(numCadena.charAt(index) != '.');
        index++;

        return numCadena.length()-index != 1;
    }

    void showRes(Vector vectorResultante){
        System.out.println("<"+vectorResultante.i+","+vectorResultante.j+","+vectorResultante.k+">");
    }
}
