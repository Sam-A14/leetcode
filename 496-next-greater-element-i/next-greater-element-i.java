class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int [] ans = new int[nums1.length];
        Arrays.fill(ans,-1);
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap <>();
        for(int i =0;i<nums2.length;i++){
            while(!stack.isEmpty() && nums2[stack.peek()]<nums2[i]){
                
                map.put(nums2[stack.pop()],nums2[i]);
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            map.put(nums2[stack.pop()],-1);
        }
        for(int i =0;i<nums1.length;i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}