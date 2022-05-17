package com.example.lab6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragA.FragAListener, FragB.FragBListener {
	Menu menu2;

	public void applySeekBar(int seekBarProgress) {
		FragB fragB;
		fragB = (FragB) getSupportFragmentManager().findFragmentByTag("FRAGB");
		fragB.displayRes(seekBarProgress);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		FragB fragB = (FragB) getSupportFragmentManager().findFragmentByTag("FRAGB");

		if ((getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE)){
			if (fragB != null) {
				getSupportFragmentManager().beginTransaction()
						.show(fragB)
						.commit();
			}
			else {
				getSupportFragmentManager().beginTransaction()
						.add(R.id.fragContainer, FragB.class,null, "FRAGB")
						.commit();
			}
			menu2.getItem(0).setVisible(true);
			getSupportFragmentManager().executePendingTransactions();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.menu, menu);
		menu2 = menu;
		menu2.getItem(0).setVisible(false);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(@NonNull MenuItem item) {
		switch (item.getItemId())
		{
			case R.id.exit:
				exitDialog exitDiag = new exitDialog();
				exitDiag.show(getSupportFragmentManager(), "exit Dialog");
				break;

			case R.id.setting:
				settingDialog exampleD = new settingDialog();
				exampleD.show(getSupportFragmentManager(), "example dialog");
				break;
		}
		return super.onOptionsItemSelected(item);
	}

	public void exitApp() {
		finish();
		System.exit(0);
	}

	@Override
	public void OnClickEvent(float input1, float input2, int flag) {
		FragB fragB;

		if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
		{
			getSupportFragmentManager().beginTransaction()
					.setReorderingAllowed(true)
					.add(R.id.fragContainer, FragB.class, null,"FRAGB")
					.addToBackStack("BBB")
					.commit();
			getSupportFragmentManager().executePendingTransactions();
			menu2.getItem(0).setVisible(true);
		}

		float res;
		char op;
		switch (flag) {
			case 1:
				res = input1 + input2;
				op = '+';
				break;
			case 2:
				res = input1 - input2;
				op = '-';
				break;
			case 3:
				res = input1 * input2;
				op = '*';
				break;
			case 4:
				res = input1 / input2;
				op = '/';
				break;
			default:
				throw new IllegalStateException("Unexpected value: " + flag);
		}
		fragB = (FragB) getSupportFragmentManager().findFragmentByTag("FRAGB");
		fragB.display(input1, input2, op, res);
	}
}
