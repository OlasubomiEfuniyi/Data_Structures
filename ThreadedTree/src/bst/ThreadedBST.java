package bst;

import java.util.ArrayList;
import java.util.List;

public class ThreadedBST<T extends Comparable<? super T>> {
    private class Node {
        public Node left;
        public T data;
        public Node right;
        private byte leftBit = 1;
        private byte rightBit = 1;

        public Node(Node left, T data, Node right) {
            this.left = left;
            this.data = data;
            this.right = right;
        }

        public void setLeftBit() {
            leftBit = 1;
        }

        public void setRightBit() {
            rightBit = 1;
        }

        public void unsetLeftBit() {
            leftBit = 0;
        }

        public void unsetRightBit() {
            rightBit = 0;
        }

        public boolean isLBSet() {
            return (leftBit == 1);
        }

        public boolean isRBSet() {
            return (rightBit == 1);
        }
    }

    private Node root;

    /**
     * This method inserts data into the ThreadedBST
     * @param data The data to be stored in the tree.
     */
    public void insert(T data) {
        Node inorderSuccesssor = null;
        Node inorderPredecessor = null;

        if(root == null) {
            //Tree is empty.New node becomes the root
            root = new Node(inorderPredecessor, data, inorderSuccesssor);
        } else {
            //Tree is not empty.Find where to insert new Node
            Node current = root;

            while(true) {
                if(data.compareTo(current.data) >= 0) {
                    inorderPredecessor = current;
                    if((current.right != null) && (!current.isRBSet())) {
                        current = current.right;
                    } else {
                        //Add node as right child and set its inorder predecessor and successor
                        current.right = new Node(inorderPredecessor, data, inorderSuccesssor);
                        current.unsetRightBit();
                        break;
                    }
                } else {
                    inorderSuccesssor = current;
                    if((current.left != null) && (!current.isLBSet())) {
                        current = current.left;
                    } else {
                        //Add node as left child and set its inorder predecessor and successor
                        current.left = new Node(inorderPredecessor, data, inorderSuccesssor);
                        current.unsetLeftBit();
                        break;
                    }
                }
            }
        }
    }

    /**
     * This method threads a ThreadedBST for preorder traversal
     * The behavior of this method is undefined if its invocation is mixed with the invocation of insert.
     * @param value The value to be stored in the ThreadedBST
     */
    public void insertPreOrder(T value) {
        if(root == null) {
            //First node in the ThreadedBST
            root = new Node(null, value, null);
        } else {
            //Not the first node in the ThreadedBST
            Node preorderSuccessor = null;
            Node current = root;

            while(true) {
                if(value.compareTo(current.data) >= 0) {
                    //Insert on the right subtree rooted at the current node
                    if(current.right == null) {
                        current.right = new Node(preorderSuccessor, value, null);
                        current.unsetRightBit();
                        if((current.left != null && !current.isLBSet())) {
                            if (current.left.left == null || current.left.isLBSet()) {
                                //The  current node has a left node that is its child  and its left points to null or is set so
                                //it currently points to another node as its preorder successor
                                current.left.left = current.right;
                            } else {
                                Node curr = current.left;
                                while(true) {
                                    //Right gets priority if it is null or a thread because the goal is to
                                    //go to find the preorder predecessor of the node just inserted and that will
                                    //be the rightmost node on the left of the left subtree of current
                                    if(curr.right != null && !curr.isRBSet()) {
                                        curr = curr.right;
                                    } else if(curr.left != null && !curr.isLBSet()){
                                        curr = curr.left;
                                    } else {
                                        break;
                                    }
                                }

                                //Left gets priority if it is null or a thread
                                if(curr.left == null || curr.isLBSet()) {
                                    curr.left = current.right;
                                } else {
                                    curr.right = current.right;
                                }
                            }
                        } else {
                            //Set the new node as the appropriate successor of an existing node
                            current.left = current.right;
                        }
                        break;
                    } else {
                        current = current.right;
                    }
                } else {
                    //Possibly update preorder successor
                    if(current.right != null) {
                        preorderSuccessor = current.right;
                    }
                    //Insert the new node in the left subtree rooted at the current node
                    if(current.left == null || current.isLBSet()) {
                        current.left = new Node(preorderSuccessor, value, null);
                        current.unsetLeftBit();
                        break;
                    } else {
                        current = current.left;
                    }
                }
            }

        }
    }

    /**
     * This function returns the inorder successor of a node
     * @param n The node whose inorder successor is required
     * @return A node which is the inorder successor of the given n
     */
    private Node inorderSuccessor(Node n) {
        Node current = n;

        if(current != null) {
            if(current.isRBSet()) {
                //The right link is a thread so it gives the inorder successor in constant time
                return current.right;
            } else {
                //The right link is not a thread so we have to travers ordinary links to find the inorder successor
                current = current.right;
                while(!current.isLBSet() && current.left!= null) {
                    current = current.left;
                }

                return current;
            }
        }

        return null;
    }

    /* This function finds the preorder successor of a given node
    *
    */
    private Node preorderSuccessor(Node n) {
        Node current = n;

        if(current != null) {
            if(current.left != null) {
                return current.left;
            } else {
                return current.right;
            }
        } else {
            return null;
        }
    }
    /*
     * This method returns the inorder predecessor of the node provided as a parameter
     */
    private Node inorderPredecessor(Node n) {
        Node current = n;

        if(current != null) {
            if(current.isLBSet()) {
                //If left bit is set, then the left link is a thread pointing directly to the inorder
                //predecessor of the node.
                return current.left;
            } else {
                //The left bit is not set so the left link is an ordinary reference. Need to traverse
                //until we reach the rightmost mode on the left side of the current node
                current = current.left;

                while(current.right != null && !current.isRBSet()) {
                    current = current.right;
                }

                return current;
            }
        } else {
            return null;
        }
    }

    /**
     * This method performs the inorder traversal of the ThreadedBST
     * @return A list of data obtained from nodes in the order they were traversed (inorder)
     */
    public List<T> inorderTraversal() {
        Node current = root;
        List<T> result = new ArrayList<T>();
        //Go as left as possible without hitting null
        while(current.left != null) {
            current = current.left;
        }

        //Add leftmost node to result first
        result.add(current.data);

        //Get the rest of the node by traversing using the inorder successors
        current = inorderSuccessor(current);
        while(current != null) {
            result.add(current.data);
            current = inorderSuccessor(current);
        }

        return result;
    }

    /**
     * This method traverses a ThreadedBST in descending order
     * @return A list containing the data stored in a ThreadedBST arranged in descending order.
     */
    public List<T> descendingOrderTraversal() {
        Node current = root;
        List<T> result = new ArrayList<T>();

        //Go as right as possible
        while(current.right != null) {
            current = current.right;
        }

        //Add the rightmost node to the list
        result.add(current.data);

        //Traverse the rest of the tree using the inorder predecessor
        current = inorderPredecessor(current);
        while(current != null) {
            result.add(current.data);
            current = inorderPredecessor(current);
        }

        return result;

    }

    /**
     * This method performs a preorder traversal of a ThreadedBST
     * @return a list containing the data stored in a ThreadedBST in preorder arrangement
     */
    public List<T> preorderTraversal() {
        List<T> result = new ArrayList<T>();
        Node current = root;

        //Add the root data to result first
        result.add(current.data);

        //Add the rest of the data starting with the preorder successor of the root and continuing
        //from there by traversing the preorder successor links/threads
        current = preorderSuccessor(current);

        while(current != null) {
            result.add(current.data);
            current = preorderSuccessor(current);
        }

        return result;
    }
}
