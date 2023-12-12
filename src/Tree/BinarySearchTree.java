package Tree;
public class BinarySearchTree
{
    private Node root;
    public BinarySearchTree(){
        root=null;
    }

    private Node insertWithNode(int key,Node root){
         //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.data)
            root.left = insertWithNode(key,root.left);
        else if (key > root.data)
            root.right = insertWithNode(key,root.right);
        return root;
    }

    public void insert(int key){
       root = insertWithNode(key,root);
    }
    private void print(Node root){
        if(root==null){
            return;
        }
        print(root.left);
        System.out.println(root.data);
        print(root.right);
    }
    public void inOrder(){
        print(root);
    }

    private boolean searchWithNode(int key,Node root){
        if(root==null) {
            return false;
        }
        if(root.data==key){
            return true;
        }
        if(key > root.data){
            return searchWithNode(key,root.right);
        }else{
            return searchWithNode(key,root.left);
        }
    }

    public void search(int key){
        System.out.println(searchWithNode(key,root)?"found":"not found");
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        // Base case: If the tree is empty
        if (root == null) {
            return root;
        }

        // Recursive cases
        if (key < root.data) {
            // If the key to be deleted is smaller, then it lies in the left subtree
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            // If the key to be deleted is greater, then it lies in the right subtree
            root.right = deleteNode(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children
            // Find the inorder successor (smallest node in the right subtree)
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteNode(root.right, root.data);
        }

        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(20);
        bst.insert(15);
        bst.insert(30);
        bst.insert(25);
        bst.inOrder();

    }
}
