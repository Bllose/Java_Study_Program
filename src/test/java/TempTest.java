import java.util.*;

/**
 * <pre>
 *
 * </pre>
 *
 * @Author Bllose
 * @Date 2019/12/31 15:27
 */
public class TempTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n == 0) return;
        Map<String, String> hxr = new HashMap<>();

        for(int i = 0; i < n; i++){
            String[] input = new String[2];
            for(int j = 0; j < 2; j++){
                if(!sc.hasNext()) return;
                input[j] = sc.next();
            }
            hxr.put(input[0], input[1]);
        }

        n = sc.nextInt();
        if(n == 0)return;

        Map<String, Integer> counter = new HashMap<>();
        for(int i = 0 ; i < n ; i ++){
            if(!sc.hasNext()) break;
            String name = sc.next();
            String companyName = hxr.get(name);
            if(counter.containsKey(companyName)){
                counter.put(companyName, counter.get(companyName) + 1);
            }else{
                counter.put(companyName, 0);
            }
        }

        String mostCompanyName = "";
        n = 0;
        for(String key : counter.keySet()){
            if (counter.containsKey(key)){
                if(counter.get(key) >= n){
                    n = counter.get(key);
                    mostCompanyName = key;
                }
            }

        }

        System.out.println(mostCompanyName);

    }


}
