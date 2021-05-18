import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Main {
	
	static HashMap<Character, List<Character>> map = new HashMap<>();
	
	static List<Character> list1 = new ArrayList<Character>();
	static List<Character> list2 = new ArrayList<Character>();
	static List<Character> list3 = new ArrayList<Character>();
	static List<Character> list4 = new ArrayList<Character>();
	static List<Character> list5 = new ArrayList<Character>();
	static List<Character> list6 = new ArrayList<Character>();
	static List<Character> list7 = new ArrayList<Character>();
	static List<Character> list8 = new ArrayList<Character>();
	
	
	static void convertAndCompare(String string_1, String string_2) {
		
		for(int i = 0; i < string_1.length(); i++) {
			
			while(string_1.charAt(i) != string_2.charAt(i) && string_1.charAt(i) != '0') {
				
				StringBuilder sb = new StringBuilder(string_1);
				
				if(map.get(string_1.charAt(i)) == null) {
					sb.setCharAt(i, '0');
				}
				else {
					List<Character> list = new ArrayList<Character>();
					list = map.get(string_1.charAt(i));
					
					for(Character ch : list) {
						sb.setCharAt(i, ch);
						
						if(sb.charAt(i) == string_2.charAt(i)) {
							break;
						}
					}
				}
				
				string_1 = sb.toString();
			}
			
			if(string_1.charAt(i) == '0') {
				break;
			}
		}
		
		if(string_1.equals(string_2)) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		list1.add('t');
		list2.add('r');
		list3.add('p');
		list4.add('c');
		list5.add('o');
		list6.add('e');
		list6.add('f');
		list7.add('h');
		list8.add('p');
		
		map.put('c', list1);
		map.put('i', list2);
		map.put('k', list3);
		map.put('o', list4);
		map.put('r', list5);
		map.put('t', list6);
		map.put('u', list7);
		map.put('w', list8);
		 
		String[] strings = new String[] {"we", "we",
										"can", "the",
										"work", "people",
										"it", "of",
										"out", "the"};
		
		
		int y = 5;
		
		for(int i = 0; i <= (2 * y - 2); i += 2) {
			if(strings[i].length() != strings[i+1].length()) {
				System.out.println("no");
			}
			else {
				if(strings[i].equals(strings[i+1])) {
					System.out.println("yes");
				}
				else {
					convertAndCompare(strings[i], strings[i+1]);
				}
			}
		}	

}
}
