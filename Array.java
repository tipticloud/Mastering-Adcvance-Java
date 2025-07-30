public class Array {

    static void Search(int[] a, int target, int i, int j) {
        // Base case: if i reaches the end
        if (i >= a.length - 1) {
            System.out.println("No pair found");
            return;
        }

        // If j reaches end, move to next i
        if (j >= a.length) {
            Search(a, target, i + 1, i + 2); // move to next i, reset j
            return;
        }

        // If pair found
        if (a[i] + a[j] == target) {
            System.out.println("Indices are: " + i + " and " + j);
            return;
        }

        // Try next j
        Search(a, target, i, j + 1);
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 7, 8};
        int target = 11;
        Search(a, target, 0, 1); // start from first pair
    }
}
