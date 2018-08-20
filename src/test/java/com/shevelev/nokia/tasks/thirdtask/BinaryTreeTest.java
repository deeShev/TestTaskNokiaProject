package com.shevelev.nokia.tasks.thirdtask;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinaryTreeTest {
    private BinaryTree<Integer> integerBinaryTree;

    @Before
    public void setUp() {
        integerBinaryTree = new BinaryTree<>();
        integerBinaryTree.add(5);
        integerBinaryTree.add(1);
        integerBinaryTree.add(6);
        integerBinaryTree.add(3);
        integerBinaryTree.add(8);
        integerBinaryTree.add(9);
        integerBinaryTree.add(100);
    }

    @Test
    public void add() {
        assertEquals(new Integer(5), integerBinaryTree.getValueRoot());
    }

    @Test
    public void height() {
        assertEquals(4, integerBinaryTree.height());
    }
}
