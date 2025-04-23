package com.zdevs.switchpatters;

public class Program {

    public  void m1Basic(String param){
        switch (param){
            case "A":
                System.out.println("Case A");
                break;
            case "B":
                System.out.println("Case B");
                break;
            case "C":
                System.out.println("Case C");
                break;
        }
    }
    public  void m2Basic(String param){
        switch (param){
            case "A" -> System.out.println("Case A");
            case "B" ->System.out.println("Case B");
            case "C" -> System.out.println("Case C");
            default -> System.out.println("Default Case");
        }
    }
    public  String  m3Basic(String param){
       return  switch (param){
           case "A":
               yield "Case A";
           case "B":
               yield "Case B";
           default :
               yield ("Default Case");
        };
    }
    public  String m4Basic(String param){
        return switch (param){
            case "A" -> "Case A";
            case "B" ->"Case B";
            case "C" -> {
                yield "Case C";
            }
            default -> "Default Case";
        };
    }
    public  void m5Basic(String param){
        switch (param){
            case "A","B" -> System.out.println("Case A & Case B");
            case "C","E","F" -> System.out.println("Case C, E, F");
            default -> System.out.println("Default Case");
        }
    }
    //preview
    //patters matching for switch solo version java19
    /*private String m6PatterMatcher(Object param){
        if (param instanceof String){

        }else if (param instanceof  Integer){

        } else if (param instanceof  Client) {

        }
       return  switch (param){
            case String a -> "Case String";
            case Integer b -> "Case Integer";
            case Client c ->"Case Cliente";

            default -> "Default Case";
        };

    }*/


    public static void main(String[] args) {


    }
}
