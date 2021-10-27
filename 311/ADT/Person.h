#pragma once
#include<string>
using namespace std;

class Person{
private:
    std::string name;
    int year;
    int month;
    int day;

public:
    Person(string name, int day, int month, int year);

    bool operator < (const Person& p){   //compares names to sort on tree
        if(name < p.name){
            return true;
        }else{
            return false;
        }
    }

    bool operator > (const Person& p){   //compares names to sort on tree
        if(name > p.name){
            return true;
        }else{
            return false;
        }
    }

    bool operator = (const Person& p){   //compares names to sort on tree
        if(name == p.name){
            return true;
        }else{
            return false;
        }
    }

    bool operator != (const Person& p){   //compares names to sort on tree
        if(name != p.name){
            return true;
        }else{
            return false;
        }
    }
};