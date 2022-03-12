package bTree.utils;

import bTree.TreeNode;
import bTree.preorderTraversal.Solution;

import java.util.*;

public class TreeUtils {
    public static void preorder(TreeNode root){
        Solution solution = new Solution();
        System.out.println(solution.preorderTraversal01(root));
    }
    public static void postorder(TreeNode root){
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
        System.out.println(result);
    }
    public static void inorder(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){
                stack.push(cur);
                cur = cur.left;  // 左
            }else {
                TreeNode pop = stack.pop();
                res.add(pop.val);   // 中
                if (pop.right!=null){
                    cur = pop.right; // 右
                }
            }
        }
        System.out.println(res);
    }
    public static void levelOrder(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            result.add(poll.val);
            if (poll.left!=null){
                queue.offer(poll.left);
            }
            if (poll.right!=null){
                queue.offer(poll.right);
            }
        }
        System.out.println(result);
    }

}
