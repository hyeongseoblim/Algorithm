package CodingTest;

public class danal01 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer();
    }

    public static String Solution(String[] strs) {
        if (strs.length == 0) return "";

        StringBuilder result = new StringBuilder();
        boolean same = true;

        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i) {
                    same = false;
                    break;
                } else if (temp == strs[j].charAt(i)) {
                    continue;
                }
                same = false;
                break;
            }

            if (same) result.append(temp);
            else break;
        }


        return result.toString();
    }


}

