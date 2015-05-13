package annotaion;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface ClassInfo {

    String author();

    boolean checked() default true;

    int currentRevision() default 1;

    Class<?>[] related();
}

@ClassInfo(author = "koche", related = { RelatedClass.class })
public class ClassInfoTest {
    public static void main(String[] args) {
        Annotation[] anotations = ClassInfoTest.class.getAnnotations();

        for (Annotation curAn : anotations) {
            if (curAn instanceof ClassInfo) {
                ClassInfo an = (ClassInfo) curAn;
                System.out.println("Author: " + an.author());
                System.out.println("Is checked: " + an.checked());
                System.out.println("Current revision: " + an.currentRevision());
                System.out.println("Related classes: " + an.related()[0].toString());

            }
        }

    }
}
