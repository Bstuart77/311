package p1.copy2;

import java.util.Stack;

public class ExpressionTree<T> {

	public ExpressionTree() {

	}

	boolean boolIsOperator(char c) { // order of operations
		switch (c) {
			case '+':
			case '-':
			case '*':
			case '/':
			case '^':
				return true;
		}
		return false;
	}

	Node<T> constructTree(char postfix[]) {
		Stack<T> st = new Stack<T>();
		Node<T> t, t1, t2;

		// Traverse through every character of
		// input expression
		for (int i = 0; i < postfix.length; i++) {

			// If operand, simply push into stack
			if (!boolIsOperator(postfix[i])) {
				t = new Node(postfix[i]);
				st.push((T) t);
			} else {	//opperator
				t = new Node(postfix[i]);

				// Pop two top nodes
				// Store top
				t1 = (Node<T>) st.pop(); // Remove top
				t2 = (Node<T>) st.pop();

				// make them children
				t.right = (T) t1;
				t.left = (T) t2;

				// System.out.println(t1 + "" + t2);
				// Add this subexpression to stack
				st.push((T) t);
			}
		}

		// only element will be root of expression
		// tree
		t = (Node<T>) st.peek();
		st.pop();

		return t;
	}

	@SuppressWarnings("unchecked")
	void preOrder(Node<T> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder((Node<T>) node.left);
			preOrder((Node<T>) node.right);
		}
	}

	@SuppressWarnings("unchecked")
	void inorder(Node t) {
		if (t != null) {
			inorder((Node) t.left);
			System.out.print(t.data + " ");
			inorder((Node) t.right);
		}
	}

	@SuppressWarnings("unchecked")
	void postOrder(Node<T> node) {
		if (node != null) {
			postOrder((Node<T>) node.left);
			postOrder((Node<T>) node.right);
			System.out.print(node.data);
		}
	}

}
