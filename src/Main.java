
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        myState(0);

    }

    public static void myState(int state){
        switch(state) {
            case 0:
                // PRINT MENU AND ASK FOR INPUT
                System.out.println("\t\tWelcome to the Menu!\n Please type the number of one of the following options to go into:\n" +
                        "\t1.-Basic Calculator\n\t2.-Encoder\n\t3.-Student Average Calculator\n\t4.-Exit ");
                myState(getInput());
                break;
            case 1:
                // BASIC CALCULATOR
                System.out.println("\t\tBASIC CALCULATOR\n Please type the number of the one you'd like to use:\n" +
                        "\t1.-Sum\n\t2.-Subtract\n\t3.-Multiply\n\t4.-Divide\n\t5.-Go back to Menu");
                switch(getInput()){
                    case 1:
                        System.out.println("Sum");
                        break;
                    case 2:
                        System.out.println("Subtract");
                        break;
                    case 3:
                        System.out.println("Multiply");
                        break;
                    case 4:
                        System.out.println("Divide");
                        break;
                    default:
                        myState(0);
                        break;
                }
                break;
            case 2:
                // ENCODER
                System.out.println("\t\tENCODER\n Please type the number of the one you'd like to use:\n" +
                        "\t1.-Encode a String to Base64\n\t2.-Decode a String from Base64\n\t3.-Go back to Menu");
                switch(getInput()){
                    case 1:
                        System.out.println("Encode...");
                        break;
                    case 2:
                        System.out.println("Decode...");
                        break;
                    default:
                        myState(0);
                        break;
                }
                break;
            case 3:
                // STUDENT AVERAGE CALCULATOR
                System.out.println("\t\tSTUDENT AVERAGE CALCULATOR");
                break;
            default:
                // code block
                System.out.println("Goodbye!");
                break;
        }
    }

    public static int getInput (){
        Scanner scanner = new Scanner(System.in);
        return Integer.parseInt(scanner.next());
    }

}
