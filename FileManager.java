import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {

    public static void saveStudent(Student student) {

        try {
            FileWriter writer = new FileWriter("students.csv", true);

            int total = PerformanceAnalyzer.calculateTotal(student.marks);
            double percentage = (double) total / 500 * 100;
            char grade = PerformanceAnalyzer.calculateGrade(percentage);

            writer.write(
                student.name + "," +
                student.marks[0] + "," +
                student.marks[1] + "," +
                student.marks[2] + "," +
                student.marks[3] + "," +
                student.marks[4] + "," +
                percentage + "," +
                grade + "\n"
            );

            writer.close();

        } catch (IOException e) {
            System.out.println("Error saving student.");
        }
    }


    public static void loadStudents(StudentManager manager) {

        try {

            BufferedReader reader =
                new BufferedReader(new FileReader("students.csv"));

            String line;

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) {
                continue;
            }

                String[] data = line.split(",");

                String name = data[0];
                if (data.length < 6) {
                System.out.println("Skipping invalid student record.");
                continue;
            }

                int[] marks = new int[5];

                for (int i = 0; i < 5; i++) {
                    marks[i] = Integer.parseInt(data[i + 1]);
                }

                Student student = new Student(name, marks);

                manager.addStudent(student);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error loading students.");

        } catch (NumberFormatException e) {

            System.out.println("Invalid data in students.csv.");
        }
    }
}