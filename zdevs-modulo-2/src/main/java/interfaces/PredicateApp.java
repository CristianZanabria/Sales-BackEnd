package interfaces;

import model.Product;

import java.util.function.Predicate;
// boolean test(T t);
public class PredicateApp {


    private  void method1(){
       Predicate<Integer> checkAge = x -> x >= 18;
       boolean result = checkAge.test(32);
       Predicate<String> checkChars = x -> x.length() >= 5;
       boolean result1 = checkChars.test("crisDevs");

        System.out.println(result);
        System.out.println(result1);

    }
    private void method2(){
        Predicate<Integer> greaterThan = x-> x > 10;
        Predicate<Integer> lowerThan = x -> x < 20;

        boolean rpta = greaterThan.and(lowerThan).test(15); //pipeline
        System.out.println(rpta);
    }
    private  void method3(Product product,Predicate<Product> fx){

        boolean rpta = fx.test(product);
        System.out.println(rpta);



    }

    public static void main(String[] args) {
        PredicateApp app = new PredicateApp();

       // app.method1();
       // app.method2();
       /* Predicate<Product> fx = x -> x.getName().length()>= 3;
        app.method3(new Product(1, "tv"),fx);*/


        app.method3(new Product(1, "tvs"),x -> x.getName().length()>= 3);

    }
}
