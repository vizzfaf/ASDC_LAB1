package org.example.Tree;

import org.example.Competitor;

public class Tree {
    Node root;
    private Node addRecursive(Node current, Competitor comp){
        if (current == null){
            return new Node(comp);
        }
        if(comp.getNumberInTable() < current.getValue().getNumberInTable()){
            current.setLeft(addRecursive(current.getLeft(),comp));
        } else if (comp.getNumberInTable() < current.getValue().getNumberInTable()) {
            current.setRight(addRecursive(current.getRight(),comp));
        } else {
            return current;
        }
        return current;
    }
    public void add(Competitor competitor){
        root = addRecursive(root,competitor);
    }

    private boolean containsRecursive(Node current,Competitor competitor){
        if(current==null) return false;
        if(competitor.equals(current.getValue())) return true;
        return competitor.getNumberInTable() < current.getValue().getNumberInTable()
                ?containsRecursive(current.getLeft(),competitor)
                :containsRecursive(current.getRight(),competitor);
    }
    public boolean contains(Competitor competitor){
        return containsRecursive(root,competitor);
    }
}
