import java.util.ArrayList;

public class percyfin{
    //create a TreeNode class
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    //add method for treenode

    public static void main(String[] args) {
        
    }
    //pre order traversal
    public ArrayList<Integer> preorderTraversal(TreeNode root) {
        ArrayList<Integer> stringnode = new ArrayList<Integer>();
        if (root == null) {
            return stringnode;
        }
        stringnode.add(root.val);
        stringnode.addAll(preorderTraversal(root.left));
        stringnode.addAll(preorderTraversal(root.right));
        return stringnode;
    }
    //in order traversal
    public ArrayList<Integer> inorderTraversal(TreeNode root) {
        ArrayList<Integer> stringnode = new ArrayList<Integer>();
        if (root == null) {
            return stringnode;
        }
        stringnode.addAll(inorderTraversal(root.left));
        stringnode.add(root.val);
        stringnode.addAll(inorderTraversal(root.right));
        return stringnode;
    }
    //post order traversal
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> stringnode = new ArrayList<Integer>();
        if (root == null) {
            return stringnode;
        }
        stringnode.addAll(postorderTraversal(root.left));
        stringnode.addAll(postorderTraversal(root.right));
        stringnode.add(root.val);
        return stringnode;
    }
    
}
