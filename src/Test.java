import java.util.Scanner;


public class Test {
    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(System.in);
        System.out.println(" M ?");
        String str = s.nextLine();
        String[] el = str.split(" ");

        if (isString(el[0]) && isString(el[2])) {
            String res = operator(el[1], el[0].replaceAll("\"", ""), el[2].replaceAll("\"", ""));
            System.out.println(getAnswer(res));
        }

        if (isInt(el[0])){
            throw new MyException ("невозможно выполнить");

        }

        if (isString(el[0]) && isInt(el[2])) {

            String res1 = operator1(el[1], el[0].replaceAll("\"", ""), Integer.valueOf(el[2]));
            if ( Integer.valueOf(el[2]) > 10 || Integer.valueOf(el[2]) <1 ) {
                throw new MyException("Введенное значение должно быть от 1 до 10");

            }
            System.out.println(getAnswer(res1));
        }
    }

    public static boolean isInt(String myint) {
        try {
            Integer.valueOf(myint).getClass().equals(Integer.class);
            return true;
        } catch (Exception e) {
            return false;

        }
    }

    private static boolean isString(String str) {
        return str.startsWith("\"") && str.endsWith("\""); // оператор ор или ии?
    }

    public static String operator(String op, String x, String y) {
        String result = "";

        if ("+".equals(op)) {
            result = x.concat(y);
            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }
        }

        if ("-".equals(op)) {
            result = x.replace(y, "");
            if (result.length() > 40) {
                result = result.substring(0, 40) + "...";
            }
        }
        return result;
    }

    private static String getAnswer(String result) {
        return "\"" + result + "\"";
    }

    private static String operator1(String op1, String x, int foo) {
        String result = "";

        if ("*".equals(op1)) {
            result = x.repeat(foo) ;
            if (result.length() > 40)
                result = result.substring(0,40) + "...";
        }

        if ("/".equals(op1)) {
            int size = x.length();
            int res1 = size / foo;
            result = x.substring (0,res1);
        }
        return result;
    }
}

class MyException extends Exception {
    MyException(String message) {
        super(message);
    }

    class MyException2 extends Exception {
        MyException2(String message) {
            super(message);
        }
    }
}