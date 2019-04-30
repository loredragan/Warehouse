package start;

import java.lang.reflect.Field;
public class ReflectionTech {
	public static String retrieveProperties(Object object) {
		String res = "";
		for (Field field : object.getClass().getDeclaredFields()) {
			field.setAccessible(true); 
			//System.out.println(field.toString());
			Object value;
			try {
				value = field.get(object);
				 res += "  "+field.getName() + "=" + value +" \n ";
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			
		}
		return res;
	}
}
