class Solution {
    public boolean isPalindrome(String s) {
        //a: 
        // can be uppercase or lowecase or digit
        // can have space  and non-alphanumeric ignore
        // can be empty or max length?
        //e:
        if(s== null)return false;
        if(s.isEmpty()) return true;
        int l=0, r=s.length()-1;
        while(l<r){
            // skip non letter or digit 
            while(l<r && !Character.isLetterOrDigit(s.charAt(l))){
                l++;
            }
            while(l<r && !Character.isLetterOrDigit(s.charAt(r))){
                r--;
            }

            //compare left char with right char
            char ll=Character.toLowerCase(s.charAt(l));
            char rr=Character.toLowerCase(s.charAt(r));
            if(ll!=rr){
                return false;
            }
            // as we have comapred l and r
            l++;
            r--;
        }
        return true;
    }
}
