package leetcode.common;

import java.util.Arrays;

public class CopyUtils {

    public static int[][] copy2D(int[][] data) {
        int[][] dataCopy = Arrays.stream(data)
            .map((int[] row) -> row.clone())
            .toArray((int length) -> new int[length][]);
        return dataCopy;
    }
}
