#include<iostream>

template <typename T>

class Node{        //struct used for public instance  
    T data;
    Node<T> *right, *left;
    Node<T>(int value){
        this.value = data;
        left = right = NULL;
    }
};

