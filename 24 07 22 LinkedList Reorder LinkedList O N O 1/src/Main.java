import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val = x;}
}

class ReorderList{
    public static void reorderList(ListNode head){
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode mid = findMiddle(head);
        ListNode secondHalf = mid.next;
        mid.next = null;
        secondHalf = reverseList(secondHalf);
        mergeLists(head, secondHalf);
    }
    private static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static void mergeLists(ListNode firstHalf, ListNode secondHalf){
        ListNode p1 = firstHalf;
        ListNode p2 = secondHalf;
        while(p2 != null){
            ListNode temp1 = p1.next;
            ListNode temp2 = p2.next;
            p1.next = p2;
            p2.next = temp1;
            p1 = temp1;
            p2 = temp2;
        }
    }

    public static ListNode createLinkedList(int[] values){
        if(values.length == 0){
            return null;
        }
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i = 1; i< values.length; i++){
            current.next = new ListNode (values[i]);
            current = current.next;
        }
        return head;
    }

    public static void printList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] values = new int[n];
        System.out.println("Enter the elements of LinkedList: ");
        for(int i = 0; i< n; i++){
            values[i] = sc.nextInt();
        }
        ListNode head = createLinkedList(values);
        reorderList(head);
        System.out.println("The reordered LinkedList: ");
        printList(head);
    }

}