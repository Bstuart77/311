package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ADT {

	private static Person person;
	static BST bst = new BST();
	static Node<Person> node;

	public static <T> void instantiate() throws IOException, ClassNotFoundException {
		System.out.println("------INSERTING---------");
		populate();	//wworks

		Person person = new Person("Brian Stuart", 1, 4, 1999, SearchType.NAME);
		
		System.out.println("----SEARCH FOR NAME Brian Stuart----");
		
		Node<Person> toBeSearched = new Node<Person>(person);
		search(toBeSearched);	
		
		System.out.println("---INORDER---");
		inOrder();	
		
		//bst.deleteNode(node, "Brian Stuart");

	}

	public static void populate() throws NumberFormatException, IOException {
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
			node = new Node<Person>(person);

			bst.insert(person);
			
			
		}
		br.close();
	}

	public static void search(Node<Person> node) {
		bst.search(bst.getRoot(), node.getData());
	}

	public static void inOrder() {
		bst.inOrder(bst.getRoot());

	}
}
