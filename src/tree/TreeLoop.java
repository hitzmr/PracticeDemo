package tree;

public class TreeLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node5 = new Node(5, null, null);
		Node node4 = new Node(4, null, null);
		Node node3 = new Node(3, null, null);
		Node node2 = new Node(2, node4, node5);
		Node node1 = new Node(1, node2, node3);
		
		TreeLoop treeLoop = new TreeLoop();
		treeLoop.preOrder(node1);
		

	}
	
	public void preOrder(Node node){
		if(node != null){
			System.out.println(node.root);
			preOrder(node.left);
			preOrder(node.right);
		}
		
	}
	
	public void midOrder(Node node){
		System.out.println(node.left);
		System.out.println(node.root);
		System.out.println(node.right);
	}
	
	public void lastOrder(Node node){
		System.out.println(node.left);
		System.out.println(node.right);
		System.out.println(node.root);
	}

}

class Node{
	int root;
	Node left;
	Node right;
	public Node(int root, Node left, Node right){
		this.root = root;
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return "Node [root=" + root + "]";
	}
}