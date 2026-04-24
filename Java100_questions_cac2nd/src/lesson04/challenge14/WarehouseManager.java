/**
 * 第4章 倉庫番のお仕事
 *
 * 問題14 各部対抗ブロックじゃんけん
 *
 * 今日はXO商事の年に一度の恒例行事、各部対抗ブロックじゃんけんの日です。
 * Yさんは東北支社のSさんと対戦することになっています。
 * ブロックじゃんけんのルールは下記の通りです。
 *
 * 1...5箱からなるコンテナを用意する。
 * 2...各箱にはグーブロック、チョキブロック、パーブロックのどれかを入れる。
 * 3...ただし上記三つのブロックの使用は、それぞれ2個までとする。
 * 4...対戦者は互いにオープンするブロックを決め、出たブロックでジャンケン勝負。
 * 5...4を5回繰り返し、勝ちが多かった方を最終的な勝者とする。
 *
 * コメントの位置に適切なコードを記述し、
 * 実行例と同じメッセージを表示してください。
 *
 * <実行例>
 *  Yさん：
 *  よし、今日はがんばるぞ！
 *
 *  コンテナ1に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞3
 *
 *  コンテナ2に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞2
 *
 *  コンテナ3に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞2
 *
 *  コンテナ4に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞1
 *
 *  コンテナ5に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞3
 *
 *  1回戦
 *  Yさん：
 *  どの手を出そうかな～
 *
 *  Sさん：
 *  はやぐ決めれ！腹減ってしゃねてば
 *
 *  オープンするコンテナを決めてください＞2
 *
 *  Yさん：
 *  よし、2番コンテナだ！
 *
 *  Sさん：
 *  こっちは3番コンテナだべ！
 *
 *  審判：
 *  ではオープンしてみましょう。
 *
 *  審判：
 *  Yさん：チョキ VS Sさん：パー
 *  で、Yさんの勝ちです。
 *
 *  Yさん：
 *  やった勝ちだ！
 *
 *  Sさん：
 *  あー、もうやんだぐなっできた...
 *
 *  ～～～～～～～～ 中略 ～～～～～～～～～
 *
 *  審判：
 *  対戦終了です。 結果は...
 *
 *  審判：
 *  Yさん：2勝1敗2分け
 *  Sさん：1勝2敗2分け
 *  で、Yさんの勝利です。
 *
 *  Yさん：
 *  まあ、そうなるよね。
 *
 *  Sさん：
 *  こっだなことがあっでいいんだべか！
 *
 * <1対戦ごとのじゃんけんでYさんが負けた場合の実行例>
 *  Yさん：
 *  次は勝つぞ！
 *
 *  Sさん：
 *  負けるわけねべ！
 *
 * <1対戦ごとのじゃんけんで引き分けた場合の実行例>
 *  Yさん：
 *  おしいな～
 *
 *  Sさん：
 *  実質おらの勝ちだべ。
 *
 * <最終判定でYさんが負けた場合の実行例>
 *  Yさん：
 *  負けちゃった。悔しいな～
 *
 *  Sさん：
 *  弱い者に勝っても、な～んも自慢になんねな。
 *
 * <最終判定で引き分けた場合の実行例>
 *  Yさん：
 *  ふ～。なんとか引き分けたか。
 *
 *  Sさん：
 *  次はたんげがんばるはんで、応援してけれな。
 *
 * <グーチョキパー以外の数値が入力された場合の実行例>
 *  Yさん：
 *  え～。そんな手ないよ。
 *
 *  コンテナ○に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞
 *
 * <その手が既に2回使用されていた場合の実行例>
 *  Yさん：
 *  ○○はもう使えません。(※○○にはグー、チョキ、パーの何れかが入る)
 *
 *  コンテナ○に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞
 *
 * <既にオープンしたコンテナが入力された場合の実行例>*
 *  Yさん：
 *  そのコンテナはもうオープンしちゃったよ。
 *
 * <存在しないコンテナが入力された場合の実行例>*
 *  Yさん：
 *  え～。そんなコンテナないよ。
 *
 */

