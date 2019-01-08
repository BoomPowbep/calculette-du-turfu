package com.amelielaurent38.digital.calculatrice.models;

public enum OperationType {
    ADDTION("+"),
    SOUSTRACTION("-"),
    MUTIPLICATION("*"),
    DIVISION("/"),
    UNKOWN("");

    private String value;

    //Constructeur
    OperationType(String value){
        this.value = value;
    }

    public String toString(){
        return value;
    }
}
