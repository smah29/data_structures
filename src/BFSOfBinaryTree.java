import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BFSOfBinaryTree {
    static BinaryTree root;

    static class BinaryTree {
        int data;
        BinaryTree left;
        BinaryTree right;
        int level;

        public BinaryTree(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        root = new BinaryTree(1);
        root.left = new BinaryTree(2);
        root.right = new BinaryTree(3);
        root.left.left = new BinaryTree(4);
        bfs(root);
    }

    private static void bfs(BinaryTree root) {
        if (root == null) return;
        Queue<BinaryTree> queue = new LinkedList<>();
        root.level = 0;
        queue.add(root);
        int current_level = -1;
        while (!queue.isEmpty()) {
            BinaryTree node = queue.poll();
            if (node.level > current_level) {
                current_level = node.level;
                System.out.println();
                System.out.print(node.data);
            } else {
                System.out.print(" " + node.data);
            }
            int new_level = node.level + 1;
            if (node.left != null) {
                node.left.level = new_level;
                queue.add(node.left);
            }
            if (node.right != null) {
                node.right.level = new_level;
                queue.add(node.right);
            }
        }
    }

}
