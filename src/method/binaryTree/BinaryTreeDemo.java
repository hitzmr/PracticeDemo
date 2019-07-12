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

        System.out.println("���������");
        preOrder(nodeA);
        System.out.println("\r\n ���������");
        midOrder(nodeA);
        System.out.println("\r\n ���������");
        lastOrder(nodeA);
        System.out.println("\r\n ���������");
        levelTravelQueue(nodeA);

        System.out.println("\r\n ���������" + getDepth(nodeA));
        System.out.println("\r\n ����������� " +getMaxWidth(nodeA));


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
     * ����queue��˳���ԣ�ÿ�α����ڵ㲢�����ӽڵ�����queue��󣬱���������queue
     */
    public static void levelTravelQueue(Node root){
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

    /**
     * ������������
     */
    public static int getDepth(Node node){
        if(node == null)
            return 0;

        // ��������������������ǿյģ���ô��Ҫ��Ӧ��ȥ�����������������������������
        if(node.left == null)
            return getDepth(node.right)+1;

        if(node.right == null)
            return getDepth(node.left)+1;

        // ������������������ǿգ���ô��Ҫȡ���������������������������������ȵ��Ǹ�
        int leftDep = getDepth(node.left);
        int rightDep = getDepth(node.right);
        return leftDep>rightDep?leftDep+1:rightDep+1;
    }

    /**
     * ����������
     * ����Ƕ��whileѭ�������ѭ���õ���ǰ���еĴ�С�����䵱����ǰ��Ľڵ��������������Щ�ڵ�֮�󣬶�Ӧ����һ��ڵ�Ҳ��ȫ���������
     */
    public static int getMaxWidth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new ArrayDeque<Node>();
        int maxWitdth = 1; // �����
        queue.add(root); // ���

        while (true) {
            int len = queue.size(); // ��ǰ��Ľڵ����
            if (len == 0)
                break;
            while (len > 0) {// �����ǰ�㣬���нڵ�
                Node t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // ��һ��ڵ����
                if (t.right != null)
                    queue.add(t.right);// ��һ��ڵ����
            }
            maxWitdth = Math.max(maxWitdth, queue.size());
        }
        return maxWitdth;
    }

//    public static boolean isBalance(Node root){
//        if(root == null)
//            return true;
//
//        if(root.left.value < root.value && root.right.value > root.value){
//            return isBalance(root.left)&isBalance(root.right);
//        }else{
//            return false;
//        }
//    }
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