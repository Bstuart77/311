package p1;

import java.util.Comparator;

public class Person implements Comparable<Person>, Comparator<Person> {

	private String name;
	private int month;
	private int day;
	private int year;
	private SearchType compareType;

	public Person(String name, int month, int day, int year, SearchType s) {
		this.name = name;
		this.month = month;
		this.day = day;
		this.year = year;
		compareType = s;
	
	} 
	
	public Person(String name, int month, int day, int year) {
		this.name = name;
		this.month = month;
		this.day = day;
		this.year = year;
		compareType = SearchType.YEAR;
	
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

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
