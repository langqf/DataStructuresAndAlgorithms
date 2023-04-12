package lang.tree;

// 哈夫曼树节点元素
public class HuffmanNode {

    private int weight; // 权
    private int parent; // 父节点索引
    private int lch; // 子孩子索引
    private int rch; // 右孩子索引

    public HuffmanNode(int weight, int parent, int lch, int rch) {
        this.weight = weight;
        this.parent = parent;
        this.lch = lch;
        this.rch = rch;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }

    public int getLch() {
        return lch;
    }

    public void setLch(int lch) {
        this.lch = lch;
    }

    public int getRch() {
        return rch;
    }

    public void setRch(int rch) {
        this.rch = rch;
    }

    public String toString(int index) {
        return "HuffmanNode: " +  index + " {" +
                "weight=" + weight +
                ", parent=" + parent +
                ", lch=" + lch +
                ", rch=" + rch +
                '}';
    }
}
