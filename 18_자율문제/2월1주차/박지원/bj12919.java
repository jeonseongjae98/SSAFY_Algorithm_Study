import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    static int k;
    static String s, t;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        //t를 계속 줄여나가는 방식으로 해결하자.
        
        k = t.length();
        result = dfs(s, t);
        System.out.println(result);

    }

    public static int dfs(String s, String t) {
        if (s.length() == t.length()) {
            if (s.equals(t)) {
                return 1;
            }
            return 0;
        }
        int ans = 0;
        //맨앞글자가 b라면 앞글자를 빼고 뒤집기
        if (t.charAt(0) == 'B') {
            String substring = t.substring(1);
            StringBuilder sb = new StringBuilder(substring);
            String string = sb.reverse().toString();
            ans += dfs(s, string);
        }
        //t의 마지막이 a라면 마지막 글자를 빼기
        if (t.charAt(t.length() - 1) == 'A') {
            ans += dfs(s, t.substring(0, t.length() - 1));
        }
        return ans > 0 ? 1 : 0;
    }
}
