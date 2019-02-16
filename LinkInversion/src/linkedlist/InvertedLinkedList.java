package linkedlist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class InvertedLinkedList<T> implements Iterable<T> {
    private class Node {
        public T data;
        public Node next;

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head;

    public InvertedLinkedList(){
        head = null;
    }

    public void insert(T data) {
        if(head == null) {
            head = new Node(data, null);
        } else {
            Node current = head;
            Node prev = null;
            while(current != null) {
                prev = current;
                current = current.next;
            }

            prev.next = new Node(data, null);
        }
    }

    public void invert() {
        Node temp = null;
        Node curr = head;
        Node prev = null;

        while(curr != null) {
            temp = prev;
            prev = curr;
            curr = curr.next;
            prev.next = temp;
        }

        head = prev;
    }

    public List<T> traverseForwardAndBackward() {
        Node temp = null;
        Node current = head;
        Node prev = null;
        List<T> result = new ArrayList<T>();

        //Go in the forward direction and set the links up for the backwards direction
        while(current != null) {
            result.add(current.data);
            temp = current;
            current = current.next;
            temp.next = prev;
            prev = temp;
        }

        //Go in the backwards direction and set the links up for the forward direction
        while(prev != null) {
            result.add(prev.data);
            temp = prev;
            prev = prev.next;
            temp.next = current;
            current = temp;
        }

        return result;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node current = head;

            public boolean hasNext() {
                return current != null;
            }

            public T next() {
                Node temp = current;
                current = current.next;
                return temp.data;
            }
        };
    }
}
