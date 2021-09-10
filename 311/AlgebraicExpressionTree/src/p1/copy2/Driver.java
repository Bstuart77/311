package p1.copy2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Driver {

	public static <T> void main(String[] args) throws FileNotFoundException {

		// input for preorder, postordr, inorder
		ExpressionTree<T> e = new ExpressionTree<T>();

		File file = new File("expressions.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNext()) {
			String exp = scanner.nextLine();
			char[] charArray = exp.toCharArray();

			Node root = e.constructTree(charArray);

			System.out.println("Postfix:");
			e.postOrder(root);
		}

	}

}
