package leetcode.common;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;
    public UndirectedGraphNode(int x) {
        this.label = x;
        neighbors = new ArrayList<>();
    }
    
    public String toString() {
        return "" + label + ", neighbors.size() " + neighbors.size();
    }
}
