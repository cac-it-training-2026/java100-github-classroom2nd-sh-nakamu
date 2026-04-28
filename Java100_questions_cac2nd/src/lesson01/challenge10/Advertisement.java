package lesson01.challenge10;

public class Advertisement {

	public static void main(String[] args) {
		//変数の初期化
		String message = "アルバイト・パート募集！！";
		String time = "１０：００～１８：００";
		int wage = 1250;
		String treatment = "社割 店内商品10%引き！！";

		//募集要項の表示
		System.out.println(message);
		System.out.println("勤務時間\t・・・" + time);
		System.out.println("時給\t\t・・・" + wage + "円");
		System.out.println("待遇\t\t・・・" + treatment);

	}

}
