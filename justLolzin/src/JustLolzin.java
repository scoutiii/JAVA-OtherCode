import java.util.Scanner;

/****************
 * This is my just lolzin program
 * This is for lecture practice and such
 * You know, just for lolzin around
 ****************/

public class JustLolzin {
    public static void main(String[] args) {

    LinkedList<String> words = new LinkedList<>();

    words.insert("A");
    words.insert("BEE");
    words.insert("bee");
    words.insert("another words");

    words.printList();

    System.out.println(words.getSize());

    words.delete("A");

    words.printList();

    System.out.println(words.getSize());

    words.delete("bee");

    words.printList();

    System.out.println(words.getSize());

    System.out.println(words.search("BEE"));

    }

}

class LinkedList <E extends Comparable<E>>{

    private ListNode<E> head = new ListNode<>();
    private int size = 0;

    public void insert(E value) {
        ListNode<E> previous = head;
        ListNode<E> current  = head.next;
        ListNode<E> node     = new ListNode(value);

        while(current != null && current.value.compareTo(node.value) < 0) {
            previous = current;
            current  = current.next;
        }

        previous.next = node;
        node.next  = current;
        this.size++;
    }

    public void delete(E value) {
        ListNode<E> previous = head;
        ListNode<E> current = head.next;

        while(!current.value.equals(value)) {
            current = current.next;
            previous = previous.next;
        }
        previous.next = current.next;
        this.size--;
    }

    public void printList() {
        for(ListNode<E> temp = head.next; temp != null; temp = temp.next) {
            System.out.println(temp.value);
        }
        System.out.println();
    }

    public boolean search(E value) {
        boolean found = false;
        for(ListNode<E> temp = head.next; temp != null && !found; temp = temp.next) {
            if(temp.value == value) {
                found = true;
            }
        }
        return found;
    }

    public int getSize() {
        return this.size;
    }

    private class ListNode<E> {
        public E value;
        public ListNode<E> next;

        public ListNode() {

        }
        public ListNode(E value) {
            this.value = value;
        }
    }

}




