// https://leetcode.com/problems/kth-smallest-product-of-two-sorted-arrays

public class KthSmallestProductOfTwoSortedArrays {

    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        // since we are taking product that why power added (a*b)
        long left = -1_000_000_000_0L, right = 1_000_000_000_0L;

        while(left<right) {
            long mid = left + (right - left) / 2;

            if (countProducts(mid, nums1, nums2) < k) { // to small
                left = mid + 1;
            } else { // mid and above is the answer
                right = mid; 
            }
        }

        return left;
    }


    public long countProducts(long target, int[] n1, int[] n2) {
        long count = 0;
        for(int n: n1) {
            if(n == 0) {
                if(target >= 0) count += n2.length;
                continue;
            }

            int left = 0, right = n2.length;
            if(n > 0){
                while(left < right) {
                    int mid = left + (right - left)/2;
                    if((long) n * n2[mid] > target) right = mid;
                    else left = mid+1;
                }
                count += left;
            } else{
                while(left<right) {
                    int mid = left + (right - left)/2;
                    if((long) n * n2[mid] <= target) {
                        right = mid;
                    } else{
                        left = mid+1;
                    }
                }
                count += n2.length - left;
            }
        }

        return count;
    }
}