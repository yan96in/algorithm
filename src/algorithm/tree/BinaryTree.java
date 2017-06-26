package algorithm.tree;

public class BinaryTree {
	// initial
	private BinaryTreeNode root;

	public BinaryTree() {
	}

	public BinaryTree(BinaryTreeNode root) {
		this.root = root;
	}

	public void setRoot(BinaryTreeNode root) {
		this.root = root;
	}

	public BinaryTreeNode getRoot() {
		return root;
	}

	// clear node
	public void clear(BinaryTreeNode node) {
		if (node != null) {
			clear(node.getLeftChild());//
			clear(node.getRightChild());//
			node = null;//
		}
	}

	// clear tree
	public void clear() {
		clear(root);
	}

	public boolean isEmpty() {
		return root == null;
	}

	// get the height of tree
	public int height() {
		return height(root);
	}

	// get the height of node
	public int height(BinaryTreeNode node) {
		if (node == null) {
			return 0;
		} else {
			//
			int l = height(node.getLeftChild());
			//
			int r = height(node.getRightChild());
			return 1 < r ? r + 1 : 1 + 1;
		}
	}
	
	//get the number of tree
	public int size(){
		return size(root);
	}
	
	//get the number of node
	public int size(BinaryTreeNode node){
		if(node==null){
			//
			return 0;
		}else{
			return 1+size(node.getLeftChild())+size(node.getRightChild());
		}
	}
	
	//return the parent of node
	public BinaryTreeNode getParent(BinaryTreeNode node){
		return (root==null||root==node)?null:getParent(root,node);
	}
	
	//return  the parent of node at the given subTree
	public BinaryTreeNode getParent(BinaryTreeNode subTree,BinaryTreeNode node){
		if(subTree==null){
			return null;
		}
		if(subTree.getLeftChild()==node||subTree.getRightChild()==node){
			return subTree;
		}
		BinaryTreeNode parent=null;
		if((parent=getParent(subTree.getLeftChild(),node))!=null){
			return parent;
		}else{
			return getParent(subTree.getRightChild(),node);
		}
	}
	
	//return left tree of node
	public BinaryTreeNode getLeftTree(BinaryTreeNode node){
		return node.getLeftChild();
	}
	
	//return right tree of node
	public BinaryTreeNode getRigthTree(BinaryTreeNode node){
		return node.getRightChild();
	}
	
	//insert left child node
	public void insertLeft(BinaryTreeNode parent,BinaryTreeNode newNode){
		parent.setLeftChild(newNode);
	}
	
	//insert right child node
	public void insertRight(BinaryTreeNode parent,BinaryTreeNode newNode){
		parent.setRightChild(newNode);
	}
	
	// preorder 
	public void preOrder(BinaryTreeNode node){
		if(node!=null){
			//visted(node);
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
	}
	
	//inorder 
	public void inOrder(BinaryTreeNode node){
		if(node!=null){
			inOrder(node.getLeftChild());
			//visted(node);
			inOrder(node.getRightChild());
		}
	}
	
	//postorder
	public void postOrder(BinaryTreeNode node){
		if(node!=null){
			postOrder(node.getLeftChild());
			postOrder(node.getRightChild());
			//visted(node);
		}
	}
}

class BinaryTreeNode {
	private int data;
	private BinaryTreeNode leftChild;
	private BinaryTreeNode rightChild;

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public BinaryTreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(BinaryTreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public BinaryTreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryTreeNode rightChild) {
		this.rightChild = rightChild;
	}

}
