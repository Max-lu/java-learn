package cn.maxlu;

import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * Created by lw on 2016/7/18.
 */

public class Test {

    public static void main(String[] args) throws Exception {
        StreamTokenizer tokenizer = new StreamTokenizer(new StringReader("Mary had 1 little lamb..."));
        while (tokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            if (tokenizer.ttype == StreamTokenizer.TT_WORD) {
                System.out.println(tokenizer.sval);
            } else if (tokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                System.out.println(tokenizer.nval);
            } else if (tokenizer.ttype == StreamTokenizer.TT_EOL) {
                System.out.println();
            }
        }
    }

    @SuppressWarnings("unchecked")
    private static <S> S get() {
        return (S) ("123");
    }

}
