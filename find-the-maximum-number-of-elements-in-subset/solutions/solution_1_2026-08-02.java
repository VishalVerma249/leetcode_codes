class Solution {
    public int maximumLength(int[] nums) {
        Map<Long,Integer> freq=new HashMap<>();

        for(int num:nums){
            long value=num;
            freq.put(value,freq.getOrDefault(value,0)+1);
        }
        int answer=1;
        int ones=freq.getOrDefault(1L,0);
        if(ones>0){
            if(ones%2==0){
                ones--;
            }
            answer=ones;
        }
        for(int num:nums){
            if(num==1){
                continue;
            }
            long current=num;
            int length=0;
            while(freq.getOrDefault(current,0)>=2){
                length+=2;

                if(current>1_000_000_000L){
                    break;
                }
                current=current*current;

            }
            if(freq.getOrDefault(current,0)>=1){
                length++;
            }
            else{
                length--;
            }
            answer=Math.max(answer,length);
        }
        return answer;
    }
}