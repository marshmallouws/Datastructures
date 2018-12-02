/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Annika
 */
public class Heap {

    private Node root;
    private final int length;
    private final int size;
    private ArrayList<Integer> values;
    private Random rnd;
    private Node current;
    private int addSize;

    public Heap(int length) {
        root = null;
        this.length = length;
        size = (int) Math.pow(2, length) - 1;
        values = new ArrayList<>();
        rnd = new Random();
        addSize = 0;
    }

    public int getSize() {
        return size;
    }

    public Node getRoot() {
        return root;
    }

    public void insertValues() {
        while (values.size() < size) {
            int num = rnd.nextInt(size + 200) + 1;
            if(!values.contains(num)) {
                values.add(num);
            }
        }
    }

    public void add() {
        int index = rnd.nextInt(values.size() - 1);

        if (root == null) {
            root = new Node(null, values.remove(0));
            add(root, values);
        }
    }

    private void add(Node current, List values) {
        int rightVal = 0;
        int leftVal = 0;
        
        if(values.size() == 0) {
            return;
        }
        
        add(current.getLeft(), values.subList(0, values.size()/2));
        add(current.getRight(), values.subList(values.size()/2 +1, values.size()-1));
        
        Node left = new Node(current, (int)values.get(0));
        
        current.setLeft();
        
        /*
        leftVal = rnd.nextInt(values.size() - 1);

        Node left = new Node(current, values.remove(leftVal));

        if (values.size() > 1) {
            rightVal = rnd.nextInt(values.size() - 1);
        }

        Node right = new Node(current, values.remove(rightVal));

        current.setLeft(left);
        current.setRight(right);

        addSize += 2;
        
        add(right);
        add(left); */
        
    }

    public void print(Node node) {

        if (node == null) {
            return;
        }

        if (node.getParent() == null) {
            System.out.println("root: " + node.getValue());
        }
        
        System.out.println(node.getValue());
        
        if(node.getLeft() != null) {
            System.out.println("left: " + node.getLeft().getValue());
        }
        
        if(node.getRight() != null) {
            System.out.println("right: " + node.getRight().getValue());
        }
        
        System.out.println("___");

        print(node.getLeft());
        print(node.getRight());

    }

    public LinkedList getValues() {
        return values;
    }

    private class Node {

        Node parent;
        Node left;
        Node right;
        int value;

        public Node(Node parent, int value) {
            this.parent = parent;
            this.value = value;
            left = null;
            right = null;
        }

        public Node getParent() {
            return parent;
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

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

    }

}
