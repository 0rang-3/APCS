import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        int[] arr = {4, 7, 14, 1, 3, 9, 17};
        int[] tmp = new int[arr.length];

        merge(arr, tmp, 0, 2, 3, 6);
        System.out.println(Arrays.toString(arr));
    }

    public static void merge(int[] arr, int[] tmp, int s1, int e1, int s2, int e2) {
        int currentLeft = s1;
        int currentRight = s2;
        int nextLoc = s1;

        while(currentLeft <= e1 && currentRight <= e2) {
            if(arr[currentLeft] < arr[currentRight]) {
                tmp[nextLoc] = arr[currentLeft];
                currentLeft++;
            } else {
                tmp[nextLoc] = arr[currentRight];
                currentRight++;
            }

            nextLoc++;
        }

        if(currentLeft <= e1) {
            for (int i = currentLeft; i <= e1; i++) {
                tmp[i] = arr[i];
            }
        }
        if(currentRight <= e2) {
            for (int i = currentRight; i < e2; i++) {
                tmp[i] = arr[i];
            }
        }

        for (int i = 0; i < tmp.length; i++) {
            arr[i] = tmp[i];
        }
    }
}
