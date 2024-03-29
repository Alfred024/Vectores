package com.vectores.demo2;

public class Procedimientos {
    Vector vectorA; //El vector A representa nuestro vector inicial (v1/vA)


    public Procedimientos(Vector vector) {
        vectorA = vector;
    }

    //Procedimientos para operaciones con 1 vector
    String getProcedimiento(Vector res, char operacion){
        String procedimiento = "";
        //Suma, resta, multiplicaión
        if(operacion == '*'){
            procedimiento+= procedimeintoMagnitudVector(vectorA,  "A");
        }


        return procedimiento;
    }

    //Procedimientos para operaciones con 2 vectores
    String getProcedimiento(Vector v2, Vector res, char operacion){
        String procedimiento = "";
        //Suma, resta, multiplicaión
        if(operacion == '-' || operacion == '+' || operacion == '·'){
            procedimiento+= procedimientoSRM(v2, res, operacion);
        }
        //Producto vectorial
        if(operacion == 'p'){
            procedimiento+= procedimeintoProductoVec(v2, res, operacion);
        }
        //Magnitud entre vectores
        if(operacion == 'm'){
            procedimiento+= procedimeintoMagnitudVecs(v2, res, operacion);
        }
        //Vector entre 2 puntos
        if(operacion == '2'){
            procedimiento+= procedimientoEntre2Puntos(v2, res, operacion);
        }
        if(operacion == '>'){
            procedimiento += "1.-Producto escalar\n";
            procedimiento+= procedimientoSRM(v2, res, '·');
            String numerador =  procedimientoPE(res)+"\n";
            procedimiento+= procedimientoPE(res)+"\n\n";
            procedimiento+= "2.-Módulo de vectores\n";
            procedimiento+=procedimeintoMagnitudVector(v2, "B")+"\n\n";
            String denominador = denominadorAoB(v2);
            procedimiento+= "Proj>BA = "+numerador+"/"+denominador;
            procedimiento+=" = "+vectorA.proyeccionVectorAsobreB(v2)+"";
        }
        //Área del paralelogramo formado entre 2 vectores
        if(operacion == 'A' || operacion == 'a'){
            //a = área de un parelelogramo, A = área de un triángulo
            procedimiento += procedimientoAreaVectores(v2, res, operacion);
        }
        //Ángulo entre vectores
        if(operacion == 'd'){
            procedimiento += procedimientoAnguloEntreVectores(v2, res, operacion);
        }

        return procedimiento;
    }

    //Obtener procedimientos
    //Suma, Resta y Multiplicación
    String procedimientoSRM(Vector v2, Vector res, char operacion){
        String procedimiento="";
        procedimiento+= "("+vectorA.i+"i"+operacion+v2.i+"i), (";
        procedimiento+= vectorA.j+"j "+operacion+ v2.j+"j), (";
        procedimiento+= vectorA.k+"k "+operacion+ v2.k+"k) = ";
        procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
        return procedimiento;
    }

    //Producto Escalar (Uno para el procedimeinto completo, otro para el resultado)
    String procedimientoPE(Vector v2, Vector res, char operacion){
        String procedimiento="";
        procedimiento+= "("+vectorA.i+operacion+v2.i+")+";
        procedimiento+= "("+vectorA.j+operacion+v2.j+")+";
        procedimiento+= "("+vectorA.k+operacion+v2.k+") = ";
        procedimiento+= res.i+"+"+res.j+"+"+res.k+" = ";
        return procedimiento;
    }
    String procedimientoPE(Vector res){
        return (res.i+res.j+res.k)+"";
    }

