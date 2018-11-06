package leetcode.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.JsonArray;
import com.google.gson.JsonParser;

public class InputUtils {
    
    public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        if (input.length() == 0) {
            return new int[0];
        }

        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for (int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }

    public static int[][] stringToInt2dArray(String input) {
        JsonArray jsonArray = new JsonParser().parse(input).getAsJsonArray();
        if (jsonArray.size() == 0) {
            return new int[0][0];
        }

        int[][] arr = new int[jsonArray.size()][];
        for (int i = 0; i < arr.length; i++) {
            JsonArray cols = jsonArray.get(i).getAsJsonArray();
            arr[i] = stringToIntegerArray(cols.toString());
        }
        return arr;
    }
    
    public static void main(String[] args) throws IOException {
        String s = "[[1, 7][3, 6], [5, 6]]";
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            int[][] edges = stringToInt2dArray(line);
            PrintUtils.print(edges);
            line = in.readLine();
            int M = Integer.parseInt(line);
            line = in.readLine();
            int N = Integer.parseInt(line);
            
            int ret = 10; // new Solution().reachableNodes(edges, M, N);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}
