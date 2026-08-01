class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count=new int[5];

        for(char ch :text.toCharArray()){
            if(ch=='b'){
                count[0]++;
            }
            if(ch=='a'){
                count[1]++;
            }
            if(ch=='l'){
                count[2]++;
            }
            if(ch=='o'){
                count[3]++;
            }
            if(ch=='n'){
                count[4]++;
            }
        }
        count[2]=count[2]/2;
        count[3]=count[3]/2;
        int answer=count[0];
        for(int val:count){
            answer=Math.min(answer,val);
        }
        return answer;
    }
}