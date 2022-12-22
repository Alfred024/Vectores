package com.vectores.demo2;

public class Procedimientos {

    Vector vectorA;
    public Procedimientos(Vector vector) {
        vectorA = vector;
    }

    String getProcedimiento(Vector v2, Vector res, char operacion){
        String procedimiento = "(";

        //Suma, resta, multiplicación
        if(operacion == '-' || operacion == '+' || operacion == '·'){
            procedimiento+= "("+vectorA.i+"i"+operacion+v2.i+"i), (";
            procedimiento+= vectorA.j+"j "+operacion+ v2.j+"j), (";
            procedimiento+= vectorA.k+"k "+operacion+ v2.k+"k) = ";
            procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
        }

        //producto vectorial
        if(operacion == 'p'){
            int vuelta = 0;
            int espaciosIJK[] = new int[3];

            procedimiento+= "|";
            while (vuelta++ < 2){
                espaciosIJK[vuelta] = getSpaces(v2, vuelta);
                //Método para calcular la posición de en medio para ahí escirbir la i,j,k
            }procedimiento+= "|\n";

            vuelta = 0;
            procedimiento+= "|";
            while (vuelta++ < 2){
                espaciosIJK[vuelta] = getSpaces(v2, vuelta);
                //Método para calcular la posición de en medio para ahí escirbir la i,j,k
            }procedimiento+= "|\n";

            //Otro método para sacar la diferencia que hay entre los espacios que habrá vacíos y la longitud del número
            //para así poder colocarlo en la posición de en medio

            //Parte fácil
            operacion = '·';
            procedimiento+= "("+vectorA.j+operacion+v2.k+")-("+vectorA.k+operacion+v2.j+") = "+res.i+"i\n";
            procedimiento+= vectorA.i+operacion+v2.k+")-("+vectorA.k+operacion+v2.i+") = "+res.j+"j\n";
            procedimiento+= vectorA.i+operacion+v2.j+")-("+vectorA.j+operacion+v2.i+") = "+res.k+"k\n";
            procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
        }
        return procedimiento;
    }

    int getSpaces(Vector v2, int vuelta){
        int espacios = 0;

        if (vuelta == 0){
            if( (((vectorA.i)+"").length()) > (((v2.i)+"").length()) ){
                espacios = ((vectorA.i)+"").length();
            }else{
                espacios = ((v2.i)+"").length();
            }
        }
        if (vuelta == 1){
            if( (((vectorA.j)+"").length()) > (((v2.j)+"").length()) ){
                espacios = ((vectorA.j)+"").length();
            }else{
                espacios = ((v2.j)+"").length();
            }
        }
        if (vuelta == 2){
            if( (((vectorA.k)+"").length()) > (((v2.k)+"").length()) ){
                espacios = ((vectorA.k)+"").length();
            }else{
                espacios = ((v2.k)+"").length();
            }
        }
        return espacios;
    }

    int posicionElemento(int espaciosRequeridos){

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
            /*
             * 1. Calculamos el producto vectorial
             * 2. Calculamos la magnitud del producto
             * */
        }
        if(operacion == "d"){
            //ángulo entre vectores
            /*
             *
             * */
        }
        return procedimiento;
    }
}
