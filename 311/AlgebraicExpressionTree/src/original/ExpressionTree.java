package original;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Brian Stuart
 *
 */
public class ExpressionTree<T> {

	private Node<String> root;
	private String infix;

	public ExpressionTree(String infix) {
		ArrayList<String> arr = infixToPostFix(infix);
		this.root = postFixToExpTree(arr);
	}

	/**
	 * Order of operations from 1-5, given c value
	 * 
	 * @param c - inputted char (+,-,*,/,(,^,' ')
	 * 
	 * @return returns number for order of operations
	 */

	int isOperator(String s) { // order of operations
		switch (s) {
		case "+":
		case "-":
			return 1;
		case "*":
		case "/":
			return 2;
		case "^":
			return 3;
		case "(": // added because with this it displays the original equation without '()'
		case ")":
		case " ":
			return 4;
		}
		return -1;
	}

	/**
	 * Takes in expression turns it into a char array and then goes through each
	 * indivisual character
	 * 
	 * @param expression - inputted String 1 + (2 * 3)
	 * 
	 * @return returns postfixed results (1 2 3 *+).
	 */

	ArrayList<String> infixToPostFix(String expression) {
		String[] exp = expression.split(" ");

		Stack<String> stack = new Stack<>();
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < exp.length; i++) {

			if (isNumber(exp[i])) {
				arr.add(exp[i]);
			} else if (exp[i].equals("(")) {
				stack.push(exp[i]);
			} else if (exp[i].equals(")")) {

				while (!stack.peek().equals("(")) {
					arr.add(stack.pop());
				}

				stack.pop();

			} else if (!stack.isEmpty() && isOperator(exp[i]) > isOperator(stack.peek())) {
				stack.push(exp[i]);
			} else

				while (isOperator(stack.peek()) >= isOperator(exp[i])) {
					stack.push(exp[i]);
				}
		}
		while (stack.size() != 0) {
			arr.add(stack.pop());
		}
		return arr;
	}

	public Node<String> postFixToExpTree(ArrayList<String> arr) {

		Stack<Node<String>> stack = new Stack<Node<String>>();

		if()
	}

	public boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
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
	void inOrder(Node<T> node) {
		if (node != null) {
			inOrder((Node<T>) node.left);
			System.out.print(node.data + " ");
			inOrder((Node<T>) node.right);
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
