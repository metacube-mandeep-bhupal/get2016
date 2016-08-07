import java.util.*;

public class ConcordanceOfCharacter {

	public Map<Character,List<Integer>> concordance(String str)
	{
		Map<Character,List<Integer>> map=new HashMap<Character,List<Integer>>();
		
		char ch[]=str.toCharArray();
		for(Integer i=0; i< str.toCharArray().length;i++)
		{
			if(map.containsKey(ch[i])){
				List list=new ArrayList();
				list=map.get(ch[i]);
				list.add(i);
				map.put(ch[i],list);
			}
			else
			{
				List list=new ArrayList();
				list.add(i);
				map.put(ch[i], list);
			}
		
		}
		return map;
	}
	
	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		String str="";
		Map<Character,List<Integer>> map= new HashMap<Character,List<Integer>>();
		ConcordanceOfCharacter concord=new ConcordanceOfCharacter();
		System.out.println("Enter the string: ");
		str=sc.nextLine();
		
		map=concord.concordance(str);
		
		for(Map.Entry<Character,List<Integer>> entry: map.entrySet())
		{
			System.out.println("\n");
			System.out.println(entry.getKey()+" : " +entry.getValue());
		}
		sc.close();

	}

}
