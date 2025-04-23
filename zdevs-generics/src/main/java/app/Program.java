package app;

import model.Car;
import model.Subaru;
import model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class Program {

    // T  = Type | Tipo de Clase
    //k = Key | Llave
    // V = Value | Valor
    //E = Element
    //? = wukdcard  unknown /? extend Object

    // Upper-bounded

    //algo tiene que ser menor igual que "Car"

    public  void m1(List<? extends  Car> list) {

    }

    // Lower-bounded
    // Algo tiene quew ser  mayor igual que "Car"
    public  void m2(List<? super  Car> list) {

    }

    public static void main(String[] args) {
        List<Vehicle> lst1 = new ArrayList<>();
        Program app = new Program();
        //app.m2(lst1);
        /*List<? extends Car> list = new ArrayList<>(); no usa por que es proteccion de tipos
        list.add(new Car());//safe type | no se permite como uso de definicion de variable por que solo se pude usar en las clases , metodo y como paso de parametro
        List<? super Car> listx = new ArrayList<>();
        listx.add(new Vehicle());//safe type Solo de deja si ya sabes en valor en concreto */

    }
}
