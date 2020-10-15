import java.util.Arrays;

public class phonenumber {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));

    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);
        String temp = phone_book[0];
        for (int i = 1; i < phone_book.length; i++) {
                if(temp.length()<phone_book[i].length()) {
                    if (temp.equals(phone_book[i].substring(0, temp.length()))) {
                        answer = false;
                }
            }else{
                    temp = phone_book[i];
                }
        }
        return answer;
    }
}
