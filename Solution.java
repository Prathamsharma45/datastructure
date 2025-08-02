class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    // Head of the linked list
    ListNode head;

    // Add at beginning
    public void addFirst(int data) {
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
    }

    // Add at end
    public void addLast(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Print the list
    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Detect cycle
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // Length of cycle
    public int lengthCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode temp = slow;
                int length = 0;
                do {
                    temp = temp.next;
                    length++;
                } while (temp != slow);
                return length;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution list = new Solution();

        // Test addFirst and addLast
        list.addFirst(3);
        list.addFirst(2);
        list.addFirst(1);
        
        list.printList();
         // List: 1 -> 2 -> 3
        list.addLast(4);  // List: 1 -> 2 -> 3 -> 4
        list.addLast(5);  // List: 1 -> 2 -> 3 -> 4 -> 5

        // Print the list
        list.printList(); // Output: 1 -> 2 -> 3 -> 4 -> 5 -> null

        // Test cycle functions (no cycle in this list)
        System.out.println("Has Cycle? " + list.hasCycle(list.head)); // false
        System.out.println("Cycle Length: " + list.lengthCycle(list.head)); // 0
    }
}
