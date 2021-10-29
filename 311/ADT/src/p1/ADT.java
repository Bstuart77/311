package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ADT{

	private static Person person;

	public static <T> void instantiate() throws IOException, ClassNotFoundException {
		BST bst = new BST();
		
		Node<Person> node = new Node<Person>(person);
		
		File file = new File("src/p1/People.txt");
		
		BufferedReader br = new BufferedReader(new FileReader(file));

		String line = "";
		while ((line = br.readLine()) != null) {
			String[] people = line.split(", ");

			String name = people[0];
			int month = Integer.parseInt(people[1]);
			int day = Integer.parseInt(people[2]);
			int year = Integer.parseInt(people[3]);

			person = new Person(name, month, day, year);
			//System.out.println(person);
			bst.insert(node, person);
			
			bst.inOrder(node);
		}
	}
}
