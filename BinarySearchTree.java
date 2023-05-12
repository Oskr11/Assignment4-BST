import java.util.*;

public class BinarySearchTree<K extends Comparable<K>, V> implements Iterable<K> {  private Node root;

    private class Node {  private K key;
        private V value; private int size = 1; private Node left, right;

        public Node(K key, V value) {
            this.key = key; this.value = value;
        }
    }

    public void put(K key, V value) {
        if (root == null) {root = new Node(key, value);
            return;
        } put(root, key, value);
    }

    private void put(Node node, K key, V value) {
        node.size++;
        int comparison = key.compareTo(node.key);
        if (comparison == 0) {node.value = value;}
        else if (comparison > 0) {if (node.right == null) { node.right = new Node(key, value); }
        else { put(node.right, key, value);}
        } else {
            if (node.left == null) { node.left = new Node(key, value);
            } else {
                put(node.left, key, value);
            }
        }
    }

    public V search(K key) { return search(root, key);}
    private V search(Node node, K key) {
        if (node == null) return null;

        int comparison = key.compareTo(node.key);
        if (comparison == 0) {
            return node.value; } else if (comparison > 0) {
            return search(node.right, key);
        } else { return search(node.left, key); }
    }

    public void delete(K key) {
        // Implement the delete method
    }

    @Override
    public Iterator<K> iterator() { return new BSTIterator(); }

    private class BSTIterator implements Iterator<K> {
        private List<K> inorderTraversal; private int cursor;

        public BSTIterator() {
            inorderTraversal = new ArrayList<>();
            inorder(root, inorderTraversal);
        }

        private void inorder(Node node, List<K> result) {
            if (node == null) return;
            inorder(node.left, result);
            result.add(node.key);
            inorder(node.right, result);
        }
        @Override
        public boolean hasNext() { return cursor < inorderTraversal.size();}
        @Override
        public K next() { return inorderTraversal.get(cursor++);}
    }
}


