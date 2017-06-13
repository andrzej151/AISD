package Grafy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DisJointSet <V> {
    public static class Node<V> {
        private V value;
        private Node<V> parent;
        private int rank;

        public Node (V value) {
            this.value = value;
            this.parent = this;
            this.rank = 0;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return value.toString();
        }
    }

    private ArrayList<Node<V>> set;

    public DisJointSet() {
        set = new ArrayList<>();
    }

    public void makeSet (V value) {
        set.add(new Node<>(value));
    }

    public void union (V firstValue, V secondValue) {
        Node<V> firstNode = findNode(firstValue);
        Node<V> secondNode = findNode(secondValue);

        if (firstNode == null || secondNode == null)
            throw new IllegalArgumentException("Given values are not part of any set!");

        link (find(firstNode), find(secondNode));
    }

    private void link(Node<V> firstNode, Node<V> secondNode) {
        if (firstNode.rank > secondNode.rank) {
            secondNode.parent = firstNode;
        }
        else if (firstNode.rank == secondNode.rank) {
            secondNode.parent = firstNode;
            firstNode.rank++;
        }
        else {
            firstNode.parent = secondNode;
        }
    }

    private Node<V> findNode (V value) {
        return set.stream().filter(n -> n.value.equals(value)).findFirst().orElse(null);
    }

    public Node<V> find (Node<V> node) {
        if (node.parent != node) {
            node.parent = find(node.parent);
        }

        return node.parent;
    }

    public void printLine (V value) {
        Node<V> node = findNode(value);
        while (node.parent != node) {
            System.out.printf("%s -> ", node.value);
            node = node.parent;
        }
        System.out.printf("%s\n", node.value);
    }

    public void printSets () {
        Map<Node<V>, ArrayList<Node<V>>> setMap = new HashMap<>();
        set.forEach(x -> addToMap(x, setMap));
        for (Map.Entry<Node<V>, ArrayList<Node<V>>> entry : setMap.entrySet()) {
            System.out.printf("%5s: %s\n", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }

    private void addToMap(Node<V> x, Map<Node<V>, ArrayList<Node<V>>> setMap) {
        setMap.putIfAbsent(find(x), new ArrayList<>());
        setMap.get(x.parent).add(x);
    }
}