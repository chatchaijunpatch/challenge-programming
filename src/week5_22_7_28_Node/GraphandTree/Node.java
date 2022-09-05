package week5_22_7_28_Node.GraphandTree;

public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value, Node... n) {
        this.value = value;
        left = null;
        right = null;
        if (n.length == 1)
            left = n[0];
        if (n.length == 2) {
            left = n[0];
            right = n[1];
        }
    }

    public int getValue() {
        return value;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }


}
