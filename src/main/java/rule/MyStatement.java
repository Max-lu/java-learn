package rule;


import org.junit.runners.model.Statement;

/**
 * Created by max.lu on 2016/3/23.
 */
public class MyStatement extends Statement {
    private final Statement statement;

    public MyStatement(Statement statement) {
        this.statement = statement;
    }

    @Override
    public void evaluate() throws Throwable {
        System.out.println("--before test--");
        try {
            statement.evaluate();
        } finally {
            System.out.println("--after test--");
        }
    }
}
