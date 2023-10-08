import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class train2{

    public static int isSequencedArray(int[] a, int m, int n){
        // check if the array size
        if ((n - m + 1) > a.length){
            return 0;
        } 
        // check if it's ascendingly sorted
        for(int i=0; i<a.length-1; i++){
            if (a[i] > a[i+1]) {
                return 0;
            }
        }
        
        for(int num=m; num<=n; num++){
            boolean isPresent = false;
            for (int j=0; j<a.length; j++){
                if (a[j] == num) {
                    isPresent = true;
                    break;
                }
            }
            if(isPresent == false) {
                return 0;
            }    
        }
        return 1;
    }

    public static int largestPrimeFactor(int n){
        int originalNumber = n;
        if (n <= 0) return 0;

        while (n > 1) {
            boolean isPrime = true;
            if ( originalNumber % n == 0){
                for(int i=2; i<n; i++){
                    if (n % i == 0){
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) return n;
            }
            n--;
        }
        return 0;
    }

    public static int[ ] encodeNumber(int n){
        if (n <= 1) return null;
        List<Integer> primeFactors = new ArrayList<>();

        for(int i=2; i<n; i++){
            while(n % i == 0){
                primeFactors.add(i);
                n /= i;
            }
        }
        if (n > 1) primeFactors.add(n);
        int[] result = new int[primeFactors.size()];
        for (int i=0; i<primeFactors.size(); i++){
            result[i] = primeFactors.get(i);
        }
        return result;
    }

    static int matchPattern(int[] a, int len, int[] pattern, int patternLen) {
        // len is the number of elements in the array a, patternLen is the number of elements in the pattern.
        int i=0; // index into a
        int k=0; // index into pattern
        int matches = 0; // how many times current pattern character has been matched so far
            for (i=0; i<len; i++) {
                if (a[i] == pattern[k]) matches++; // current pattern character was matched
                else if (matches == 0 || k == patternLen-1) return 0; // if pattern[k] was never matched (matches==0) or at end of pattern (k==patternLen-1)
                else {
                    // Advance to the next pattern character and reset matches
                    k++;
                    matches = 0;
                    // Check if the new pattern character matches the current array element
                    if (a[i] == pattern[k]) {
                        matches++;  // current pattern character was matched
                    } else {
                        return 0;   // If not, return 0
                    }      
            } // end of else
        } // end of for
        // return 1 if at end of array a (i==len) and also at end of pattern (k==patternLen-1)
        if (i==len && k==patternLen-1) return 1; else return 0;
    }
    
    public static void doIntegerBasedRounding(int[] a, int n){
        if (n <= 0) return;
        for (int i = 0; i < a.length; i++){
            if (a[i] >= 0){
                int lowerBound = (a[i] / n) * n;
                int upperBound = lowerBound + n;
                int middleElement = n % 2 == 0 ? lowerBound + n / 2 : lowerBound + n / 2 + 1;
                a[i] = a[i] >= middleElement ? upperBound : lowerBound; 
            }
        }
    }

    public static int isCubePowerful(int n){
        int originalNumber = n;
        if (n <= 0) return 0;
        int result = 0;
        while (n > 0){
            int num = n % 10;
            n /= 10;
            result += Math.pow(num, 3);
        }
        return originalNumber == result ? 1 : 0; 
    }

    // {2, -3, -2, 6, 9, 18}
    public static int decodeArray(int[] a){
        int sign = 1;
        int result = 0;
        int k = a.length - 2; // 4
        for (int i=0; i<a.length -1; i++){
            sign = a[0] < 0 ? -1 : 1;
            result += Math.abs(a[i]-a[i+1]) * Math.pow(10, k);
            k--;
        }
        return result * sign;
    }

    public static int isZeroPlentiful(int[ ] a){
        int count = 0;
        List<Integer> zeroSequences = new ArrayList<>();
        for (int i =0; i < a.length; i++){
            if(a[i] == 0){
                zeroSequences.add(a[i]);
                if (zeroSequences.size() == 4){
                    count ++;
                    zeroSequences.clear();
                }
            }
            else if (a[i] != 0 && zeroSequences.size() > 1 && zeroSequences.size()<4) return 0;
        }

        return count;
    }

    static int isDigitIncreasing(int num) {
        for (int i = 1; i <= 9; i++) {
            int sum = 0;
            int n = i;
            for (int j = 1; j <= 9; j++) {
                sum = sum + n;
                if (sum == num) {
                    return 1;
                }
                if (sum >= num) {
                    break;
                }
                n = (n * 10) + i;
            }
        }

        return 0;
    }

    public static int isFancy(int n){
        if (n <= 0) return 0;
        int first = 1;
        int second = 1;
        int third = 0;
        for (int i=1; i<=n; i++){
            third = 3 * second + 2 * first;
            if (third == n) return 1;
            first = second;
            second = third;
        }
        return 0;
    }
    public static void main(String[] args){
        // is Sequenced Array
        // int[] arr1 = {1, 2, 3, 4, 5};
        // int[] arr2 = {1, 3, 4, 2, 5};
        // int[] arr3 = {-5, -5, -4, -4, -4, -3, -3, -2, -2, -2};
        // int[] arr4 = {0, 1, 2, 3, 4, 5};
        // int[] arr5 = {1, 2, 3, 4};
        // int[] arr6 = {1, 2, 5};
        // int[] arr7 = {5, 4, 3, 2, 1};

        // System.out.println(isSequencedArray(arr1, 1, 5)); // Output: 1
        // System.out.println(isSequencedArray(arr2, 1, 5)); // Output: 0
        // System.out.println(isSequencedArray(arr3, -5, -2)); // Output: 1
        // System.out.println(isSequencedArray(arr4, 1, 5)); // Output: 0
        // System.out.println(isSequencedArray(arr5, 1, 5)); // Output: 0
        // System.out.println(isSequencedArray(arr6, 1, 5)); // Output: 0
        // System.out.println(isSequencedArray(arr7, 1, 5)); // Output: 0

        // largest Prime Number
        // System.out.println(largestPrimeFactor(10)); // Output: 5
        // System.out.println(largestPrimeFactor(6936)); // Output: 17
        // System.out.println(largestPrimeFactor(1)); // Output: 0

         // theorem of arthimethic state
        // System.out.println(Arrays.toString(encodeNumber(2)));
        // System.out.println(Arrays.toString(encodeNumber(6)));
        // System.out.println(Arrays.toString(encodeNumber(14)));
        // System.out.println(Arrays.toString(encodeNumber(24)));
        // System.out.println(Arrays.toString(encodeNumber(1200)));
        // System.out.println(Arrays.toString(encodeNumber(1)));
        // System.out.println(Arrays.toString(encodeNumber(-10)));

        // System Pattern
        // int[] arr3 = {1, 1, 1,1,1};
        // int[] pattern3 = {1};
        // System.out.println(matchPattern(arr3, arr3.length, pattern3, pattern3.length)); // Output: 1

        // int[] arr4 = {1};
        // int[] pattern4 = {1};
        // System.out.println(matchPattern(arr4, arr4.length, pattern4, pattern4.length)); // Output: 0

        // int[] arr5 = {1, 1, 2, 2, 2, 2};
        // int[] pattern5 = {1, 2};
        // System.out.println(matchPattern(arr5, arr5.length, pattern5, pattern5.length)); // Output: 0

        // int[] arr6 = {1, 1, 2, 2, 2, 2, 3};
        // int[] pattern6 = {1, 3};
        // System.out.println(matchPattern(arr6, arr6.length, pattern6, pattern6.length)); // Output: 0

        // int[] arr7 = {1, 1, 3};
        // int[] pattern7 = {1, 2};
        // System.out.println(matchPattern(arr7, arr7.length, pattern7, pattern7.length)); // Output: 0

        // int[] arr8 = {1, 1, 1, 1, 2, 2, 3, 3};
        // int[] pattern8 = {1, 3, 2};
        // System.out.println(matchPattern(arr8, arr8.length, pattern8, pattern8.length)); // Output: 0

        // int[] arr9 = {1, 1, 10, 4, 4, 3};
        // int[] pattern9 = {1, 4, 3};
        // System.out.println(matchPattern(arr9, arr9.length, pattern9, pattern9.length)); // Output: 0

        //  // lowerBound
        // int[] ary1 = {1,2,3,4,5};
        // int[] ary2 = {1,2,3,4,5};
        // int[] ary3 = {1,2,3,4,5};
        // int[] ary4 = {-1, -2, -3, -4, -5};
        // int[] ary5 = {-18, 1, 2, 3, 4, 5};
        // int[] ary6 = {1,2,3,4,5};
        // int[] ary7 = {1,2,3,4,5};
        // doIntegerBasedRounding(ary1, 2);
        // doIntegerBasedRounding(ary2, 3);
        // doIntegerBasedRounding(ary3, -3);
        // doIntegerBasedRounding(ary4, 4);
        // doIntegerBasedRounding(ary5, 4);
        // doIntegerBasedRounding(ary6, 5);
        // doIntegerBasedRounding(ary7, 100);

        // System.out.println(Arrays.toString(ary1));
        // System.out.println(Arrays.toString(ary2));
        // System.out.println(Arrays.toString(ary3));
        // System.out.println(Arrays.toString(ary4));
        // System.out.println(Arrays.toString(ary5));
        // System.out.println(Arrays.toString(ary6));
        // System.out.println(Arrays.toString(ary7));

        // Cubed function
        // System.out.println(isCubePowerful(153));
        // System.out.println(isCubePowerful(370));
        // System.out.println(isCubePowerful(371));
        // System.out.println(isCubePowerful(407));
        // System.out.println(isCubePowerful(87));
        // System.out.println(isCubePowerful(0));
        // System.out.println(isCubePowerful(-81));

        // decode array
        // int[] ary1 = {0, -3, 0, -4, 0};
        // int[] ary2 = {-1, 5, 8, 17, 15};
        // int[] ary3 = {1, 5, 8, 17, 15};
        // int[] ary4 = {111, 115, 118, 127, 125};
        // int[] ary5 = {1, 1};


        // System.out.println(decodeArray(ary1));
        // System.out.println(decodeArray(ary2));
        // System.out.println(decodeArray(ary3));
        // System.out.println(decodeArray(ary4));
        // System.out.println(decodeArray(ary5));

        // zero sequence
        // int [] ary1 = {0, 0, 0, 0, 0};
        // int [] ary2 = {1, 2, 0, 0, 0, 0, 2, -18, 0, 0, 0, 0, 0, 12};
        // int [] ary3 = {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0, 0};
        // int [] ary4 = {1, 2, 3, 4};
        // int [] ary5 = {1, 0, 0, 0, 2, 0, 0, 0, 0};
        // int [] ary6 = {0};

        // System.out.println(isZeroPlentiful(ary1));
        // System.out.println(isZeroPlentiful(ary2));
        // System.out.println(isZeroPlentiful(ary3));
        // System.out.println(isZeroPlentiful(ary4));
        // System.out.println(isZeroPlentiful(ary5));
        // System.out.println(isZeroPlentiful(ary6));

        // Digit Increasing
        // System.out.println(isDigitIncreasing(7));    // Output: 1
        // System.out.println(isDigitIncreasing(36));   // Output: 1
        // System.out.println(isDigitIncreasing(984));  // Output: 1
        // System.out.println(isDigitIncreasing(7404)); // Output: 1

        System.out.println(isFancy(1)); // Output: 1
        System.out.println(isFancy(5)); // Output: 1
        System.out.println(isFancy(17)); // Output: 1
        System.out.println(isFancy(61)); // Output: 1
        System.out.println(isFancy(98)); // Output: 0
        System.out.println(isFancy(217)); // Output: 1

    }
}