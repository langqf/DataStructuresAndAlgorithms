package lang.my.stack;

public class StackObject {

    private int value;

    public StackObject(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "value=" + value;
    }
}
