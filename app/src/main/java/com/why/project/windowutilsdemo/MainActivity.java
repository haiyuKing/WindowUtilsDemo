package com.why.project.windowutilsdemo;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.why.project.windowutilsdemo.utils.WindowUtils;

public class MainActivity extends AppCompatActivity {

	private TextView tv_show;
	private Button btn_switch;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initEvents();
	}

	@Override
	protected void onResume() {
		super.onResume();
		//横竖屏切换的时候也会执行
		initDatas();
	}

	private void initViews() {
		tv_show = (TextView) findViewById(R.id.tv_show);
		btn_switch = (Button) findViewById(R.id.btn_switch);
	}

	private void initDatas() {
		if (WindowUtils.isLandscape(this)) {
			tv_show.setText("当前处于横屏");
		}
		if (WindowUtils.isPortrait(this)) {
			tv_show.setText("当前处于竖屏");
		}
	}

	private void initEvents() {
		btn_switch.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggleFullScreen();
			}
		});
	}

	/**
	 * 全屏切换，点击全屏按钮
	 */
	private void toggleFullScreen() {
		if (WindowUtils.getScreenOrientation(this) == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
			this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		} else {
			this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
		}
	}
}
