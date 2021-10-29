package p1;

public class Node<T> {
	Node<T> left, right;
	T data;

	public Node(T data) {
		this.data = data;
		left = right = null;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Data = " + data + " ,left=" + left + ", right=" + right;
	}

	
	
}
