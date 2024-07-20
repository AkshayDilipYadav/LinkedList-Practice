import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;

    public void add(int data){
        if(head == null){
            head = new Node(data);
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new Node(data);
    }

    private Node reverse(Node head){
        Node previous = null;
        Node current = head;
        Node next = null;
        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public boolean isPalindrome(){
        if(head == null || head.next == null){return true;}
        Node slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfHead = reverse(slow);
        Node firstHalfHead = head;
        while(secondHalfHead != null){
            if(firstHalfHead.data!= secondHalfHead.data){return false;}
            firstHalfHead = firstHalfHead.next;
            secondHalfHead = secondHalfHead.next;
        }
        return true;

    }

    public void display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: " );
        for(int i = 0; i< n; i++){
            list.add(sc.nextInt());
        }
        System.out.println("Original List: ");
        list.display();
        if(list.isPalindrome()){
            System.out.println("The Linked List is a Palindrome");
        }
        else{System.out.println("The Linked List is not a Palindrome");}
    }
}