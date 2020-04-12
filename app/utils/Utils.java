package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.util.List;

public class Utils {

	private static final ObjectMapper objMapper = new ObjectMapper();
	
	
	public static <T> List<T> convertObjectList(Object from, Class<T> to)
    {
        return objMapper.convertValue(from, TypeFactory.defaultInstance().constructCollectionType(List.class,
                to));
    }
}
