import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        // 태그 or 단어 or 공백에 따라 token 나누기
        Pattern p = Pattern.compile("<[a-z\\s]+>|[a-z0-9]+|\\s");
        Matcher m = p.matcher(str);

        String answer = "";
        while(m.find()){
            String token = m.group();

            if (token.charAt(0)=='<' | token.charAt(0)==' '){ // 태그거나 공백이면 그대로 붙이기
                answer += token;
            }
            else { // 단어면 뒤집어서 붙이기
                StringBuffer sb = new StringBuffer(token);
                answer += sb.reverse().toString();
            }
        }
        System.out.println(answer);
       
    }
}
