package p1;

public class BST<T extends Comparable<T>> {

	private Node<T> root;

	public BST() {
		root = null;
	}

	void insert(T key) {
		root = insert_Recursive(root, key);
		System.out.println(key);
	}

	// recursive insert function
	Node<T> insert_Recursive(Node<T> root, T key) {
		// tree is empty
		if (root == null) {
			root = new Node<T>(key);
			return root;
		}
		// traverse the tree
		if (key.compareTo(root.data) < 0) { // insert in the left subtree
			root.left = insert_Recursive(root.left, key);
		} else if (key.compareTo(root.data) > 0) { // insert in the right subtree
			root.right = insert_Recursive(root.right, key);
		}
		return root;
	}

	public boolean search(Node<T> root, T key) {
		root = searchH(root, key);
		if (root != null) {
			System.out.println("FOUND!");
			return true;
		} else {
			System.out.println("NOT FOUND");
			return false;
		}
	}

	public Node<T> searchH(Node<T> node, T key) {
		Person pKey = (Person) key;
		Person pRoot = (Person) root.data;

		if (node == null || pKey.getName().equals(pRoot.getName())) {
			return node;
		}

		if (node.data.compareTo(key) > 0) {
			return searchH(node.left, key);
		}
		return searchH(node.right, key);
	}

	public Node<T> findMinValue(Node<T> node) {
		Node<T> current = node;

		while (current.left != null) {
			current = current.left;
		}
		return current;
	}

	public Node<T> deleteNode(Node<T> node, T key) { // REDO WITH TYPER LINK
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

	public Node<T> inOrder(Node<T> node) {
		if (node != null) {
			inOrder((Node<T>) node.left);
			System.out.print(node.data + "\n");
			inOrder((Node<T>) node.right);
		}
		return node;
	}

	public Node<T> getRoot() {
		//System.out.println(root);
		return root;
	}

}