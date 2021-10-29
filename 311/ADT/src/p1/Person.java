package p1;

import java.util.Comparator;

public class Person implements Comparable<Person> {

	String name;
	int month;
	int day;
	int year;

	public Person(String name, int month, int day, int year) {
		this.name = name;
		this.month = month;
		this.day = day;
		this.year = year;

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

	@Override
	public String toString() {
		return "Person [name= " + name + ", month= " + month + ", day= " + day + ", year= " + year + "]";
	}

	@Override
	public int compareTo(Person o) {
		if (this.year > o.getYear()) {
			return 1;
		} else if (this.year < o.getYear()) {
			return -1;
		} else {
			return 0;
		}
	}
}
