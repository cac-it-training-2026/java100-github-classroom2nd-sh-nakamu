/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題7 10分割して販売する
 *
 * マカロンが大きすぎて売上が芳しくないので
 * 1個のマカロンを10分割して0.1個から販売することにします。
 * (値段も0.1倍～)
 * ただし合計金額と在庫は小数を切り捨て、
 * 常に整数で表示します。
 *
 * 問題6の答えを改変し、以下の実行例を参考に処理を記述してください。
 *
 * <実行例>
 *
 * ～～～～～～～～～省略～～～～～～～～～～～
 *
 * それぞれ何個ずつ買いますか？（最大30個まで）
 *
 * シトロン      >5
 * ショコラ      >1.5
 * ピスターシュ  >2.5
 *
 * シトロン     5.0個
 * ショコラ     1.5個
 * ピスターシュ 2.5個
 *
 * 合計個数    9.0個
 * 合計金額   2470円
 *
 * をお買いあげですね。
 * 承りました。
 *
 * 本日のおすすめ商品です。
 *
 * シトロン      \250 ・・・ 残り25個
 * ショコラ      \280 ・・・ 残り28個
 * ピスターシュ  \320 ・・・ 残り27個
 *
 */

package lesson01.challenge07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Patisserie {

	public static void main(String[] args) throws IOException {
		//在庫を表す変数を初期化
		int stock_citron = 30;
		int stock_chocolate = 30;
		int stock_p = 30;

		//各商品の金額と在庫数を表示
		System.out.println("本日のおすすめ商品です。\n");
		System.out.println("シトロン　　　\\250 ・・・ 残り" + stock_citron + "個");
		System.out.println("ショコラ　　　\\280 ・・・ 残り" + stock_chocolate + "個");
		System.out.println("ピスターシュ　\\320 ・・・ 残り" + stock_p + "個");

		//購入個数の確認と入力準備
		System.out.println("それぞれ何個ずつ買いますか？（最大30個まで）\n");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		//表品名を表示・入力された購入個数をdouble型の変数として代入
		System.out.print("シトロン		>");
		String input_citron = reader.readLine();
		double num_citron = Double.parseDouble(input_citron);

		//シトロンと同様
		System.out.print("ショコラ		>");
		String input_chocolate = reader.readLine();
		double num_chocolate = Double.parseDouble(input_chocolate);

		//シトロンと同様
		System.out.print("ピスターシュ	>");
		String input_p = reader.readLine();
		double num_p = Double.parseDouble(input_p);

		//各種の購入個数を表示
		System.out.println("シトロン		>" + num_citron + "個");
		System.out.println("ショコラ		>" + num_chocolate + "個");
		System.out.println("ピスターシュ	>" + num_p + "個\n");

		//合計の購入個数をdouble型の変数sumに代入
		double sum = num_citron + num_chocolate + num_p;

		//合計金額を計算した後、double型からint型へ型変換し代入
		int total_amount = (int) (num_citron * 250 + num_chocolate * 280 + num_p * 320);

		//合計個数と合計金額を表示
		System.out.println("合計個数\t" + sum + "個");
		System.out.println("合計金額\t" + total_amount + "円\n");

		//文字を表示
		System.out.println("をお買い上げですね");
		System.out.println("承りました");

		//在庫数から購入個数を引いた後、int型へ型変換し代入
		stock_citron = (int) (stock_citron - num_citron);
		stock_chocolate = (int) (stock_chocolate - num_chocolate);
		stock_p = (int) (stock_p - num_p);

		//各商品と更新した在庫数を表示
		System.out.println("本日のおすすめ商品です");
		System.out.println("シトロン　　　\\250 ・・・ 残り" + stock_citron + "個");
		System.out.println("ショコラ　　　\\280 ・・・ 残り" + stock_chocolate + "個");
		System.out.println("ピスターシュ　\\320 ・・・ 残り" + stock_p + "個");
	}

}
