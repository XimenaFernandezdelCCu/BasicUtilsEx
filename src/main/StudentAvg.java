
import java.util.Scanner;
import java.util.Arrays;


public class StudentAvg {

    static void startStudent(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the student name:");
        String name = scanner.nextLine();
        System.out.println("Please enter your grade:");
        String grade = scanner.nextLine();
        System.out.println("Please enter the number of courses:");
        int n = Integer.parseInt(scanner.next());
        String[] courses = new String[n];
        double[] grades = new double[n];
        for (int i=0; i<n; i++){
            System.out.printf("Please enter the name of course %d: \n", i+1);
            courses[i]= scanner.next();
            System.out.printf("Please enter the grade earned on course %d: \n", i+1);
            grades[i]= Double.parseDouble((scanner.next()));

        }

        // Calculate the average using streams
        double average = Arrays.stream(grades)
                .average()
                .orElse(0.0);

        String level;
        if(average>85){
            level="Great!";
        } else if (average>75) {
            level="You can do better!";

        }else{
            level="Need to Study more!";
        }


        System.out.println("--------------------------------------------------");
        System.out.printf(" Student name: %s\t\t\tGrade: %s\n", name, grade);
        System.out.println("--------------------------------------------------");
        for(int i=0; i<n; i++){
            System.out.printf("\tCourse: %s\t\t Grade: %f\n", courses[i], grades[i]);
        }
        System.out.println("--------------------------------------------------\n");
        System.out.printf("Final Average: %f\t\t\tStatus: %s",average, level );
        Menu.secondaryMenu(3,0);

    }

}