package lesson04.challenge14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WarehouseManager {

	public static void main(String[] args) throws IOException {

		String[] handArray = { "グー", "チョキ", "パー" };
		int winPoint = 0;
		int losePoint = 0;
		int drawPoint = 0;

		int stoneCount1 = 0;
		int stoneCount2 = 0;
		int scissorsCount1 = 0;
		int scissorsCount2 = 0;
		int paperCount1 = 0;
		int paperCount2 = 0;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		System.out.println("Yさん：");
		System.out.println("よし、今日はがんばるぞ！");
		int[] jankenArray1 = new int[5];
		int[] jankenArray2 = new int[5];

		//Yさんのコンテナにじゃんけんの手を入れる処理を記述する。
		for (int i = 0; i < jankenArray1.length; i++) {
			System.out.println("コンテナ" + (i + 1) + "に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞");

			String inputHandString = br.readLine();
			int inputHand = Integer.parseInt(inputHandString);
			boolean loopFlag = false;

			//グーが3回以上入れないように条件分岐
			if ((inputHand == 1) && (stoneCount1 == 0)) {
				jankenArray1[i] = inputHand;
				++stoneCount1;
			} else if ((inputHand == 1) && (stoneCount1 == 1)) {
				jankenArray1[i] = inputHand;
				++stoneCount1;
				++stoneCount2;
			} else if ((inputHand == 1) && (stoneCount2 == 1)) {
				//グー以外選ぶまでループ
				do {
					System.out.println("Yさん：");
					System.out.println(handArray[inputHand - 1] + "はもう使えません。");

					System.out.println("コンテナ" + (i + 1) + "に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞");
					inputHandString = br.readLine();
					inputHand = Integer.parseInt(inputHandString);
					if (inputHand == 1) {
						loopFlag = true;
					} else {
						jankenArray1[i] = inputHand;
						loopFlag = false;
					}
				} while (loopFlag);
			}

			//チョキが3回以上入れないように条件分岐
			if ((inputHand == 2) && (scissorsCount1 == 0)) {
				jankenArray1[i] = inputHand;
				++scissorsCount1;
			} else if ((inputHand == 2) && (scissorsCount1 == 1)) {
				jankenArray1[i] = inputHand;
				++scissorsCount1;
				++scissorsCount2;
			} else if ((inputHand == 2) && (scissorsCount2 == 1)) {
				//チョキ以外選ぶまでループ
				do {
					System.out.println("Yさん：");
					System.out.println(handArray[inputHand - 1] + "はもう使えません。");

					System.out.println("コンテナ" + (i + 1) + "に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞");
					inputHandString = br.readLine();
					inputHand = Integer.parseInt(inputHandString);
					if (inputHand == 2) {
						loopFlag = true;
					} else {
						jankenArray1[i] = inputHand;
						loopFlag = false;
					}
				} while (loopFlag);
			}

			//パーが3回以上入れないように条件分岐
			if ((inputHand == 3) && (paperCount1 == 0)) {
				jankenArray1[i] = inputHand;
				++paperCount1;
			} else if ((inputHand == 3) && (paperCount1 == 1)) {
				jankenArray1[i] = inputHand;
				++paperCount1;
				++paperCount2;
			} else if ((inputHand == 3) && (paperCount2 == 1)) {
				//パー以外選ぶまでループ
				do {
					System.out.println("Yさん：");
					System.out.println(handArray[inputHand - 1] + "はもう使えません。");

					System.out.println("コンテナ" + (i + 1) + "に入れるブロックを選択してください（1.グー、2.チョキ、3.パー）＞");
					inputHandString = br.readLine();
					inputHand = Integer.parseInt(inputHandString);
					if (inputHand == 3) {
						loopFlag = true;
					} else {
						jankenArray1[i] = inputHand;
						loopFlag = false;
					}
				} while (loopFlag);
			}
		}

		//Sさんのコンテナにじゃんけんの手を入れる処理を記述する。（ランダム）
		stoneCount1 = 0;
		stoneCount2 = 0;
		scissorsCount1 = 0;
		scissorsCount2 = 0;
		paperCount1 = 0;
		paperCount2 = 0;
		boolean loopFlag = false;

		for (int i = 0; i < jankenArray2.length; i++) {
			int hand = (int) (Math.random() * 10 / 3 + 1);
			loopFlag = false;

			if ((hand == 1) && (stoneCount1 == 0)) {
				jankenArray1[i] = hand;
				++stoneCount1;
			} else if ((hand == 1) && (stoneCount1 == 1)) {
				jankenArray1[i] = hand;
				++stoneCount1;
				++stoneCount2;
			} else if ((hand == 1) && (stoneCount2 == 1)) {
				//グー以外選ぶまでループ
				do {
					if (hand == 1) {
						loopFlag = true;
					} else {
						jankenArray1[i] = hand;
						loopFlag = false;
					}
				} while (loopFlag);
			}

			//チョキが3回以上入れないように条件分岐
			if ((hand == 2) && (scissorsCount1 == 0)) {
				jankenArray1[i] = hand;
				++scissorsCount1;
			} else if ((hand == 2) && (scissorsCount1 == 1)) {
				jankenArray1[i] = hand;
				++scissorsCount1;
				++scissorsCount2;
			} else if ((hand == 2) && (scissorsCount2 == 1)) {
				//チョキ以外選ぶまでループ
				do {
					if (hand == 2) {
						loopFlag = true;
					} else {
						jankenArray1[i] = hand;
						loopFlag = false;
					}
				} while (loopFlag);
			}

			//パーが3回以上入れないように条件分岐
			if ((hand == 3) && (paperCount1 == 0)) {
				jankenArray1[i] = hand;
				++paperCount1;
			} else if ((hand == 3) && (paperCount1 == 1)) {
				jankenArray1[i] = hand;
				++paperCount1;
				++paperCount2;
			} else if ((hand == 3) && (paperCount2 == 1)) {
				//パー以外選ぶまでループ
				do {
					if (hand == 3) {
						loopFlag = true;
					} else {
						jankenArray1[i] = hand;
						loopFlag = false;
					}
				} while (loopFlag);
			}
		}

		//出した手を管理する配列

		for (int count = 0; count < 5; count++) {

			System.out.println("\nYさん：");
			System.out.println("どの手を出そうかな～\n");

			System.out.println("Sさん：");
			System.out.println("はやぐ決めれ！腹減ってしゃねてば\n");

			int openNum1 = 0;

			//Yさんのどのコンテナをオープンするか入力してもらう処理を記述する。
			do {
				loopFlag = false;
				System.out.print("オープンするコンテナを決めてください＞");
				String openNumStr = br.readLine();
				openNum1 = Integer.parseInt(openNumStr) - 1;
				if (openNum1 < 0 || openNum1 > 4) {
					System.out.println("\nYさん：");
					System.out.println("え～。そんなコンテナないよ。\n");
					loopFlag = true;
				} else if (jankenArray1[openNum1] == 0) {
					System.out.println("\nYさん：");
					System.out.println("そのコンテナはもうオープンしちゃったよ。\n");
					loopFlag = true;
				}
			} while (loopFlag);

			int openNum2 = 0;
			do {
				loopFlag = false;
				openNum2 = (int) (Math.random() * 10) % 5;
				if (jankenArray2[openNum2] == 0) {
					loopFlag = true;
				}
			} while (loopFlag);

			//Sさんのどのコンテナをオープンするか決定する処理を記述する。（ランダム）
			openNum2 = (int) (Math.random() * 10 / 5);

			System.out.println("\nYさん：");
			System.out.println("よし、" + (openNum1 + 1) + "番コンテナだ！\n");

			System.out.println("Sさん：");
			System.out.println("こっちは" + (openNum2 + 1) + "番コンテナだべ！\n");

			System.out.println("審判：");
			System.out.println("ではオープンしてみましょう。\n");

			System.out.println("審判：");
			System.out.print("Yさん：" + handArray[jankenArray1[openNum1] - 1]);
			System.out.print(" VS ");
			System.out.println("Sさん：" + handArray[jankenArray2[openNum2] - 1]);
			System.out.print("で、");

			//1回ごとの勝敗判定およびメッセージの出力処理を記述する。
			if (jankenArray1[openNum1] == jankenArray2[openNum2]) {
				System.out.println("引き分けです。\n");
				System.out.println("Yさん：");
				System.out.println("おしいな～\n");
				System.out.println("Sさん：");
				System.out.println("実質おらの勝ちだべ。\n");
				drawPoint++;
			} else {
				if (jankenArray1[openNum1] == 1) {
					if (jankenArray2[openNum2] == 2) {
						System.out.println("Yさんの勝ちです。\n");
						System.out.println("Yさん：");
						System.out.println("やった勝ちだ！\n");
						System.out.println("Sさん：");
						System.out.println("あー、もうやんだぐなっできた...\n");
						winPoint++;
					} else if (jankenArray2[openNum2] == 3) {
						System.out.println("Sさんの勝ちです。\n");
						System.out.println("Yさん：");
						System.out.println("次は勝つぞ！\n");
						System.out.println("Sさん：");
						System.out.println("負けるわけねべ！\n");
						losePoint++;
					}
				} else if (jankenArray1[openNum1] == 2) {
					if (jankenArray2[openNum2] == 1) {
						System.out.println("Sさんの勝ちです。\n");
						System.out.println("Yさん：");
						System.out.println("次は勝つぞ！\n");
						System.out.println("Sさん：");
						System.out.println("負けるわけねべ！\n");
						losePoint++;
					} else if (jankenArray2[openNum2] == 3) {
						System.out.println("Yさんの勝ちです。\n");
						System.out.println("Yさん：");
						System.out.println("やった勝ちだ！\n");
						System.out.println("Sさん：");
						System.out.println("あー、もうやんだぐなっできた...\n");
						winPoint++;
					}
				} else {
					if (jankenArray2[openNum2] == 1) {
						System.out.println("Yさんの勝ちです。\n");
						System.out.println("Yさん：");
						System.out.println("やった勝ちだ！\n");
						System.out.println("Sさん：");
						System.out.println("あー、もうやんだぐなっできた...\n");
						winPoint++;
					} else if (jankenArray2[openNum2] == 2) {
						System.out.println("Sさんの勝ちです。\n");
						System.out.println("Yさん：");
						System.out.println("次は勝つぞ！\n");
						System.out.println("Sさん：");
						System.out.println("負けるわけねべ！\n");
						losePoint++;
					}
				}
			}
			jankenArray1[openNum1] = 0;
			jankenArray2[openNum2] = 0;
		}

		System.out.println("審判：");
		System.out.println("対戦終了です。 結果は...\n");

		System.out.println("審判：");
		System.out.println("Yさん：" + winPoint + "勝" + losePoint + "敗"
				+ drawPoint + "分け");
		System.out.println("Sさん：" + losePoint + "勝" + winPoint + "敗"
				+ drawPoint + "分け");
		System.out.print("で、");

		if (winPoint > losePoint) {
			System.out.println("Yさんの勝利です。\n");
			System.out.println("Yさん：");
			System.out.println("まあ、そうなるよね。\n");
			System.out.println("Sさん：");
			System.out.println("こっだなことがあっでいいんだべか！\n");
		} else if (winPoint < losePoint) {
			System.out.println("Sさんの勝利です。\n");
			System.out.println("Yさん：");
			System.out.println("負けちゃった。悔しいな～\n");
			System.out.println("Sさん：");
			System.out.println("弱い者に勝っても、な～んも自慢になんねな。\n");
		} else {
			System.out.println("引き分けです。\n");
			System.out.println("Yさん：");
			System.out.println("ふ～。なんとか引き分けたか。\n");
			System.out.println("Sさん：");
			System.out.println("次はたんげがんばるはんで、応援してけれな。\n");
		}
	}
}
