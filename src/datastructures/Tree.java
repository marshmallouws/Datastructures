/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructures;

/**
 *
 * @author Annika
 */
public class Tree {
    private Node root;
    private int size;
    
    public Tree() {
        root = null;
        size = 0;
    }
    
    public boolean add(int value) {
        
        if(root == null) {
            root = new Node(value);
            return true;
        } else {
            return add(root, value);
        }
    }
    
    private boolean add(Node current, int value) {
        Node newNode = new Node(value);
        
        if(current == null) throw new IllegalStateException("Node may not be null");
        if(newNode == current) return false;
        
        
        if(value > current.getValue()) {
            Node right = current.getRight();
            if(right == null) {
                current.setRight(newNode);
                size++;
                return true;
            } else {
                return add(right, value);
            }
        } else {
            Node left = current.getLeft();
            if(left == null) {
                current.setLeft(newNode);
                size++;
                return true;
            } else {
                return add(left, value);
            }
        }
    }

    private class Node {
        Node left;
        Node right;
        int value;
        
        public Node(int value) {
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

        public int getValue() {
            return value;
        }

    }

}
