import java.util.HashMap;
import java.util.Map;

public class Person {
	private String name;//名前
	private String team;//チーム名
	private String time;//参加可能時間
	private Map<String,String> classes = new HashMap<>(); //クラス,練度
	private Map<String,String> arky = new HashMap<>(); // クラスとアーキ
	
	Person(String name,String team,String time){
		this.name = name;
		this.team = team;
		this.time = time;
		
	}
	
	public String GetTeam() {
		return this.team;
	}
	public String GetTime() {
		return this.time;
	}
	public String GetName() {
		return this.name;
	}
	public void SetClass(String class_name,String rendo) {
		classes.put(class_name, rendo);
	}
	public void SetArky(String class_name, String arky) {
		this.arky.put(class_name, arky);
	}
	
	public void ViewArkyAndRendo(String class_name) { 
		 if(classes.containsKey(class_name)) {
			 System.out.print("[");
			 System.out.print(name + ":");
			 System.out.print("アーキ:");
			 System.out.print(arky.get(class_name));
			 System.out.print("(" + classes.get(class_name) + ")");
			 System.out.println("],");
		 }
	}
}
