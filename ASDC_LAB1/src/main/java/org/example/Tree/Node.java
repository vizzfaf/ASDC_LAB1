package org.example.Tree;

import org.example.Competitor;

public class Node {
    private Competitor value;
    private Node left;
    private Node right;

    public Node(Competitor competitor) {
        value = competitor;
    }

    public Competitor getValue() {
        return value;
    }

    public void setValue(Competitor value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
