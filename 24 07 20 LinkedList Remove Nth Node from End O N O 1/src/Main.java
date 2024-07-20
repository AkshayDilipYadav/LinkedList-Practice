import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){val =x;}
}

class LinkedList{
    public static void printLinkedList(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.val + "->");
            current = current.next;
        }
        System.out.println("Null");

    }
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

    public static ListNode removeNthFromEnd(ListNode head, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        for(int i =0; i<= n; i++){
            first = first.next;
        }
        while(first != null){
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the elements of the Linked List: ");
        String[] input = sc.nextLine().split(" ");
        int[] values = new int[input.length];
        for(int i = 0; i< input.length; i++){
            values[i] = Integer.parseInt(input[i]);
        }
        System.out.println("Enter the position of the node to remove from the end");
        int n = sc.nextInt();
        ListNode head = createLinkedList(values);
        System.out.println("Original Linked List: ");
        printLinkedList(head);
        head = removeNthFromEnd(head, n);
        System.out.println("Updated Linked List: ");
        printLinkedList(head);
    }

}