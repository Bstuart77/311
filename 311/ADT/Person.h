#include<iostream>
#include<string>

using namespace std;

class Person{

private:
    string name;
    string month;
    int day;
    int year;
public:
    Person(string name_val, string month_val, int day_val, int year_val);
};
