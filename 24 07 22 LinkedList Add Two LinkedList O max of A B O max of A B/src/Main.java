import java.util.Scanner;
class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
    }
}

class AddTwoNumbers{
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dumy = new ListNode(0);
        ListNode current = dumy;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int sum = carry;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;

            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            carry =  sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        return dumy.next;
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
        System.out.print("Enter the number of elements of First LinkedList: ");
        int n1 = sc.nextInt();
        int[] values1 = new int[n1];
        System.out.println("Enter the elements of the first LinkedList: ");
        for(int i = 0; i< n1; i++){
            values1[i] = sc.nextInt();
        }
        System.out.print("Enter the number of elements of second LinkedList: ");
        int n2 = sc.nextInt();
        int[] values2 = new int[n2];
        System.out.println("Enter the elements of the second LinkedList: ");
        for(int i = 0; i< n2; i++){
            values2[i] = sc.nextInt();
        }

        ListNode head1 = createLinkedList(values1);
        ListNode head2 = createLinkedList(values2);

        ListNode result = addTwoNumbers(head1, head2);
        System.out.println("Updated LinkedList: ");
        printList(result);
    }

}