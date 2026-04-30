/**
 * 第7章 武士のお仕事
 *
 * 問題12 インターフェース①
 *
 * 勘定奉行インターフェースを作る。
 *
 * 抽象メソッドfigure()を持つ勘定奉行インターフェースIChiefTreasurerを
 * 作成し、問題3で作成した奉行クラスMagistrateに実装してください。
 *
 * <実行例>
 * 奉行に勘定奉行を兼ねてもらうことになりました。
 *
 * 奉行1：
 * 藩の資産を計算するよ～。
 *
 */

package lesson07.challenge12;

//ここにIChiefTreasurerインターフェースを記述
interface IChiefTreasurer {
	void figure();
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

//ここにMagistrateクラスを記述
class Magistrate implements IChiefTreasurer {
	void judge() {
		System.out.println("判決を下すよ～。");
	}

	public void figure() {
		System.out.println("藩の資産を計算するよ～。");
	};
}

public class CastleTown {

	public static void main(String[] args) {
		System.out.println("奉行に勘定奉行を兼ねてもらうことになりました。\n");

		System.out.println("奉行1：");

		//ここに適切な処理を記述
		Magistrate magistrate = new Magistrate();
		magistrate.figure();

	}
}
