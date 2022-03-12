package bTree;

import bTree.utils.GenTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode tree = GenTree.getTree();
        System.out.println(Arrays.toString(solution.averageOfLevels(tree)));
    }
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 计算树每层的平均值
     * @param root TreeNode类 根节点
     * @return double浮点型一维数组
     */
    double[] sums = new double[1000];
    int[] nodeCount = new int[1000];
    int levelCount = 0;
    public double[] averageOfLevels (TreeNode root) {
        if (root!=null){
            dfs(root,levelCount);
        }
        double[] result = new double[levelCount+1];
        for(int i=0;i<=levelCount;i++){
            result[i] = sums[i]/nodeCount[i];
        }
        return result;
        // write code here
    }
    public void dfs(TreeNode root,int k){
        if(root==null)return;
        if(root.left==null&&root.right==null){
            nodeCount[k]++;
            sums[k]+=root.val;
            levelCount = Math.max(levelCount,k);
        }else{
            sums[k]+=root.val;
            nodeCount[k]++;
            if(root.left!=null){
                dfs(root.left,k+1);
            }
            if(root.right!=null){
                dfs(root.right,k+1);
            }
        }
    }
}
class Solution2{
    public String shuffle (String s, int[] indices) {
        int sl = s.length();
        char[] chars = new char[sl];
        for (int i = 0; i < sl; i++) {
            chars[i] = s.charAt(indices[i]);
        }
        return new String(chars);
    }
}
class Solution3{
    public List<Integer> postorder(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop==null){
                TreeNode pop1 = stack.pop();
                result.add(pop1.val);
            }else {
                stack.push(pop);
                stack.push(null);
                if (pop.right!=null)stack.push(pop.right);
                if (pop.left!=null)stack.push(pop.left);
            }
        }
        return result;
    }
}
class solution4{
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

    class Solution {
        public List<Integer> postorder(Node root) {
            LinkedList<Node> stack = new LinkedList<Node>();
            List<Integer> result = new ArrayList<Integer>();
            stack.push(root);
            while(!stack.isEmpty()){
                Node top = stack.pop();
                if(top!=null){
                    stack.push(top);
                    stack.push(null);
                    if(top.children!=null){
                        int cs = top.children.size();
                        for(int i=cs-1;i>=0;i--){
                            stack.push(top.children.get(i));
                        }
                    }
                }else{
                    if (!stack.isEmpty()){
                        Node p1 = stack.pop();
                        result.add(p1.val);
                    }
                }
            }
            return result;
        }
    }
}