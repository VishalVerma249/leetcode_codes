class Solution {
    public int largestAltitude(int[] gain) {
        int current=0;
        int maximum=0;
        for(int i=0;i<gain.length;i++){
            current=current+gain[i];
            maximum=Math.max(maximum,current);
        }
        return maximum;
    }
}