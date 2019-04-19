package leetcode.Q146_LRUCache;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private final int capacity;
    private Map<Integer, Node> cacheMap = new HashMap<>();
    private Node dummyHead = new Node(-1, -1);
    private Node dummyTail = new Node(-1, -1);

    public Solution(int capacity) {
        this.capacity = capacity;
        link(dummyHead, dummyTail);
    }


    public int get(int key) {
        if (!cacheMap.containsKey(key)) {
            return -1;
        }

        Node node = cacheMap.get(key);
        unlink(node);
        unshift(node);
        return node.val;
    }

    public void put(int key, int value) {
        if (cacheMap.containsKey(key)) {
            Node node = cacheMap.get(key);
            node.val = value;
            unlink(node);
            unshift(node);
        } else {
            if (cacheMap.size() == capacity && dummyTail.prev != dummyHead) {
                removeLast();
            }
            Node node = new Node(key, value);
            unshift(node);
            cacheMap.put(key, node);
        }
    }

    private void link(Node n1, Node n2) {
        n1.next = n2;
        n2.prev = n1;
    }

    private void unlink(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void unshift(Node node) {
        Node next = dummyHead.next;
        link(dummyHead, node);
        link(node, next);
    }

    private void removeLast() {
        Node last = dummyTail.prev;
        cacheMap.remove(last.key);
        unlink(last);
    }
}
