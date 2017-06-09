package cn.maxlu.java.learn.reflect.basic;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

/**
 * Created by luwei on 2017/6/8.
 */

/**
 * 获取泛型信息
 */
public class ParameterizeTest {

    public Map<String, Object> get(List<String> list) {
        return null;
    }

    public static void main(String[] args) throws Exception {
        Method getMethod = ParameterizeTest.class.getMethod("get", List.class);
        Type returnType = getMethod.getGenericReturnType();
        if (returnType instanceof ParameterizedType) {
            ParameterizedType returnType1 = (ParameterizedType) returnType;
            Type[] actualTypeArguments = returnType1.getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println(actualTypeArgument);
            }
        }

        Type[] genericParameterTypes = getMethod.getGenericParameterTypes();
        for (Type genericParameterType : genericParameterTypes) {
            if (genericParameterType instanceof ParameterizedType) {
                ParameterizedType genericParameterType1 = (ParameterizedType) genericParameterType;
                Type[] actualTypeArguments = genericParameterType1.getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println(actualTypeArgument);
                }
            }
        }
    }
}
