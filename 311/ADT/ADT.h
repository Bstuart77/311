//modify, pass Person as ADT into tree. Have BinaryTree and add onto it
#pragma once
#include "BST.h"
#include "Node.h"
#include "BST.cpp"
#include <string>
#include "Person.h"

using namespace std;

class ADT{
private:
    BST<Person> bst;
public:

template <typename T>
void instantiate(){
    Person person("Todd Howard",1,4,1938);
    bst.insert(bst->root, person);
    bst.inOrder(bst->root);
    }
};




