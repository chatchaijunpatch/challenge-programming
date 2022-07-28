package week5_22_7_28.GraphandTree;

public class Nodemain {


    void inorder(Node n1){
        if (n1 == null) return;
        inorder(n1.left);
        System.out.println(n1.value);
        inorder(n1.right);
    }

    public void go() {
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n2 = new Node(2, n4, n5);
        Node n3 = new Node(3);
        Node n1 = new Node(1, n2, n3);
        inorder(n1);
    }
    public static void main(String[] args) {
        new Nodemain().go();
    }
}
