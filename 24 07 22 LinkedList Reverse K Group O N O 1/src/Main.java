import java.util.Scanner;

class ListNode{
    int val;
    ListNode next;
    ListNode(int x){
        val = x;
        next = null;
    }
}

class Solution{
    public ListNode reverseKGroup(ListNode head, int B){
        if(head == null || B == 1){
            return head;
        }
        ListNode dumy = new ListNode(0);
        dumy.next = head;
        ListNode curr = dumy, nex = dumy, pre = dumy;
        int count = 0;
        while(curr.next != null){
            curr = curr.next;
            count++;
        }

        while(count >= B){
            curr = pre.next;
            nex = curr.next;
            for(int i = 1; i < B; i++){
                curr.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = curr.next;
            }
            pre = curr;
            count -= B;
        }
        return dumy.next;
    }

    public static void printList(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static ListNode createList(int[] values){
        if(values.length == 0){return null;}
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for(int i = 1; i< values.length; i++){
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        int[] values = new int[n];
        System.out.println("Enter the values: ");
        for(int i = 0; i< n; i++){
            values[i] = sc.nextInt();
        }

        System.out.println("Enter the value B : ");
        int B = sc.nextInt();
        ListNode head = createList(values);
        Solution solution = new Solution();
        ListNode newHead = solution.reverseKGroup(head, B);
        System.out.println("Updated LinkedList");
        printList(newHead);
    }

}