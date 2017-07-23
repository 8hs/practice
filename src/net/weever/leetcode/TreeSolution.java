package net.weever.leetcode;

import net.weever.domain.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by weever on 7/22/17.
 */
public class TreeSolution {

    //199. Binary Tree Right Side View
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            result.add(queue.peek().val);
            Queue<TreeNode> temp = new LinkedList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(node.right != null)
                    temp.add(node.right);
                if(node.left != null)
                    temp.add(node.left);
            }
            queue = temp;
        }
        return result;
    }
}
