public class Problem5_RemoveElements {

    // keep values >= val, overwrite from front, return k kept.
    public static int removeSmaller(double[] nums, double val){
        int k = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] >= val){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    private static void printArray(double[] a, int length) {
        System.out.print("[");
        for (int i = 0; i < length; i++) {
            System.out.print(a[i]);
            if (i < length - 1) System.out.print(", ");
        }
        System.out.print("]");
    }

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
