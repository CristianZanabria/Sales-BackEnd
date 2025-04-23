package app;

import model.Employee;

import java.util.*;

public class Program {

    public static void main(String[] args) {

        List<Employee>  list = new ArrayList<>();

        Employee e1 = new Employee(1, "juan", 23.53);
        Employee e2 = new Employee(1,"pedro",25.86);

        list.add(e1);
        list.add(e2);

        List<Employee> list2 = Arrays.asList(e1,e2);
        List<Employee> list3 = new ArrayList<>(150);// capacidad siempre es 10 segun oracle
        System.out.println(list2);

        List<Employee> list4 = new ArrayList<>();
        list4.add(new Employee(1, "lucas",1258.2));
        list4.add(new Employee(2, "marcos",1258.2));
        list4.add(new Employee(3, "juan",1258.2));



        Collections.shuffle(list4);
        Collections.reverse(list4);

        System.out.println(list4);

        // Tipico de java 6

        for (int i=0; i< list4.size(); i++){
            System.out.println(list4.get(1));
        }

        System.out.println("================================");


        //Desde java >= 7
        // For mejorado / For Enhancement

        for (Employee e : list4){
            System.out.println(e);
        }

        System.out.println("===================================");

        //Desde java >= 8

        list4.forEach(x -> System.out.println(x));




    }
}
