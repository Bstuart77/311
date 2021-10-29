package p1;

public class BST<T extends Comparable<T>> {
	
	public Node<T> insert(Node<T> node, T person) {
		if (node == null) {
			node = new Node<T>((T) person);
		}
		if((node.data != null)) {
		if (node.data.compareTo((T) person	) > 0) {
			node.right = insert(node, person);
		} else {
			node.left = insert(node, person);
		}
		}
		return node;
	}

	public Node<T> search(Node<T> node, T key) {
		if (node == null || node.data == key) {
			return node;
		} else if (key.compareTo(node.data) > 0) { // input key > root.key, go left
			return search(node, key);
		} else {
			return search(node, key);
		}
	}

	public Node<T> findMinValue(Node<T> node) {
		Node<T> current = node;

		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public Node<T> deleteNode(Node<T> node, T key) {
		if (node == null) {
			return node;
		}

		if (node.data.compareTo(key) > 0) {
			node.left = deleteNode(node.left, key);
		} else if (key.compareTo(node.data) > 0) {
			node.right = deleteNode(node.right, key);
		} else { // if contains both children
			if (node.left == null && node.right == null) {
				return null;
			} else if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}
			Node<T> temp = findMinValue(node.right);
			node.data = temp.data;
			node.right = deleteNode(node.right, temp.data);
		}
		return node;
	}
	
	public Node<String> inOrder(Node<String> node) {
		if (node != null) {
			inOrder((Node<String>) node.left);
			System.out.print(node.data + "\n");
			inOrder((Node<String>) node.right);
		}
		return node;
	}
	
	
}