import java.util.*;

public class StudentManagement {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        int choice;
        do{
            // Display menu
            System.out.println("\n=====MENU STUDENT MANAGEMENT=====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Remove Student");
            System.out.println("5. Sort Students by Grade");
            System.out.println("0. Exit");
            System.out.println("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch(choice){
                case 1:
                    // Add Student
                    System.out.println("Enter Student ID: ");
                    String id = sc.nextLine();
                    System.out.println("Enter Student Name: ");
                    String name = sc.nextLine();
                    System.out.println("Enter Student Grade: ");
                    double grade = Double.parseDouble(sc.nextLine());
                    students.add(new Student(id, name, grade));
                    System.out.println("Student added successfully!");
                    break;
                
                case 2:
                    // Display All Students
                    if(students.isEmpty()){
                        System.out.println("No students to display.");
                    }else{
                        System.out.println("\n====List of Students====");
                        for(Student s : students){
                            s.display();
                        }
                    }
                    break;

                case 3:
                    // Search Student by ID
                    System.out.println("Enter Student ID to search:");
                    String searchId = sc.nextLine();
                    boolean found = false;
                    for(Student s : students){
                        if(s.getId().equals(searchId)){
                            System.out.println("Student found:");
                            s.display();
                            found = true;
                            break;
                        }
                    }
                    if(!found){
                        System.out.println("Student with ID" + searchId +  " not found!");
                    }
                    break;

                case 4:
                    // Remove Student
                    System.out.println("Enter Student ID to remove:");
                    String removeId = sc.nextLine();
                    Student toRemove = null;
                    for(Student s : students){
                        if(s.getId().equalsIgnoreCase(removeId)){
                            toRemove = s;
                            break;
                        }
                    }
                    if(toRemove != null){
                        students.remove(toRemove);
                        System.out.println("Student removed successfully!");
                    }else{
                        System.out.println("Student with ID" + removeId + " not found!");
                    }
                    break;
                
                case 5:
                    // Sort Students by Grade
                    students.sort((a, b) -> Double.compare(b.getGrade(), a.getGrade()));
                    System.out.println("Students sorted by grade in descending order.");
                    break;

                case 0:
                    // Exit
                    System.out.println("Exiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again!");
            }
        }while(choice != 0);
        sc.close();
    }
}
