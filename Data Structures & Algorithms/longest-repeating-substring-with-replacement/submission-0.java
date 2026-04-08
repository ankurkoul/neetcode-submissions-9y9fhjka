class Solution {
    public int characterReplacement(String s, int k) {
        //a
            // only uppercase 
            // any special chars? like "" ,@
            // u can replace with k max repeating
            // s can be empty? k is 0? then what?
            // k max value ?
            // s max length? 
            // which char to replace? 
                //always less repeating to consume least k
                // try to match seq to most repeating
        //a
            // 26 chars : A to Z 
                // A B A B B A , K=2 , 
                //   l     r         freq=> A=1,B=3
                //   here window size: r-l+1 = 4-1+1 =4 
                //   here most freq=3 
                //   hence non repeats chars are= 4-3=1 ie A
                //   this count < k hence valid window

                //  A B A Z B A , k=2
                //    l     r         freq=> A=1,B=2,Z=1
                //   here most freq=2
                //   here window size= r-l+1= 4-1+1=4
                //   hence non repeats chars are = 4-2=2 ie A,Z
                //   this count == k hence valid window

                // expand window: shift right when condition is valid
                // shrink window: shift left when condition is not valid

                //  A B A B B A
                //  lr                    -> a=1,b=0,.....z=0 is 26 charsmap 
                //                          is valid? => window_size - most_freq => 1-1=0
                //  l r                   -> a=1,b=1 => window_size - most_freq => 2-1=1
                //  l   r                 -> a=2,b=1 => window_size - most_freq => 3-2=1
                //  l     r               -> a=2,b=2 => window_size - most_freq => 4-2=2
                //  l       r             -> a=2,b=3 => window_size - most_freq => 5-3=2
                //  l         r           -> a=3,b=3 => window_size - most_freq => 6-3=3 (invalid)
                //    l       r           -> a=2,b=3 => window_size - most_freq => 5-3=2 //reduce l count,
                //               r        -> end loop
               // but r reached end hence break;
               // improve most_freq search?
               // maxFreq variable? to track max count any time 
               
                Map<Character, Integer> count = new HashMap<>();
                int maxF=0,res=0;
                int l=0,r=0;
                while(r< s.length()){
                    char c=s.charAt(r);
                    count.put(c, count.getOrDefault(c,0)+1);
                    maxF=Math.max(maxF, count.get(c));
                    if((r-l+1)-maxF>k){
                       count.put(s.charAt(l), count.get(s.charAt(l)) - 1);
                        //invalid window
                        l++;
                    }
                    res=Math.max(res,r-l+1);
                    r++;
                }
            return res;
        //c
        //t
        //s
    }
}
