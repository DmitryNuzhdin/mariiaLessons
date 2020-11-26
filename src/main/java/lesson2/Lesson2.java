package lesson2;

import java.util.*;

public class Lesson2 {
    public static void main(String[] args) {

        List<String> arrayList = new ArrayList<>();
        arrayList.get(1);
        LinkedList<String> linkedList = new LinkedList<>();
        //linkedList.get(1000);
        new Node<String>(new Node<>(new Node(null, "3"), "2"), "1");

        Map<Integer, String> hashMap = new HashMap<>();
        hashMap.put(1, "AAAA");
        hashMap.put(1, "BBB");
        System.out.println(hashMap.get(1));


        Map<Integer, String> treeMap = new TreeMap<>();

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();

    }
}


class Node<E> {
    public Node(Node<E> next, E data) {
        this.next = next;
        this.data = data;
    }

    Node<E> next;
    E data;
}