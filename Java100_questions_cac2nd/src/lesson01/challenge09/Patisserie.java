/**
 * 第1章 マカロン屋さんのお仕事
 *
 * 問題9 新商品の開発
 *
 * 翌日から新商品を発売することにしました。
 * 新商品の名前は「三色マカロン」です。
 * シトロン、ショコラ、ピスターシュの３つの味が
 * 1個のマカロンに集約されているのが特徴で、
 * その配合率は前日の売上比で決まり、
 * 価格はマカロン１個あたりの平均売上価格に準じて
 * 自動的に決定されます。（ただし、1の位は切り捨て）
 *
 * 以下の実行例を参考に処理を追記、改変してください。
 *
 * <実行例>
 *
 * ～～～～～～～～～省略～～～～～～～～～～～
 *
 * 閉店時間となりました。
 * またのお越しをお待ちしております。
 *
 * 売上の割合
 * 売上合計      \2470
 *
 * 内訳
 * シトロン      \1250・・・ 50%
 * ショコラ      \420・・・ 17%
 * ピスターシュ  \800・・・ 32%
 *
 * 明日の三色マカロンの配合率が決まりました！
 *
 * シトロンの味    ・・・ 50%
 * ショコラの味    ・・・ 17%
 * ピスターシュの味・・・ 32%
 *
 * が楽しめます！
 *
 * 値段は\270です。
 *
 */

package lesson01.challenge09;

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
		System.out.println("承りました\n");

		//在庫数から購入個数を引いた後、int型へ型変換し代入
		stock_citron = (int) (stock_citron - num_citron);
		stock_chocolate = (int) (stock_chocolate - num_chocolate);
		stock_p = (int) (stock_p - num_p);

		//各商品と更新した在庫数を表示
		System.out.println("本日のおすすめ商品です\n");
		System.out.println("シトロン　　　\\250 ・・・ 残り" + stock_citron + "個");
		System.out.println("ショコラ　　　\\280 ・・・ 残り" + stock_chocolate + "個");
		System.out.println("ピスターシュ　\\320 ・・・ 残り" + stock_p + "個\n");

		//文字を表示
		System.out.println("閉店時間となりました");
		System.out.println("またのお越しをお待ちしております\n");

		//売上の合計金額を表示
		System.out.println("売上の割合");
		System.out.println("売上の合計\t" + "\\" + total_amount + "\n");

		//各商品の売上金額を表す変数を初期化
		int amount_citron = (int) (250 * num_citron);
		int amount_chocolate = (int) (280 * num_chocolate);
		int amount_p = (int) (320 * num_p);

		//各商品の売上割合を表す変数を初期化
		int percentage_citron = (int) (100 * amount_citron / total_amount);
		int percentage_chocolate = (int) (100 * amount_chocolate / total_amount);
		int percentage_p = (int) (100 * amount_p / total_amount);

		//内訳の表示
		System.out.println("内訳");
		System.out.println("シトロン\t\\" + amount_citron + "・・・" + percentage_citron + "%");
		System.out.println("ショコラ\t\\" + amount_chocolate + "・・・" + percentage_chocolate + "%");
		System.out.println("ピスターシュ\t\\" + amount_p + "・・・" + percentage_p + "%");

		System.out.println("明日の三色マカロンの配合率が決まりました!\n");

		//配合率の表示
		System.out.println("シトロンの味\t・・・" + percentage_citron + "%");
		System.out.println("ショコラの味\t・・・" + percentage_chocolate + "%");
		System.out.println("ピスターシュの味・・・" + percentage_p + "%\n");
		System.out.println("が楽しめます!");

		//三色マカロンの金額を表す変数に代入
		int price_triple = (250 * percentage_citron + 280 * percentage_chocolate + 320 * percentage_p) / 100;
		System.out.println("値段は\\" + price_triple + "です");

	}

}
