package com.example.lab6;

import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragA.FragAListener, FragB.FragBListener {
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
			getSupportFragmentManager().executePendingTransactions();
		}
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
