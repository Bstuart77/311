package p1.copy;

public class Node<T> {
	T left, right;
	T data;

	public Node(T data) {
		this.data = data;
		left = right = null;
	}

	public Node(T data, T left, T right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}

	public T getLeft() {
		return left;
	}

	public T getRight() {
		return right;
	}

	public T getNode() {
		return data;
	}

	@Override
	public String toString() {
		return "left=" + left + ", right=" + right;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Node<T> other = (Node<T>) obj;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null) {
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}

}
