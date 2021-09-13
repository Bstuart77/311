package p1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {

	public static <T> void main(String[] args) throws FileNotFoundException {

		// input for preorder, postordr, inorder

		File file = new File("expressions.txt");
		Scanner scanner = new Scanner(file);

		while (scanner.hasNext()) {

			String exp = scanner.nextLine();
			ExpressionTree e = new ExpressionTree(exp);
			
			System.out.println(e.toString());
		}
		scanner.close();
	}

}
