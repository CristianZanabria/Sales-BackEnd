package com.zdevs.record;

import java.time.LocalDate;

public record ClientRecord(
        int id,
        String name,
        LocalDate birthDate,
        boolean status
) implements Repository {

    public static final String defaultName = "DUKE";

    public ClientRecord(LocalDate birthDate){
        this(1,"cris", birthDate,true);
    }

    public  String toUpperCaseName(){
        return name.toUpperCase();
    }
    public static  String toUpperCaseNameStatic(){
        return  "TEST";
    }

    @Override
    public void test() {
        System.out.println("TEST TEST");
    }


    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
