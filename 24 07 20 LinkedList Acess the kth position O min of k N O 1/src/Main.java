import java.util.Scanner;

class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

class LinkedList{
    Node head;

    public void add(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }
        else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public int getKthElement(int k){
        if (k <= 0){
            throw new IllegalArgumentException("k must be greater than 0");
        }
        Node current = head;
        int count = 1;
        while(current != null && count < k){
            current = current.next;
            count++;
        }
        if(current == null){
            throw new IndexOutOfBoundsException("k is greater than the length of the list");
        }
        return current.data;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements: ");
        for(int i = 0; i< n; i++){
            int element = sc.nextInt();
            list.add(element);
        }

        System.out.print("Enter the position k: ");
        int k = sc.nextInt();
        try {
            int kthElement = list.getKthElement(k);
            System.out.println(k + " th element: "+ kthElement);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
}