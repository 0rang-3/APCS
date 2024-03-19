public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("hello world");
        System.out.println(removeX("dkljxjs"));
    }

    public static int countX(String in, int counter) {
        if(in.length() == 1) {
            if(in.equals("x")) {
                counter++;
            }
            return counter;
        }

        String a = in.substring(0, 1);
        if(a.equals("x")) {
            counter++;
        }
        return countX(in.substring(1), counter);
    }

    public static String removeX(String in) {
        if(in.substring(0, 1).equals("x")) {
            return removeX(in.substring(1));
        }

        return in.substring(0, 1) + removeX(in.substring(1));
    } 
}
