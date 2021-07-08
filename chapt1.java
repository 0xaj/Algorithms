import java.util.*;

public class chapt1 {


    //    Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
//    Output: [[1,6],[8,10],[15,18]]
//    Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> li = new LinkedList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        for (int[] interval : intervals) {
            if (li.isEmpty() || li.getLast()[1] < interval[0]) {
                li.add(interval);
            } else {
                li.getLast()[1] = Math.max(li.getLast()[1], interval[1]);
            }
        }
        return li.toArray(new int[li.size()][]);

    }
//
//    Input: prices = [7,1,5,3,6,4]
//    Output: 5
//    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.


    public int maxProfit(int[] prices) {

        int min = Integer.MAX_VALUE;
        int result = Integer.MIN_VALUE;

        for(int i=0;i<prices.length;i++){

            if(prices[i] < min){
                min = prices[i];
            }

            result = Math.max(prices[i]-min,result);
        }
        return result;
    }

//    Input  :  arr[] = {1, 5, 7, -1},
//    sum = 6
//    Output :  2
//    Pairs with sum 6 are (1, 5) and (7, -1)
//
//    Input  :  arr[] = {1, 5, 7, -1, 5},
//    sum = 6
//    Output :  3
//    Pairs with sum 6 are (1, 5), (7, -1) &
//            (1, 5)

    static int getPairsCount(int[] arr, int sum)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i = 0; i < arr.length; i++) {

            // initializing value to 0, if key not found
            if (!hm.containsKey(arr[i]))
                hm.put(arr[i], 0);

            hm.put(arr[i], hm.get(arr[i]) + 1);
        }
        int twice_count = 0;

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < arr.length; i++) {
            if (hm.get(sum - arr[i]) != null)
                twice_count += hm.get(sum - arr[i]);

            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (sum - arr[i] == arr[i])
                twice_count--;
        }

        // return the half of twice_count
        return twice_count / 2;
    }

    private static boolean isPrime(int n) {

        for (int x = 2; x * x <= 11; x++) {
            if (11 % x == 0) return false;
        }
        return true;

    }
    static boolean areRotations(String str1, String str2)
    {
        // There lengths must be same and str2 must be
        // a substring of str1 concatenated with str1.
        return (str1.length() == str2.length()) &&
                ((str1 + str1).indexOf(str2) != -1);
    }


    public static void reverseString(char[] s) {


        for (int i = 0; i < s.length / 2; i++) {
            int end = s.length - i - 1;
            char temp = s[i];
            s[i] = s[end];
            s[end] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    static List<String> li = new ArrayList<>();
    public static void printAllSubsequence(String str, String ans){
        if(str.length() == 0){
            li.add(ans);
            return;
        }
        printAllSubsequence(str.substring(1),ans + str.charAt(0));
        printAllSubsequence(str.substring(1),ans);
    }

    public static int binarySearch(int[] nums, int target) {


        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            System.out.println(mid);

            if (mid < nums.length && nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {

                start = mid + 1;
                ;

            } else {
                end = mid - 1;
            }
        }
        return -1;

    }

    static int fib(int n) {
        if (n <= 0) return 0;
        else if (n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    private static int powersOfTwo(int n) {
        if (n < 1) return 0;
        else if (n == 1) {
            System.out.println(1);
            return 1;
        } else {
            int prev = powersOfTwo(n / 2);

            int curr = prev * 2;
            System.out.println(curr);
            return curr;
        }

    }
       public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3)
            return new ArrayList();
        Set<List<Integer>> set=new HashSet<>();
        Arrays.sort(nums);
        int n=nums.length;
        for(int i=0;i<n-2;i++)
        {
            int j=i+1;
            int k=n-1;
            while(j<k)
            {
                int sum=nums[i]+nums[j]+nums[k];
                if(sum==0)
                    set.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if(sum>0)
                    k--;
                else
                    j++;
            }
        }
        return new ArrayList(set);
    }
    private static boolean validParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        for(char ch:s.toCharArray()){
            System.out.println(stack);
            if(ch=='('){
                stack.push(')');
            }
            else if(ch=='{'){
                stack.push('}');
            }
            else if(ch=='['){
                stack.push(']');
            }
            else{
                if(stack.isEmpty() || stack.pop() != ch){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    
    
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int count = 0, median = 0;
        int i=0, j=0;

        if ((m+n) % 2 == 0) {
            int firstElement = 0;
            for (count = 1; count <= (m+n)/2 + 1; count++) {
                if (i < m && j < n) {
                    if (nums1[i] <= nums2[j])
                        median = nums1[i++];
                    else
                        median = nums2[j++];
                } else if (i == m) {
                  median = nums2[j++];  
                } else if (j == n) {
                    median = nums1[i++];
                }
                if (count == (m+n)/2) {
                    firstElement = median;
                }
            }
            return (double)(firstElement + median) / 2;
        } else {
            for (count = 1; count <= (m+n)/2 + 1; count++) {
                if (i < m && j < n) {
                    if (nums1[i] <= nums2[j])
                        median = nums1[i++];
                    else
                        median = nums2[j++];
                } else if (i == m) {
                  median = nums2[j++];  
                } else if (j == n) {
                    median = nums1[i++];
                }
            }
        }
        return median;
    }
    
    //Input: strs = ["eat","tea","tan","ate","nat","bat"]
    //Output: [["bat"],["nat","tan"],["ate","eat","tea"]]
    
     public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) ca[c - 'a']++;
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
      public static boolean isValidInet4Address(String ip)
    {
        String[] groups = ip.split("\\.");
 
        if (groups.length != 4) {
            return false;
        }
 
        try {
            return Arrays.stream(groups)
                        .filter(s -> s.length() > 1 && s.startsWith("0"))
                        .map(Integer::parseInt)
                        .filter(i -> (i >= 0 && i <= 255))
                        .count() == 4;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    //Input: n = 4
//Output: "1211"
//Explanation:
//countAndSay(1) = "1"
//countAndSay(2) = say "1" = one 1 = "11"
//countAndSay(3) = say "11" = two 1's = "21"
//countAndSay(4) = say "21" = one 2 + one 1 = "12" + "11" = "1211"
    
       public String countAndSay(int n) {

           if (n < 0) return "0";

           String result = "1";

           int index = 1;

           while (index++ < n) {
               StringBuilder sb = new StringBuilder();
               int count = 1;
               for (int i = 1; i < result.length(); i++) {
                   if (result.charAt(i) == result.charAt(i - 1)) {
                       count++;
                   } else {
                       sb.append(count);
                       sb.append(result.charAt(i - 1));
                       count = 1;
                   }
               }
               sb.append(count);
               sb.append(result.charAt(result.length() - 1));
               result = sb.toString();


           }
           return result;
       }
    public int fact(int accumulator, int n){

        if( n == 1 ) return accumulator;

        return fact(accumulator*n, n-1);
    }

        
      
    
  /*  import java.math.BigInteger;

class Solution {
    public int getDecimalValue(ListNode head) {
        
        String strval = "";
        while(head != null){
            strval += head.val;
            head = head.next;
        }
        BigInteger ans = new BigInteger(strval,2);
        int result = ans.intValue();
        return result;
    }
}*/


    public static void main(String[] args) {
        /*System.out.println(isPrime(11));
        reverseString("edcba".toCharArray());
        System.out.println(binarySearch(new int[]{1,2,3,4,5,}, 4));
        */

        //  System.out.println(powersOfTwo(24));
        // System.out.println(validParentheses("(({}{()}))[]["));
        System.out.println(kthSmallestAndLargest(new int[]{2, 1, 3, 6, 4}, 3));
    }




    public static int kthSmallestAndLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            pq.add(arr[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            pq.poll();
        }
        return pq.poll();
    }
    
      //Input: s = "aaabbbcc"
        //Output: 2
	//Explanation: You can delete two 'b's resulting in the good string "aaabcc".
	//Another way it to delete one 'b' and one 'c' resulting in the good string "aaabbc".
  
    
     public int minDeletions(String s) {
        int[] arr=new int[26];
        for(int i=0;i<s.length();i++)
        {
           arr[s.charAt(i)-'a']++;//count frequency
        }
        HashSet<Integer> freq=new HashSet<>();
        int del=0;
        for(int i=0;i<arr.length;i++)
        {
            while(arr[i]!=0 && freq.contains(arr[i]))//if set already contains that frequency then deletion is performed and frequency of that character will be reduced so arr[i]--,del++
            {
               arr[i]--;
               del++;
            }
            freq.add(arr[i]);
        }
        return del;
    }

    public void rotate(int[] nums, int k) {
    //can use the same one to check if the array os rotaion of an other rray
        int[] a = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            a[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = a[i];
        }
    }

    public static void mergeArray(int[] arr1, int[] arr2) {

        // length of first arr1
        int n = arr1.length;

        // length of second arr2
        int m = arr2.length;

        // Now traverse the array1 and if
        // arr2 first element
        // is less than arr1 then swap
        for (int i = 0; i < n; i++) {

            if (arr1[i] > arr2[0]) {

                // swap
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                // after swapping we have to sort the array2
                // again so that it can be again swap with
                // arr1

                // we will store the firstElement of array2
                // and left shift all the element and store
                // the firstElement in arr2[k-1]

                int firstElement = arr2[0];

                int k;
                for (k = 1;
                     k < m && arr2[k] < firstElement;
                     k++) {
                    arr2[k - 1] = arr2[k];
                }
                arr2[k - 1] = firstElement;
            }
        }


    }
    
    
    
    //nCr = (n!) / (r! * (n-r)!)

	static int nCr(int n, int r)
{
    return fact(n) / (fact(r) *
                  fact(n - r));
}
 
// Returns factorial of n
static int fact(int n)
{
    int res = 1;
    for (int i = 2; i <= n; i++)
        res = res * i;
    return res;
}
 
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
