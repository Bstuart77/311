package p1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author Brian Stuart
 *
 */
public class ExpressionTree {

	private Node<String> root;
	private String infix;

	public ExpressionTree(String infix) {
		ArrayList<String> arr = infixToPostFix(infix); // arr = inputted string to infixtoPostFix method
		this.infix = infix;
		this.root = postFixToExpTree(arr); // root = inputted arraylise for postFixToExpTree
	}

	/**
	 * Order of operations from 1-5, given s value
	 * 
	 * @param s - inputted string (+,-,*,/,(,^,' ')
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
		}
		return -1;
	}

	/**
	 * checks if s is a operator
	 * 
	 * @param s - inputted string (+,-,*,/,(,^,' ')
	 * 
	 * @return T/F depending on if operator is s
	 */
	boolean boolIsOperator(String s) { // order of operations
		switch (s) {
		case "+":
		case "-":
		case "*":
		case "/":
		case "^":
			return true;
		}
		return false;
	}

	/**
	 * Takes in expression
	 * 
	 * @param expression - inputted String 1 + (2 * 3)
	 * 
	 * @return returns postfixed results (1 2 3 *+).
	 */

	ArrayList<String> infixToPostFix(String expression) {

		String[] exp = expression.split(" "); // split the expression at spaces

		Stack<String> stack = new Stack<>();
		ArrayList<String> arr = new ArrayList<>();

		for (int i = 0; i < exp.length; i++) {

			if (isNumber(exp[i])) { // if isNumber is true
				arr.add(exp[i]); // add to arrList

			} else if (exp[i].equals(" ")) {
				arr.add(exp[i]);
				
			} else if (boolIsOperator(exp[i])) {
				stack.push(exp[i]);
				
			} else if (exp[i].equals("(")) { // if exp[i] continue or else "(" shows in output
				continue;
				
			} else if (exp[i].equals(")")) {

				while (!stack.isEmpty()) {
					arr.add(stack.pop());

				}

				// operator checks high to low
			} else if (!stack.isEmpty() && isOperator(exp[i]) > isOperator(stack.peek())) { // if operator has a higher
																							// return value then on top
																							// of stack
				stack.push(exp[i]); // push to stack

			} else { // exp[i] is operator

				// opperator checks low to high
				while (!stack.isEmpty() && isOperator(exp[i]) <= isOperator(stack.peek())) { // if read operator >= top
																								// of stack
					arr.add(stack.pop()); // add to outputted arr
				}
				
				stack.push(exp[i]); // when done, push operator to stack
			}
		}
		return arr;
	}

	public Node<String> postFixToExpTree(ArrayList<String> arr) {

		Stack<Node<String>> stack = new Stack<Node<String>>();

		for (String str : arr) {

			if (isNumber(str)) { // if isNumber is true
				root = new Node<String>(str); // new root = str
				stack.push(root);

			} else {
				root = new Node<String>(str); // root for operator
				root.right = stack.pop(); // operator.right
				root.left = stack.pop();
				stack.push(root);
			}
		}
		return root;
	}

	public boolean isNumber(String s) {
		try {
			Integer.parseInt(s); // Turn s to a number
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	private Node<String> preOrder(Node<String> node) {
		if (node != null) {
			System.out.print(node.data + " ");
			preOrder((Node<String>) node.left);
			preOrder((Node<String>) node.right);
		}
		return node;
	}

	@SuppressWarnings("unchecked")
	private Node<String> inOrder(Node<String> node) {
		if (node != null) {
			inOrder((Node<String>) node.left);
			System.out.print(node.data + "\n");
			inOrder((Node<String>) node.right);
		}
		return node;
	}

	@SuppressWarnings("unchecked")
	private Node<String> postOrder(Node<String> node) {
		if (node != null) {
			postOrder((Node<String>) node.left);
			postOrder((Node<String>) node.right);
			System.out.print(node.data + " ");

		}
		return node;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExpressionTree other = (ExpressionTree) obj;
		if (infix == null) {
			if (other.infix != null)
				return false;
		} else if (!infix.equals(other.infix))
			return false;
		if (root == null) {
			if (other.root != null)
				return false;
		} else if (!root.equals(other.root))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "\nType Of Tree: " + getClass().getSimpleName() + "\nInfix: " + infix + "\nPrefix: " + preOrder(root)
				+ "\nPostFix: " + infixToPostFix(infix) + "\n-----------------------";
	}
}
