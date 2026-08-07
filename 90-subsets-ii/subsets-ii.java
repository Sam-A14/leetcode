class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
           List<List<Integer>> ans = new ArrayList<>();
           List<Integer> curr = new ArrayList<>();
           backtrack(nums,0,curr,ans);
           return ans;
    }
    private void backtrack(int [] nums,int index, List<Integer> curr,List<List<Integer>> ans ){
        if(nums.length==index){
            ans.add(new ArrayList<>(curr));
            return;
        }
            curr.add(nums[index]);
            backtrack(nums,index+1,curr,ans);
            curr.remove(curr.size()-1); 
    while(index+1<nums.length && nums[index]==nums[index+1]){
            index++;
    }
    backtrack(nums,index+1,curr,ans);
    }
}