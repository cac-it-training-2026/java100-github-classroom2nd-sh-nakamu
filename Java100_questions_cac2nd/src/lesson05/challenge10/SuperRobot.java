package lesson05.challenge10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 野菜の下処理を実行するロボット
 */
public class SuperRobot {
	int energy;
	int water;
	String name;

	public static void main(String[] args) throws IOException {
		System.out.println("野菜の下処理を行います。\n");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("下処理する野菜を入力してください＞");
		String materials = br.readLine();

		System.out.print("切り方を入力してください＞");
		String cutting = br.readLine();

		System.out.print("ゆでる時間を入力してください");
		String boiltimeStr = br.readLine();
		int boiltime = Integer.parseInt(boiltimeStr);

		System.out.print("\n焼き時間を入力してください");
		String baketimeStr = br.readLine();
		int baketime = Integer.parseInt(baketimeStr);

		System.out.println("しばらくお待ちください");

		SuperRobot robot = new SuperRobot();
		robot.vegetableDishes(materials, cutting, boiltime, baketime);

	}

	public void pumpWater() {
		System.out.println("水を" + this.water + "リットルだしました\n");
	}

	public void randomWater() {
		this.water = (int) (Math.random() * 10) % 9 + 1;
	}

	public void setWater(int water) {
		this.water = water;
	}

	public void makeOmlet(int eggNum, int butterNum) {
		int eggused = (int) (eggNum / 2);
		int butterused = (int) (butterNum / 5);
		int numOmlet = Math.min(eggused, butterused);
		System.out.println(numOmlet + "人分のオムレツを作成しました。\n");
	}

	public int getWater() {
		return this.water;
	}

	public String makeEggDishes(int flourNum, int sugerNum, int eggNum, int butterNum) {
		if ((flourNum >= 170) && (sugerNum >= 50) && (eggNum >= 1) && (butterNum >= 80)) {
			return "クッキー";
		} else if ((eggNum >= 2) && (butterNum >= 5)) {
			return "オムレツ";
		} else if (eggNum >= 1) {
			return "ゆで卵";
		} else {
			return null;
		}
	}

	public void cutMaterial(String materials, String cutting) {
		System.out.println(cutting + "で" + materials + "を切りました。");
	}

	public void boilMaterial(String materials, int boiltime) {
		System.out.println(materials + "を" + boiltime + "分間湯掻きました。");
	}

	public void bakeMaterial(String materials, int baketime) {
		System.out.println(materials + "を" + baketime + "分間焼きました。");
	}

	public void plateMaterial() {
		System.out.println("食材を盛り付けました。\n");
	}

	public void vegetableDishes(String materials, String cutting, int boiltime, int baketime) {
		this.cutMaterial(materials, cutting);
		this.boilMaterial(materials, boiltime);
		this.bakeMaterial(materials, baketime);
		this.plateMaterial();
		System.out.println("皿を取り出してください。");
	}

}
