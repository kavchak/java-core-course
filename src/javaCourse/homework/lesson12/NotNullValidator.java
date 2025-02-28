package javaCourse.homework.lesson12;

import java.lang.reflect.Field;

public class NotNullValidator {
    public static void validate(Object obj) throws NotNullFieldException {
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(NotNullValue.class)) {
                field.setAccessible(true);
                try {
                    Object value = field.get(obj);
                    if (value == null) {
                        throw new NotNullFieldException("Field " + field.getName() + " cannot be null!");
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException("Error accessing field: " + field.getName(), e);
                }
            }
        }
    }
}
