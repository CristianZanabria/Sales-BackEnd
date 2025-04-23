package stream;

import function.Employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.function.Predicate;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.*;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toSet;


public class AppStream {
    final Logger LOG = Logger.getLogger("com.zdevs.AppStream");

    private void m1Developers(List<Employee> list, String searchText) {
        Predicate<Employee> fx = e -> e.getJob().toLowerCase().contains(searchText);
        // List<Employee> newList = list.stream()
        list.stream()
                .filter(fx)
                .forEach(System.out::println);// x-> System.out.println(x)
        //.filter(e -> e.getJob().toLowerCase().contains(searchText))
        // .collect(Collectors.toList()); seria para java 11
        //.toList();//desde java 16

        //System.out.println(newList);

    }

    private void m2GetInverse(List<Employee> list) {
        list.stream()
                .sorted(comparing(Employee::getIdEmployee).reversed())
                .forEach(System.out::println);
    }

    private void m3getAdult(List<Employee> list) {
        Predicate<Employee> isAdult = e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() >= 18;

        list.stream()
                .filter(isAdult)
                .forEach(System.out::println);
    }

    private void m4getOldEstAdult(List<Employee> list) {
        list.stream()
                .sorted(comparing(Employee::getIdEmployee))
                .limit(1)
                .forEach(System.out::println);
    }

    public void m5GetMaxSalary(List<Employee> list) {
        double max = list.stream()
                .mapToDouble(Employee::getSalary)
                .max()
                .orElse(0);
        double min = list.stream()
                .mapToDouble(Employee::getSalary)
                .min()
                .orElse(0);
        Employee emp = list.stream()
                .max(comparing(Employee::getSalary))
                .orElse(new Employee());


        System.out.println("Max:" + max);
        System.out.println("Min: " + min);
        System.out.println("Emp Max: " + emp);

    }

    public void m6AtAverage(List<Employee> list) {
        double avg = list.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    public void m7getSummary(List<Employee> list) {
        DoubleSummaryStatistics stats = list.stream()
                .mapToDouble(Employee::getSalary)
                .summaryStatistics();

        System.out.println(stats);
        System.out.println("Count: " + stats.getCount());
        System.out.println("Average: " + stats.getAverage());
        System.out.println("MAx: " + stats.getMax());
        System.out.println("Min: " + stats.getMin());
        System.out.println("Sum: " + stats.getSum());
    }

    public void m8getDistinct(List<Employee> list) {
        list.stream()
                .distinct()//va de la  mano  con equal en hascoth
                .forEach(System.out::println);

    }
     public void m9getCount(List<Employee> list) {
         long count1 = list.stream().count();
         int cpunt2 = list.size();

         System.out.println(count1);
         System.out.println(cpunt2);
     }
     private void  m10skiplimit(List<Employee> list){
        list.stream()
                .skip(4)
                .limit(2)
                .forEach(System.out::println);
     }
     private void m11AnyYounger(List<Employee> list){
        Predicate<Employee> isYounger = e -> Period.between(e.getBirthDate(), LocalDate.now()).getYears() < 18;
        boolean rpta = list.stream()
                .anyMatch(isYounger);
         System.out.println("Is any Younger in this data? " + rpta);
     }

     private void m12Map(List<Employee> list){
        list.stream()
                .map(e -> {// map de elemento a elemneto
                    e.setSalary(e.getSalary() * 1.10);
                    return e;

                })
                .forEach(System.out::println);
     }
    private void m13FlaMap(List<Employee> list){
        list.stream() // de elmento a otro elemento o varios elementos
                .flatMap(e -> {
                    e.setSalary(e.getSalary() * 1.10);
                    return Stream.of(e.getSalary(), e.getName(),"Zdevs");

                })
                .forEach(System.out::println);
    }
    private void m14peek(List<Employee> list){
        list.stream()
                .filter(e -> e.getSalary() < 600)
                .peek(e -> LOG.info("FIST" + e.toString()))
                .filter(e -> e.getSalary() < 700)
                .peek(e -> LOG.info("SECOND" + e.toString()))
                .filter(e -> e.getSalary() < 1000)
                .collect(Collectors.toList());
    }
    public void m15GorupBy(List<Employee> list){
        Map<String, List<Employee>> byDepartment = list.stream()
                .collect(groupingBy(Employee::getDepartment));

        Map<String,Map<String , List<Employee>>> byDepartmentAndJOb= list.stream()
                .collect(groupingBy(Employee::getDepartment, groupingBy(Employee::getJob )));
       /* var byDepartmentAndJOb= list.stream()
                .collect(groupingBy(Employee::getDepartment, groupingBy(Employee::getJob )));*/

        //System.out.println(byDepartment);
        System.out.println(byDepartmentAndJOb);
    }
    public void m16ToSet(List<Employee> list){
        //Set<Employee> set = list.stream().collect(toSet());

        Set<Employee> set = new HashSet<>(list);
    }
    public void m17Order(List<Employee> list){
        list.stream()
                .sorted(comparingInt(Employee::getIdEmployee).reversed())
                .forEach(System.out::println);

        Stream.of("Z","M","Q","R","C")
                .sorted(reverseOrder())
                .forEach(System.out::println);

    }


        public static void main (String[]args){

            AppStream appStream = new AppStream();

            Employee e1 = new Employee(1, "zeta1", "Developer", LocalDate.of(1991, 2, 2), 996.99, "TI");
            Employee e2 = new Employee(2, "cris2", "QA", LocalDate.of(1995, 1, 1), 999.99, "Hotel");
            Employee e3 = new Employee(3, "mili3", "Architect", LocalDate.of(2000, 1, 1), 799.99, "TI");
            Employee e4 = new Employee(4, "zeta4", "Cloud Engineer", LocalDate.of(2010, 4, 4), 994.99, "TI");
            Employee e5 = new Employee(5, "cris5", "DevOps Engineer", LocalDate.of(2011, 1, 1), 99549.99, "TI");
            Employee e6 = new Employee(6, "mili6", "Scrum Master", LocalDate.of(1993, 1, 2), 4499.99, "TI");
            Employee e7 = new Employee(7, "zeta7", "Leader Project", LocalDate.of(1998, 5, 5), 4569.99, "TI");
            Employee e8 = new Employee(8, "cris8", "Senior Developer", LocalDate.of(2004, 1, 1), 699.99, "TI");
            Employee e9 = new Employee(9, "mili9", "Junior Developer", LocalDate.of(1997, 1, 1), 459.99, "TI");
            Employee e10 = new Employee(10, "zeta10", "Mobile Developer", LocalDate.of(1992, 1, 1), 9469.99, "TI");
            Employee e11 = new Employee(11, "cris11", "Salesman", LocalDate.of(1992, 4, 2), 1699.99, "TI");
            Employee e12 = new Employee(11, "cris11", "Salesman", LocalDate.of(1992, 4, 2), 1699.99, "Hotel");

            List<Employee> list = List.of(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10, e11, e12);

            // appStream.m1Developers(list, "developer");
            //appStream.m3getAdult(list);
            //appStream.m4getOldEstAdult(list);
            //appStream.m5GetMaxSalary(list);
            //appStream.m6AtAverage(list);
            //appStream.m7getSummary(list);
            //appStream.m8getDistinct(list);
            //appStream.m9getCount(list);
            //appStream.m10skiplimit(list);
           // appStream.m11AnyYounger(list);

            //appStream.m12Map(list);}
            appStream.m17Order(list);

        }
    }
