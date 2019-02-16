package tests;

import bst.InvertibleBST;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestInvertibleBST {
    @Test
    public void testInsert() {
        InvertibleBST<Integer> bst = new InvertibleBST<Integer>();

        bst.insert(5);
        bst.insert(2);
        bst.insert(10);
        bst.insert(99);
        bst.insert(1);
        bst.insert(57);

        System.out.println(bst);
        assertTrue(bst.getSize() == 6);
    }

    @Test
    public void testPreorderTraversal1() {
        InvertibleBST<Integer> bst = new InvertibleBST<Integer>();

        bst.insert(5);
        bst.insert(9);
        bst.insert(10);
        bst.insert(2);
        bst.insert(3);
        bst.insert(8);

        List<Integer> res = bst.preorderTraversal();
        System.out.println(res);
        assertIterableEquals(res, Arrays.asList(5, 2, 3, 9, 8, 10));
    }

    @Test
    public void testPreorderTraversal2() {
        InvertibleBST<Character> bst = new InvertibleBST<Character>();

        bst.insert('M');
        bst.insert('F');
        bst.insert('U');
        bst.insert('D');
        bst.insert('C');
        bst.insert('A');
        bst.insert('Z');
        bst.insert('W');
        bst.insert('R');

        List<Character> res = bst.preorderTraversal();
        assertIterableEquals(res, Arrays.asList('M', 'F', 'D', 'C', 'A', 'U', 'R', 'Z', 'W'));
    }

    @Test
    public void testPreorderTraversal3() {
        InvertibleBST<Character> bst = new InvertibleBST<Character>();
        assertTrue(bst.preorderTraversal().size() == 0);
    }

    @Test
    public void testInorderTraversal() {
        InvertibleBST<Integer> bst = new InvertibleBST<Integer>();

        bst.insert(5);
        bst.insert(9);
        bst.insert(10);
        bst.insert(2);
        bst.insert(3);
        bst.insert(8);

        List<Integer> res = bst.inorderTraversal();
        System.out.println(res);
        assertIterableEquals(res, Arrays.asList(2, 3, 5, 8, 9, 10));
    }

    @Test
    public void tesInorderTraversal2() {
        InvertibleBST<Character> bst = new InvertibleBST<Character>();

        bst.insert('M');
        bst.insert('F');
        bst.insert('U');
        bst.insert('D');
        bst.insert('C');
        bst.insert('A');
        bst.insert('Z');
        bst.insert('W');
        bst.insert('R');

        List<Character> res = bst.inorderTraversal();
        assertIterableEquals(res, Arrays.asList('A', 'C', 'D', 'F', 'M', 'R', 'U', 'W', 'Z'));
    }

    @Test
    public void testInorderTraversal3() {
        InvertibleBST<Character> bst = new InvertibleBST<Character>();
        assertTrue(bst.preorderTraversal().size() == 0);
    }

    @Test
    public void testPostorderTraversal() {
        InvertibleBST<Integer> bst = new InvertibleBST<Integer>();

        bst.insert(5);
        bst.insert(9);
        bst.insert(10);
        bst.insert(2);
        bst.insert(3);
        bst.insert(8);

        List<Integer> res = bst.postorderTraversal();
        System.out.println(res);
        assertIterableEquals(res, Arrays.asList(3, 2, 8, 10, 9, 5));
    }

    @Test
    public void tesPostorderTraversal2() {
        InvertibleBST<Character> bst = new InvertibleBST<Character>();

        bst.insert('M');
        bst.insert('F');
        bst.insert('U');
        bst.insert('D');
        bst.insert('C');
        bst.insert('A');
        bst.insert('Z');
        bst.insert('W');
        bst.insert('R');

        List<Character> res = bst.postorderTraversal();
        assertIterableEquals(res, Arrays.asList('A', 'C', 'D', 'F', 'R', 'W', 'Z', 'U', 'M'));
    }

    @Test
    public void testPostorderTraversal3() {
        InvertibleBST<Character> bst = new InvertibleBST<Character>();
        assertTrue(bst.preorderTraversal().size() == 0);
    }

}
