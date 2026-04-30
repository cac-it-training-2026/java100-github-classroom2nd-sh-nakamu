package lesson04.challenge15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class Yamanotesen {

	public static void main(String[] args) throws IOException {

		String[] YamanotesenArray = { "東京", "新宿", "新橋", "御徒町", "五反田", "秋葉原", "浜松町",
				"渋谷", "田町", "恵比寿", "有楽町", "目黒", "大崎", "原宿",
				"品川", "目白", "大塚", "上野", "池袋", "日暮里", "西日暮里",
				"駒込", "田端", "高田馬場", "神田", "鴬谷", "代々木", "新大久保",
				"巣鴨", "高輪ゲートウェイ" };

		String[] AnswerArray = new String[YamanotesenArray.length];
		boolean[] stationFlag = new boolean[YamanotesenArray.length];
		boolean gameoutcome = false;
		boolean loopFlag = false;

		System.out.println("※※※ 山手線ゲーム ※※※");
		System.out.println("      ゲームスタート！    ");

		//入力準備
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Random rand = new Random();

		//
		do {
			// プレイヤーに駅名を入力してもらう
			String inputStationName = br.readLine();

			// プレイヤーの入力した駅名がOKかどうかを判定するための繰り返し（駅の総数まで繰り返す）
			for (int i = 0; i < stations.length; i++) {

				// プレイヤーの入力した駅名が配列に含まれていれば
				if (stations[i].equals(inputStationName)) {

					// / その番号の駅が既出でないか判定する
					if (stationFlag[i]) {

						// 正解したという目印にフラグを立てる
						hitFlag = true;

						// この駅名はもう答えましたという意味でfalseに変えておく
						stationFlag[i] = false;

						// 内側のループを抜ける
						break;

						// 入力した駅名が既出であればゲームオーバー
					} else {

						// 内側のループを抜ける
						break;
					}
				}
			}

			// ゲームの実行回数を一つ増やす
			gameCount++;

			// プレイヤーが誤答した場合または全ての駅名が出尽くした場合
			if (!hitFlag || (gameCount == stations.length)) {

				// 外側のループを抜けて終了処理へ
				break;
			}

			// フラグをクリアしておく
			hitFlag = false;

			// コンピュータが回答するための繰り返し（正解するまで繰り返す）
			while (!hitFlag) {

				// 総駅数の範囲で乱数を取得
				int num = rand.nextInt(stations.length);

				// その番号の駅が既出でないか判定する
				if (stationFlag[num]) {

					// 既出でなければ駅名を出力する
					System.out.println(stations[num]);

					// この駅名はもう答えましたという意味でfalseに変えておく
					stationFlag[num] = false;

					// 正解したという目印にフラグを立てる
					hitFlag = true;
				}
			}

			// ゲームの実行回数を一つ増やす
			gameCount++;

			// フラグをクリアしておく
			hitFlag = false;

			// 駅名が出尽くした場合ループを抜ける
		} while (gameCount != stations.length);

		// 駅名が出尽くしていればプレイヤーの勝ち、そうでなければ負け
		if (gameCount == stations.length) {
			System.out.println("あなたの勝ちです！");
		} else {
			System.out.println("あなたの負けです！");
		}
	}

}
