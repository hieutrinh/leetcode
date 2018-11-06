package leetcode.common;

public class DoubleListNodeUtils {
    
    public static DoubleListNode<Integer> ArrayToList(int[] input) {
        return ArrayToList(toInteger(input));
    }
    
    public static DoubleListNode<Integer> ArrayToList(Integer[] input) {
        
        DoubleListNode<Integer> root = null, prev = null, next = null;
        
        for (int i : input) {
            if (root == null) {
                root = new DoubleListNode<Integer>(i);
                prev = root;
            } else {
                next = new DoubleListNode<Integer>(i);
                next.prev = prev;
                prev.next = next;
                prev = next;
            }
        }
        return root;
    }
    
    public static Integer[] toInteger(int[] nums) {
        Integer[] res = new Integer[nums.length];
        for (int i=0; i<nums.length; i++) {
            res[i] = new Integer(nums[i]);
        }
        return res;
    }
    
    public static <T> void print(DoubleListNode<T> node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        DoubleListNode<T> itor = node;
        boolean first = true;
        
        DoubleListNode<T> last = null;
        
        while (itor != null) {
            last = itor;
            if (first) {
                first = false;
            } else {
                sb.append("->");
            }
            sb.append(itor.value);
            itor = itor.next;
        }
        sb.append(" ]");
        
        itor = last;
        sb.append("\n[ ");
        first = true;
        while (itor != null) {
            last = itor;
            if (first) {
                first = false;
            } else {
                sb.append("->");
            }
            sb.append(itor.value);
            itor = itor.prev;
        }
        sb.append(" ]");
        System.out.println(sb.toString());
        
    }
}
