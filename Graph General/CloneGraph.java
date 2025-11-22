


import java.util.*;

import org.w3c.dom.Node;

public class CloneGraph {
    // Definition for a Node.
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //? using HashMap to store the mapping between original and cloned nodes
    class Solution {
        HashMap<Node, Node> mp = new HashMap<>();

        private Node cloneUtil(Node node) {
            Node cloned = new Node(node.val);
            mp.put(node, cloned);

            for (Node neighbor : node.neighbors) {
                if (!mp.containsKey(neighbor)) {
                    cloned.neighbors.add(cloneUtil(neighbor));
                } else {
                    cloned.neighbors.add(mp.get(neighbor));
                }
            }
            return cloned;
        }

        public Node cloneGraph(Node node) {
            if (node == null) {
                return null;
            }
            return cloneUtil(node);
        }
    }

    // ? using DFS 
    // class Solution {
    //     Map<Node, Node> map = new HashMap<>();

    //     public Node cloneGraph(Node node) {
    //         if (node == null)
    //             return null;
    //         if (map.containsKey(node))
    //             return map.get(node);
    //         Node new1 = new Node(node.val, new ArrayList<>());
    //         map.put(node, new1);
    //         for (Node n : node.neighbors) {
    //             new1.neighbors.add(cloneGraph(n));
    //         }
    //         return new1;
    //     }
    // }

    public static void main(String[] args) {
        CloneGraph cg = new CloneGraph();
        Solution solution = cg.new Solution();

        Node node1 = cg.new Node(1);
        Node node2 = cg.new Node(2);
        Node node3 = cg.new Node(3);
        Node node4 = cg.new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);
        node2.neighbors.add(node1);
        node2.neighbors.add(node3);
        node3.neighbors.add(node2);
        node3.neighbors.add(node4);
        node4.neighbors.add(node1);

        Node clonedGraph = solution.cloneGraph(node1);
        System.out.println("Cloned graph node value: " + clonedGraph.val);
    }

}
