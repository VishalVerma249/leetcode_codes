class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        for(int price:costs){
            if(coins>=price){
                coins=coins-price;
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}