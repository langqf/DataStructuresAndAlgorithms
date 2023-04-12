package lang.tree;

// 哈夫曼编码树节点元素
public class HuffmanCodeNode {
    private Character data;// 节点元素
    private float weight; // 权
    private int parent; // 父节点索引
    private int lch; // 子孩子索引
    private int rch; // 右孩子索引

    public HuffmanCodeNode(Character data, float weight, int parent, int lch, int rch) {
        this.data = data;
        this.weight = weight;
        this.parent = parent;
        this.lch = lch;
        this.rch = rch;
    }

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
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
        return "HuffmanCodeNode: " +  index + " {" +
                "data=" + data +
                ", weight=" + weight +
                ", parent=" + parent +
                ", lch=" + lch +
                ", rch=" + rch +
                '}';
    }
}
