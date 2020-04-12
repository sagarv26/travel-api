package utils;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

public class Utils {

	private static final ObjectMapper objMapper = new ObjectMapper();

	public static <T> List<T> convertObjectList(Object from, Class<T> to) {
		return objMapper.convertValue(from, TypeFactory.defaultInstance().constructCollectionType(List.class, to));
	}
}
