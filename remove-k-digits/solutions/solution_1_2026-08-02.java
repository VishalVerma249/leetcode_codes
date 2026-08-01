class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> stack= new Stack<>();

        for(char digit:num.toCharArray()){
            while(!stack.isEmpty() && k>0 && stack.peek()>digit){
                stack.pop();
                k--;
            }
            stack.push(digit);
        }
        while(k>0){
            stack.pop();
            k--;
        }

        StringBuilder ans=new StringBuilder();

        for(char digit:stack){
            ans.append(digit);
        }

        int index=0;

        while(index<ans.length()&& ans.charAt(index)=='0'){
            index++;
        }
        String result=ans.substring(index);

        if(result.length()==0){
            return "0";
        }
        return result;
    }
}