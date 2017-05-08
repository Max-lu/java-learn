package annotation.policy.clazz;

/**
 * Created by luwei on 2017/5/8.
 */
@Meta(name = "obj")
@Header(code = 200)
public class AnnotationObject {

    private String val;

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }
}
