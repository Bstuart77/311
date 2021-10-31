package p1;

import java.util.Comparator;

public class Person implements Comparable<Person>, Comparator<Person> {

	//instance variables name, month, year, compareType
	private String name;
	private int month;
	private int day;
	private int year;
	private SearchType compareType;

	public Person(String name, int month, int day, int year, SearchType s) {	//Helper for when I have to search by names
		this.name = name;
		this.month = month;
		this.day = day;
		this.year = year;
		compareType = s;
	
	} 
		
	public Person(String name, int month, int day, int year) {			//Person constructor
		this.name = name;
		this.month = month;
		this.day = day;
		this.year = year;
		compareType = SearchType.YEAR;
	
	}

	/**
	 * Gets objects name specific node
	 * 
	 * @return objects node name
	 * 
	 */
	
	public String getName() {
		return name;
	}

	/**
	 * sets Name of person object node
	 * 
	 * @param name given by args
	 * 
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets objects Month 
	 * 
	 * @return objects month value
	 * 
	 */
	
	public int getMonth() {
		return month;
	}

	/**
	 * sets Person's Month 
	 * 
	 * @param month given by args
	 * 
	 */
	
	public void setMonth(int month) {
		this.month = month;
	}

	/**
	 * Gets day of specific node
	 * 
	 * @return objects day value
	 * 
	 */
	
	public int getDay() {
		return day;
	}

	/**
	 * sets Person's day
	 * 
	 * @param day given by args
	 * 
	 */
	
	public void setDay(int day) {
		this.day = day;
	}

	/**
	 * gets year of specific node
	 * 
	 * @return objects year value
	 * 
	 */
	
	public int getYear() {
		return year;
	}

	/**
	 * sets Person's year
	 * 
	 * @param year given by args
	 * 
	 */
	
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Set Person's Type
	 * 
	 * @param s given by args
	 * 
	 */
	
	
	public void setType(SearchType s) {
		this.compareType = s;
	}
	
	@Override
	public String toString() {
		return "Person [name= " + name + ", month= " + month + ", day= " + day + ", year= " + year + ", " + compareType +  "]";
	}

	@Override
	public int compareTo(Person o) {
		int returnValue = -255;
		if (this.compareType == SearchType.YEAR) {

			if (this.year > o.getYear()) {
				returnValue = 1;
			} else if (this.year < o.getYear()) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}
		} else if (this.compareType == SearchType.NAME) {
			if (this.name.compareTo(o.getName()) > 0) {
				returnValue = 1;
			} else if (this.name.compareTo(o.getName()) < 0) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}
		}
		return returnValue;
	}

	@Override
	public int compare(Person o1, Person o2) {
		if (o1.getName().compareTo(o2.getName()) > 0) {
			return 1;
		} else if (o1.getName().compareTo(o2.getName()) < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
