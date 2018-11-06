package leetcode.common;

public class ListNode<T> {
    public ListNode<T> next;
    public T value;
    
    public ListNode(T value) {
        this.value = value;
    }
    
    public void setNext(ListNode<T> next) {
        this.next = next;
    }
    
    public String toString() {
        return String.valueOf(value);
    }
}
