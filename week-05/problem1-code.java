// Approach1_HashMap.java
import java.util.*;

class Node {
    int val;
    Node next;
    Node random;
    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Approach1_HashMap {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        // Step 1: Map original nodes to cloned nodes
        Map<Node, Node> map = new HashMap<>();
        Node curr = head;
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // Step 2: Assign next and random pointers using the map
        curr = head;
        while (curr != null) {
            map.get(curr).next = map.get(curr.next);
            map.get(curr).random = map.get(curr.random);
            curr = curr.next;
        }

        // Return cloned head
        return map.get(head);
    }

    // Just for testing
    public static void main(String[] args) {
        // Create original list: 7 -> 13 -> 11 -> 10 -> 1
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n5;

        // Random pointers
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Approach1_HashMap obj = new Approach1_HashMap();
        Node cloneHead = obj.copyRandomList(n1);

        System.out.println("Original head: " + n1 + ", Clone head: " + cloneHead);
    }
}
