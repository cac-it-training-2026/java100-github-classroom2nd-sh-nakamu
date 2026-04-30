/**
 * 第7章 武士のお仕事
 *
 * 問題13 インターフェース②
 *
 * 文化人インターフェースを作る。
 *
 * 抽象メソッドlearn()を持つ文化人インターフェースICelebrityを
 * 作成し、藩士クラスと浪人クラスにそれぞれ実装し、<実行例>と
 * 同じメッセージを表示してください。
 *
 * <実行例>
 * 藩士1：
 * 茶道を嗜むよ～。
 *
 * 浪人1：
 * 塾を開くよ～。
 *
 *
 */

package lesson07.challenge13;

//ここにICelebrityインターフェースを記述
interface ICelebrity {
	void learn();
}

//ここにSamuraiクラスを記述
abstract class Samurai {

	protected String name;

	public abstract void work();

	void fight() {
		System.out.println("戦うよ～。");
	}
}

//ここにRetainerクラスを記述
class Retainer extends Samurai implements ICelebrity {
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

	public void learn() {
		System.out.println("茶道を嗜むよ～。");
	}
}

//ここにRoninクラスを記述
class Ronin extends Samurai implements ICelebrity {

	public Ronin() {
	}

	void covered() {
		System.out.println("傘張りするよ～。");
	}

	public void work() {
		System.out.println("傘張るよ～。");
	}

	public void learn() {
		System.out.println("塾を開くよ～。");
	}
}

public class CastleTown {

	public static void main(String[] args) {
		System.out.println("藩士1：");

		//ここに適切な処理を記述
		Retainer retainer = new Retainer();
		retainer.learn();

		System.out.println("\n浪人1：");

		//ここに適切な処理を記述
		Ronin ronin = new Ronin();
		ronin.learn();
	}
}
