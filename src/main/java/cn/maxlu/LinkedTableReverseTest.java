package cn.maxlu;

/**
 * Created by luwei on 2017/5/25.
 */
public class LinkedTableReverseTest {

    public static void main(String[] args) throws Exception {
        Node node1 = new Node(1);
        Node node2 = new Node(2, node1);
        Node node3 = new Node(3, node2);
        Node node4 = new Node(4, node3);
        Node node5 = new Node(5, node4);
        Node node6 = new Node(6, node5);

        print(node6);

//        Node reverse = reverse(node6);
        Node reverse = reverse2(node6);
        print(reverse);

    }

    private static void print(Node head) {
        System.out.println(head);
        while (head.hasNext()) {
            Node next = head.getNext();
            System.out.println(next);
            head = next;
        }
    }

    private static Node reverse(Node current) {
        Node next = current.next;
        if (next == null) {
            return current;
        }

        current.next = null;

        Node restReverse = reverse(next);

        next.next = current;

        return restReverse;
    }

    private static Node reverse2(Node current) {
        Node prev = null;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;

            prev = current;
            current = next;
        }
        return prev;
    }

    private static class Node {
        private Object value;

        private Node next;

        public Node(Object value) {
            this(value, null);
        }

        public Node(Object value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Object getValue() {
            return value;
        }

        public void setValue(Object value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public boolean hasNext() {
            return next != null;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }


}
