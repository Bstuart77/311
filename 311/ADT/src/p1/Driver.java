package p1;

import java.io.IOException;

public class Driver<T extends Comparable<T>> {

	static Node<Person> node;

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub

		ADT adt = new ADT();																//Instanced class
		System.out.println("---------INSERTING------------\n");
		adt.populate();																		//calls populate function to get all names in tree
		
		Person person = new Person("Brian Stuart", 1, 4, 1999, SearchType.NAME);			//Creates Person person
		Person person2 = new Person("Brian Stuart", 1, 4, 2002, SearchType.NAME);			//Creates Personn p2 for modify testing

		System.out.println("\n---------SEARCH FOR NAME Brian Stuart-------");

		Node<Person> toBeSearched = new Node<Person>(person);								//Instanced Node<Person> class and pass in perosn objects to store in tree
		adt.search(toBeSearched);															//Searches for the person Node

		System.out.println("\n---------INORDER--------");
		adt.inOrder();																		//Prints the tree in order

		System.out.println("\n---------MODIFY Brian Stuart-----------");
		adt.modify(person2);																//Modifies the tree's value based on First Name

		adt.inOrder();																		//Prints the tree in order

		System.out.println("\n---------DELETED BRIAN STUART---------");
		adt.delete(toBeSearched);															//Deletes toBeSearched Perosn Object Node from tree

		adt.inOrder();																		//Prints the tree in order

	}
}
