#include<iostream>
#include<string>

template <typename T>

class Node{  
         
private:
    T data;
    Node<T> *right, *left;
public:
    Node(T val){
        data = val;
        left = right = NULL;
    }

    Node<T> *getLeft(){
        return left;
    }

    Node<T> *getRight(){
        return right;
    }

    T getData(){
        return data;
    }
};





