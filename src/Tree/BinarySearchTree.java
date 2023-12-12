package Tree;

public class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    private Node insertWithNode(int key, Node root) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data)
            root.left = insertWithNode(key, root.left);
        else if (key > root.data)
            root.right = insertWithNode(key, root.right);
        return root;
    }

    public void insert(int key) {
        root = insertWithNode(key, root);
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.println(root.data);
        inOrderTraversal(root.right);
    }

    public void inOrder() {
        inOrderTraversal(root);
    }

    private boolean searchWithNode(int key, Node root) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (key > root.data) {
            return searchWithNode(key, root.right);
        } else {
            return searchWithNode(key, root.left);
        }
    }

    public void search(int key) {
        System.out.println(searchWithNode(key, root) ? "found" : "not found");
    }

    public void delete(int key) {
        root = deleteNode(root, key);
    }

    private Node deleteNode(Node root, int key) {
        if (root == null) {
            return root;
        }
        if (key < root.data) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.data) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
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
}
