package p1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ADT {
												//instanced Classes for building ADT
	private static Person person;
	static BST<Person> bst = new BST<Person>();
	static Node<Person> node;
	
	/**
	 * populates the tree by reading the txt file
	 * 
	 * @throws NumberFormatException
	 * @throws IOException
	 * 
	 */

	public void populate() throws NumberFormatException, IOException {
		File file = new File("People.txt");										//Pass in File for reading
		
		BufferedReader br = new BufferedReader(new FileReader(file));			//Reads character by character, also used for CSV parsing

		String line = "";
		while ((line = br.readLine()) != null) {
			String[] people = line.split(", ");									//split line at ", " making every ", " a new array

			String name = people[0];
			int month = Integer.parseInt(people[1]);
			int day = Integer.parseInt(people[2]);
			int year = Integer.parseInt(people[3]);

			person = new Person(name, month, day, year);						//Make Person Object
			node = new Node<Person>(person);

			bst.insert(person);													//insert into BST

		}
		br.close();
	}

	/**
	 * Searches for given Node<Person>
	 * 
	 * 
	 */
	
	public void search(Node<Person> node) {
		bst.search(bst.getRoot(), node.getData());								//calls BST's Search method, pass in the root and the node's data given when searching
	}

	/**
	 * prints inOrder tree
	 * 
	 * 
	 */
	
	public void inOrder() {
		bst.inOrder(bst.getRoot());												//calls BST's inOrder method given the root. Traverses the tree and display values In order of year

	}

	/**
	 * Deletes Node from tree if it exists
	 * 
	 */
	
	public void delete(Node<Person> node) {
		bst.delete(node.getData());												//calls BST's dele method, pass in the root
	}

	/**
	 * Modifies Node's value
	 * 
	 * 
	 */
	public <T> void modify(T key) {		
		bst.modify(bst.getRoot(), (Person) key);								//calls BST's modify method, pass in the root and the Person Object to update the node to
	}
}
