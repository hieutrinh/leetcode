package leetcode.common;

public class RandomListNodeUtils {
    
    public static RandomListNode ArrayToList(int[] input) {
        RandomListNode root = null, curr = null, prev = null, next = null, prevprev = null;
        
        
        for (int i : input) {
            if (root == null) {
                root = new RandomListNode(i);
                prevprev = prev;
                prev = curr;
                curr = root;
            } else {
                next = new RandomListNode(i);
                curr.next = next;
                prevprev = prev;
                prev = curr;
                if (prevprev != null) {
                    prevprev.random = next;
                }
                curr = next;
            }
        }
        return root;
    }
    
    public static void print(RandomListNode node) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        RandomListNode itor = node;
        boolean first = true;
        while (itor != null) {
            if (first) {
                first = false;
            } else {
                sb.append("->");
            }
            sb.append(itor.label);
            itor = itor.next;
        }
        sb.append(" ]\n");
        
        itor = node;
        while (itor != null) {
            if (itor.random == null) {
                sb.append(itor.label + "->null\n");
            } else {
                sb.append(itor.label + "->" + itor.random.label + "\n");
            }
            itor = itor.next;
        }
        
        System.out.println(sb.toString());
    }
    
    public static void main(String[] args) {
        int[] nums = new int[] {2,3,4,5,6,7,9,1};
        RandomListNode node = ArrayToList(nums);
        print(node);
    }
}
