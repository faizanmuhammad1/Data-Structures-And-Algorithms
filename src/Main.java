import BinaryTree.*;
public class Main{
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(123);
        bst.insert(54);
        bst.insert(35);
        bst.insert(55545);
        bst.insert(34);
        bst.insert(123);
        bst.insert(54);
        bst.insert(35);
        bst.insert(55545);
        bst.insert(34);
        bst.insert(55);
        bst.insert(55);
        bst.insert(55);
        bst.insert(55);
        bst.inOrder();
        bst.search(55545);
    }
}

