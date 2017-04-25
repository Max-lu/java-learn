package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by luwei on 2017/4/13.
 */
public class ReverseTest {
    @Test
    public void test() {
        int[] a = {1, 2, 3, 4, 5, 6, 7};

        int n = a.length - 1;
        for (int i = 0; i <= n / 2; i++) {
            int j = n - i;
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
        System.out.println(Arrays.toString(a));
    }
}
