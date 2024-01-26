import java.util.Scanner;

public class Menu {

    public static void displayMenu(int state){
            // this method displays the menu and calls the Utils.
            switch(state) {
                case 0:
                    // PRINT MENU AND ASK FOR INPUT
                    System.out.println("\t\tWelcome to the Menu!\n Please type the number of one of the following options to go into:\n" +
                            "\t1.-Basic Calculator\n\t2.-Encoder\n\t3.-Student Average Calculator\n\t4.-Exit ");
                    accept(0);
                    break;

                case 1:
                    // BASIC CALCULATOR
                    System.out.println("\t\tBASIC CALCULATOR\n Please type the number of the one you'd like to use:\n" +
                            "\t1.-Sum\n\t2.-Subtract\n\t3.-Multiply\n\t4.-Divide\n\t5.-Go back to Menu");
                    accept(1);
                    break;

                case 2:
                    // ENCODER
                    System.out.println("\t\tENCODER\n Please type the number of the one you'd like to use:\n" +
                            "\t1.-Encode a String to Base64\n\t2.-Decode a String from Base64\n\t3.-Go back to Menu");
                    accept(2);
                    break;

                case 3:
                    // STUDENT AVERAGE CALCULATOR
                    System.out.println("\t\tSTUDENT AVERAGE CALCULATOR");
                    StudentAvg.startStudent();
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    break;

                default:
                    message(0);
            }
    }

    static void accept (int type){
        // this method checks the input of the menu and redirects to the util or calls error message.
        Scanner scanner = new Scanner(System.in);
        String[] valid = {"1234", "12345", "123"};
        CallUtills[] methods ={
                Menu::displayMenu,
                Calculator::runCalculator,
                Encoder::code
        };

        String choice = scanner.next();
        if (valid[type].contains(choice)){
            methods[type].call(Integer.parseInt(choice));
        } else {
            message(type);
        }
    }

    static void message(int type){
        // this method displays an error message when the input is invalid and redirects back.
        System.out.println(" (!) The input provided isn't a Menu Option.\n" +
                "Please provide a valid option. \n");
        Menu.displayMenu(type);
    }

    public static void secondaryMenu(int type, int subtype){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nWhat would you like to do next?:");
        switch (type){
            case 1:
                String[] subtypeArr = {"Sum", "Subtraction", "Multiplication", "Division"};
                System.out.printf("1.- Another %s\n2.-Go back to Calculator\n", subtypeArr[subtype-1]);
                break;
            case 2:
                String[] subtypeArrB = {"Encoding", "Decoding"};
                System.out.printf("1.- Another %s\n2.-Go back to Encoder\n", subtypeArrB[subtype-1]);
                break;
            case 3:
                System.out.println("1.-Another Student\n");
                break;
            default:
                break;
        }
        System.out.println("3.-Go back to Menu\n4.-Exit");
        int choice = Integer.parseInt(scanner.next());
        try {
            switch (choice) {
                case 4: displayMenu(4);
                    break;
                case 3: displayMenu(0);
                    break;
                case 2: displayMenu(type);
                    break;
                case 1:
                    if (type ==1){
                        Calculator.runCalculator(subtype);
                    } else if (type == 2){
                        Encoder.code(subtype);
                    } else {
                        StudentAvg.startStudent();
                    }
                    break;
                default:
                    secondaryMenu(type, subtype);
            }
        } catch (NumberFormatException e) {
            secondaryMenu(type, subtype);

        }

    }


}
