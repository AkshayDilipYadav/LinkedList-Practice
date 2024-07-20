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
        Node newNode  = new Node(data);
        if(head == null){head = newNode;}
        else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public boolean contains(int x){
        Node current = head;
        while (current != null){
            if(current.data == x){
                return true;
            }
            current = current.next;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the elements");
        for(int i = 0; i< n; i++){
            int element = sc.nextInt();
            list.add(element);
        }
        System.out.println(" Enter the value to check : ");
        int x = sc.nextInt();
        boolean contains = list.contains(x);
        if(contains){System.out.println("The List contains the value " + x);}
        else{System.out.println("The list does not contain the value "+ x);}
    }
}