package algorithms;

public class ReverserWord {
    public static void main(String[] args) {
        String s = " hello   llo  ";
        String[] strArrays = s.trim().split("\\s+");
        for (int i = 0; i < strArrays.length; i++) {
            System.out.println(strArrays[i]);
        }
    }
}
