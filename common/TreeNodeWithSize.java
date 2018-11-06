package leetcode.common;

public class TreeNodeWithSize<T extends Comparable<?>>{
    public TreeNodeWithSize<T> left, right;
    public T val;
    public int size;
    
    public TreeNodeWithSize(T data) {
        this.val = data;
        this.size = 1;
    }
    
    public String toString() {
        return String.valueOf(val);
    }
}