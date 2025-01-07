package com.projeto.teste.exceptions;

public class MedicoNotFoundException extends  RuntimeException{

    public MedicoNotFoundException(String msg) {
        super(msg);
    }

}
