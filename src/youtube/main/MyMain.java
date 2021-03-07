package youtube.main;

import youtube.implementation.MySinglyLinkedList;

public class MyMain {
    public static void main(String[] args) {
        MySinglyLinkedList linkedList = new MySinglyLinkedList();
        linkedList.addFirst(10);
        linkedList.addLast(20);
        linkedList.traverse();
        //linkedList.removeFirst();
        linkedList.traverse();
        //linkedList.removeLast();
        linkedList.traverse();
        System.out.println(linkedList.addAfterGivenNode(100, 10));
        System.out.println(linkedList.addBeforeGivenNode(170, 20));
        linkedList.traverse();
        System.out.println(linkedList.addBeforeGivenNode(500, 10));
        System.out.println(linkedList.addAfterGivenNode(690, 20));
        linkedList.traverse();
        System.out.println(linkedList.search(690));
        System.out.println(linkedList.search(1000));
        linkedList.removeGivenNode(690);
        linkedList.traverse();
        linkedList.addLastWithOutUsingTail(590);
        linkedList.traverse();
    }
}
