package rule;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;

/**
 * Created by max.lu on 2016/3/23.
 */
public class MyRule implements MethodRule {
    @Override
    public Statement apply(Statement statement, FrameworkMethod frameworkMethod, Object o) {
        return new MyStatement(statement);
    }
}
