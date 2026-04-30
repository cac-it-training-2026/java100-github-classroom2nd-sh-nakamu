/**
 * 第7章 武士のお仕事
 *
 * 問題10  抽象クラス
 *
 * 抽象クラス、抽象メソッドを作る。
 *
 * 侍クラスのwork()メソッドを抽象化してください。
 *
 * <実行例>
 * 侍は働きます。
 *
 * 具体的に言うと藩士は年貢を取り立てます。
 *
 * 藩士1：
 * 年貢を取り立てるよ～。
 *
 * 具体的に言うと浪人は傘張りをします。
 *
 * 浪人1：
 * 傘張るよ～。
 *
 */

package lesson07.challenge10;

//ここにSamuraiクラスを記述
abstract class Samurai {

	protected String name;

	public abstract void work();

	void fight() {
		System.out.println("戦うよ～。");
	}
}

//ここにRetainerクラスを記述
class Retainer extends Samurai {
	protected String domain;

	public Retainer() {
	}

	public Retainer(String name, String domain) {
		super();
		this.name = name;
		this.domain = domain;
		System.out.println("拙者は" + this.domain + this.name + "ともうす。");
	}

	public String toString() {
		return this.name;
	}

	public void equals(Retainer retainer) {
		boolean isChecked = this.domain.equals(retainer.domain);
		if (isChecked) {
			System.out.println("【同じ藩に所属しています】");
		} else {
			System.out.println("【同じ藩に所属していません】");
		}
	}

	public void work() {
		System.out.println("年貢を取り立てるよ～。");
	}
}

//ここにRoninクラスを記述
class Ronin extends Samurai {

	public Ronin() {
	}

	void covered() {
		System.out.println("傘張りするよ～。");
	}

	public void work() {
		System.out.println("傘張るよ～。");
	}
}

public class CastleTown {

	public static void main(String[] args) {
		System.out.println("侍は働きます。");

		System.out.println("\n具体的に言うと藩士は年貢を取り立てます。\n");

		System.out.println("藩士1：");

		//ここに適切な処理を記述
		Retainer retainer = new Retainer();
		retainer.work();

		System.out.println("\n具体的に言うと浪人は傘張りをします。\n");

		System.out.println("浪人1：");

		//ここに適切な処理を記述
		Ronin ronin = new Ronin();
		ronin.work();

	}
}
