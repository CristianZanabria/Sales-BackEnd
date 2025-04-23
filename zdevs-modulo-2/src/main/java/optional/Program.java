package optional;

import function.Employee;

import java.time.LocalDate;
import java.util.Optional;

public class Program {

    private void mOptional(){
      //Optional<Employee> op = Optional.of(new Employee(1, "zeta1", "Developer", LocalDate.of(1991, 2, 2), 996.99, "TI"));
        //**Optional<Employee> op = Optional.empty();
        //Optional<Employee> op = Optional.ofNullable(null);// Ignora el NPE y devuelve el orELse del optional
        Optional<Employee> op = Optional.of(null); //ocaiona MpE

        //System.out.println(op.isPresent());
       // System.out.println(op.isEmpty());
        //System.out.println(op.get());
        //op.ifPresent(obj -> System.out.println(obj.getName()));
        System.out.println(op.orElse(new Employee()));
       // System.out.println(op.orElseGet(() -> new Employee()));
       // System.out.println(op.orElseGet(Employee::new));
       // System.out.println(op.orElseThrow(ArithmeticException::new));




    }

    public static void main(String[] args) {

        Program app = new Program();
        app.mOptional();

    }
}
