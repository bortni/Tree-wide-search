package com.my.tree;

public class Tree<T extends Number> {
    private Node root;

    class Node {
        Node left;
        Node right;
        T value;

        Node(T value) {
            this.value = value;
        }
    }

    private void insert(T value, Node node) {
        if (root == null) {
            root = new Node(value);
            System.out.println("Корень" + root.value);
            return;
        }
        if (node.value.doubleValue() > value.doubleValue()) {
            if (node.left == null) {
                node.left = new Node(value);
                System.out.println("Корень" + node.value + "left" + value);
            } else
                insert(value, node.left);
        } else {
            if (node.right == null) {
                node.right = new Node(value);
                System.out.println("Корень" + node.value + "right" + value);
            } else
                insert(value, node.right);
        }
    }

    public void add(T value) {
        insert(value, root);
    }

    private void show_private(Node node) {
        if (node == null)
            return;
        String left, right;

        if (node.left == null) {
            left = "нет значения";
        } else {
            left = node.left.value + "";
        }

        if (node.right == null) {
            right = "нет значения";
        } else {
            right = node.right.value + "";
        }

        System.out.println("Корень" + node.value + "левый ребенок: " + left + "правый ребенок: " + right);
        show_private(node.left);
        show_private(node.right);
    }
}
