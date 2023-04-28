class Solution {
public:
    int findMin(vector<int>& nums) {
        int length = nums.size();
        int left = 0;
        int right = length - 1;
        int midPoint, ans;
        // 2 < 2 && 2 > 1
        int count = 0;
        while(left <= right) {
            count++;
            midPoint = (left + right) / 2;
            cout<<midPoint<<" "<<left<<" "<<right<<endl;
            if(nums[left] <= nums[midPoint] && nums[midPoint] > nums[right]) {
                //move mid to right
                cout<<"im here";
                left = midPoint + 1;
            }
            else if(nums[left] >= nums[midPoint] && nums[midPoint] < nums[right]) {
                //move mid to left
                right = midPoint;
            }
            else {
                cout<<count<<endl;
                break;
            }
            cout<<midPoint<<" "<<left<<" "<<right<<endl;
        }
        cout<<left<<endl;
        return nums[left];
    }
};