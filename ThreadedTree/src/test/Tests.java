package test;

import org.junit.jupiter.api.Test;
import bst.ThreadedBST;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    @Test
    public void testInorderTraversal() {
        ThreadedBST<Integer> bst = new ThreadedBST<>();

        bst.insert(50);
        bst.insert(10);
        bst.insert(90);
        bst.insert(15);
        bst.insert(29);
        bst.insert(5);
        bst.insert(51);
        bst.insert(100);

        List<Integer> res = bst.inorderTraversal();
        System.out.println(res.toString());
        assertTrue(res.get(0) == 5);
        assertTrue(res.get(1) == 10);
        assertTrue(res.get(2) == 15);
        assertTrue(res.get(3) == 29);
        assertTrue(res.get(4) == 50);
        assertTrue(res.get(5) == 51);
        assertTrue(res.get(6) == 90);
        assertTrue(res.get(7) == 100);
    }

    @Test
    public void testDescendingOrderTraversal() {
        ThreadedBST<Integer> bst = new ThreadedBST<>();

        bst.insert(50);
        bst.insert(10);
        bst.insert(90);
        bst.insert(15);
        bst.insert(29);
        bst.insert(5);
        bst.insert(51);
        bst.insert(100);

        List<Integer> res = bst.descendingOrderTraversal();
        System.out.println(res.toString());
        assertTrue(res.get(0) == 100);
        assertTrue(res.get(1) == 90);
        assertTrue(res.get(2) == 51);
        assertTrue(res.get(3) == 50);
        assertTrue(res.get(4) == 29);
        assertTrue(res.get(5) == 15);
        assertTrue(res.get(6) == 10);
        assertTrue(res.get(7) == 5);
    }

    @Test
    public void testPreorderTraversal() {
        ThreadedBST<Integer> bst = new ThreadedBST<>();

        bst.insertPreOrder(50);
        bst.insertPreOrder(10);
        bst.insertPreOrder(90);
        bst.insertPreOrder(15);
        bst.insertPreOrder(29);
        bst.insertPreOrder(5);
        bst.insertPreOrder(51);
        bst.insertPreOrder(100);

        List<Integer> res = bst.preorderTraversal();
        System.out.println(res.toString());
        assertTrue(res.get(0) == 50);
        assertTrue(res.get(1) == 10);
        assertTrue(res.get(2) == 5);
        assertTrue(res.get(3) == 15);
        assertTrue(res.get(4) == 29);
        assertTrue(res.get(5) == 90);
        assertTrue(res.get(6) == 51);
        assertTrue(res.get(7) == 100);
    }

    @Test
    public void testPreorderTraversal2() {
        ThreadedBST<Integer> bst = new ThreadedBST<>();

        bst.insertPreOrder(95);
        bst.insertPreOrder(30);
        bst.insertPreOrder(100);
        bst.insertPreOrder(10);
        bst.insertPreOrder(49);
        bst.insertPreOrder(45);
        bst.insertPreOrder(50);
        bst.insertPreOrder(47);
        bst.insertPreOrder(48);

        List<Integer> res = bst.preorderTraversal();
        System.out.println(res.toString());
        assertTrue(res.get(0) == 95);
        assertTrue(res.get(1) == 30);
        assertTrue(res.get(2) == 10);
        assertTrue(res.get(3) == 49);
        assertTrue(res.get(4) == 45);
        assertTrue(res.get(5) == 47);
        assertTrue(res.get(6) == 48);
        assertTrue(res.get(7) == 50);
        assertTrue(res.get(8) == 100);

    }

    @Test
    public void testPreorderTraversal3() {
        ThreadedBST<Integer> bst = new ThreadedBST<>();

        bst.insertPreOrder(95);
        bst.insertPreOrder(50);
        bst.insertPreOrder(40);
        bst.insertPreOrder(30);
        bst.insertPreOrder(60);
        bst.insertPreOrder(100);


        List<Integer> res = bst.preorderTraversal();
        System.out.println(res.toString());
        assertTrue(res.get(0) == 95);
        assertTrue(res.get(1) == 50);
        assertTrue(res.get(2) == 40);
        assertTrue(res.get(3) == 30);
        assertTrue(res.get(4) == 60);
        assertTrue(res.get(5) == 100);
    }
}
