package jp.androidapl.touchgame;

import android.R;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		//スコアの保存(仮実装)
		SharedPreferences prefin =getSharedPreferences("pref",MODE_PRIVATE);

		Editor eBestScore = prefin.edit();
		eBestScore.putString("ScoreAtack", "100");
		eBestScore.putString("TimeAtack", "15.5");
		eBestScore.commit();

		//スコアの取り出し
		SharedPreferences prefout =getSharedPreferences("pref",MODE_PRIVATE);
		String sScoATK = prefout.getString("ScoreAtack", "0");
		String sTimATK = prefout.getString("TimeAtack", "99.9");

		//スコアアタック　ベストスコアの表示
		TextView tvMode1 = (TextView) findViewById(R.id.ScoreAtackScore);
		tvMode1.setText(sScoATK);

		//タイムアタック　ベストスコアの表示
		TextView tvMode2 = (TextView) findViewById(R.id.TimeAtackScore);
		tvMode2.setText(sTimATK);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
