import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String args[]){
        
        //scanner class object
        Scanner sc = new Scanner(System.in);

        //needed avriable
        int totalMarks = 0;
        double avgMarks;

        //no of subjects input from user
        System.out.println("- - - Enter The Number Of Subjects You Have  - - -");
        int noOfSubjects = sc.nextInt();

        //array of marks with size of how many subjects you have
        int marks[] = new int[noOfSubjects];
        
        //store each marks in the array
        for(int i = 0; i<noOfSubjects; i++){
            System.out.println("\n- - - Enter The Mark You Get In Subject " + (i+1) + " - - -");
            marks[i]=sc.nextInt();
            totalMarks += marks[i];
        }

        for(int i = 0; i<noOfSubjects; i++){
            System.out.println("\nYou Have Obtained " + marks[i] + " Marks In Subject " + (i+1));
            if(marks[i]>=90 && marks[i]<=100){
                System.out.println("\nYour Grade For Subject " + (i+1) + " Is O (Outsatnding)");
            } else if(marks[i]>=80 && marks[i]<90){
                System.out.println("\nYour Grade For Subject " + (i+1) + " Is E (Excellent)");
            } else if(marks[i]>=70 && marks[i]<80){
                System.out.println("\nYour Grade For Subject " + (i+1) + " Is A (Very Good)");
            } else if(marks[i]>=60 && marks[i]<70){
                System.out.println("\nYour Grade For Subject " + (i+1) + " Is B (Good)");
            } else if(marks[i]>=50 && marks[i]<60){
                System.out.println("\nYour Grade For Subject " + (i+1) + " Is C (Fair)");
            } else if(marks[i]>=40 && marks[i]<50){
                System.out.println("\nYour Grade For Subject " + (i+1) + " Is D (Below Average)");
            } else if(marks[i]<40){
                System.out.println("\nYour Grade For Subject " + (i+1) + " Is F (Falied)");
            } else {
                System.out.println("\nYour Grade For Subject " + (i+1) + " Is I (Incomplete)");
            }
        }

        avgMarks = totalMarks/noOfSubjects;
        System.out.println("\n\nTotal Marks Obtained Is : " + totalMarks + " And Average Mark Is : " + avgMarks + " And Percentage Is : " + avgMarks + "%");
        if(avgMarks>=90 && avgMarks<=100){
                System.out.println("\nYour Grade Is O (Outsatnding)");
            } else if(avgMarks>=80 && avgMarks<90){
                System.out.println("\nYour Grade Is E (Excellent)");
            } else if(avgMarks>=70 && avgMarks<80){
                System.out.println("\nYour Grade For Subject Is A (Very Good)");
            } else if(avgMarks>=60 && avgMarks<70){
                System.out.println("\nYour Grade For Subject Is B (Good)");
            } else if(avgMarks>=50 && avgMarks<60){
                System.out.println("\nYour Grade For Subject Is C (Fair)");
            } else if(avgMarks>=40 && avgMarks<50){
                System.out.println("\nYour Grade For Subject Is D (Below Average)");
            } else if(avgMarks<40){
                System.out.println("\nYour Grade For Subject Is F (Falied)");
            } else {
                System.out.println("\nYour Grade For Subject Is I (Incomplete)");
            }

    }
}
