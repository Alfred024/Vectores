package com.vectores.demo2;

public class Vector {
    int i,j,k,size;
    int x=0,y=0;

    /*Y si en lugar de hacer que cada componente del vector lo obtenga de un output, hacemos que el vector sea declarado en una
    * sola línea, con un String, y se vayan escogiendo los componentes de uno a uno*/

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

    /*EL de resta no puede ser el mismo que el de suma porque cambia el orden en que se resta*/
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
    /*boolean tieneDecimales(double num){
        int index=0;
        String numCadena = num+"";
        do{
            index++;
        }while(numCadena.charAt(index) != '.');
        index++;

        return numCadena.length()-index != 1;
    }*/

    String showRes(Vector vectorResultante){
        return "< "+vectorResultante.i+"i, "+vectorResultante.j+"j, "+vectorResultante.k+"k >";
    }
}
