package algorithm.binarytree;/**
 *
 */

import java.util.ArrayDeque;

/**
 *@ClassName LeetCode116
 *@Description TODO
 *@Author wuhao51
 *@Date 2023/2/8 20:13
 *@Version 1.0
 **/
public class LeetCode116 {
    public Node connect(Node root) {
//        1、迭代
//        return iterate(root);
//        2、递归
//        if (root == null) return null;
//        connect(root.left, root.right);
//        return root;
//        3、dfs
        if (root == null) return null;
        dfs(root);
        return root;
    }


    private Node iterate(Node root) {
        if (root == null) return null;
        ArrayDeque<Node> arrayDeque = new ArrayDeque<>();
        arrayDeque.offer(root);
        while (!arrayDeque.isEmpty()) {
            int len = arrayDeque.size();
            Node tmpNode = new Node();
            while (len > 0) {
                tmpNode = arrayDeque.poll();
                tmpNode.next = arrayDeque.peek();
                if (tmpNode.left != null) arrayDeque.offer(tmpNode.left);
                if (tmpNode.right != null) arrayDeque.offer(tmpNode.right);
                len--;
            }
            tmpNode.next = null;
        }
        return root;
    }

    private void connect(Node node1, Node node2) {
        if (node1 == null || node2 == null) return;
        node1.next = node2;
        connect(node1.left, node1.right);
        connect(node2.left, node2.right);
        connect(node1.right, node2.left);
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        Node left = root.left;
        Node right = root.right;
        //将每一层的断层节点连接起来,即将左子树最右边的节点连接右子树最左边的节点
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        //递归
        dfs(root.left);
        dfs(root.right);
    }

    private void dfsv2(Node root) {
        if (root == null) return;
        Node left = root.left;
        Node right = root.right;
        //连接断层处的左右节点
        while (left != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
        dfsv2(root.left);
        dfsv2(root.right);
    }
}

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
