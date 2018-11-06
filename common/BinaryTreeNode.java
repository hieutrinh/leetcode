package leetcode.common;

// Use TreeNode
public class BinaryTreeNode {

    public BinaryTreeNode left, right;
    public int val;

    public BinaryTreeNode(int data) {
        this.val = data;
    }
    
    public String toString() {
        return String.valueOf(val);
    }
}
