public class Node {
    int data;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class BalancedBST {
    public Node sortedArrayToBST(int[] arr) {
        return sortedArrayToBST(arr, 0, arr.length - 1);
    }

    private Node sortedArrayToBST(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);

        root.left = sortedArrayToBST(arr, start, mid - 1);
        root.right = sortedArrayToBST(arr, mid + 1, end);

        return root;
    }

    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public static void main(String[] args) {
        BalancedBST balancedBST = new BalancedBST();

        int[] arr = {1, 2, 3, 4, 5, 6, 7};

        Node root = balancedBST.sortedArrayToBST(arr);

        System.out.println("The balanced binary search tree is: ");
        balancedBST.preOrder(root);
    }
}