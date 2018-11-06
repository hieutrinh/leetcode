package leetcode.common;

public class MatrixUtils {

    private final static int[] right = {0,1};
    private final static int[] left = {0,-1};
    private final static int[] down = {1,0};
    private final static int[] up = {-1,0};
    private final static int[][] cwdirs = { right, down, left, up };
    private final static int[][] swdirs = { down, left };

    public static int[][] traversalSw(int[][] matrix, int startRow, int startCol, int[][] dirs) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        int direction = 0;
        int r = startRow, c = startCol;
        int[][] result = new int[row * col][2];
        
        int index = 0;
        while (0 <= r && r < row && 0 <= c && c < col && !visited[r][c]) {
            result[index][0] = r;
            result[index][1] = c;
            visited[r][c] = true;
            int nr = r + dirs[direction][0];
            int nc = c + dirs[direction][1];
            if (0 <= nr && nr < row && 0 <= nc && nc < col && !visited[nr][nc]) {
                r = nr;
                c = nc;
            } else {
                direction = (direction + 1) % dirs.length;
                r = r + dirs[direction][0];
                c = c + dirs[direction][1];
                if (0 <= nr && nr < row && 0 <= nc && nc < col && !visited[nr][nc]) {
                    break;
                }
            }
            index++;
        }
        return result;
    }
    
    public static int[][] traversalSw(int[][] matrix, int[][] dirs) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        int direction = 0;
        int[][] result = new int[row * col][2];
        
        int index = 0;
        for (int j=matrix[0].length-1; j>=0; j--) {
            
            int r = 0, c = j;
            while (0 <= r && r < row && 0 <= c && c < col && !visited[r][c]) {    
                result[index][0] = r;
                result[index][1] = c;
                
                visited[r][c] = true;
                int nr = r + dirs[direction][0];
                int nc = c + dirs[direction][1];
                if (0 <= nr && nr < row && 0 <= nc && nc < col && !visited[nr][nc]) {
                    r = nr;
                    c = nc;
                } else {
                    direction = (direction + 1) % dirs.length;
                    r = r + dirs[direction][0];
                    c = c + dirs[direction][1];
                    if (0 <= nr && nr < row && 0 <= nc && nc < col && !visited[nr][nc]) {
                        break;
                    }
                }
                index++;
            }
        }
        return result;
    }
    
    public static int[][] traversalCw(int[][] matrix, int[][] dirs) {
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] visited = new boolean[row][col];
        int direction = 0;
        int r = 0, c = 0;
        int[][] result = new int[row * col][2];
        
        for (int i=0; i<row*col; i++) {
            result[i][0] = r;
            result[i][1] = c;
            visited[r][c] = true;
            int nr = r + dirs[direction][0];
            int nc = c + dirs[direction][1];
            if (0 <= nr && nr < row && 0 <= nc && nc < col && !visited[nr][nc]) {
                r = nr;
                c = nc;
            } else {
                direction = (direction + 1) % dirs.length;
                r = r + dirs[direction][0];
                c = c + dirs[direction][1];
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[][] matrix = new int[4][5];
        PrintUtils.print(traversalCw(matrix, cwdirs));
        PrintUtils.print(traversalSw(matrix, swdirs));
        
        for (int col=matrix[0].length-1; col>=0; col--) {
            PrintUtils.print(traversalSw(matrix, /*row*/ 0, col, swdirs));
        }
    }
}
