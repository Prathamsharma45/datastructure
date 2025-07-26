public class mergelink{
     Node head;

    // Node class
    public class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public static mergelink merge(mergelink first,mergelink second) {
        Node list1 = first.head;
        Node list2 = second.head;
        mergelink ans = new mergelink();

        while (list1 != null && list2 != null) {
            if (list1.data < list2.data) {
                ans.addLast(list1.data);
                list1 = list1.next;
            } else {
                ans.addLast(list2.data);
                list2 = list2.next;
            }
        }
        while (list1 != null) {
            ans.addLast(list1.data);
            list1 = list1.next;
        }
        while (list2 != null) {
            ans.addLast(list2.data);
            list2 = list2.next;
        }

        return ans;
    }

    public void printList() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
 
         mergelink first=new mergelink();
         mergelink second=new mergelink();
    
        first.addLast(1);

    first.addLast(2);
    first.addLast(5);

    second.addLast(1);
    
    second.addLast(3);
    second.addLast(9);
    
    second.addLast(14);

        mergelink ans= mergelink.merge(first, second);
         ans.printList(); 
        // Output: 4 -> 6 
}
}