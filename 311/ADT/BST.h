#pragma once
#include<iostream>
#include "Node.h"

template <class T>
class BST{

private:
    Node<T> *root;
    T val;

public:
    Node<T>* insert(Node<T>* node, T val);
    Node<T>* search(Node<T>* node, T val);
    Node<T>* getSuccessor(Node<T>* node);
    Node<T>* deleteNode(Node<T>* node, T val);
    Node<T>* makeNode(T val);
    void inOrder(Node<T>* node);
    BST();
};