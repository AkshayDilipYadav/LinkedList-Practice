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
    public ListNode reverseBetween(ListNode A, int B, int C){
        if(A == null || B == C){return A;}
        ListNode dumy = new ListNode(0);
        dumy.next = A;
        ListNode prev = dumy;
        for(int i = 1; i< B; i++){
            prev = prev.next;
        }
        ListNode start = prev.next;
        ListNode then = start.next;

        for(int i =0; i< C -B; i++){
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }
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
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode current = head;
        for(int i = 1; i< n; i++){
            current.next = new ListNode(sc.nextInt());
            current = current.next;
        }

        System.out.println("Enter the positions B and C: ");
        int B = sc.nextInt();
        int C = sc.nextInt();

        Solution solution = new Solution();
        System.out.println("Original List: ");
        printList(head);
        ListNode result = solution.reverseBetween(head, B, C);
        System.out.println("Modified List: ");
        printList(result);


    }

}