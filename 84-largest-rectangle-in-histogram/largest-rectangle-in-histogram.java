class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>stack = new Stack<>();
        int maxarea=0;
        for(int i =0;i<=heights.length;i++){
            int currheight = (i==heights.length)?0:heights[i];
            while(!stack.isEmpty() && currheight<heights[stack.peek()]){
                int h = heights[stack.pop()];
                int width = stack.isEmpty()?i:i-stack.peek()-1;
                maxarea = Math.max(maxarea,h*width);
            }
            if(i<heights.length){
                stack.push(i);
            }
        }
        return  maxarea;
    }
}