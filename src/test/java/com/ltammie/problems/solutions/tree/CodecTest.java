package com.ltammie.problems.solutions.tree;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CodecTest {

    @Test
    void serialize() {
        Codec codec = new Codec();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        String serializedTree = codec.serialize(t1);
        assertEquals("[1,2,3,null,null,4,5]", serializedTree);
    }

    @Test
    void deserialize() {
        Codec codec = new Codec();

        TreeNode deserializedTree = codec.deserialize("[1,2,3,null,null,4,5]");
        TreeNode deserializedTree1 = codec.deserialize("[1,2,3,null,null,4,5,6,7]");
        System.out.println(deserializedTree);
    }
}