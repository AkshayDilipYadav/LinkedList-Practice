import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}
class middleLinkedList{
    public static ListNode createLinkedList(int[] values){
        if(values.length == 0){return null;}
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i = 1; i< values.length; i++){
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
    public static int findMiddleElement(ListNode head){
        if(head == null){return -1;}
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;
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
        int middleElement = findMiddleElement(head);
        System.out.println("The Middle element is: " + middleElement);
    }
}