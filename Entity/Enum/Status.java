package com.example.demo.Entity.Enum;

public enum Status {
    Livre(1),
    Ocupado(2);

    private int code;

    private Status(int code){
        this.code = code;
    }

    public int getCode() {
        return code;
    }
    public static Status valueOff(int code){
        for(Status st: Status.values()){
            if(st.getCode() == code){
                return st;
            }
        }throw new IllegalArgumentException("Status não encontrado para,"+code);
    }
}