package tests;

import linkedlist.InvertedLinkedList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;


public class TestInvertedLinkedList {
    @Test
    public void testInsert() {
        InvertedLinkedList<Integer> inv = new InvertedLinkedList<Integer>();

        inv.insert(0);
        inv.insert(1);
        inv.insert(2);
        inv.insert(3);
        inv.insert(4);
        inv.insert(5);

        Iterator<Integer> invIter = inv.iterator();


        assertTrue(invIter.next() == 0);
        assertTrue(invIter.next() == 1);
        assertTrue(invIter.next() == 2);
        assertTrue(invIter.next() == 3);
        assertTrue(invIter.next() == 4);
        assertTrue(invIter.next() == 5);
    }

    @Test
    public void testInvert() {
        InvertedLinkedList<Integer> inv = new InvertedLinkedList<Integer>();

        inv.insert(0);
        inv.insert(1);
        inv.insert(2);
        inv.insert(3);
        inv.insert(4);
        inv.insert(5);

        inv.invert();
        Iterator<Integer> invIter = inv.iterator();


        for(Integer v: inv) {
            System.out.print(v + " ");
        }

        System.out.println("\n");

        assertTrue(invIter.next() == 5);
        assertTrue(invIter.next() == 4);
        assertTrue(invIter.next() == 3);
        assertTrue(invIter.next() == 2);
        assertTrue(invIter.next() == 1);
        assertTrue(invIter.next() == 0);

        inv.invert();
        invIter = inv.iterator();


        for(Integer v: inv) {
            System.out.print(v + " ");
        }

        assertTrue(invIter.next() == 0);
        assertTrue(invIter.next() == 1);
        assertTrue(invIter.next() == 2);
        assertTrue(invIter.next() == 3);
        assertTrue(invIter.next() == 4);
        assertTrue(invIter.next() == 5);
    }

    @Test
    public void testForwardBackwardTraversal() {
        InvertedLinkedList<Integer> inv = new InvertedLinkedList<Integer>();

        inv.insert(0);
        inv.insert(1);
        inv.insert(2);
        inv.insert(3);
        inv.insert(4);
        inv.insert(5);

        List<Integer> res = inv.traverseForwardAndBackward();
        assertIterableEquals(res, new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,5,4,3,2,1,0)));
    }
}
