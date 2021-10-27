#pragma once
#include "Node.h"
#include "BST.h"
#include <string>
using namespace std;

template<class T>
    Node<T>* BST<T>::insert(Node<T> *node, T value){
        if(node == nullptr){
           return(makeNode(value));
        }

        if(value > node->value){
           node->right = insert(node->right, value);

        }else if(value < node->value){
            node->left = insert(node->left, value);
        }

        return node;
        
    }
    //getSuccessor / getParent
template<class T>
    Node<T>* BST<T>::makeNode(T val){
        Node<T>* node = new Node<T>;
        node.data = val;
        return node;
    }

template<class T>
    Node<T>* BST<T>::search(Node<T> *node, T key){
        if(node == nullptr || node->key = key){
            return node;
        }else if(node.key < key){       //input key key > root.key, go left
            return search(node->right, key);
        }else{
            return search(node->left, key);
        }
    }

template<class T>
    Node<T>* BST<T>::getSuccessor(Node<T> *node){
        Node<T> *current = node->right;

        while(current.left != nullptr){
            current = current.left;
        }
        return current;
    }
template<class T>
    void BST<T>::inOrder(Node<T> *node){
        inOrder(node->left);
        cout << node->data << endl;
        inOrder(node->right);
    }
    
template<class T>
    Node<T>* BST<T>::deleteNode(Node<T> *node, T key){    
        if(node == nullptr){
            return node;
        }
        //if node has 1 child, search tree for parent,  parents child = nodes child(left and right). delete the node
        if(node->key > key){
            node->left = deleteNode(node->left,key);
            
        }else if(key > node->key){
            node->right = deleteNode(node->right, key);

        }else{      //if node is found

            if(node->left == nullptr && root->right == nullptr){
                return nullptr;

            }else if(node->left == nullptr){
                Node<T>* temp = node->right;
                return temp;
            }else if(node.right == nullptr){
                Node<T>* temp = node->right;
                return temp;
            }
                //has 2 children
            Node<T> temp = getSuccessor(root.right);
            node->data = temp->data;
            node->right = deleteNode(node->right, temp->data);
        }
        return node;
    };