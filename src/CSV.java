import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CSV {
	private List<Person> pn = new ArrayList<>();
	private List<Person> ps = new ArrayList<>();
	private List<Person> ps20 = new ArrayList<>();
	private List<String> infoA = new ArrayList<>();
	private List<String> infoB = new ArrayList<>();
	private String[] Classes = {"E","R","W","D","Nc","V","B","Nm"};
	
	//CSV読み込み関数
	public void CSVRead(String filename) {
		try {			List<String> lines =Files.readAllLines(Paths.get(filename),Charset.forName("UTF-8"));
			for(int i = 1; i< lines.size(); i++) {
				String[] data = lines.get(i).split(","); //csv列取得
				/*0番目は、timestampなので不要*/
				String name = data[1]; //名前
				String team = data[2]; //チーム
				String time = data[3]; //参加可能な時間帯
				int classNum = 0; //Classes配列用変数
				
				Person p = new Person(name,team,time);
				int index = data.length;
				if(index == 14) {
					String temp = name + ":" + data[13];
					if(team.equals("A"))
						infoA.add(temp);
					if(team.equals("B"))
						infoB.add(temp);
					index =13;
				}
				for(int j = 5; j < index; j++) {
					if(data[j].equals("")) {
						classNum++;
						continue;
					}
					p.SetClass(Classes[classNum], 0);
					p.SetArky(Classes[classNum], data[j]);
					classNum++;	
				}
				if (time.equals("参加できる"))ps.add(p);
				else pn.add(p);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	//参加できない人リスト出力
	public void ViewNameN(String team) {
		System.out.print("[");
		if(pn.size() == 0)System.out.print("該当者なし");
		for(Person p : pn) {
			if(!p.GetTeam().equals(team)) continue;
			System.out.print(p.GetName() + ",");
		}
		System.out.println("]");
	}
	
	//17時参加可能リスト出力
	public void ViewName(String team) {
		System.out.print("[");
		if(ps.size() == 0)System.out.print("該当者なし");
		for(Person p : ps) {
			if(!p.GetTeam().equals(team)) continue;
			System.out.print(p.GetName() + ",");
		}
		System.out.println("]");
	}
	
	
	//20時参加可能リスト出力
	public void ViewName20(String team) {
		System.out.print("[");
		if(ps20.size() == 0)System.out.print("該当者なし");
		for(Person p : ps20) {
			if(!p.GetTeam().equals(team)) continue;
			System.out.print(p.GetName() + ",");
		}
		System.out.println("]");
	}
	
	//17時参加可能Personリスト出力
	public List<Person> GetList(){
		return ps;
	}
	
	//20時参加可能Personリスト出力
	public List<Person> GetList20(){
		return ps20;
	}
	
	//特記事項出力
	public List<String> GetInfo(String team){
		if(team.equals("A"))
			return infoA;
		if(team.equals("B"))
			return infoB;
		return null;
	
	}
	

}
