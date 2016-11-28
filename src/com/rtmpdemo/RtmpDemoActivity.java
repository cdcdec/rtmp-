package com.rtmpdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class RtmpDemoActivity extends Activity implements OnClickListener {

	private Button btnVideo;
	private Button btnAudio;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rtmp_activity_main);

		initView();
	}

	private void initView() {
		btnVideo = (Button) findViewById(R.id.btnVideo);
		btnAudio = (Button) findViewById(R.id.btnAudio);
		btnAudio.setOnClickListener(this);
		btnVideo.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id = v.getId();
		switch (id) {
		case R.id.btnVideo:
			Intent intentVideo=RtmpVideoActivity.getNewIntent(this, "rtmp://xxx/myapp/101");
			startActivity(intentVideo);
			break;

		case R.id.btnAudio:
			Intent intentAudio=RtmpAudioActivity.getNewIntent(this, "rtmp://xxx/myapp/101");
			startActivity(intentAudio);
			break;

		default:
			break;
		}
	}

}
