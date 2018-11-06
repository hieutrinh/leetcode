package leetcode.common;

import java.util.HashSet;
import java.util.Set;

public class ListNodeUtils {
    public static ListNode<Integer> ArrayToList(int[] input) {
        ListNode<Integer> root = null, prev = null, next = null;
        
        for (int i : input) {
            if (root == null) {
                root = new ListNode<Integer>(i);
                prev = root;
            } else {
                next = new ListNode<Integer>(i);
                prev.next = next;
                prev = next;
            }
        }
        return root;
    }
    
    public static <T> void print(ListNode<T> node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        ListNode<T> itor = node;
        boolean first = true;
        Set<ListNode<T>> set = new HashSet<>();
        while (itor != null) {
            if (first) {
                first = false;
            } else {
                sb.append("->");
            }
            sb.append(itor.value);
            if (set.contains(itor)) {
                System.out.println("Cycle detected at: " + itor.value);
                break;
            } else {
                set.add(itor);
            }
            itor = itor.next;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
    }
    
    public static <T> ListNode<T> reverseRecursive(ListNode<T> head) {
        return _reverseRecursive(head, null);
    }
    
    // need the <T> infront of the return type
    public static <T> ListNode<T> _reverseRecursive(ListNode<T> head, ListNode<T> newHead) {
        if (head == null) return newHead;
        ListNode<T> next = head.next;
        head.next = newHead;
        return _reverseRecursive(next, head);
    }
    
    public static <T> ListNode<T> reverseIterative(ListNode<T> head) {
        ListNode<T> prev = null;
        while (head != null) {
            ListNode<T> next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,4,5,6,7,3,5};
        ListNode<Integer> node = ArrayToList(nums);
        print(node);
        
        node = reverseRecursive(node); 
        print(node);
        
        node = reverseIterative(node);
        print(node);
    }
}
