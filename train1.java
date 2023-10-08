import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class train1 {
    static char[] a3(char[] a, int start, int len) {
        // Check if start position and length are legal
        if (start < 0 || start >= a.length || len < 0 || start + len > a.length) {
            return null;
        }
        
        // Create new character array with specified length
        char[] result = new char[len];
        
        // Copy characters from input array to result array
        for (int i = 0; i < len; i++) {
            result[i] = a[start + i];
        }
        
        return result;
    }
    
    public static int largestPrimeNumber(int num){
        // code here
        if (num <= 0) return 0;
        int number = num;
        while (number > 1){
            boolean isPrime = true;
            if (num % number == 0){
                for(int i=2; i<number; i++){
                    if (number % i == 0){
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) return number;
            }
            number --;
        }
        return 0;
    }

    public static int[] encodeNumber(int num){
        if (num <= 1) return null;
        // int number = num;
        // int factt = 2;
        List<Integer> primeFactors = new ArrayList<>();
        // while (number > 1){
        //     if (number % factt == 0){
        //         number /= factt;
        //         primeFactors.add(factt);
        //     }
        //     factt ++;
        // }
        // if (number > 1) primeFactors.add(number);
        for(int i=2; i<num; i++){
            while(num % i == 0){
                primeFactors.add(i);
                num = num / i;
            }
        }
        if (num > 1) primeFactors.add(num);
        int[] result = new int[primeFactors.size()];
        for(int i=0; i<primeFactors.size(); i++){
            result[i] = primeFactors.get(i);
        }

        return result;
    }

    public static void doIntegerBasedRounding(int[] arr, int num){
        if (num <= 0) return;
        for (int i=0; i<arr.length; i++){
            if (arr[i] >= 0){
                int lowerBound = (arr[i]/num)*num;
                int upperBound = lowerBound + num;
                int middleElement =  num % 2 == 0 ? lowerBound + num/2 : lowerBound + num/2 + 1;
                if (arr[i] >= middleElement) arr[i] = upperBound;
                else arr[i] = lowerBound;
            }
        }
    }

    public static int largestAdjacentSum(int[ ] a){
        int maxSum = 0;
        for (int i=0; i<a.length-1; i++){
            maxSum = Math.max(maxSum, (a[i]+a[i+1]));
        }
        return maxSum;
    }

    public static int checkConcatenatedSum(int n, int catlen){
        int result = 0;
        int originalNumber = n;
        while(n != 0){
            int num = n % 10;
            int concateSum = 0;
            for(int i=0; i<catlen; i++){
                concateSum = num + (concateSum * 10);
            }
            result += concateSum;
            n /= 10;
        }
        return result == originalNumber ? 1 : 0;
        // return result;
    }

    public static int isSequencedArray(int[ ] a, int m, int n){
        if (a.length < (n - m + 1)) {
            return 0;
        }

        // Check if the array is in ascending order
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return 0;
            }
        }

        for(int num = m; num<=n; num++){
            boolean isFound = false;
            for (int i=0; i<a.length; i++){
                if (a[i] == num){
                    isFound = true;
                    break;
                }
            }
            if (!isFound) return 0;
        }

        return 1;
    }

    public static void main(String[] args){
        // a3 test cases
        // char[] arr1 = {'a', 'b', 'c'};
        // char[] arr2 = {'a', 'b', 'c'};
        // char[] arr3 = {'a', 'b', 'c'};
        // char[] arr5 = {};

        // lowerBound
        int[] ary1 = {1,2,3,4,5};
        int[] ary2 = {1,2,3,4,5};
        int[] ary3 = {1,2,3,4,5};
        int[] ary4 = {-1, -2, -3, -4, -5};
        int[] ary5 = {-18, 1, 2, 3, 4, 5};
        int[] ary6 = {1,2,3,4,5};
        int[] ary7 = {1,2,3,4,5};
        doIntegerBasedRounding(ary1, 2);
        doIntegerBasedRounding(ary2, 3);
        doIntegerBasedRounding(ary3, -3);
        doIntegerBasedRounding(ary4, 4);
        doIntegerBasedRounding(ary5, 4);
        doIntegerBasedRounding(ary6, 5);
        doIntegerBasedRounding(ary7, 100);

        System.out.println(Arrays.toString(ary1));
        System.out.println(Arrays.toString(ary2));
        System.out.println(Arrays.toString(ary3));
        System.out.println(Arrays.toString(ary4));
        System.out.println(Arrays.toString(ary5));
        System.out.println(Arrays.toString(ary6));
        System.out.println(Arrays.toString(ary7));


        // System.out.println(a3(arr1, 0, 3));
        // System.out.println(a3(arr1, 0, 4));


        // largest Prime Number test cases
        // System.out.println(largestPrimeNumber(10));
        // System.out.println(largestPrimeNumber(6936));
        // System.out.println(largestPrimeNumber(1));

        // theorem of arthimethic state
        // System.out.println(Arrays.toString(encodeNumber(2)));
        // System.out.println(Arrays.toString(encodeNumber(6)));
        // System.out.println(Arrays.toString(encodeNumber(14)));
        // System.out.println(Arrays.toString(encodeNumber(24)));
        // System.out.println(Arrays.toString(encodeNumber(1200)));
        // System.out.println(Arrays.toString(encodeNumber(1)));
        // System.out.println(Arrays.toString(encodeNumber(-10)));

        // MaxAdjecent sum 
        // int[] arr1 = {1, 2, 3, 4};
        // int[] arr2 = {18, -12, 9, -10};
        // int[] arr3 = {1, 1, 1, 1, 1, 1, 1 };
        // int[] arr4 = {1,1,1,1,1,2,1,1,1};

        // System.out.println(largestAdjacentSum(arr1));
        // System.out.println(largestAdjacentSum(arr2));
        // System.out.println(largestAdjacentSum(arr3));
        // System.out.println(largestAdjacentSum(arr4));

        // checkConcatenatedSum
        // System.out.println(checkConcatenatedSum(198, 2));
        // System.out.println(checkConcatenatedSum(198, 3));
        // System.out.println(checkConcatenatedSum(2997, 3));
        // System.out.println(checkConcatenatedSum(2997, 2));
        // System.out.println(checkConcatenatedSum(13332, 4));
        // System.out.println(checkConcatenatedSum(9, 1));

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
    } 

}
