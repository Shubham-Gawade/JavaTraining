import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo3 {
	
	public static void main(String[] args) {
		
		
		Map<Integer, String> map1=new HashMap<Integer, String>();
		map1.put(101, "Saheer");
		
		Map<Integer, String> map2=new HashMap<Integer, String>();
		map2.put(102, "Shashank");
		
		//Adding put, putAll
		map1.putAll(map2);
		
		System.out.println(map1);
		
		//Checking
		System.out.println(map1.containsKey(101));
		System.out.println(map1.containsValue(101));
		System.out.println(map1.equals(map2));
		//Removing
		
		//Get
		System.out.println(map1.get(101));
		
		Set<Integer> keySet=map1.keySet();
		Collection<String> values=map1.values();
		
		System.out.println(keySet);
		System.out.println(values);
		
	}

}
