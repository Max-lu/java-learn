package cn.maxlu.java.learn.io;

import java.io.StreamTokenizer;
import java.io.StringReader;

/**
 * Created by luwei on 2017/5/22.
 */
public class StreamTokenizerTest {

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

}
