class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        
        if(nums2.size() < nums1.size()){
            return findMedianSortedArrays(nums2,nums1);
        }
        //we have assumed size of n is less than size of m
        int n = nums1.size();
        int m = nums2.size();
        int size = n + m;
        int lo = 0, hi = n;
        while(lo <= hi){
            int i = (lo + hi)/2;
            int j = ((n + m + 1) / 2) - i;
            int Aleft = (i == 0 ? INT_MIN : nums1[i - 1]);
            int Aright = (i >= n ? INT_MAX : nums1[i]);
            
            int Bleft = (j == 0 ? INT_MIN : nums2[j - 1]);
            int Bright = (j >= m ? INT_MAX : nums2[j]);
            if(Aleft <= Bright && Bleft <= Aright){
                if(size % 2 == 0){
                    return (max(Aleft,Bleft) + min(Aright,Bright)) / 2.0;
                }
                else{
                    return max(Aleft,Bleft);
                }
            }
            else if(Aleft > Bright){
                hi = i - 1;
            }
            else{
                lo = i + 1;
            }
        }
        return 0;
//         
    }
};