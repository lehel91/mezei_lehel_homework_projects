package mystack;

import java.util.ArrayList;
import java.util.List;
import mystack.exceptions.EmptyContainerException;
import mystack.tester_classes.Speakable;

public class MyStack<T extends Speakable & Comparable> {

    private List<T> container;
    public static final int MAX_SIZE = 10;

    public MyStack() {
        this.container = new ArrayList<T>();
    }

    public int size() {
        return this.container.size();
    }

    public boolean put(T element) {
        if (size() == MAX_SIZE) {
            System.out.println("The stack is full, you can't add more elements!");
            return false;
        }

        if (this.container.isEmpty()) {
            this.container.add(element);
            return true;
        }

        int i = 0;

        while (i <= this.container.size() - 1) {
            if (this.container.get(i).compareTo(element) == 0) {
                return false;
            }
            i++;
        }

        this.container.add(element);
        return true;
    }

    public T pop() throws EmptyContainerException {

        int youngest = size() - 1;

        if (youngest == -1) {
            throw new EmptyContainerException();
        }

        T objectToReturn = this.container.get(youngest);
        this.container.remove(youngest);
        return objectToReturn;

    }

    public T top() throws EmptyContainerException {
        int youngest = size() - 1;

        if (youngest == -1) {
            throw new EmptyContainerException();
        }

        return this.container.get(youngest);
    }

    @Override
    public String toString() {
        String elements = "";

        for (int i = 0; i < size(); i++) {
            elements += this.container.get(i) + "\n";
        }

        return elements;
    }

}
