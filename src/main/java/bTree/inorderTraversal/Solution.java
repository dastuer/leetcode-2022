package bTree.inorderTraversal;

import bTree.RandomBTreeGenerator;
import bTree.node.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = RandomBTreeGenerator.getTree();
        System.out.println(solution.inorderTraversal(tree));
    }
    public List<Integer> inorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        stack.push(root);
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;
            }else {
                TreeNode pop = stack.pop();
                res.add(pop.val);
                if (pop.right!=null){
                    stack.push(pop.right);
                }
            }
        }
        return res;
    }
}
