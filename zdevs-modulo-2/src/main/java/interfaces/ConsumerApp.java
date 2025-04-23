package interfaces;

import java.util.List;
import java.util.function.Consumer;

// void accept(Tt);
public class ConsumerApp {

    private  void method1(){
        Consumer<String> fx1 = x -> System.out.println(x);

       // fx1.accept("hello coders");

        Consumer<String> fx2 = x -> System.out.println( "fx2: " + x);

        fx1.andThen(fx2).accept("hello coders");

       /* List<Integer> list = List.of(1,2,3,4,5);
        list.forEach(x -> System.out.println(x));

        Consumer<Integer> fx1 = x ->{
            x = x + 5;
            System.out.println(x);

        };
        fx1.accept(10);*/
    }

    private void method2() {

        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Consumer<Integer> consumer = x -> {
            x++;
            System.out.println(x);

        };
        //list.forEach(consumer);
        listAll(list, consumer);
    }
 // High order Functions / fuanciones de alto orden
    private  void  listAll(List<Integer> list, Consumer<Integer> fx){
        list.forEach(fx);

    }

    public static void main(String[] args) {
        ConsumerApp app = new ConsumerApp();



        app.method2();
    }
}
