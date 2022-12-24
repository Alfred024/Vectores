package com.vectores.demo2;

public class Procedimientos {
    Vector vectorA;

    public Procedimientos(Vector vector) {
        vectorA = vector;
    }

    String getProcedimiento(Vector v2, Vector res, char operacion){
        String procedimiento = "";

        //Suma, resta, multiplicaión
        if(operacion == '-' || operacion == '+' || operacion == '·'){
            procedimiento+= "("+vectorA.i+"i"+operacion+v2.i+"i), (";
            procedimiento+= vectorA.j+"j "+operacion+ v2.j+"j), (";
            procedimiento+= vectorA.k+"k "+operacion+ v2.k+"k) = ";
            procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
        }

        //Producto vectorial
        if(operacion == 'p'){

            String componentes[][] =
                    {{"i", "j", "k"},
                            {vectorA.i+"", vectorA.j+"", vectorA.k+""},
                            {v2.i+"", v2.j+"", v2.k+""}};
            int espaciosIJK[] = new int[3];


            for (int f = 0; f < espaciosIJK.length; f++) {
                procedimiento+= "|";
                for (int c = 0; c < espaciosIJK.length; c++) {
                    espaciosIJK[c] = getSpaces(v2, c);
                    for (int i = 0; i < getSpacesLateral(espaciosIJK[c], 1); i++) {
                        procedimiento+=" ";
                    }
                    procedimiento+=componentes[f][c];
                    //Espacios lado derecho
                    for (int i = 0; i < getSpacesLateral(espaciosIJK[c], 1); i++) {
                        procedimiento+=" ";
                    }
                }procedimiento+= "|\n";
            }

            operacion = '·';
            procedimiento+= "("+vectorA.j+operacion+v2.k+")-("+vectorA.k+operacion+v2.j+") = "+res.i+"i\n";
            procedimiento+= "("+vectorA.i+operacion+v2.k+")-("+vectorA.k+operacion+v2.i+") = "+res.j+"j\n";
            procedimiento+= "("+vectorA.i+operacion+v2.j+")-("+vectorA.j+operacion+v2.i+") = "+res.k+"k\n";
            procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
        }
        return procedimiento;
    }

    //Obtener el número con el mayor número de chars
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

    //No es un índice el que debemos calcular, más bien es un número de espacios que debemos de dejar al costado de cada nuevo elemento
    int getSpacesLateral(int numMasLargo_tam, int numActual_tam){
        int espaciosLaterales = (numMasLargo_tam - numActual_tam)/2;
        return espaciosLaterales+1;
    }


    /*Procedimientos que devuelven un double*/
    //(Área sobre vectores, Ángulo sobre vectores)
    String getProcedimiento(Vector res, String operacion){
        String procedimiento = "";
        if("m".equals(operacion) ){
            procedimiento+= "√("+ res.i + "²" + " + " + res.j + "²" + " + " + res.k + "²" +")\n";
            procedimiento+="Magnitud: " +res.magnitudVector()+"";
        }
        if("a".equals(operacion)){
            //área  entre vectores
            /*
             * 1. Calculamos el producto vectorial
             * 2. Calculamos la magnitud del producto
             * */
        }
        if("d".equals(operacion)){
            //ángulo entre vectores
            /*
             *
             * */
        }
        return procedimiento;
    }



}
