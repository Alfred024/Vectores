package com.vectores.demo2;

public class Procedimientos {
    Vector vectorA;


    public Procedimientos(Vector vector) {
        vectorA = vector;
    }

    String getProcedimientoA(Vector v2, Vector res, char operacion){
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
            int espaciosLateral;

            for (int i = 0; i < espaciosIJK.length; i++) {
                espaciosIJK[i] = getSpaces(v2, i); //Calcula el elemento más largo de la columna de componentes actual
            }

            for (int f = 0; f < 3; f++) {
                procedimiento+= "|";
                for (int c = 0; c < 3; c++) {
                    espaciosLateral = getSpacesLateral(espaciosIJK[c], (componentes[f][c]).length());
                    for (int i = 0; i < espaciosLateral; i++) {
                        procedimiento+=" ";
                    }
                    procedimiento+=componentes[f][c];
                    for (int i = 0; i < espaciosLateral; i++) {
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
    String getProcedimientoB(Vector v2, Vector res, char operacion){
        String procedimiento = "";
        if(operacion == 'm'){
            procedimiento+= "√("+ res.i + "²" + " + " + res.j + "²" + " + " + res.k + "²" +")\n";
            procedimiento+="Magnitud: " +res.magnitudVector()+"";
        }
        if(operacion == 'a'){
            //área de un paralelogramo entre vectores
            procedimiento += this.getProcedimientoA(v2, res, operacion)+"\n";
            operacion = 'm';
            procedimiento += this.getProcedimientoB(v2, res, operacion);
        }
        if(operacion == 'd'){
            //ángulo entre vectores
            /*
             *
             * */
        }
        return procedimiento;
    }



}
