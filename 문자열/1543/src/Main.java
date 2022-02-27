import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String doc = br.readLine();     // 문서(<=2500)
        Pattern p = Pattern.compile(br.readLine());    // 검색하고 싶은 단어(<=50)
        Matcher m = p.matcher(doc);
        int ans = 0;
        while(m.find()){
            ans++;
        }
        System.out.println(ans);
        
    }
}
