package interfaces;

import java.time.LocalDate;
import java.util.function.Supplier;

public class SupplierApp {
    private void method1(){
        Supplier<LocalDate> fx = () -> LocalDate.now().minusDays(1);
        System.out.println(fx.get());
    }
    public static void main(String[] args) {
        SupplierApp app = new SupplierApp();

        app.method1();
    }
}
