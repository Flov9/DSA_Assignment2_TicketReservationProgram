/*
Name: Loo Sai Hong
Matric no.: 209012
Date: 2 December 2022
 */

public class MyLinkedList<E> {
    private Node<E> first, last;
    private int size = 0;

    public MyLinkedList() {

    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = first; // link the new node with the head
        first = newNode; // head points to the new node
        size++; // Increase list size

        if (last == null) // the new node is the only node in list
            last = first;
    }

    public void addLast(E e) {
        // If there is no node then create a new node
        if (last == null) {
            first = last = new Node<>(e);
        }
        else {
            last.next = new Node<>(e); // current last points to a new node
            last = last.next; // new node becomes current last
        }

        size++;
    }

    public E removeFirst() {
        // If there is nothing in the linked list return null
        if (size == 0) {
            return null;
        }
        else {
            E temp = first.element; // Assign first element to temp to be returned at the end
            first = first.next; // Assign next node as the new first
            size--;

            // If the new first is null then last is also null
            if (first == null) {
                last = null;
            }
            return temp;
        }
    }

    public E removeLast() {
        // If there is nothing in the linked list return null
        if (size == 0) {
            return null;
        }
        else if (size == 1) {
            E temp = first.element; // Assign first element to temp to be returned at the end
            first = last = null;
            size = 0;
            return temp;
        }
        else {
            Node<E> current = first; // Set first element to current

            // loop til the last second node
            for (int i = 0; i < size - 2; i++) {
                current = current.next;
            }

            E temp = last.element; // Assign last element to temp to be returned at the end
            last = current; // current is now assigned to last
            last.next = null; // last points to null
            size--;
            return temp;
        }
    }

    public E remove(int index) {
        // If no such index
        if (index < 0 || index >= size) {
            return null;
        }
        else if (index == 0) { // If index is first
            return removeFirst();
        }
        else if (index == size - 1) { // If index is last
            return removeLast();
        }
        else {
            Node<E> previous = first; // Assign first to previous

            // Loop til right before the node that is to be deleted
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }

            Node<E> current = previous.next; // Assign the node to be deleted to current node
            previous.next = current.next; // Point the previous node to the next node current node is pointing to
            size--;

            return current.element;
        }
    }

    public boolean contains(E e) {
        Node<E> current = first; // Assign first pointer to current node

        while (current != null) { // Loop through the entire linked list
            if (current.element.equals(e)) // Check if the element exists or not
                return true;

            current = current.next;
        }

        return false;
    }

    public int indexOf(E e) {
        int index = 0;
        Node<E> current = first; // Assign first pointer to current node

        while (current != null) { // Loop through the entire linked list
            if (current.element.equals(e)) {
                return index;
            }

            current = current.next;
            index++; // index increment by 1 for every iteration
        }

        return -1;
    }
}

// Generic type node for the linked list, will be known as Ticket in the main application
class Node<E> {
    E element;
    Node<E> next;

    public Node(E e) {
        element = e;
    }
}