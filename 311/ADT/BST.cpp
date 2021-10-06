#include<Node.h>
#include<string>

using namespace std;


template <typename T>

class BST{

public:
    void BST::insert(Node<T> node, T value){
        if(node == NULL){
            node = new Node(value);
        }

        if(value > root->value){
            root->right = insert(node.left, value)
        }else{
            root->left = insert(node.right, value);
        }
    }

    Node<T> BST::search(Node<T> node, T key){
        if(node == NULL || node->key = key){
            return root;
        }else if(node.key < key){       //input key key > root.key, go left
            return search(key)
        }else{
            return search(key);
        }
    }

    Node<T> BST::findMinValue(Node<T> node){
        Node<T> current = node;

        while(current && current.left != NULL){
            current = current.left;
        }
        return current;
    }
    

    Node<T> deleteNode(Node<T> node, T key){
        if(node == NULL){
            return node;
        }

        if(node.key > key){
            node.left = delete(node.left,key)
        }else if(key > node.key){
            node.right = delete(node.right, key);
        }else{      //if contains both children
            if(node.left == NULL && root.right == NULL){
                return null;
            }else if(node.left == NULL){
                return node.right;
            }else if(node.right == NULL){
                return node.left;
            }
            Node<T> temp = findMinValue(root.right);
            root.key = temp.key;
            root.right = delete(root.rigt, temp.key);
        }
    }
};