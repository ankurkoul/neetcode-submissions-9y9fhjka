class Solution {
    public int characterReplacement(String s, int k) {
        /**
        //a
            min or max s?
            can lowercase or special char?
        //l 
            replacement count should be less than k;
            min replacement is possible if we turn non most freq char
            hence replacement is (window-maxf)
            valid window: grow window   by moving r++
            invalid     : shrink window by moving l++
        //e

        //t

        /s
        
        */
        if(s==null || s.isEmpty())return 0;
        int l=0,r=0;
        Map<Character,Integer>count=new HashMap<>();
        int res=0,maxF=0;
        while(r<s.length()){
            char ch=s.charAt(r);
            count.put(ch, count.getOrDefault(ch,0)+1);
            maxF=Math.max(maxF,count.get(ch));
            if((r-l+1)-maxF>k){
                char ch2=s.charAt(l++);
                count.put(ch2,count.get(ch2)-1);
            }
            res=Math.max(res,r-l+1);
            r++;
        }
        return res;
    }
    /*
    
    Excellent question. This is a clever optimization in the sliding window approach for problems like "Longest Repeating Character Replacement". Let's break down why you don't need to update the maximum frequency (maxF) when the window shrinks.

The core idea relies on the condition for a valid window:
window_length - max_frequency <= k

We can rearrange this to:
window_length <= max_frequency + k

Our goal is to find the maximum possible window_length. From the rearranged formula, you can see that a larger window_length is only possible if we also have a larger max_frequency.

Here's the step-by-step reasoning:

We Seek a Longer Window: The algorithm tries to find the longest valid substring. Let's say the longest window we've found so far has length L. To find a better answer, we need to find a window of length L+1 or more.

Condition for a Longer Window: To achieve a new maximum length of L+1, we would need to find a window where L+1 <= new_max_frequency + k. This means the max_frequency in that new window must be greater than or equal to the max_frequency that supported our previous best length L.

Why Decreasing maxF Doesn't Matter: When we shrink the window by moving the left pointer, the true maximum frequency of the characters inside the current, smaller window might decrease.

However, a window with a smaller max_frequency can never be longer than the best window we have found so far.
Since we are only hunting for a longer window, we are only interested in cases where max_frequency increases.
The Optimization: The algorithm keeps maxF as a "high-water mark"—the maximum frequency seen in any window so far. The window size (j - i + 1) will continue to slide but won't grow larger than the current maximum length. It can only expand to a new record length if we encounter a new substring that increases maxF to a new high-water mark.

In short, we can afford to have an "incorrect" or "outdated" maxF while the window shrinks, because that window is guaranteed not to be our final answer anyway. The final answer can only be updated when the window expands, which happens only when we find a higher maxF.
    */
}
