class Solution {
    public int numberOfSubstrings(String s) {
        int left=0;
        int ans=0;
        int acount=0;
        int bcount=0;
        int ccount=0;

        for(int right=0;right<s.length();right++){
            char ch =s.charAt(right);
            if(ch=='a'){
                acount++;
            }
            if (ch=='b'){
                bcount++;
            }
            if(ch=='c'){
                ccount++;
            }
            while(acount>0 && bcount>0 && ccount>0){
                ans+=s.length()-right;
                char leftchar=s.charAt(left);

                if(leftchar=='a'){
                    acount--;
                }
                if(leftchar=='b'){
                    bcount--;
                }
                if(leftchar=='c'){
                    ccount--;
                }
                left++;
            }
        }
        return ans;
    }
}