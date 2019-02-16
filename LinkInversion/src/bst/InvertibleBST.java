package bst;

import linkedlist.InvertedLinkedList;

import java.util.ArrayList;
import java.util.List;

public class InvertibleBST<T extends Comparable<? super T>> {
    private class Node{
        T data;
        public Node left;
        public Node right;
        byte flag;  //Used to determine whether to perform ascension from left or right

        public Node(T data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void setFlag() {
            this.flag = 1;
        }

        public void unsetFlag() {
            this.flag = 0;
        }

        public boolean isFlagSet() {
            return this.flag == 1;
        }
    }

    private Node root;
    private int size;

    public InvertibleBST() {
        root = null;
    }

    /**
     * This function inserts a value into the InvertibleBST
     * @param data The value to be inserted
     */
    public void insert(T data) {
        if(root == null) {
            //Tree empty
            root = new Node(data, null, null);
            size++;
        } else {
            //Tree not empty, determine where new node should go
            Node current = root;

            while(true)  {
                if(data.compareTo(current.data) >= 0) {
                    //Insert nde in right subtree of the current node
                    if(current.right ==  null) {
                        current.right = new Node(data, null, null);
                        size++;
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    //Insert node in left subtree of the current node
                    if(current.left ==  null) {
                        current.left = new Node(data, null, null);
                        size++;
                        break;
                    } else {
                        current = current.left;
                    }
                }
            }
        }
    }

    /**
     * This method traverses the InvertibleBST in rLR order (preorder)
     * @return A list containing the data stored in the tree in preorder
     */
    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<T>();
        Node current = root;
        Node prev = null;
        Node temp = null;

        if(root == null) {
            return result;
        }

        while(prev != null || (current != null && !current.isFlagSet())) {
            //Loop runs as long as there is a previous node or the current node still has a right
            //subtree for us to explore
            if(current != null && !current.isFlagSet()) {
                //Descend Left
                result.add(current.data);
                temp = current;
                current = current.left;
                temp.left = prev;
                prev = temp;
            } else if(current == null || current.isFlagSet()) {
                if(prev.isFlagSet()) {
                    //Ascend from right
                    temp = prev;
                    prev = prev.right;
                    temp.right = current;
                    current = temp;
                } else {
                    //Ascend from left
                    temp = prev;
                    prev = prev.left;
                    temp.left = current;
                    current = temp;

                    //Descend right
                    current.setFlag();
                    temp = current;
                    current = current.right;
                    temp.right = prev;
                    prev = temp;
                }
            }
        }

        return result;
    }

    /**
     * This method returns the contents of the InvertibleBST inorder
     * @return A list containing the contents of the tree inorder
     */
    public List<T> inorderTraversal() {
        Node current = root;
        Node prev = null;
        Node temp = null;
        List<T> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        while(prev != null || (current != null && !current.isFlagSet())) {
            //Loop runs as long as there is a previous node or the current node still has a right
            //subtree for us to explore
            if(current != null && !current.isFlagSet()) {
                //Descend Left
                temp = current;
                current = current.left;
                temp.left = prev;
                prev = temp;
            } else if(current == null || current.isFlagSet()) {
                if(prev.isFlagSet()) {
                    //Ascend from right
                    temp = prev;
                    prev = prev.right;
                    temp.right = current;
                    current = temp;
                } else {
                    //Ascend from left
                    result.add(prev.data);
                    temp = prev;
                    prev = prev.left;
                    temp.left = current;
                    current = temp;

                    //Descend right
                    current.setFlag();
                    temp = current;
                    current = current.right;
                    temp.right = prev;
                    prev = temp;
                }
            }
        }

        return result;
    }

    /**
     * This method returns the contents of the InvertibleBST postorder
     * @return A list containing the contents of the tree postorder
     */
    public List<T> postorderTraversal() {
        Node current = root;
        Node prev = null;
        Node temp = null;
        List<T> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        while(prev != null || (current != null && !current.isFlagSet())) {
            //Loop runs as long as there is a previous node or the current node still has a right
            //subtree for us to explore
            if(current != null && !current.isFlagSet()) {
                //Descend Left
                temp = current;
                current = current.left;
                temp.left = prev;
                prev = temp;
            } else if(current == null || current.isFlagSet()) {
                if(prev.isFlagSet()) {
                    //Ascend from right
                    result.add(prev.data);
                    temp = prev;
                    prev = prev.right;
                    temp.right = current;
                    current = temp;
                } else {
                    //Ascend from left
                    temp = prev;
                    prev = prev.left;
                    temp.left = current;
                    current = temp;

                    //Descend right
                    current.setFlag();
                    temp = current;
                    current = current.right;
                    temp.right = prev;
                    prev = temp;
                }
            }
        }

        return result;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        return toStringAux(root, "");
    }

    public String toStringAux(Node start, String res) {
        if(start == null) {
            return res;
        } else {
            res = toStringAux(start.left, res);
            res += " " + start.data;
            res = toStringAux(start.right, res);
            return res;
        }
    }

}
