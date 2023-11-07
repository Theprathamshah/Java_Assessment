import java.util.Scanner;

class Node {
    int data;
    Node next;

    public Node() {

    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    public static Node mergeSortedLinkedList(Node head1, Node head2) {
        Node dummyNode = new Node();

        Node tail = dummyNode;

        while (true) {

            if (head1 == null) {
                tail.next = head2;
                break;
            }

            if (head2 == null) {
                tail.next = head1;
                break;
            }

            if (head1.data <= head2.data) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                tail.next = head2;
                head2 = head2.next;
            }

            tail = tail.next;
        }
        return dummyNode.next;
    }

    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head1 = null, tail1 = null, head2 = null, tail2 = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of element for first list");
        int list1_length = sc.nextInt();
        for (int i = 0; i < list1_length; i++) {
            if (head1 == null) {
                head1 = new Node(sc.nextInt());
                tail1 = head1;
            } else {
                tail1.next = new Node(sc.nextInt());
                tail1 = tail1.next;
            }
        }

        System.out.println("Enter number of element for second list");
        int list2_length = sc.nextInt();
        for (int i = 0; i < list2_length; i++) {
            if (head2 == null) {
                head2 = new Node(sc.nextInt());
                tail2 = head2;
            } else {
                tail2.next = new Node(sc.nextInt());
                tail2 = tail2.next;
            }
        }

        printList(mergeSortedLinkedList(head1, head2));
        sc.close();
    }
}
