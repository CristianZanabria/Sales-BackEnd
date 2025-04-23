package basic;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list .forEach(x ->{ //SI la tienes codigo mas d euna linea se usa llaves  si no solo en la misma linea
            x++;
            System.out.println(x);
            //return hay gumas lamdas que requieren que retornes algo
        });
    }
}
