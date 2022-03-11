package greedy.minCameraCover;
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();

    }
    private int result = 0;
    public int minCameraCover(TreeNode root){
        if (traversal(root)==0) {
            result++;
        }
        return result;
    }
    private int traversal(TreeNode root){
        // 空节点假设为已被覆盖
        if (root==null)return 2;
        int left = traversal(root.left);
        int right = traversal(root.right);
        // 左右两边都被覆盖，该节点一定未被覆盖
        if ((left==right&&left==2))return 0;
        // 左边或右边未被覆盖，则必须在该节点安监控进行覆盖
        if (left==0||right==0){
            result++;
            return 1;
        }
        // 其他情况表示该节点已被覆盖
        return 2;
    }
}
