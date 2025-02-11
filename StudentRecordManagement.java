
class StudentNode {
    int rollNo;
    String name;
    int age;
    char grade;
    StudentNode next;
    public StudentNode(int rollNo, String name, int age, char grade) {
        this.rollNo = rollNo;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}
class StudentLinkedList {
    StudentNode head;
    public StudentLinkedList() {
        head = null;
    }
    public void addStudentAtBeginning(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        newNode.next = head;
        head = newNode;
    }
    public void addStudentAtEnd(int rollNo, String name, int age, char grade) {
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        if (head == null) {
            head = newNode;
            return;
        }
        StudentNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
    }
    public void addStudentAtPosition(int rollNo, String name, int age, char grade, int position) {
        if (position == 0) {
            addStudentAtBeginning(rollNo, name, age, grade);
            return;
        }
        StudentNode newNode = new StudentNode(rollNo, name, age, grade);
        StudentNode current = head;
        int count = 0;
        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }
        if (current != null) {
            newNode.next = current.next;
            current.next = newNode;
        } else {
            System.out.println("Position out of bounds.");
        }
    }
    public void deleteStudentByRollNo(int rollNo) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        if (head.rollNo == rollNo) {
            head = head.next;
            return;
        }
        StudentNode current = head;
        while (current.next != null && current.next.rollNo != rollNo) {
            current = current.next;
        }
        if (current.next == null) {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        } else {
            current.next = current.next.next;
        }
    }
    public StudentNode searchStudentByRollNo(int rollNo) {
        StudentNode current = head;
        while (current != null) {
            if (current.rollNo == rollNo) {
                return current;
            }
            current = current.next;
        }
        return null;
    }
    public void displayAllStudents() {
        if (head == null) {
            System.out.println("No students to display.");
            return;
        }
        StudentNode current = head;
        while (current != null) {
            System.out.println("Roll No: " + current.rollNo + ", Name: " + current.name + ", Age: " + current.age + ", Grade: " + current.grade);
            current = current.next;
        }
    }
    public void updateStudentGrade(int rollNo, char newGrade) {
        StudentNode student = searchStudentByRollNo(rollNo);
        if (student != null) {
            student.grade = newGrade;
            System.out.println("Student grade updated to: " + newGrade);
        } else {
            System.out.println("Student with Roll No " + rollNo + " not found.");
        }
    }
}
public class StudentRecordManagement {
    public static void main(String[] args) {
        StudentLinkedList list = new StudentLinkedList();        
        list.addStudentAtEnd(101, "Aarushi", 20, 'A');
        list.addStudentAtEnd(102, "Kanishka", 21, 'B');
        list.addStudentAtBeginning(100, "Vibhuti", 19, 'A');        
        System.out.println("Student Records:");
        list.displayAllStudents();       
        StudentNode student = list.searchStudentByRollNo(102);
        if (student != null) {
            System.out.println("Found Student - Roll No: " + student.rollNo + ", Name: " + student.name + ", Age: " + student.age + ", Grade: " + student.grade);
        } else {
            System.out.println("Student not found.");
        }        
        list.updateStudentGrade(101, 'A');       
        System.out.println("Updated Student Records:");
        list.displayAllStudents();      
        list.deleteStudentByRollNo(102);       
        System.out.println("Student Records after deletion:");
        list.displayAllStudents();     
        list.addStudentAtPosition(104, "David", 22, 'B', 1);        
        System.out.println("Student Records after adding at position:");
        list.displayAllStudents();
    }
}

