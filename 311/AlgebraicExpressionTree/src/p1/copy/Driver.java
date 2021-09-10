package p1.copy;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static <T> void main(String[] args) throws FileNotFoundException {

		ExpressionTree<T> e = new ExpressionTree<T>();

		File file = new File("expressions.txt");
		Scanner scanner = new Scanner(file);

		
			String postfix = "(1 + (2 * 3)) + (((4 * 55) + 66) * 77)";
			Node<T> root = e.construct(postfix);

			System.out.println("PreOrder: ");
			e.preOrder(root);

			System.out.print("Postfix Expression: ");
			e.postOrder(root);

			System.out.print("\nInfix Expression: ");
			e.inorder(root);
			
			System.out.println("--------------------");
		}	

}
