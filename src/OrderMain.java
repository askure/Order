import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.sql.Timestamp;
import java.util.List;

public class OrderMain {

	public static void main(String[] args) {
		
		try {
			/*csvファイルを取得*/
			System.out.println("プログラムのあるフォルダにある調査結果csvのファイル名を入力");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String fileName = br.readLine();
			File file = new File(fileName);
			if(!file.exists()) {
				System.out.println("ファイルが存在しません");
				return;
			}
			System.out.println("使用クラス 5クラスを入力 , 全て表示は-1を入力");
			String input = br.readLine();
			String[] classes ;
			 String[] Classes = {"E","R","W","D","Nc","V","B","Nm"};
			if(input.equals("-1")) {
				classes = Classes;
			}
			else {
				classes  = input.split(" ");
			}
			
			CSV csv = new CSV();
			csv.CSVRead(fileName);
			List<Person> ps20 = csv.GetList20(); //20時参加者teリスト
			List<Person> ps = csv.GetList();//17時参加者リスト
			List<String> info = csv.GetInfo("A");//特記事項(A)リスト
			String now = new Timestamp(System.currentTimeMillis()).toString();//取得時間
			/*Aチーム出力開始*/
		    System.out.println("Aチーム");
		    System.out.print("参加できない");
		    csv.ViewNameN("A");//参加できない人リスト
		    System.out.print("参加できる");
		    csv.ViewName("A");//参加できる人リスト
			for(int i = 0; i < classes.length; i++) {
				System.out.print(classes[i] + ":");
				for(Person p : ps) {
					if(!p.GetTeam().equals("A")) continue;	
					p.ViewArkyAndRendo(classes[i]);	
				 }
				System.out.println();		
			}
			
			//20時以降出力(使わないときはコメントアウト推奨)
			
			
			/*System.out.println("20:00～ ");
			csv.ViewName20("A");
			for(int i = 0; i < classes.length; i++) {
				System.out.print(classes[i] + ":");
				for(Person p : ps20) {
					if(!p.GetTeam().equals("A")) continue;	
					p.ViewArkyAndRendo(classes[i]);	
				 }
				System.out.println();		
			}*/
			
			
			System.out.println("特記事項");
			for(int i = 0; i< info.size(); i++) {
				System.out.println(info.get(i));
			}
			System.out.println(now + "時点");			
			/*Aチーム出力終了*/
			
			/*Bチーム出力開始*/
			System.out.println("Bチーム");
			System.out.print("参加できない");
			
		    csv.ViewNameN("B");//参加できない人リスト
			info = csv.GetInfo("B");
			System.out.print("参加できる");
			csv.ViewName("B");//参加できる人リスト
			for(int i = 0; i < classes.length; i++) {
				System.out.print(classes[i] + ":");
				for(Person p : ps) {
					if(!p.GetTeam().equals("B")) continue;
					p.ViewArkyAndRendo(classes[i]);
					
				 }
				System.out.println();
					
			}
			
			
			//20時以降出力(使わないときはコメントアウト推奨)
			
			
			/*System.out.print("20:00～ ");
			csv.ViewName20("B");
			for(int i = 0; i < classes.length; i++) {
				System.out.print(classes[i] + ":");
				for(Person p : ps20) {
					if(!p.GetTeam().equals("B")) continue;
					p.ViewArkyAndRendo(classes[i]);
					
				 }
				System.out.println();
					
			}
			*/
						
			
			System.out.println("特記事項");
			for(int i = 0; i< info.size(); i++) {
				System.out.println(info.get(i));
			}
			System.out.println(now + "時点");
			
			/*Bチーム出力終了*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
