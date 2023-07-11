package leetcode.tree;

import java.util.*;

public class Leetcode_637 {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Double> temp = new ArrayList<>();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                temp.add((double) node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            double average = getAverage(temp);
            result.add(average);
        }
        return result;
    }

    private double getAverage(List<Double> temp) {
        double average = 0;
        for (double d : temp) {
            average += d;
        }
        average = average / temp.size();
        return average;
    }
}
