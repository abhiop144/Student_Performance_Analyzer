import java.util.ArrayList;
import java.util.Comparator;

public class StudentManager {

    ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public void viewStudents() {

    for (Student student : students) {

        int total = PerformanceAnalyzer.calculateTotal(student.marks);
        double average = PerformanceAnalyzer.calculateAverage(student.marks);
        double percentage = (double) total / 500 * 100;
        int highest = PerformanceAnalyzer.findHighest(student.marks);
        int lowest = PerformanceAnalyzer.findLowest(student.marks);
        char grade = PerformanceAnalyzer.calculateGrade(percentage);

        System.out.println("\n----------------------------");
        System.out.println("Name: " + student.name);
        System.out.println("Total: " + total);
        System.out.println("Average: " + average);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Highest: " + highest);
        System.out.println("Lowest: " + lowest);
        System.out.println("Grade: " + grade);
    }
}
    public void searchStudent(String name) {

    boolean found = false;

    for (Student student : students) {

        if (student.name.equalsIgnoreCase(name)) {

            System.out.println("\nStudent Found!");
            System.out.println("Name: " + student.name);

            found = true;
            break;
        }
    }

    if (!found) {
        System.out.println("\nStudent not found.");
    }
    
}
public void findTopper() {

    if (students.isEmpty()) {
        System.out.println("No students available.");
        return;
    }

    Student topper = students.get(0);

    for (Student student : students) {

        int currentTotal =
            PerformanceAnalyzer.calculateTotal(student.marks);

        int topperTotal =
            PerformanceAnalyzer.calculateTotal(topper.marks);

        if (currentTotal > topperTotal) {
            topper = student;
        }
    }

    int total = PerformanceAnalyzer.calculateTotal(topper.marks);
    double percentage = (double) total / 500 * 100;

    System.out.println("\n----- Topper -----");
    System.out.println("Name: " + topper.name);
    System.out.println("Total: " + total);
    System.out.println("Percentage: " + percentage + "%");
}
public void calculateClassAverage() {

    if (students.isEmpty()) {
        System.out.println("No students available.");
        return;
    }

    double totalPercentage = 0;

    for (Student student : students) {

        int total =
            PerformanceAnalyzer.calculateTotal(student.marks);

        double percentage = PerformanceAnalyzer.calculatePercentage(student.marks);
        totalPercentage = totalPercentage + percentage;
    }

    double classAverage = totalPercentage / students.size();

    System.out.println("\n----- Class Average -----");
    System.out.println("Average Percentage: " + classAverage + "%");
}
public void rankStudents() {

    if (students.isEmpty()) {
        System.out.println("No students available.");
        return;
    }

    students.sort(new Comparator<Student>() {

        @Override
        public int compare(Student s1, Student s2) {

            double percentage1 =
                PerformanceAnalyzer.calculatePercentage(s1.marks);

            double percentage2 =
                PerformanceAnalyzer.calculatePercentage(s2.marks);

            return Double.compare(percentage2, percentage1);
        }
    });

    System.out.println("\n----- Student Rankings -----");

    int rank = 1;

    for (Student student : students) {

        double percentage =
            PerformanceAnalyzer.calculateAverage(student.marks);

        System.out.println(
            rank + ". " +
            student.name +
            " - " +
            percentage + "%"
        );

        rank++;
    }
}
public void subjectAnalysis() {

    if (students.isEmpty()) {
        System.out.println("No students available.");
        return;
    }

    System.out.println("\n----- Subject Analysis -----");

    for (int subject = 0; subject < 5; subject++) {

        int total = 0;

        for (Student student : students) {
            total = total + student.marks[subject];
        }

        double average = (double) total / students.size();

        System.out.println(
            "Subject " + (subject + 1) +
            " Average: " + average
        );
    }
}
public boolean studentExists(String name) {

    for (Student student : students) {

        if (student.name.equalsIgnoreCase(name)) {
            return true;
        }
    }

    return false;
}
}