package method.binaryTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTreeDemo {
    public static void main(String[] args) {

        /**
         *                      A
         *                    /  \
         *                  B     C
         *                /      / \
         *               D      E   F
         *             / \       \
         *            G   H       J
         *               /
         *              I
         */
        Node nodeA = new Node("A");
        Node nodeB = new Node("B");
        Node nodeC = new Node("C");
        Node nodeD = new Node("D");
        Node nodeE = new Node("E");
        Node nodeF = new Node("F");
        Node nodeG = new Node("G");
        Node nodeH = new Node("H");
        Node nodeI = new Node("I");
        Node nodeJ = new Node("J");

        nodeA.setLeft(nodeB);
        nodeA.setRight(nodeC);

        nodeB.setLeft(nodeD);

        nodeC.setLeft(nodeE);
        nodeC.setRight(nodeF);

        nodeD.setLeft(nodeG);
        nodeD.setRight(nodeH);

        nodeE.setRight(nodeJ);

        nodeH.setLeft(nodeI);

        System.out.println("先序遍历：");
        preOrder(nodeA);
        System.out.println("\r\n 中序遍历：");
        midOrder(nodeA);
        System.out.println("\r\n 后序遍历：");
        lastOrder(nodeA);
        System.out.println("\r\n 层序遍历：");
        LevelTravelQueue(nodeA);


    }

    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.value);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void midOrder(Node root) {
        if (root != null) {
            midOrder(root.left);
            System.out.print(root.value);
            midOrder(root.right);
        }
    }

    public static void lastOrder(Node root) {
        if (root != null) {
            lastOrder(root.left);
            lastOrder(root.right);
            System.out.print(root.value);
        }
    }


    /**
     *
     * @param root
     * 借助queue的顺序性，每次遍历节点并将其子节点塞到queue最后，遍历完整个queue
     */
    public static void LevelTravelQueue(Node root){
        if(root == null)
            return;
        Queue<Node> nodeQueue = new ArrayDeque<>();
        nodeQueue.add(root);

        Node node;

        while(!nodeQueue.isEmpty()){
            node = nodeQueue.peek();
            if(node != null){
                System.out.print(node.value);
                nodeQueue.remove();
            }
            if(node.left != null){
                nodeQueue.add(node.left);
            }

            if(node.right != null){
                nodeQueue.add(node.right);
            }
        }

    }
}

class Node implements Comparable {
    public Node(String value) {
        this.value = value;
    }

    String value;
    Node left;
    Node right;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", left=" + left.value +
                ", right=" + right.value +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 1;
    }
}