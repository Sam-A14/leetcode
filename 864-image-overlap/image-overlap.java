class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> A = new ArrayList<>();
        List<int[]> B = new ArrayList<>();
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                if(img1[i][j]==1){
                    A.add(new int[]{i,j});
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img2[i][j]==1){
                    B.add(new int[]{i,j});
                }
            }
        }
        HashMap <String,Integer>map=new HashMap<>();
        int ans=0;
        for(int[]a:A){
            for(int[]b:B){
                int dr=b[0]-a[0];
                int dc=b[1]-a[1];
                String key = dr+","+dc;
                int count =map.getOrDefault(key,0)+1;
                map.put(key,count);
                ans = Math.max(ans,count);
            }
        }
        return ans;
        }
}