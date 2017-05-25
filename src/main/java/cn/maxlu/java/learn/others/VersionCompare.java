package cn.maxlu.java.learn.others;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * Created by max.lu on 2015/12/31.
 */
public class VersionCompare {

    public static void main(String[] args) throws Exception {
        compare("1.2", "1.3.5");
    }

    private static long compare(String source, String target) {
        return convert(source) - convert(target);
    }

    private static long convert(String version) {
        if (version == null)
            return 0;

        String ver = version + "...0";
        String[] vers = ver.split("\\.");
        BigDecimal result = BigDecimal.ZERO;

        for (int i = 0; i < 4; i++) {
            if (!Objects.equals(vers[i], "")) {
                result = result.add(BigDecimal.TEN.pow(3 * (3 - i)).multiply(new BigDecimal(vers[i])));
            }
        }
        return result.longValue();
    }
}
