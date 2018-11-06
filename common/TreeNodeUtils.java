package leetcode.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeNodeUtils {
    public static TreeNode<Integer> arrayToTreeNode(Integer[] input) {
        return createTreeNode(input, 1);
    }
    
    public static TreeNode<Integer> createTreeNode(Integer[] input, int index) {
        if (index <= input.length) {
            // need to -1 because array index at 0
            Integer value = input[index-1];
            if (value != null) {
                TreeNode<Integer> tree = new TreeNode<Integer>(value);
                tree.left = createTreeNode(input, index * 2);
                tree.right = createTreeNode(input, index * 2 + 1);
                return tree;
            }
        }
        return null;
    }
    
    public static TreeNode<Integer> createTreeNode_V2(Integer[] input) {
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        TreeNode<Integer> tree = new TreeNode<Integer>(input[0]);
        q.offer(tree);
        int index = 1;
        while (index < input.length || !q.isEmpty()) {
            int size = q.size(); // each valid node in the queue has two children
            for (int i=0; i<size; i++) {
                TreeNode<Integer> node = q.poll();
                if (index < input.length && input[index] != null) {
                    node.left = new TreeNode<Integer>(input[index]);
                    q.offer(node.left);
                }
                index++;
                if (index < input.length && input[index] != null) {
                    node.right = new TreeNode<Integer>(input[index]);
                    q.offer(node.right);
                }
                index++;
            }
        }
        return tree;
    }
    
    public static TreeNodeWithSize<Integer> createTreeNodeWithSize_V2(Integer[] input) {
        Queue<TreeNodeWithSize<Integer>> q = new LinkedList<>();
        TreeNodeWithSize<Integer> tree = new TreeNodeWithSize<Integer>(input[0]);
        q.offer(tree);
        int index = 1;
        while (index < input.length || !q.isEmpty()) {
            int size = q.size(); // each valid node in the queue has two children
            for (int i=0; i<size; i++) {
                TreeNodeWithSize<Integer> node = q.poll();
                if (index < input.length && input[index] != null) {
                    node.left = new TreeNodeWithSize<Integer>(input[index]);
                    node.size += node.left.size;
                    q.offer(node.left);
                }
                index++;
                if (index < input.length && input[index] != null) {
                    node.right = new TreeNodeWithSize<Integer>(input[index]);
                    node.size += node.right.size;
                    q.offer(node.right);
                }
                index++;
            }
        }
        return tree;
    }
    
    public static TreeNode<Integer> unsortedArrayToBinarySearchTree(Integer[] input) {
        List<Integer> list = Arrays.asList(input);
        Collections.sort(list);
        input = list.toArray(new Integer[0]);
        return sortedArrayToBinarySearchTree(input, 0, input.length-1); 
    }
    
    public static TreeNode<Integer> sortedArrayToBinarySearchTree(Integer[] input) {
        return sortedArrayToBinarySearchTree(input, 0, input.length-1); 
    }
    
    public static TreeNode<Integer> sortedArrayToBinarySearchTree(Integer[]input, int start, int end) {
        if (start > end) return null;
        int m = (start + end)/2;
        TreeNode<Integer> root = new TreeNode<Integer>(input[m]);
        root.left = sortedArrayToBinarySearchTree(input, start, m-1);
        root.right = sortedArrayToBinarySearchTree(input, m+1, end);
        return root;
    }
    
    public static TreeNodeWithSize<Integer> unsortedArrayToBinarySearchTreeWithSize(Integer[] input) {
//        List<Integer> list = Arrays.asList(input);
//        Collections.sort(list);
//        input = list.toArray(new Integer[0]);
        Arrays.sort(input);
        return sortedArrayToBinarySearchTreeWithSize(input, 0, input.length-1); 
    }
    
    public static TreeNodeWithSize<Integer> sortedArrayToBinarySearchTreeWithSize(Integer[] input) {
        return sortedArrayToBinarySearchTreeWithSize(input, 0, input.length-1); 
    }
    
    public static TreeNodeWithSize<Integer> sortedArrayToBinarySearchTreeWithSize(Integer[]input, int start, int end) {
        if (start > end) return null;
        int m = (start + end)/2;
        TreeNodeWithSize<Integer> root = new TreeNodeWithSize<Integer>(input[m]);
        root.left = sortedArrayToBinarySearchTreeWithSize(input, start, m-1);
        root.right = sortedArrayToBinarySearchTreeWithSize(input, m+1, end);
        root.size += (root.left != null)? root.left.size : 0;
        root.size += (root.right != null)? root.right.size : 0;
        return root;
    }
    
    public static <T extends Comparable<?>> void printNode(TreeNode<T> root) {
        int maxLevel = maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }
    
    public static <T extends Comparable<?>> void printNode(TreeNodeWithSize<T> root) {
        int maxLevel = maxLevel(root);

        printNodeInternalWithSize(Collections.singletonList(root), 1, maxLevel);
    }
    
    /*
     * Print tree BFS in string
[1,null,2,null,3]
   1       
    \   
     \  
     2   
      \ 
      3 
                
[1,null,3,2]
   1       
    \   
     \  
     3   
    /   
    2   
                
[2,1,3]
 2   
/ \ 
1 3 
        
[3,1,null,null,2]
   3       
  /     
 /      
 1       
  \     
  2     
                
[3,2,null,1]
   3       
  /     
 /      
 2       
/       
1       
     */
    public static <T extends Comparable<?>> void printNodeString(TreeNode<T> root) {
        StringBuilder sb = new StringBuilder();
        // BFS
        Queue<TreeNode<T>> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
            while (!q.isEmpty()) {
                TreeNode<T> node = q.poll();
                // don't output the last node if it is null
                if (q.isEmpty() && node == null) break;
                
                if (sb.length() > 0) {
                    sb.append(",");
                }
                
                sb.append((node == null)? "null" : node.val);
                if (node != null) {
                    if (node.left != null || node.right != null) {
                        q.offer(node.left);
                        q.offer(node.right);
                    }
                }
            }
        }
        System.out.println("[" + sb.toString() + "]");
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNode<T>> newNodes = new ArrayList<TreeNode<T>>();
        for (TreeNode<T> node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternalWithSize(List<TreeNodeWithSize<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        printWhitespaces(firstSpaces);

        List<TreeNodeWithSize<T>> newNodes = new ArrayList<TreeNodeWithSize<T>>();
        for (TreeNodeWithSize<T> node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    printWhitespaces(1);

                printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    printWhitespaces(1);

                printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternalWithSize(newNodes, level + 1, maxLevel);
    }
    
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNode<T> node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }

    private static <T extends Comparable<?>> int maxLevel(TreeNodeWithSize<T> node) {
        if (node == null)
            return 0;

        return Math.max(maxLevel(node.left), maxLevel(node.right)) + 1;
    }
    
    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }
    
    public static void main(String[] args) {
        Integer[] nums = { 1, 3, 4, 2, 7, 9, 8, 6, 10, 13, 23 };
        TreeNode<Integer> head = sortedArrayToBinarySearchTree(nums);
        printNode(head);
    }
}
