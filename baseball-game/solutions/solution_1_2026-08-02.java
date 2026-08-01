class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> stack = new Stack<>();
        for(String num:operations){
            if(num.equals("+")){
                int last=stack.pop();
                int secondlast=stack.peek();
                int next= last+secondlast;
                stack.push(last);
                stack.push(next);
            }
            else if(num.equals("C")){
                stack.pop();
            }
            else if(num.equals("D")){
                int last=stack.pop();
                int next=last*2;
                stack.push(last);
                stack.push(next);
            }else{
                int score= Integer.parseInt(num);
                stack.push(score);
            }
        }
        int ans=0;
        while(!stack.empty()){
            ans=ans+stack.pop();
        }
        return ans;
    }
}