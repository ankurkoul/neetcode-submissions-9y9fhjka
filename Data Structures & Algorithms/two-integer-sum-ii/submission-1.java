class Solution {
    public int[] twoSum(int[] numbers, int target) {
        //a
        // no dec: can have same and increaseong hence sorted
        // [1,1,1,1] or[1,2,3,4] or[1,1,4,4,5]
        // return 1 indexed
        // index1 ,index2 where index 1< index2
        // O(1) hence no extra space
        // can be negative , integer or long?
        // no matched value: ? gurante 1 sol
        // is number empty return list
        //e
        if(numbers.length<1)return numbers;
        int l=0, r=numbers.length-1;
        while(l<r){
            int num1=numbers[l];
            int num2=numbers[r];
            int sum=num1+num2;
            if(target==sum)return new int[]{l+1,r+1};
            else if(target<sum) r--;
            else l++;
        }
        return new int[]{};
    }
}
