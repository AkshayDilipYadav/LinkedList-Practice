import java.util.Scanner;
//1. Constructor to initialize a node
class Node{
    int data;
    Node next;
    public Node(int data){
        this.data = data;
        this.next = null;
    }
}

// 2. Method of creating LinkedList
class LinkedList{
    Node head;
    //a. new Node at beginning

    //b. new node at the end of the list
    public void addAtEnd(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    //c. add a new Node at a specific position
    public void addAtPosition(int data, int position){
        if(position <= 0){
            throw new IllegalArgumentException("Position must be greater than 0");
        }
        Node newNode = new Node(data);
        if(position == 1){
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        for(int i = 1; i < position -1 && current != null; i++){
            current = current.next;
        }
        if(current == null){
            throw new IndexOutOfBoundsException("Position is greater than the length of the list");
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    public void display(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        LinkedList list = new LinkedList();
        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();
        System.out.println("Enter the elements: ");
        for(int i = 0; i< n; i++){
            int element = sc.nextInt();
            list.addAtEnd(element);
        }

        System.out.println("Enter the element: ");
        int element = sc.nextInt();

        System.out.println("Enter the position");
        int position = sc.nextInt();

        try{list.addAtPosition(element, position);}
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        System.out.println("Final Linked List: ");
        list.display();
    }
}