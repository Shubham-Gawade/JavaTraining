import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapDemo1 {

	
	public static void main(String[] args) {
		
		Map<Integer, String> namesWithIdMap=new HashMap<>();
		
		namesWithIdMap.put(101, "Saheer");
		namesWithIdMap.put(102, "Dhaval");
		
		System.out.println(namesWithIdMap);
		
		//Collection view of the map is required to traverse the elements
		Set<Map.Entry<Integer, String>> set=namesWithIdMap.entrySet();
		
		
		for(Map.Entry<Integer, String> p: set) {
			System.out.println(p.getKey() +"  "+ p.getValue());
		}
		
		Iterator<Map.Entry<Integer, String>> iterator=set.iterator();
		while(iterator.hasNext()) {
			
			Map.Entry<Integer, String> mapElement= iterator.next();
			System.out.println(mapElement.getKey() +"  "+ mapElement.getValue());
		}
		
		
		
		
		
		
		
		
		
	}
}
