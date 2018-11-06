package leetcode.common;

public class PrintTime {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        long st = System.currentTimeMillis();
        for (long i = 0L; i < 1000000L; i++) {
            sb.append(i);
        }
        System.out.println(sb.toString());
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - st));
    }
}
