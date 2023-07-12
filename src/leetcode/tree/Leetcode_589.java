package leetcode.tree;

import java.util.ArrayList;
import java.util.List;

public class Leetcode_589 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return list;
        }
        list.add(root.val);
        List<Node> children = root.children;
        if (!children.isEmpty()){
            for (Node node : children) {
                preorder(node);
            }
        }
        return list;
    }
}
