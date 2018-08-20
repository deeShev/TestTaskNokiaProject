package com.shevelev.nokia.tasks.thirdtask;

public class BinaryTree<T extends Comparable<T>> {
    private Node<T> root;

    private static final class Node<T extends Comparable<T>> {
        T data;
        Node<T> left, right;

        Node(T data) {
            this.data = data;
        }

        void insert(T value) {
            if (data.compareTo(value) < 0) {
                if (right != null) {
                    right.insert(value);
                } else {
                    right = new Node<>(value);
                }
            } else {
                if (left != null) {
                    left.insert(value);
                } else {
                    left = new Node<>(value);
                }
            }
        }

        int height(Node<T> value) {
            if (value == null) {
                return -1;
            } else {
                return 1 + Math.max(height(value.left), height(value.right));
            }
        }

        @Override
        public String toString() {
            return "{data=" + data +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public T getValueRoot() {
        return root.data;
    }

    public void add(T value) {
        if (root == null) {
            root = new Node<>(value);
        } else {
            root.insert(value);
        }
    }

    public int height() {
        if (root == null) {
            return -1;
        } else {
            return root.height(root);
        }
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}
