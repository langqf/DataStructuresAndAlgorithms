package lang.tree;

//
public class HuffmanPair {
    private char data;// 节点元素
    private float weight; // 权

    public HuffmanPair(char data, float weight) {
        this.data = data;
        this.weight = weight;
    }

    public char getData() {
        return data;
    }

    public void setData(char data) {
        this.data = data;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

}
