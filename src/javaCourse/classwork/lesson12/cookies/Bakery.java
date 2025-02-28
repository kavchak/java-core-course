package javaCourse.classwork.lesson12.cookies;

import java.lang.reflect.Method;

public class Bakery {

    public static void main(String[] args) throws ClassNotFoundException {

        Class cl = Class.forName("javaCourse.classwork.lesson12.cookies.Cookie");

        if (cl.isAnnotationPresent(ControlledObject.class)) {
            System.out.println("annotation is present");

            ControlledObject annotation = (ControlledObject) cl.getAnnotation(ControlledObject.class);
            System.out.println(annotation);

            System.out.println(annotation.name());

            boolean isStart = false;
            boolean isStop = false;

            Method[] methods = cl.getMethods();
            for (Method method: methods) {
                if (method.isAnnotationPresent(StartObject.class)) {
                    isStart = true;
                }
                if (method.isAnnotationPresent(StopObject.class)) {
                    isStop = true;
                }

                if (isStart && isStop) {
                    break;
                }
            }

            System.out.println("This class can start baking: " + isStart);
            System.out.println("This class can stop baking: " + isStop);

            if (isStart && isStop) {
                Cookie cookie = new Cookie();
                cookie.cook(annotation.name());
                cookie.finish(annotation.name());
            }
        } else {
            System.out.println("not annotated");
        }
    }
}
