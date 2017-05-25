package cn.maxlu.annotation.policy.clazz;


/**
 * Created by luwei on 2017/5/8.
 */
public class ClassAnnotationTest {
    public static void main(String[] args) throws Exception {
        //使用ASM字节码技术获取注解
//        ClassNode classNode = new ClassNode();
//
//        ClassReader cr = new ClassReader(new FileInputStream("classes/me/format/annotation/AnnotationObject.class"));
//
//        cr.accept(classNode, 0);
//
//        System.out.println("Class Name: " + classNode.name);
//        System.out.println("Source File: " + classNode.sourceFile);
//
//        System.out.println("invisible: ");
//        AnnotationNode anNode = null;
//        for (Object annotation : classNode.invisibleAnnotations) {
//            anNode = (AnnotationNode) annotation;
//            System.out.println("Annotation Descriptor : " + anNode.desc);
//            System.out.println("Annotation attribute pairs : " + anNode.values);
//        }
//
//        System.out.println("visible: ");
//        for (Object annotation : classNode.visibleAnnotations) {
//            anNode = (AnnotationNode) annotation;
//            System.out.println("Annotation Descriptor : " + anNode.desc);
//            System.out.println("Annotation attribute pairs : " + anNode.values);
//        }
    }
}
