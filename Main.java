import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentManager manager = new StudentManager();

        // Load previously saved students
        FileManager.loadStudents(manager);

        while (true) {

            System.out.println("\n===== Student Performance Analyzer =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Find Topper");
            System.out.println("5. Class Average");
            System.out.println("6. Student Rankings");
            System.out.println("7. Subject Analysis");
            System.out.println("8. Exit");


            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

            System.out.print("\nEnter student name: ");
            String name = sc.nextLine();

            if (manager.studentExists(name)) {

            System.out.println("A student with this name already exists.");

        } else {

        int[] marks = new int[5];

        System.out.println("Enter marks for 5 subjects:");

        for (int j = 0; j < marks.length; j++) {
            marks[j] = InputValidator.getValidMarks(sc, j + 1);
        }

        Student student = new Student(name, marks);

        manager.addStudent(student);

        // FileManager.saveStudent(student);

        System.out.println("Student added successfully.");
    }
} 
            else if (choice == 2) {

                System.out.println("\n----- Student Reports -----");
                manager.viewStudents();

            } 
            else if (choice == 3) {

                System.out.print("\nEnter student name to search: ");
                String searchName = sc.nextLine();

                manager.searchStudent(searchName);

            } 
            else if (choice == 4) {

                manager.findTopper();

            } 
           else if (choice == 5) {

    manager.calculateClassAverage();

}
else if (choice == 6) {

    manager.rankStudents();

}
else if (choice == 7) {

    manager.subjectAnalysis();

}
else if (choice == 8){

    System.out.println("Exiting Program ....");
    break;

}
else {

    System.out.println("Invalid choice. Please try again.");

}
        }

        sc.close();
    }
}