    //Producto vectorial
    String procedimeintoProductoVec(Vector v2, Vector res, char operacion){
        String procedimiento="";
        //Representa la matriz creada con los componentes i,j,k + los 2 vectores
        String componentes[][] =
                {{"i", "j", "k"},
                        {vectorA.i+"", vectorA.j+"", vectorA.k+""},
                        {v2.i+"", v2.j+"", v2.k+""}};
        int espaciosIJK[] = new int[3];
        int espacios;

        //Calcula el componente más largo de cada columna (i,j,k)
        for (int i = 0; i < espaciosIJK.length; i++) {
            espaciosIJK[i] = mayorLongComponenteActual(v2, i);
        }

        //Explora cada componente de la matriz para anexarlos al procedimiento final
        for (int f = 0; f < 3; f++) {
            procedimiento+= "|";
            for (int c = 0; c < 3; c++) {
                espacios = espacioLaterales(espaciosIJK[c], (componentes[f][c]).length());
                for (int i = 0; i < espacios; i++) {
                    procedimiento+=" ";
                }
                procedimiento+=componentes[f][c];
                for (int i = 0; i < espacios; i++) {
                    procedimiento+=" ";
                }
            }procedimiento+= "|\n";
        }

        procedimiento+= "("+vectorA.j+'·'+v2.k+")-("+vectorA.k+'·'+v2.j+") = "+res.i+"i\n";
        procedimiento+= "("+vectorA.i+'·'+v2.k+")-("+vectorA.k+'·'+v2.i+") = "+res.j+"j\n";
        procedimiento+= "("+vectorA.i+'·'+v2.j+")-("+vectorA.j+'·'+v2.i+") = "+res.k+"k\n";
        procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
        return procedimiento;
    }
    int mayorLongComponenteActual(Vector v2, int vuelta){
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
    int espacioLaterales(int numMasLargo_tam, int numActual_tam){
        int espaciosLaterales = (numMasLargo_tam - numActual_tam)/2;
        return espaciosLaterales+1;
    }

    //Magnitud vectorial
    /*
    * (El primero es para la magnitud de 2 vectores, el segundo es para la magnitud de uno solo)
    * El tercero es para los resultados individuales de la operación
    * */
    String procedimeintoMagnitudVecs(Vector v2, Vector res, char operacion){
        String procedimiento="";
        procedimiento+= "√("+ res.i + "²" + " + " + res.j + "²" + " + " + res.k + "²" +")\n";
        procedimiento+="Magnitud: " +res.magnitudVector()+"";
        return procedimiento;
    }
    String procedimeintoMagnitudVector(Vector vectorX, String vectorAoB){
        String procedimiento= "|"+vectorAoB+"|= ";
        procedimiento+= "√("+ vectorX.i + "²" + " + " + vectorX.j + "²" + " + " + vectorX.k + "²" +")";
        procedimiento+="= "+redondeo2decimales(vectorX.magnitudVector())+"";
        return procedimiento;
    }
    String denominadorAoB(Vector vectorX){
        return redondeo2decimales(vectorX.magnitudVector())+"";
    }

    //Vector entre 2 puntos
    String procedimientoEntre2Puntos(Vector v2, Vector res, char operacion){
        String procedimiento="";
        procedimiento+= "("+v2.i+"i - "+vectorA.i+"i), (";
        procedimiento+= v2.j+"j - "+ vectorA.j+"j), (";
        procedimiento+= v2.k+"k - "+vectorA.k+"k) = ";
        procedimiento+="<"+res.i+"i ,"+res.j+"j ,"+res.k+"k >\n";
        return procedimiento;
    }

    //Área de paralelogramo dado 2 vectores
    String procedimientoAreaVectores(Vector v2, Vector res, char operacion){
        String procedimiento = "";
        procedimiento += "1.-Producto vectorial\n";
        procedimiento+= procedimeintoProductoVec(v2, res, operacion)+"\n\n";
        procedimiento += "2.-Módulo de vectores\n"+procedimeintoMagnitudVector(res, "ab")+"\n\n";
        if(operacion == 'A'){
            procedimiento += "3.-Área = 1/2 * ";
        }else{
            procedimiento += "3.-Área = ";
        }
        return procedimiento;
    }

    //Ángulo entre vectores
    String procedimientoAnguloEntreVectores(Vector v2, Vector res, char operacion){
        String procedimiento = "";
        procedimiento += "1.-Producto escalar\n";
        String procNumerador =  procedimientoPE(v2, res, '*');
        String numerador =  procedimientoPE(res)+"\n";

        String procDenominador = "2.-Módulo de vectores\n"+procedimeintoMagnitudVector(vectorA, "a")+"\n";
        procDenominador += procedimeintoMagnitudVector(v2, "b");
        String denominador = "("+denominadorAoB(vectorA)+"*"+denominadorAoB(v2)+")";

        procedimiento += procNumerador+numerador+"\n";
        procedimiento += procDenominador;
        procedimiento += "\n\n3.-Ángulo entre vectores\n";
        procedimiento += "cos α = "+numerador+"/"+denominador;
        return procedimiento;
    }
    double redondeo2decimales(double num){
        return Math.round(num*100.0)/100.0;
    }
}
