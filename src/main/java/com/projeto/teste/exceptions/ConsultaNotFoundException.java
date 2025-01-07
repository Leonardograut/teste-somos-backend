package com.projeto.teste.exceptions;

public class ConsultaNotFoundException  extends  RuntimeException{

    public ConsultaNotFoundException(String msg){
        super(msg);
    }
}
