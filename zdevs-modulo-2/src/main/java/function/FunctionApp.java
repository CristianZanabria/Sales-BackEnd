package function;

import java.time.LocalDate;
import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;


public class FunctionApp {


    private void m1Apply(){
        Function<String, Integer> fx = x -> x.length();
       int rpta = fx.apply("mitoCode");
        System.out.println(rpta);

    }
    private void m2AndThen(){
        Function<String, Integer> fx = x -> x.length();
        Function<Integer, Integer> fx2 = x -> x + 10;


        int rpta = fx.andThen(fx2).apply("mitoCode");
        System.out.println(rpta);

    }
    private void m2AndThen2(){
        Function<Integer, Integer> fx = x -> x*2;
        Function<Integer, Integer> fx2 = x -> x + 10;


        Integer rpta = fx.andThen(fx2).apply(5);
        System.out.println(rpta);

    }
    private void m3compose(){
        Function<Integer, Integer> fx = x -> x*2;
        Function<Integer, Integer> fx2 = x -> x + 10;


        Integer rpta = fx.compose(fx2).apply(5);
        System.out.println(rpta);

    }
    private void m4Identity(){// tambien se le conoce como espejo
        Function<Employee, Employee>  fx = Function.identity();
        Function<Integer, Integer>  fx2 = Function.identity();
        System.out.println(fx.apply(new Employee()));
        System.out.println(fx2.apply(5));

    }private void m5Identity(){// tambien se le conoce como espejo

        List<Employee> list = new ArrayList<>();

        list.add(new Employee(1,"zeta","teacher", LocalDate.now(),99.99,"fisica"));
        list.add(new Employee(2,"cris","salesperson", LocalDate.now(),999.99,"Hotel"));
        list.add(new Employee(3,"mili","doctor", LocalDate.now(),799.99,"Hospital"));
        // tranformar de lista a mapa / List -> Map

        Map<Integer, Employee> map =list.stream()    // Stream<Employee
                   // .collect(Collectors.toMap(x -> x.getIdEmployee(),x -> x.getName()));
                  //.collect(Collectors.toMap(x -> x.getIdEmployee(),Function.identity()));
                  .collect(Collectors.toMap(Employee :: getIdEmployee, Function.identity()));





       /* Map<Integer, String> map = new HashMap<>();
        for ( Employee e : list ){
            map.put(e.getIdEmployee(),e.getName());

        }*/
        System.out.println(map);


    }
    private void m6Identity(){
        Function<Integer, Integer> f1 = Function.identity();
        Function<Integer, Integer> f2 = Function.identity();
        Function<Integer, Integer> f3 = Function.identity();

        Function<Integer, Integer> f4 = t -> t;
        Function<Integer, Integer> f5 = t -> t;
        Function<Integer, Integer> f6 =t -> t ;

        System.out.println(f1);
        System.out.println(f2);
        System.out.println(f3);
        System.out.println("=================================================");
        System.out.println(f4);
        System.out.println(f5);
        System.out.println(f6);
    }


    public static void main(String[] args) {
        FunctionApp app = new FunctionApp();


        app.m6Identity();
    }
}
