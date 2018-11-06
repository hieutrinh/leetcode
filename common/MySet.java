package leetcode.common;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class MySet {

    public static void main(String[] args) {
        Set<Point> set = new HashSet<>();
        set.add(new Point(1,2));
        set.add(new Point(2,3));
        System.out.println(set.size());
        set.remove(new Point(1,2));
        System.out.println(set.size());
    }
    
    public static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        public String toString() {
            return "(" + x + "," + y + ")";
        }
        
        @Override
        public boolean equals(Object o) {
//            if (this == o)
//                return true;
//            if (o == null || getClass() != o.getClass())
//                return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}
