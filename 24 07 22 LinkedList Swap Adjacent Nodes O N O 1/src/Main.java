import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

class SwappAdjacentNodes{
    public static ListNode swapPairs(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode prev = dumy;
        while(prev.next != null && prev.next.next != null){
            ListNode first = prev.next;
            ListNode second = first.next;
            first.next = second.next;
            second.next = first;
            prev.next = second;
            prev = first;
        }

        return dumy.next;

    }

    public static ListNode createLinkedList(int[] values){
        if(values.length == 0){return null;}
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i = 1; i < values.length; i++){
            current.next = new ListNode(values[i]);
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
        System.out.println("Enter the elements of the LinkedLIst: ");
        for(int i = 0; i< n ;i++){
            values[i] = sc.nextInt();
        }
        ListNode head = createLinkedList(values);
        ListNode swappedHead = swapPairs(head);
        System.out.println("The Linked List after swapping: ");
        printList(swappedHead);
    }
}