class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int total = m + n;
        int half = total / 2;
        
        int i = 0 , j = 0 ;
        int prev = -1 , curr = -1 ;

        for (int count = 0 ; count <= half ; count++) {
            prev = curr ;
            
            if (i<m && ( j >= n || nums1[i] < nums2[j])) {
                curr = nums1[i] ;
                i++ ;
            } else {
                curr = nums2[j] ;
                j++ ;
            }
        }

        if (total % 2 == 1) {
            return curr ;
        } else {
            return ( prev + curr) / 2.0 ;
        }
    }
 
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = {1, 4};
        int[] nums2 = {2, 6};
        double median = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median: " + median);
    }


}