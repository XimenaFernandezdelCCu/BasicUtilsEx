import java.util.Scanner;

public class Calculator {


   static void runCalculator(int type){
       if(type==5){
           Menu.displayMenu(0);
       }
       Scanner scanner = new Scanner(System.in);
       String[] catArr = {"Sum (a+b)", "Subtraction (a-b)", "Multiplication (a*b)", "Division (a/b)"};
       char[] chars = {'+','-','*','/' };
       CalculatorInterface[] op = {Double::sum, (a, b) -> a - b, (a, b) -> a * b,(a, b) -> a / b };
       int type2=type-1;

       System.out.println(catArr[type2]);
       System.out.println("\nEnter a value for a: ");

       try {
           double aVal = Double.parseDouble(scanner.next());
           System.out.println("Enter a value for b");
           double bVal = Double.parseDouble(scanner.next());
           if(type==4 && bVal==0){
               System.out.println("Cannot perform division / 0, " +
                       "please provide another denominator");
               runCalculator(4);
           } else {
               System.out.printf("\n\t%G %c %G = %G\n", aVal, chars[type2], bVal, calculate(aVal, bVal, op[type2]));
               Menu.next2(1,type);
           }

       } catch(NumberFormatException e) {
           message(type);
       }
   }


    static double calculate(double x1, double x2, CalculatorInterface op) {
        return op.apply(x1, x2);
    }

    static void message(int type){
        System.out.println("Can't perform operations with anything other than numbers\n" +
                "Please provide a valid operand. ");
        runCalculator(type);

    }

}
