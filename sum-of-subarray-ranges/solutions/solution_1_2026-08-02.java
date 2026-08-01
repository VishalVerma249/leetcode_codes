class Solution {
    public long subArrayRanges(int[] nums) {
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int maximum=nums[i];
            int minimum=nums[i];
            for(int j=i;j<nums.length;j++){
                minimum=Math.min(minimum,nums[j]);
                maximum=Math.max(maximum,nums[j]);
                ans+=maximum-minimum;
            }
        }
        return ans;
    }
}