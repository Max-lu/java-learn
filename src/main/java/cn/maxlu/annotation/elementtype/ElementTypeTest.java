package cn.maxlu.annotation.elementtype;

/**
 * Created by luwei on 2017/6/9.
 */
@TypeAnnotation
public class ElementTypeTest {

    @FieldAnnotation
    private int a;

    @ConstructorAnnotation
    public ElementTypeTest() {
    }

    public static class Holder< @TypeParameterAnnotation T > extends @TypeUseAnnotation Object {

        @MethodAnnotation
        public T method(@ParameterAnnotation int c) throws @TypeUseAnnotation Exception {
            @LocalVariableAnnotation @TypeUseAnnotation int b = 2;
            return null;
        }
    }

    @TypeAnnotation
    @AnnotationTyeAnnotation
    private  @interface TestAnnotation {
    }

}
