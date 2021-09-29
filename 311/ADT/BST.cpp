#include<iostream>
using namespace std;



   struct Node* search(Node* root, int data){
        if(root == NULL || root->data == data){
            return root;
        } 
        if(data > root->data){
            return search(root->right, data);
        }

        return search(root->left, data);
    }

};