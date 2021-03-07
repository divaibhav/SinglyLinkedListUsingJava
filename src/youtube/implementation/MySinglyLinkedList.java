package youtube.implementation;

public class MySinglyLinkedList {
    //head
    private Node head;
    //tail
    private Node tail;
    //size - number of nodes in linked list
    private int size;

    public boolean isEmpty(){
        return head == null;
    }
    public int size(){
        return size;
    }
    //insert
    //insertAtHead
    public void addFirst(int element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            node.setNext(head);
            head = node;
        }
        size++;
    }
    //insert
    //insertAtEnd
    //O(1)
    public void addLast(int element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            tail = node;
        }
        else{
            tail.setNext(node);
            tail = node;
        }
        size++;
    }
    //delete
    //deleteFirst
    //DeleteFromHead
    public Node removeFirst(){
        Node deleted = null;
        if(!isEmpty()){
            deleted = new Node(head.getData());
            //single node, we have to update head as well tail
            if(size == 1){ // if(head == tail)
                head = null;
                tail = null;
            }
            //multiple nodes, then head only update
            else{
                head = head.getNext();
            }
            size--;
        }
        return deleted;
    }

    //traversal of linked list
    public void traverse(){
        System.out.println("printing linked list elements");
        System.out.print("head -->");
        Node temp = head;
        while (temp != null){
            System.out.print(temp.getData() + "-->");
            temp = temp.getNext();
        }
        System.out.println("null");
    }

    //deleteLast
    //deleteFromEnd
    public Node removeLast(){
        Node deleted = null;
        if(!isEmpty()){
            deleted = new Node(tail.getData());
            //traversing and finding the second last node
            Node temp = head;
            Node previous = null;
            while (temp.getNext() != null){
                previous = temp;
                temp = temp.getNext();
            }
            if(previous == null){
                //single node
                head = null;
                tail = null;
            }
            else{
                //multiple node
                previous.setNext(null);
                tail = previous;
            }
            size--;
        }
        return deleted;
    }

    //insert at last, without using tail reference
    //O(n)
    public void addLastWithOutUsingTail(int element){
        Node node = new Node(element);
        if(isEmpty()){
            head = node;
            //update tail also
            tail = node;
        }
        else{
            Node temp = head;
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(node);
            //update tail
            tail = node;
        }
        size++;
    }
    //search
    public boolean search(int searchElement){
        boolean response = false;
        Node temp = head;
        while(temp != null){
            if(temp.getData() == searchElement){
                response = true;
                break;
            }
            temp = temp.getNext();

        }
        return response;
    }
    //insertAfterGivenNode
    public boolean addAfterGivenNode(int element, int givenElement){
        boolean response = false;
        Node temp = head;
        while (temp != null){
            if(temp.getData() == givenElement){
                break;
            }
            temp = temp.getNext();
        }
        if(temp != null){
            Node node = new Node(element);
            node.setNext(temp.getNext());
            temp.setNext(node);
            response = true;
            size++;
            //check if temp is last node, then tail must refer to node
            if(temp == tail){
                tail = node;
            }
        }
        return response;
    }

    //addBeforeGivenNode
    //InsertInBetween
    public boolean addBeforeGivenNode(int element, int givenElement){
        boolean response = false;
        Node temp = head;
        Node previous = null;
        while (temp != null){
            if(temp.getData() == givenElement){
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }
        if(temp != null){
            Node node = new Node(element);
            node.setNext(temp);
            response = true;
            size++;
            if(previous == null){
                //adding at head
                head = node;
            }
            else{
                previous.setNext(node);
            }
        }


        return response;
    }

    //deleteGivenElement
    public Node removeGivenNode(int givenElement){
        Node deleted = null;
        Node temp = head;
        Node previous = null;
        while (temp != null){
            if(temp.getData() == givenElement){
                break;
            }
            previous = temp;
            temp = temp.getNext();
        }
        //if givenElement is present in linked list
        if(temp != null){
            deleted = new Node(temp .getData());
            //deleting node is head
            if(previous == null){
                head = head.getNext();
                //if only single node and is deleted, head becomes null
                if(head == null){
                    tail = null;
                }
            }
            else{
                previous.setNext(temp.getNext());
                //if temp is the last node, update the tail
                if(temp == tail){
                    tail = previous;
                }
            }
            size--;
        }

        return deleted;
    }
}
