import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
// A traditional if-else construct in C, Java and JavaScript is written:

// if (a > b) {
//     result = x;
// } else {
//     result = y;
// }
// This can be rewritten as the following statement:

// result = a > b ? x : y;

public class percyfin {
    // create a TreeNode class
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    // add method for treenode

    public static void main(String[] args) {

    }

    // pre order traversal
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

    // in order traversal
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

    // post order traversal
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
    //implement depth first search iteratively
    public ArrayList<Integer> iterativeInorderTraversal(TreeNode root) {
        ArrayList<Integer> stringnode = new ArrayList<Integer>();
        if (root == null) {
            return stringnode;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            stringnode.add(current.val);
            current = current.right;
        }
        return stringnode;
    }
    //implement breath first search recursively
    public ArrayList<Integer> breathFirstSearch(TreeNode root) {
        ArrayList<Integer> stringnode = new ArrayList<Integer>();
        if (root == null) {
            return stringnode;
        }
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove(0);
            stringnode.add(current.val);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return stringnode;
    }
    public static TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(temp);
        return root;
    }
    public static boolean sametree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        else if (root1 == null || root2 == null) {
            return false;
        }
        else if (root1.val != root2.val) {
            return false;
        }
        return sametree(root1.left, root2.left) && sametree(root1.right, root2.right);
    }
    public static LinkedList flattentree(TreeNode root){
        LinkedList<Integer> list = new LinkedList<Integer>();
        if (root == null) {
            return list;
        }
        LinkedList<Integer> left = flattentree(root.left);
        LinkedList<Integer> right = flattentree(root.right);
        list.addAll(left);
        list.add(root.val);
        list.addAll(right);
        return list;

    }
    public static TreeNode invertTree(TreeNode root){
        if (root == null) {
            return null;
        }
        TreeNode temp = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;

    } 
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;
    }
    public static int maxSumBST(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxSumBST(root.left);
        int right = maxSumBST(root.right);
        if (left == -1 || right == -1) {
            return -1;
        }
        if (root.left != null && root.left.val >= root.val) {
            return -1;
        }
        if (root.right != null && root.right.val <= root.val) {
            return -1;
        }
        return root.val + left + right;
    }
}
