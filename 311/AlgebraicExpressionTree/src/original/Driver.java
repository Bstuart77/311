package original;

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
			System.out.println("Infix: " + exp);
			
			System.out.println("PostFix: " + e.infixToPostFix(exp));
			
			System.out.println("---------------------");
		}

	}

}
