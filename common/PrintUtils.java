package leetcode.common;

import java.util.List;

public class PrintUtils {
    public static String[] BRACES = new String[] { "{ ", " }", "{", "}" };
    public static String[] BRACKETS= new String[] { "[ ", " ]", "[", "]"};
    public static String SEP = ", ";
    public static String NL = "\n";
    
    public static void print(int[] grid1D) {
//        System.out.println(toString(grid1D));
        print(grid1D, BRACES);
    }
    
    public static void print(long[] grid1D) {
//      System.out.println(toString(grid1D));
      print(grid1D, BRACES);
  }
    
    public static void print(char[] grid1D) {
//      print(grid1D, BRACES);
    }
    public static void print(double[] grid1D) {
        print(grid1D, BRACES);
    }
    
    public static void print(Integer[] grid1D) {
      print(grid1D, BRACES);
    }
    
    public static void print(Long[] grid1D) {
      print(grid1D, BRACES);
    }
    
    
    public static void print(String[] grid1D) {
//        print(grid1D, BRACES);
    }
     
    public static void print(Integer[] grid1D, String[] style) {
        System.out.println(gridToString(grid1D, style));
    }
    
    public static void print(Long[] grid1D, String[] style) {
        System.out.println(gridToString(grid1D, style));
    }
    
    public static void print(boolean[] grid1D) {
      print(grid1D, BRACES);
    }
    
    public static void print(int[] grid1D, String[] style) {
        System.out.println(gridToString(grid1D, style));
    }
    
    public static void print(long[] grid1D, String[] style) {
        System.out.println(gridToString(grid1D, style));
    }
    public static void print(double[] grid1D, String[] style) {
        System.out.println(gridToString(grid1D, style));
    }
    
    public static void print(boolean[] grid1D, String[] style) {
        System.out.println(gridToString(grid1D, style));
    }
    
    public static void print(int[][] grid2D) {
        print(grid2D, BRACES);
    }
    
    public static void print(long[][] grid2D) {
        print(grid2D, BRACES);
    }
    
    public static void print(boolean[][] grid2D) {
        print(grid2D, BRACES);
    }
    
    public static void print(long[][] grid2D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]).append(NL);
        String pad = "  ";
        for (int i=0; i<grid2D.length; i++) {
            if (i == (grid2D.length-1)) {
                sb.append(pad+ gridToString(grid2D[i], style)).append(NL);
            } else {
                sb.append(pad+ gridToString(grid2D[i], style)).append(SEP).append(NL);
            }
        }
        sb.append(style[3]);
        System.out.println(sb.toString());
    }
    
    public static void print(int[][] grid2D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]).append(NL);
        String pad = "  ";
        for (int i=0; i<grid2D.length; i++) {
            if (i == (grid2D.length-1)) {
                sb.append(pad+ gridToString(grid2D[i], style)).append(NL);
            } else {
                sb.append(pad+ gridToString(grid2D[i], style)).append(SEP).append(NL);
            }
        }
        sb.append(style[3]);
        System.out.println(sb.toString());
    }
    
    public static void print(boolean[][] grid2D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]).append(NL);
        String pad = "  ";
        for (int i=0; i<grid2D.length; i++) {
            if (i == (grid2D.length-1)) {
                sb.append(pad+ gridToString(grid2D[i], style)).append(NL);
            } else {
                sb.append(pad+ gridToString(grid2D[i], style)).append(SEP).append(NL);
            }
        }
        sb.append(style[3]);
        System.out.println(sb.toString());
    }
    
    public static void printlist(List<List<Integer>> lists) {
        for (List<Integer> list : lists) {
            print(list);
        }
    }
    
    public static void print(List<Integer> list) {
        print(list.toArray(new Integer[0]), BRACKETS);
    }
    
    public static void printNestList(List<List<Integer>> lists) {
        StringBuilder sb = new StringBuilder();
        for (List<Integer> list : lists) {
            if (sb.length() > 0) sb.append(",\n");
            sb.append("\t").append(listToString(list));
        }
        sb.insert(0, "[\n");
        sb.append("\n]").append("\n");
        System.out.println(sb.toString());
    }
    
    private static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (Integer i : list) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(i);
        }
        sb.insert(0, "[").append("]");
        return sb.toString();
    }
    
    public static String toString(int[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i=0; i<nums.length; i++) {
            if (i == (nums.length-1)) {
                sb.append(nums[i]);
            } else {
                sb.append(nums[i]).append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
    
    public static String toString(double[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i=0; i<nums.length; i++) {
            if (i == (nums.length-1)) {
                sb.append(nums[i]);
            } else {
                sb.append(nums[i]).append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
    
    public static String toString(boolean[] nums) {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i=0; i<nums.length; i++) {
            if (i == (nums.length-1)) {
                sb.append(nums[i]? "T" : "F");
            } else {
                sb.append(nums[i]? "T" : "F").append(", ");
            }
        }
        sb.append(" ]");
        return sb.toString();
    }
    
    private static String gridToString(int[] grid1D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]);
        for (int i=0; i<grid1D.length; i++) {
            if (i == (grid1D.length-1)) {
                sb.append(grid1D[i]);
            } else {
                sb.append(grid1D[i]).append(", ");
            }
        }
        sb.append(style[1]);
        return sb.toString();
    }
    
    private static String gridToString(long[] grid1D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]);
        for (int i=0; i<grid1D.length; i++) {
            if (i == (grid1D.length-1)) {
                sb.append(grid1D[i]);
            } else {
                sb.append(grid1D[i]).append(", ");
            }
        }
        sb.append(style[1]);
        return sb.toString();
    }
    private static String gridToString(double[] grid1D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]);
        for (int i=0; i<grid1D.length; i++) {
            if (i == (grid1D.length-1)) {
                sb.append(grid1D[i]);
            } else {
                sb.append(grid1D[i]).append(", ");
            }
        }
        sb.append(style[1]);
        return sb.toString();
    }
    
    private static String gridToString(Integer[] grid1D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]);
        for (int i=0; i<grid1D.length; i++) {
            if (i == (grid1D.length-1)) {
                sb.append(grid1D[i]);
            } else {
                sb.append(grid1D[i]).append(", ");
            }
        }
        sb.append(style[1]);
        return sb.toString();
    }
    
    private static String gridToString(Long[] grid1D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]);
        for (int i=0; i<grid1D.length; i++) {
            if (i == (grid1D.length-1)) {
                sb.append(grid1D[i]);
            } else {
                sb.append(grid1D[i]).append(", ");
            }
        }
        sb.append(style[1]);
        return sb.toString();
    }
    
    private static String gridToString(boolean[] grid1D, String[] style) {
        StringBuilder sb = new StringBuilder();
        sb.append(style[0]);
        for (int i=0; i<grid1D.length; i++) {
            if (i == (grid1D.length-1)) {
                sb.append(grid1D[i]? "T" : "F");
            } else {
                sb.append(grid1D[i]? "T" : "F").append(", ");
            }
        }
        sb.append(style[1]);
        return sb.toString();
    }
    
    
    public static void main(String[] arg) {
        int[] grid1D = new int[] { 1,2,4,5,9,8 };
        
        int[][] grid2D = new int[][] {
            {1,0,0,0,1},
            {0,0,0,1,0},
            {0,0,0,0,0},
            {0,1,0,0,0},
            {0,0,1,0,0}
        };
        
        print(grid1D);
        print(grid2D);
    }
}
