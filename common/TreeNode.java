package leetcode.common;

public class TreeNode<T extends Comparable<?>> {
	public TreeNode<T> left, right;
    public T val;

    public TreeNode(T data) {
        this.val = data;
    }
    
    public String toString() {
    	return String.valueOf(val);
    }
}