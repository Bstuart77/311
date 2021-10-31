package p1;

public class Node<T> {
	Node<T> left, right;		//instance variables left, right
	T data;						//generic Data because we dont know what we'll pass in

	/**
	 * Constructor to place new Nodes in trees
	 * 
	 * @param key - Pass Data into tree
	 * 
	 */
	
	public Node(T data) {
		this.data = data;
		left = right = null;
	}

	/**
	 * gets left childs node
	 * 
	 * @return left child node
	 * 
	 */
	
	public Node<T> getLeft() {
		return left;
	}

	/**
	 * setLeft's childs data
	 * 
	 * @param left given by args
	 * 
	 */
	
	public void setLeft(Node<T> left) {
		this.left = left;
	}

	/**
	 *  getRight child's node
	 * 
	 * @return right child
	 * 
	 */
	
	public Node<T> getRight() {
		return right;
	}

	/**
	 * setRight childs data
	 * 
	 * @param right given by args
	 * 
	 */

	public void setRight(Node<T> right) {
		this.right = right;
	}

	/**
	 *  gets Data for node
	 * 
	 * @return data of specific node
	 * 
	 */
	
	public T getData() {
		return data;
	}
	
	/**
	 * setsData of node
	 * 
	 * @param data given by args
	 * 
	 */

	public void setData(T data) {
		this.data = data;
	}

	
	@Override
	public String toString() {
		return "\nData = " + data + " ,left=" + left + ", right=" + right;
	}

	
	
}
