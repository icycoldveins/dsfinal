import java.util.List;

public class hades {
    // create a listnode class
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

    }

    // checks height of a tree
    public static int height(Node root) {
        if (root == null)
            return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // checks if a tree is balanced
    public static boolean isBalanced(Node root) {
        if (root == null)
            return true;
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    // implementation of depth first traversal
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return null;
        ListNode current = head;
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public ListNode mergeTwoListNode(ListNode headA, ListNode headB) {
        if (headA == null)
            return headB;
        if (headB == null)
            return headA;
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (headA != null && headB != null) {
            if (headA.val < headB.val) {
                current.next = headA;
                headA = headA.next;
            } else {
                current.next = headB;
                headB = headB.next;
            }
            current = current.next;
        }
        if (headA != null) {
            current.next = headA;
        }
        if (headB != null) {
            current.next = headB;
        }
        return dummy.next;
    }

    public static ListNode reverselinkedlist(ListNode root) {
        if (root == null)
            return null;
        ListNode prev = null;
        ListNode current = root;
        while (current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // convert sorted list to binary search tree
    public static TreeNode convert(ListNode head) {
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = convert(head);
        root.right = convert(slow.next);
        return root;
    }
    //remove duplicates from an unsorted linkedlist 
    public static ListNode newlist(ListNode root){
        if(root==null)
            return null;
        ListNode current=root;
        while(current.next!=null){
            if(current.val==current.next.val){
                current.next=current.next.next;
            }
            else{
                current=current.next;
            }
        }
        return root;
    }
 
    public ListNode getIntersectionNode(ListNode headA,ListNode headB){
        if(headA==null || headB==null)
            return null;
        ListNode currentA=headA;
        ListNode currentB=headB;
        while(currentA!=currentB){
           if(currentA.val>currentB.val){
               currentA=currentA.next;
           }
           else{
               currentB=currentB.next;
           }
        }
        return currentA;
    }
    public static ListNode insertionSortList(ListNode head) {
        if (head == null)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode current = head;
        while (current != null) {
            ListNode next = current.next;
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < current.val) {
                prev = prev.next;
            }
            current.next = prev.next;
            prev.next = current;
            current = next;
        }
        return dummy.next;
    }
    // group all the nodes with odd indices together with even indices
    // and return the reordered list
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}