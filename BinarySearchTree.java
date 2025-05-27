package trees;

public class BinarySearchTree {
    // --- Node Definition ---
    private static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
        }
    }

    private Node root;

    // --- Public API ---
    /** Insert a key into the BST */
    public void insert(int key) {
        root = insertRec(root, key);
    }

    /** Search for a key in the BST (true if found) */
    public boolean search(int key) {
        return searchRec(root, key);
    }

    /** In-order traversal: Left, Root, Right */
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    /** Pre-order traversal: Root, Left, Right */
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    /** Post-order traversal: Left, Right, Root */
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    // --- Internal Helpers ---
    private Node insertRec(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insertRec(node.left, key);
        } else if (key > node.key) {
            node.right = insertRec(node.right, key);
        }
        // if key == node.key, do nothing (no duplicates)
        return node;
    }

    private boolean searchRec(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (key == node.key) {
            return true;
        }
        return key < node.key
            ? searchRec(node.left, key)
            : searchRec(node.right, key);
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.key + " ");
            inorderRec(node.right);
        }
    }

    private void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    private void postorderRec(Node node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.key + " ");
        }
    }

    // --- Demo Main ---
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] keys = {50, 30, 70, 20, 40, 60, 80};

        for (int k : keys) {
            bst.insert(k);
        }

        System.out.print("In-order traversal:  ");
        bst.inorder();    // 20 30 40 50 60 70 80

        System.out.print("Pre-order traversal: ");
        bst.preorder();   // 50 30 20 40 70 60 80

        System.out.print("Post-order traversal:");
        bst.postorder();  // 20 40 30 60 80 70 50

        int searchKey = 60;
        System.out.printf("Search %d: %s%n",
            searchKey,
            bst.search(searchKey) ? "FOUND" : "NOT FOUND"
        );
    }
}
