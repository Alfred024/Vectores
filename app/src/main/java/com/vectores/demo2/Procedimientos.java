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
        //Área del paralelogramo formado entre 2 vectores
        if(operacion == 'a'){
            //área de un paralelogramo entre vectores, para calcular el área de un triángulo se divide entre 2
            procedimiento += this.getProcedimiento(v2, res, operacion)+"\n";
            operacion = 'm';
            procedimiento += this.getProcedimiento(v2, res, operacion);
        }
        if(operacion == 'd'){
            //ángulo entre vectores
            /*
             *
             * */
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
    String procedimeintoMagnitudVecs(Vector v2, Vector res, char operacion){
        String procedimiento="";
        procedimiento+= "√("+ res.i + "²" + " + " + res.j + "²" + " + " + res.k + "²" +")\n";
        procedimiento+="Magnitud: " +res.magnitudVector()+"";
        return procedimiento;
    }

    //Área de paralelogramo dado 2 vectores
    String procedimientoAreaVectores(Vector v2, Vector res, char operacion){
        String procedimiento = "";

        return procedimiento;
    }

}
