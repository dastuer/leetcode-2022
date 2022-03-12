package bTree.postorderTraversal;

import bTree.utils.GenTree;
import bTree.TreeNode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        TreeNode tree = GenTree.getTree();
        Solution solution = new Solution();
        System.out.println(solution.postorderTraversal(tree));
        System.out.println(solution.postorderTraversal01(tree));
    }
    public List<Integer> postorderTraversal(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            result.add(pop.val); // 中
            if (pop.left!=null)stack.push(pop.left); // 左
            if (pop.right!=null)stack.push(pop.right); // 右
        }
        Collections.reverse(result); // 反转 右 左 中 -> 中 左 右
        return result;
    }
    public List<Integer> postorderTraversal01(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode top = stack.pop();
            if (top!=null){
                stack.push(top);
                stack.push(null);
                if (top.right!=null)
                    stack.push(top.right);
                if (top.left!=null)
                    stack.push(top.left);

            }else {
                if (!stack.isEmpty()) {
                    TreeNode pop = stack.pop();
                    result.add(pop.val);
                }
            }
        }
        return result;
    }
}
