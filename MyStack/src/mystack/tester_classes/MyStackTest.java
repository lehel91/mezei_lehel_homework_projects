package mystack.tester_classes;

import mystack.MyStack;
import mystack.exceptions.EmptyContainerException;

public class MyStackTest {

    public static void main(String[] args) {
        try {
            MyStack<Teacher> teachers = new MyStack<Teacher>();
            MyStack<Student> students = new MyStack<>();

            students.put(new Student("Kovacs Lajos", 34));
            students.put(new Student("Kovacs Peter", 35));
            students.put(new Student("Kovacs Erno", 36));
            students.put(new Student("Kovacs Kazmer", 37));
            students.put(new Student("Kovacs Ferenc", 38));
            System.out.println("The number of students in the class " + students.size());
            System.out.println(students);

            System.out.println("Now we are banning out the newcomer: " + students.pop());
            System.out.println("");
            System.out.println(students);
            System.out.println("");

            System.out.println("Now we are just showing the actual newcomer: " + students.top());
            System.out.println("");
            System.out.println(students);

            teachers.pop();

        } catch (EmptyContainerException ece) {
            System.out.println(ece.getMessage());
        }
    }
}
