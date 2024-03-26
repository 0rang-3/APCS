public class App {
    public static void main(String[] args) throws Exception {
        moveStack(3, 1, 3);
    }

    public static void moveStack(int n,int start, int target) {
        int other = 6-target-start;

        if(n == 1) {
            System.out.println("Move Disk from peg " + start + " to peg " + target);
            return;
        }
        moveStack(n-1, start, target);
        System.out.println(start + "-->" + target);
        moveStack(n-1, other, target);
    }
}
