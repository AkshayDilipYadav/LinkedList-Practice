import java.util.Scanner;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

class MergeSortedLinkedLists{
    public static ListNode createLinkedList(int[] values){
        if(values.length == 0 ){return null;}
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i = 1; i< values.length; i++){
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2){
        ListNode dumy = new ListNode(0);
        ListNode current = dumy;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                current.next = l1;
                l1 = l1.next;
            }
            else{
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        if(l1 != null){current.next = l1;}
        else{current.next = l2;}
        return dumy.next;
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
        System.out.print("Enter the number of elements for first LinkedList : ");
        int n1 = sc.nextInt();
        int[] values1 = new int[n1];
        System.out.println("Enter the elements of first LinkedList: ");
        for(int i = 0; i< n1; i++){
            values1[i] = sc.nextInt();
        }
        System.out.print("Enter the number of elements for second LinkedList : ");
        int n2 = sc.nextInt();
        int[] values2 = new int[n1];
        System.out.println("Enter the elements of second LinkedList: ");
        for(int i = 0; i< n2; i++){
            values2[i] = sc.nextInt();
        }
        ListNode head1 = createLinkedList(values1);
        ListNode head2 = createLinkedList(values2);

        ListNode mergedList = mergeTwoLists(head1, head2);

        System.out.println("Merged LinkedList: ");
        printList(mergedList);

    }

}