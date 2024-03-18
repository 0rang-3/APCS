public class App {
    public static void main(String[] args) throws Exception {
        System.out.println(insertStarV2("abcdefg"));
        System.out.println(countX("woihxioh", 0));
    }

    public static String insertStarV1(String in) {
        if(in.length() == 1) {
            return in;
        }
        String a = in.substring(0, 1);
        String b = in.substring(1);
        return insertStarV1(a)+"*"+insertStarV1(b);
    }

    public static String insertStarV2(String in) {
        if(in.length() == 1) {
            return in;
        }

        String a = in.substring(0, in.length()/2);
        String b = in.substring(in.length()/2);

        return insertStarV2(a) + "*" + insertStarV2(b);
    }

    public int countX(String in, int counter) {
        if(in.equals("x")) {
            return counter++;
        }

        String a = in.substring(0, 1);
        if(a.equals("x")) {
            counter++;
        }
        return countX(in.substring(1), counter);
    }
}
