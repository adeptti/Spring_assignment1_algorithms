public class Problem5_RemoveElements {

    /* 
     *  Removes all the elements smaller than val from the array.
     *
     *  The method overwrites the array in-palce so that the first k elements'
     *  are all values >= val. The relative order of kept elements is preserved.
     *     
     * 
     *  Returns:
     *      k = number of elements that are >= val
     *
     * Time complexity: O(n)
     * Space complexity: S(1) extra space
    */
    // keep values >= val, overwrite from front, return k kept.
    public static int removeSmaller(double[] nums, double val){

        //  k tracks the position where the next valid element should be written
        int k = 0;

        //  Scan through the array once.
        for(int i = 0; i < nums.length; i++){

            //  If the cuurent elemtn should be kept
            if(nums[i] >= val){

                //  Overwrites the elements at index k with the valid value
                nums[k] = nums[i];
                
                //  Move k forward to the next write position
                k++;
            }
        }
        //  k is the number of elements >= val
        return k;
    }

    //  Prints only the first 'length' elements of the array
    //  (used to show the modified portion after removal)
    private static void printArray(double[] a, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(a[i]);
            if (i < length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }

    //  Prints the entire array (including leftover values past k)
    private static void printFullArray(double[] a){
        System.out.print("[");
        for(int i = 0; i < a.length; i++){
            System.out.print(a[i]);
            if(i < a.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        double[] nums = {1.5, 3.2, 2.9, 4.0, 0.5, 3.5};
        double val = (args.length >= 1) ? Double.parseDouble(args[0]) : 3.0;

        System.out.println("Problem 5: Remove Elements Smaller Than val");
        System.out.println("-----------------------------------------");

        System.out.print("Original array: ");
        printFullArray(nums);
        System.out.println();

        System.out.println("Value (val): " + val);

        int k = removeSmaller(nums, val);

        System.out.println("Number of elements >= val (k): " + k);

        System.out.print("Modified array (first k elements): ");
        printArray(nums, k);
        System.out.println();
    }
}
