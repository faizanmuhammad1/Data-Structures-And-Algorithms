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
}
