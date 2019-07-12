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
        levelTravelQueue(nodeA);

        System.out.println("\r\n 二叉树深度" + getDepth(nodeA));
        System.out.println("\r\n 二叉树最大宽度 " +getMaxWidth(nodeA));


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
     * 求二叉树的深度
     */
    public static int getDepth(Node node){
        if(node == null)
            return 0;

        // 如果左子树或者右子树是空的，那么就要对应的去右子树或者左子树上面继续往下找
        if(node.left == null)
            return getDepth(node.right)+1;

        if(node.right == null)
            return getDepth(node.left)+1;

        // 如果左子树右子树都非空，那么就要取左子树的子树和右子树的子树中最大深度的那个
        int leftDep = getDepth(node.left);
        int rightDep = getDepth(node.right);
        return leftDep>rightDep?leftDep+1:rightDep+1;
    }

    /**
     * 求二叉树宽度
     * 利用嵌套while循环，外层循环得到当前队列的大小，将其当作当前层的节点个数，遍历完这些节点之后，对应的下一层节点也将全部进入队列
     */
    public static int getMaxWidth(Node root) {
        if (root == null)
            return 0;

        Queue<Node> queue = new ArrayDeque<Node>();
        int maxWitdth = 1; // 最大宽度
        queue.add(root); // 入队

        while (true) {
            int len = queue.size(); // 当前层的节点个数
            if (len == 0)
                break;
            while (len > 0) {// 如果当前层，还有节点
                Node t = queue.poll();
                len--;
                if (t.left != null)
                    queue.add(t.left); // 下一层节点入队
                if (t.right != null)
                    queue.add(t.right);// 下一层节点入队
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