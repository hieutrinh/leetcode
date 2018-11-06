package leetcode.common;

public class DoubleListNode<T> {
    public DoubleListNode<T> prev;
    public DoubleListNode<T> next;
    public T value;
    
    public DoubleListNode(T value) {
        this.value = value;
    }

    public String toString() {
        return String.valueOf(value);
    }
}