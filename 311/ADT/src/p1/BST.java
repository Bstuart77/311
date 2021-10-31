package p1;

/**
 * @author Brian Stuart
 *
 */

public class BST<T extends Comparable<T>> {

	private Node<T> root;

	public BST() {
		root = null;
	}

	/**
	 * Insert method passed to insertH helper method
	 * 
	 * @param key - inputed Person from txt file
	 * 
	 */

	void insert(T key) {
		root = insertH(root, key); // set instance root = insert Helper function(root, inputed key)
		System.out.println(key);
	}

	/**
	 * Insert helper method. Determine where node should be placed
	 * 
	 * @param (root, person) - root, Person object
	 * 
	 * @return return Node<T> got inserted Person
	 * 
	 */

	Node<T> insertH(Node<T> root, T person) {

		if (root == null) {
			root = new Node<T>(person);			//make a new Node = person
			return root;
		}

		if (person.compareTo(root.data) < 0) { 					//left subtree
			root.left = insertH(root.left, person);

		} else if (person.compareTo(root.data) > 0) { 			//right subtree
			root.right = insertH(root.right, person);
		}

		return root;
	}

	/**
	 * Delete method passed to insertH helper method
	 * 
	 * @param person - deletes Person if Person exists
	 * 
	 */

	public void delete(T person) {
		root = deleteH(root, person);				//set instance root = delete Helper(root, person)

	}

	/**
	 * Delete helper method. Determine whether Person exists and deletes them
	 * 
	 * @param (node, person) - (root, Person object)
	 * 
	 * @return return Node<T> got from deleted Person
	 * 
	 */

	private Node<T> deleteH(Node<T> node, T person) {
		if (node == null) {
			return node;
		}

		if (node.data.compareTo(person) > 0) {			//go left
			node.left = deleteH(node.left, person);
			
		} else if (node.data.compareTo(person) > 0) {	//go right
			node.right = deleteH(node.right, person);
			
		} else {										//left and right exist

			if (node.right == null) {
				System.out.println("Found");
				return node.right;
				
			} else if (node.left == null) {
				System.out.println("Found");
				return node.left;
			}

			node.data = findMinValue(node.right);			//find value of right subtree
			node.right = deleteH(node.right, person);		//delete node.right and make the right child the parent
		}
		return node;
	}

	/**
	 * Finds minimum value of nodes
	 * 
	 * @param (node) - Person object
	 * 
	 * @return T gotten from comparing data from nodes
	 * 
	 */

	private T findMinValue(Node<T> node) {
		T minValue = node.data;
		
		while (node.left != null) {
			minValue = node.left.data;
			node = node.left;
		}
		return minValue;
	}

	/**
	 * Search method passed to Search helper method
	 * 
	 * @param (root, person) - (root, name)
	 * 
	 * @return T/F
	 */

	public boolean search(Node<T> root, T person) {
		root = searchH(root, person);
		
		if (root != null) {
			System.out.println("FOUND!");
			return true;
			
		} else {
			System.out.println("NOT FOUND");
			return false;
		}
	}

	/**
	 * Search helper method. Displays the T/F depending on if it exists
	 * 
	 * @param (node, person) - (root, Person object)
	 * 
	 * @return return Node<T> whether Person was found or not
	 * 
	 */

	public Node<T> searchH(Node<T> node, T person) {
		Person pKey = (Person) person;					//pKey  to keep track of the generic object
		Person pRoot = (Person) node.data;				//pRoot to keep track of the persons root

		if (node == null || pKey.getName().equals(pRoot.getName())) {
			return node;
		}

		if (node.data.compareTo(person) > 0) {	//if nodes data > passed in person data go left
			return searchH(node.left, person);
		}
		
		return searchH(node.right, person);
	}

	/**
	 * Modifies a given node to a different person's value
	 * 
	 * @param (root, person) - (root, Person object)
	 * 
	 */
	
	public void modify(Node<T> node, T person) {
		if (search(node, node.data)) {
			delete(node.data);
			insert(person);
		}
	}

	/**
	 * Displays tree inOrder 
	 * 
	 * @param node
	 */
	public void inOrder(Node<T> node) {
		if (node != null) {
			inOrder((Node<T>) node.left);
			System.out.print(node.data + "\n");
			inOrder((Node<T>) node.right);
		}
	}
	/**
	 * Gets the root of tree
	 * 
	 * @return Node<T>
	 */
	public Node<T> getRoot() {
		// System.out.println(root);
		return root;
	}

}