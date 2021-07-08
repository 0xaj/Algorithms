package linkedlist;

import java.util.HashSet;

public class lists {
       static  Node head;

    public static void main(String[] args) {

        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);

        n1.setNext(n2);
        n2.setNext(n3);
        n3.setNext(n4);
        n4.setNext(null);
       // print(n1);
        //reverseLL(n1);
        print(reverseK(n1,2));
    }

    private static Node reverseK(Node n1, int k) {
        Node curr = n1;
        Node prev = null;
        System.out.println(prev);
        int count  = 0;
        Node temp = null;
        while(count++ < k && curr != null){

           temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        print(prev);
        if(temp!=null)
       n1.next = reverseK(curr,k);
        return prev;
    }

    private static void reverseLL(Node n1) {
        Node prev = null;
        Node curr = n1;
        while(curr != null){
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;

        }
        System.out.println();
        print(prev);
    }

    private static void print(Node n) {
        System.out.println();
       Node temp = n;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }
    void removeDuplicates()
    {
        /*Another reference to head*/
        Node curr = head;

        /* Traverse list till the last node */
        while (curr != null) {
            Node temp = curr;
            /*Compare current node with the next node and
            keep on deleting them until it matches the current
            node data */
            while(temp!=null && temp.data==curr.data) {
                temp = temp.next;
            }
            /*Set current node next to the next different
            element denoted by temp*/
            curr.next = temp;
            curr = curr.next;
        }
    }
    static void removeDuplicate(Node head)
    {
        // Hash to store seen values
        HashSet<Integer> hs = new HashSet<>();

        /* Pick elements one by one */
        Node current = head;
        Node prev = null;
        while (current != null)
        {
            int curval = current.data;

            // If current value is seen before
            if (hs.contains(curval)) {
                prev.next = current.next;
            } else {
                hs.add(curval);
                prev = current;
            }
            current = current.next;
        }

    }
}


class Node{
    Node next;
    int data;
    Node(int data){
        this.data = data;
        this.next = null;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }
}