class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int [] ans = new int[nums.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<2*nums.length;i++){
            int current = nums[i%nums.length];
            while(!stack.isEmpty() && nums[stack.peek()]<current){
                int index = stack.pop();
                ans[index]=current;
            }
            if(i<nums.length)
            stack.push(i);
        }
        return ans;
    }
}