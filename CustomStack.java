package tp2ex2;

import java.util.Scanner;
public class CustomStack {
    Object[] S;
    Object head;
    int capacity;
    int nbElements = 0;

    public CustomStack(int capacity) {
        this.capacity = capacity;
        S = new Object[capacity];
        head = null;
    }

    public void addElement(Object element) {
        if (stackIsFull()) {
            System.out.println("Stack is Full");
        } else {
            if (stackIsEmpty()) {
                head = element;
                S[capacity - 1] = element;
                nbElements += 1;
            } else {
                head = element;
                S[capacity - nbElements] = element;
                nbElements += 1;
            }
        }
       
    }

    public void removeElement() {
        if (stackIsEmpty()) {
            System.out.println("Stack is Empty");
        } else {
            if (nbElements == 1) {
                nbElements -= 1;
                head = null;
            } else {
            	for (int i=0;i<nbElements-1;i++)
            		S[i]=S[i+1];
            	
                head = S[capacity - nbElements];
            	nbElements -= 1;
            }
        }
        
    }

    public Object lastInStack() {
        return S[capacity - 1];
    }

    public boolean stackIsEmpty() {
        return (nbElements == 0);
    }

    public boolean stackIsFull() {
        return (nbElements == capacity);
    }

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Give the capacity of the Stack");
    int n = sc.nextInt();
    sc.nextLine(); 
    CustomStack stack = new CustomStack(n);
    for (int i = 0; i < n; i++) {
        System.out.print("Enter an object: ");
        String el = sc.nextLine();
        Object userObject = (Object) el;
        stack.addElement(el);
    }
        System.out.println("Last in stack: " + stack.lastInStack());

        stack.removeElement();
        System.out.println("Last in stack after removal: " + stack.lastInStack());
        System.out.println("First in stack after removal: " + stack.head);
        

        System.out.println("Is stack empty? " + stack.stackIsEmpty());
        System.out.println("Is stack full? " + stack.stackIsFull());
    }
}
