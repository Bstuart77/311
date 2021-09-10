package p1.copy;

import java.util.Stack;

public class ExpressionTree<T> {

	public ExpressionTree() {
		
	}

	static boolean isOperator(char c) { // order of operations
		return (c == '+' || c == '-' || c == '×' || c == '/' || c == '^');
	}

	@SuppressWarnings("unchecked")
	public Node<T> construct(String postfix) {
		// create an empty stack to store tree pointers
		Stack<Node<Character>> s = new Stack<>();

		// traverse the postfix expression
		for (char c : postfix.toCharArray()) {
			// if the current token is an operator
			if (isOperator(c)) {
				// pop two nodes `x` and `y` from the stack
					Node<Character> x = s.pop();
					Node<Character> y = s.pop();

					// construct a new binary tree whose root is the operator and whose
					// left and right children point to `y` and `x`, respectively
					Node<Character> node = new Node(c, y, x);

					// push the current node into the stack
					s.add(node);

					// if the current token is an operand, create a new binary tree node
					// whose root is the operand and push it into the stack
				} else {
					s.add(new Node<Character>(c));
				}
			}

			// a pointer to the root of the expression tree remains on the stack

		return (Node<T>) s.peek();
	}

	@SuppressWarnings("unchecked")
	void preOrder(Node<T> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder((Node<T>) node.left);
			preOrder((Node<T>) node.right);
			System.out.println(node.data);
		}
	}

	@SuppressWarnings("unchecked")
	void inorder(Node root) {
		if (root == null) {
			return;
		}
		// if the current token is an operator, print open parenthesis
		if (isOperator((char) root.data)) {
			System.out.print("(");
		}

		inorder((Node) root.left);
		System.out.print(root.data);
		inorder((Node) root.right);

		// if the current token is an operator, print close parenthesis
		if (isOperator((char) root.data)) {
			System.out.print(")");
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
