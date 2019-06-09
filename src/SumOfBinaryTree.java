
public class SumOfBinaryTree {
	public static void main(String[] args){
		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(5);
		Node node5 = new Node(-1);
		Node node6 = new Node(-8);
		Node node7 = new Node(10);
		Node node8 = new Node(4);
		Node node9 = new Node(9);
		Node node10 = new Node(7);
		Node node11 = new Node(6);
		
		node1.setLeft(node2);
		node1.setRight(node3);
		
		node2.setLeft(node4);
		node2.setRight(node5);
		
		node3.setLeft(node6);
		node3.setRight(node7);
		
		node4.setLeft(node8);
		node4.setRight(node9);
		
		node5.setLeft(node10);
		node5.setRight(node11);
		
		int maxSum = getMaximumSum(node1);
		System.out.println(maxSum);
	}
	
	public static int getMaximumSum(Node root){
		if(root == null)
			return 0;
		
		int leftSum = preOrder(root.left);
		int rightSum = preOrder(root.right);
		
		if(leftSum > rightSum){
			System.out.println("leftSum");
			return leftSum;
		}else{
			System.out.println("rightSum");
			return rightSum;
		}
	}
	
	public static int preOrder(Node root){
		if(root == null)
			return 0;
		
		int sum = 0;
		sum += root.value;
		sum += preOrder(root.left);
		sum += preOrder(root.right);
		
		return sum;
	}

}


class Node{
	@Override
	public String toString() {
		return "Node [value=" + value + ", left=" + left.value + ", right=" + right.value
				+ "]";
	}

	int value;
	Node left;

	Node right;
	
	public Node(int value){
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
	
}