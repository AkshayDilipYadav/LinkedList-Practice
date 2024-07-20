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
    public void delete(int data){
        if(head == null){return;}
        if(head.data == data){
            head = head.next;
            return;
        }
        Node current = head;
        while(current.next != null && current.next.data != data)
        {
            current = current.next;
        }
        if(current.next != null){
            current.next = current.next.next;
        }
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
        System.out.println("Enter the elements");
        for(int i = 0; i< n; i++){
            list.add(sc.nextInt());
        }
        System.out.println("Original linked list: ");
        list.display();
        System.out.println("Enter the value to be deleted: ");
        int value = sc.nextInt();
        list.delete(value);
        System.out.println("Updated linked list: ");
        list.display();
    }
}