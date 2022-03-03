package answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: ls
 * @date: 2022/3/3
 * @description:
 */
public class Demo3 {

    public static void main(String[] args) {
        String[] a = {"208730101", "208730071", "208639901", "208639881", "208639861", "208639811", "208639801"};
        getReal(a);
    }

    static void getReal(String[] a) {
        List<String> r = new ArrayList<>();
        for (String s : a) {
            int mid = s.length() / 2;
            String b = s.substring(1, mid) + s.substring(mid + 1, s.length() - 1);
            if (b.startsWith("0")) {
                b = b.substring(1, b.length());
                r.add(b);
            }
        }
        System.out.println(Arrays.toString(r.toArray()));
    }
}
