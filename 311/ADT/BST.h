#include<iostream>
#include<Node.h>

template <typename T>
class BST{

private:
    Node<T> node;
    T val;

public:
    void insert(node, val);
    Node<T> seach(node, val);
    Node<T> findMinValue(node);
    Node<T> deleteNode(node, val);
};