import java.util.Base64;
import java.util.Scanner;

public class Encoder {
    public static void code(int type){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your String:");

        switch (type){
            case 1:
                System.out.println(Base64.getEncoder().encodeToString(scanner.nextLine().getBytes()));
                Menu.secondaryMenu(2,type);
                break;
            case 2:
                System.out.println( new String(Base64.getDecoder().decode(scanner.nextLine())) );
                Menu.secondaryMenu(2,type);
                break;
            default:
                Menu.displayMenu(0);
                break;
        }


    }
}
