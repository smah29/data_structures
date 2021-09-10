class linkedList {
    Node head;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) return null;
        Node middle = findMiddle(head);
        Node nextOfMiddle = middle.next;
        middle.next = null;
        Node left = mergeSort(head);
        Node right = mergeSort(nextOfMiddle);
        Node sortedNode = sortedMerged(left, right);
        return sortedNode;
    }

    private Node sortedMerged(Node a, Node b) {
        Node result = null;
        if (a == null) return b;
        if (b == null) return a;
        if (a.data <= b.data) {
            result = a;
            result.next = sortedMerged(a.next, b);
        } else {
            result = b;
            result.next = sortedMerged(a, b.next);
        }
        return result;

    }

    private Node findMiddle(Node head) {
        if (head == null) return null;
        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }
}

public class MergeSortLinkedList {
    public static void main(String[] args) {
        linkedList li = new linkedList();
        /*
         * Let us create a unsorted linked list to test the functions
         * created. The list shall be a: 2->3->20->5->10->15
         */
        li.push(15);
        li.push(10);
        li.push(5);
        li.push(20);
        li.push(3);
        li.push(2);

        // Apply merge Sort
        li.head = li.mergeSort(li.head);
        System.out.print("\n Sorted Linked List is: \n");
        li.printList(li.head);
    }

}
