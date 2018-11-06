package leetcode.common;

public class NodeReverse {
    public NodeReverse parent;
    public int v;
    public NodeReverse(int v, NodeReverse p) {
        this.v = v;
        this.parent = p;
    }
}
