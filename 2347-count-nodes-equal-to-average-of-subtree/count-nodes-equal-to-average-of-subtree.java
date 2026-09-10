/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans =0;
    class Info{
        int sum;
        int count;
        Info(int sum ,int count){
            this.sum = sum;
            this.count = count;
        }
    }
    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return ans;
    }
    private Info dfs(TreeNode root){
        if(root==null){
            return new Info(0,0);
        }
        Info left = dfs(root.left);
        Info right = dfs(root.right);
       int sum = left.sum + right.sum  +root.val;
       int count = left.count+right.count+1;
       if(root.val==sum/count){
        ans++;
       }
       return new Info(sum,count);
    }
}