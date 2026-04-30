/**
 * 第5章 ロボット工場のお仕事
 *
 * 問題8  材料によって作るメニューを変える
 *
 * 引数として渡された食材の分量を計算して
 * 的確な料理を返すメソッドを追加します。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  Rさん：
 *  もうちょっと高度な調理機能が欲しいですね。
 *
 *  G博士：
 *  では材料の分量に応じて作るメニューを変える機能を入れてみようかの。
 *
 *  Rさん：
 *  そんなことが出来るんですか！
 *
 *  G博士：
 *  出来るとも。小麦粉170g、砂糖50g、卵1個、バター80gがそろえばクッキーを作る。
 *
 *  G博士：
 *  クッキーが出来ない場合で、卵2個、バター5gがそろえばオムレツを作る。
 *
 *  G博士：
 *  卵のみの場合はゆで卵を作る。
 *
 *  G博士：
 *  それ以外の場合は何も作らないようにするんじゃ。
 *
 *  Rさん：
 *  それは凄そうですね。完成をお待ちしています。
 *
 *  G博士：
 *  ......出来たぞ！早速動かしてみよう。
 *
 *  小麦粉の量を入力してください（グラム）＞○
 *
 *  砂糖の量を入力してください（グラム）＞○
 *
 *  卵の個数を入力してください＞○
 *
 *  バターの量を入力してください（グラム）＞○
 *
 *  <料理を作成する条件を満たす場合の実行例>
 *  【※調理できる料理】が出来ました。
 *
 *  <料理を作成する条件を満たさない場合の実行例>
 *  何も作れません。
 *
 */

package lesson05.challenge08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//ここに問題7で作成したクラスに次の条件を足したクラスを作成してください。
//メソッド名：makeEggDishes(引数int flourNum, int sugarNum, int eggNum, int butterNum、
//戻り値String、作成できるメニューを戻り値として返す。また、作成できるメニューが無い場合はnull値を返す)
class Robot {
	int energy;
	int water;
	String name;

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
}

public class RobotMaker {

	public static void main(String[] args) throws IOException {

		System.out.println("Rさん：");
		System.out.println("もうちょっと高度な調理機能が欲しいですね。\n");
		System.out.println("G博士：");
		System.out.println("では材料の分量に応じて作るメニューを変える機能を入れてみようかの。\n");
		System.out.println("Rさん：");
		System.out.println("そんなことが出来るんですか！\n");
		System.out.println("G博士：");
		System.out.println("出来るとも。小麦粉170g、砂糖50g、卵1個、バター80gがそろえばクッキーを作る。\n");
		System.out.println("G博士：");
		System.out.println("クッキーが出来ない場合で、卵2個、バター5gがそろえばオムレツを作る。\n");
		System.out.println("G博士：");
		System.out.println("卵のみの場合はゆで卵を作る。\n");
		System.out.println("G博士：");
		System.out.println("それ以外の場合は何も作らないようにするんじゃ。\n");
		System.out.println("Rさん：");
		System.out.println("それは凄そうですね。完成をお待ちしています。\n");
		System.out.println("G博士：");
		System.out.println("......出来たぞ！早速動かしてみよう。\n");

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("小麦粉の量を入力してください（グラム）＞");
		String flourNumStr = br.readLine();
		int flourNum = Integer.parseInt(flourNumStr);

		System.out.print("\n砂糖の量を入力してください（グラム）＞");
		String sugarNumStr = br.readLine();
		int sugarNum = Integer.parseInt(sugarNumStr);

		System.out.print("\n卵の個数を入力してください＞");
		String eggNumStr = br.readLine();
		int eggNum = Integer.parseInt(eggNumStr);

		System.out.print("\nバターの量を入力してください（グラム）＞");
		String butterNumStr = br.readLine();
		int butterNum = Integer.parseInt(butterNumStr);

		//ここでRobotクラスのインスタンスを作り、
		//（インスタンス名はrobot）
		//makeEggDishesを実行する。
		//標準出力でメニューを表示する。

		Robot robot = new Robot();
		String dishes = robot.makeEggDishes(flourNum, sugarNum, eggNum, butterNum);
		if (dishes != null) {
			System.out.println(dishes + "が出来ました。");
		} else {
			System.out.println("何も作れません。");
		}
	}

}
