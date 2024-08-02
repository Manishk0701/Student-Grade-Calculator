import java.util.Scanner;



public class task2 {
    
    private static final int A = 90, A_PLUS = 75, A_MINUS = 65, B_PLUS = 55, B = 50, C = 45, P = 40;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean tryAgain = true;

        while (tryAgain) {
            
            welcomeMessage();

            
            int numSubjects = getNumberOfSubjects(scanner);

            
            int[] marks = getSubjectMarks(scanner, numSubjects);

            
            int totalMarks = calculateTotalMarks(marks);
            double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);

           
            int gradePoint = calculateGradePoint(averagePercentage);
            String grade = calculateGrade(averagePercentage);

           
            displaySubjectResults(numSubjects, marks);

            
            displayResults(totalMarks, averagePercentage, gradePoint, grade);

           
            displayGradeChart();

            
            tryAgain = askForTryAgain(scanner);

            
            clearConsole();
        }

        
        goodbyeMessage();

        
        scanner.close();
    }

    
    private static void welcomeMessage() {
        System.out.println("Welcome to the Student Grade Calculator!");
    }

    
    private static int getNumberOfSubjects(Scanner scanner) {
        System.out.print("Enter the number of subjects: ");
        return scanner.nextInt();
    }

    
    private static int[] getSubjectMarks(Scanner scanner, int numSubjects) {
        int[] marks = new int[numSubjects];
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + ": ");
            marks[i] = scanner.nextInt();
        }
        return marks;
    }

    
    private static int calculateTotalMarks(int[] marks) {
        int totalMarks = 0;
        for (int mark : marks) {
            totalMarks += mark;
        }
        return totalMarks;
    }

    
    private static double calculateAveragePercentage(int totalMarks, int numSubjects) {
        return (double) totalMarks / numSubjects;
    }

    
    private static int calculateGradePoint(double averagePercentage) {
        if (averagePercentage >= A) return 10;
        else if (averagePercentage >= A_PLUS) return 9;
        else if (averagePercentage >= A_MINUS) return 8;
        else if (averagePercentage >= B_PLUS) return 7;
        else if (averagePercentage >= B) return 6;
        else if (averagePercentage >= C) return 5;
        else if (averagePercentage >= P) return 4;
        else return 0;
    }

   
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= A) return "O";
        else if (averagePercentage >= A_PLUS) return "A+";
        else if (averagePercentage >= A_MINUS) return "A";
        else if (averagePercentage >= B_PLUS) return "B+";
        else if (averagePercentage >= B) return "B";
        else if (averagePercentage >= C) return "C";
        else if (averagePercentage >= P) return "P";
        else return "F";
    }

   
    private static void displaySubjectResults(int numSubjects, int[] marks) {
        System.out.println("\nSubject-wise Results:");
        for (int i = 0; i < numSubjects; i++) {
            System.out.println("Subject " + (i + 1) + ": Marks - " + marks[i]);
        }
    }

    
    private static void displayResults(int totalMarks, double averagePercentage, int gradePoint, String grade) {
        System.out.println("\nOverall Results:");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade Point: " + gradePoint);
        System.out.println("Grade: " + grade);
    }

    
    private static void displayGradeChart() {
        System.out.println("\nGrade Chart:");
        System.out.println("Marks (in %)\tGrade Point\tGrade");
        System.out.println("90 to 100\t\t10\t\tO");
        System.out.println("75 to 89\t\t9\t\tA+");
        System.out.println("65 to 74\t\t8\t\tA");
        System.out.println("55 to 64\t\t7\t\tB+");
        System.out.println("50 to 54\t\t6\t\tB");
        System.out.println("45 to 49\t\t5\t\tC");
        System.out.println("40 to 44\t\t4\t\tP");
        System.out.println("Less than 40 or absent\t0\t\tF");
    }

    
    private static boolean askForTryAgain(Scanner scanner) {
        System.out.print("\nWould you like to try again? (yes/no): ");
        String tryAgainInput = scanner.next().toLowerCase();
        return tryAgainInput.equals("yes");
    }

    
    private static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    
    private static void goodbyeMessage() {
        System.out.println("\nThank you. Goodbye.");
    }
}