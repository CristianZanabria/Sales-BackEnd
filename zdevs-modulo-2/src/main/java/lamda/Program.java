package lamda;

public class Program {
    public static void main(String[] args) {
        //la forma normal
        Operation opi = new Sum();
        int result = opi.operate(5,4);
        System.out.println(result);

        //lamdas
        Operation op2 = (a,b) -> a + b;
        Operation op3 = (a,b) -> a*b;
        int res = op2.operate(9,4);
        int resul = op3.operate(9,4);
        System.out.println(res);
        System.out.println(resul);
    }
}
