// ? https://leetcode.com/problems/lru-cache/?envType=study-plan-v2&envId=top-interview-150

//! 146. LRU Cache
// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
// Implement the LRUCache class:
// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
// int get(int key) Return the value of the key if the key exists, otherwise return -1.
// void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
// The functions get and put must each run in O(1) average time complexity.

// Example 1:
// Input
// ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
// [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
// Output
// [null, null, null, 1, null, -1, null, -1, 3, 4]

import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Node;

public class LRUCache {

    class LRUCache {
        static class Node {
            int key, value;
            Node next, prev;

            Node(int k, int v) {
                key = k;
                value = v;
            }

        }

        private static int capacity;
        private static Map<Integer, Node> map;
        private static Node head, tail;

        LRUCache(int cap) {
            capacity = cap;
            map = new HashMap<>();
            head = new Node(0, 0);
            tail = new Node(0, 0);
            head.next = tail;
            tail.prev = head;

        }

        public static int get(int key) {
            if (!map.containsKey(key)) {
                return -1;
            }

            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        }

        public static void put(int key, int value) {
            if (map.containsKey(key)) {
                Node existing = map.get(key);
                existing.value = value;
                remove(existing);
                insert(existing);
            } else {
                if (capacity == map.size()) {
                    Node lru = tail.prev;
                    remove(lru);
                    map.remove(lru.key);
                }
                Node node = new Node(key, value);
                insert(node);
                map.put(key, node);
            }
        }

        public static void remove(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // insert at first
        public static void insert(Node node) {
            node.next = head.next;
            head.next.prev = node;
            head.next = node;
            node.prev = head;
        }

    }
}
