package com.example.demo.Entity.Enum;

public enum Status {
    LIVRE, OCUPADO

    ;
    public static Status valueOfIgnoreCase(String name) {
        for (Status status : values()) {
            if (status.name().equalsIgnoreCase(name)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Status não encontrado para: " + name);
    }

    private String code;

    private Status(String code){
        this.code = code;
    }

    Status() {

    }

    public String getCode() {
        return code;
    }
    public static Status valueOff(String code){
        for(Status st: Status.values()){
            if(st.getCode().equals(code)){
                return st;
            }
        }throw new IllegalArgumentException("Status não encontrado para,"+code);
    }

}