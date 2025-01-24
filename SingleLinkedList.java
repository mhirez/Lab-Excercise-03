/**
 *  @assignment LAB EXCERCISE 03
 *
 *  @author      STUDENT'S NAME: MOHMMED R H HIREZ
 *               STUDENT'S NO:   1 2022 0519
 *
 *  @instructor  Dr. Eyad El-Masri
 *
 *  @course      BSAI2121 Data Structures and Algorithm Analysis - Lab
 *
 *  @date        24 Jan 2025
 */


public class SingleLinkedList {


    public static void main(String[] args) {
        

        SingleLinkedList list = new SingleLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(10);
        list.addLast(30);
        list.addLast(40);

        System.out.println("Initial List:");
        list.display();


        boolean removed = list.remove(20);
        System.out.println("Removed 20? " + removed);
        list.display();

        System.out.println("Sum of items: " + list.getSum());

        int valueToCount = 10;
        int count = list.countOccurrences(valueToCount);
        System.out.println("Occurrences of " + valueToCount + ": " + count);


        SingleLinkedList list2 = new SingleLinkedList();
        list2.addLast(10);
        list2.addLast(10);
        list2.addLast(30);
        list2.addLast(40);

        System.out.println("Is list identical to list2? " + list.isIdentical(list2));

        System.out.println("Removing duplicates from first list...");
        list.removeDuplicates();
        list.display();

        System.out.println("Deleting the entire list...");
        list.deleteList();
        list.display();
    }


    private Node head;

    public SingleLinkedList() {
        this.head = null;
    }

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    


    public void addLast(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }


    public void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        System.out.print("List Items: ");
        Node current = head;
        while (current != null) {
            System.out.print(current.data + (current.next != null ? " -> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public boolean remove(int value) {

        if (head == null) {
            return false;
        }

        if (head.data == value) {
            head = head.next;
            return true;
        }

        Node current = head;
        while (current.next != null && current.next.data != value) {
            current = current.next;
        }

        if (current.next == null) {
            return false;
        }

        current.next = current.next.next;
        return true;
    }

    public int getSum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }


    public void deleteList() {
        head = null;
    }


    public int countOccurrences(int value) {
        int count = 0;
        Node current = head;
        while (current != null) {
            if (current.data == value) {
                count++;
            }
            current = current.next;
        }
        return count;
    }


    public boolean isIdentical(SingleLinkedList other) {
        Node current1 = this.head;
        Node current2 = other.head;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return (current1 == null && current2 == null);
    }

    public void removeDuplicates() {
        Node current = head;
        while (current != null) {
            Node runner = current;
            while (runner.next != null) {
                if (runner.next.data == current.data) {
                    // Remove the duplicate node
                    runner.next = runner.next.next;
                } else {
                    runner = runner.next;
                }
            }
            current = current.next;
        }
    }
}
