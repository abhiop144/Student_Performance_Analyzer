public class PerformanceAnalyzer {

    public static int calculateTotal(int[] marks) {

        int sum = 0;

        for (int i = 0; i < marks.length; i++) {
            sum = sum + marks[i];
        }

        return sum;
    }

    public static double calculateAverage(int[] marks) {

        int total = calculateTotal(marks);

        return (double) total / marks.length;
    }

    public static int findHighest(int[] marks) {

        int highest = marks[0];

        for (int i = 1; i < marks.length; i++) {

            if (marks[i] > highest) {
                highest = marks[i];
            }
        }

        return highest;
    }

    public static int findLowest(int[] marks) {

        int lowest = marks[0];

        for (int i = 1; i < marks.length; i++) {

            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }

        return lowest;
    }

    public static char calculateGrade(double percentage) {

        if (percentage >= 90) {
            return 'A';
        } else if (percentage >= 80) {
            return 'B';
        } else if (percentage >= 70) {
            return 'C';
        } else if (percentage >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    public static double calculatePercentage(int[] marks){
        int total = calculateTotal(marks);
        return (double) total / (marks.length *100) *100;
    }
}