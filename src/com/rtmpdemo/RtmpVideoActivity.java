package com.rtmpdemo;

import java.io.IOException;
import java.net.SocketException;

import net.ossrs.yasea.SrsCameraView;
import net.ossrs.yasea.SrsEncodeHandler;
import net.ossrs.yasea.SrsPublisher;
import net.ossrs.yasea.SrsRecordHandler;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.TextView;

import com.github.faucamp.simplertmp.RtmpHandler;

public class RtmpVideoActivity extends Activity implements RtmpHandler.RtmpListener,
SrsRecordHandler.SrsRecordListener, SrsEncodeHandler.SrsEncodeListener,OnClickListener{
	/**推流直播**/
	private TextView txtPublish;
	/**切换摄像头**/
	private TextView txtSwCam;
	/**推流**/
	private SrsPublisher mPublisher;
	/**推流直播地址**/
	private  String rtmpUrl;
	
	private static final String RTMP_URL="rtmp_video_url";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		setContentView(R.layout.rtmp_video_activity);
		rtmpUrl=this.getIntent().getStringExtra(RTMP_URL);
		initView();
		init();
	}
	
	private void init(){
       mPublisher.setEncodeHandler(new SrsEncodeHandler(this));
       mPublisher.setRtmpHandler(new RtmpHandler(this));
       mPublisher.setRecordHandler(new SrsRecordHandler(this));
       
       txtPublish.setOnClickListener(this);
       txtSwCam.setOnClickListener(this);
	}
	private void initView(){
		mPublisher = new SrsPublisher((SrsCameraView) findViewById(R.id.mPublisher));
		txtPublish=(TextView) findViewById(R.id.txtPublish);
		txtSwCam=(TextView) findViewById(R.id.txtSwCam);
	}
	
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		int id=v.getId();
		switch (id) {
		case R.id.txtPublish:
			String temp=txtPublish.getText().toString();
			if(temp.equals("开始直播")){
				 mPublisher.setPreviewResolution(1280, 720);
                 mPublisher.setOutputResolution(384, 640);
                 mPublisher.setVideoSmoothMode();
                 mPublisher.startPublish(rtmpUrl);
                 txtPublish.setText("停止直播");
			}else if(temp.equals("停止直播")){
				mPublisher.stopPublish();
				txtPublish.setText("开始直播");
				
			}
			break;
		case R.id.txtSwCam:
			if (Camera.getNumberOfCameras() > 0) {
                mPublisher.switchCameraFace((mPublisher.getCamraId() + 1) % Camera.getNumberOfCameras());
            }
			break;
		default:
			break;
		}
	}
	
	 @Override
	    protected void onDestroy() {
	        super.onDestroy();
	        mPublisher.stopPublish();
	    }
	
	
	public static Intent getNewIntent(Context context,String rtmpUrl){
		Intent intent=new Intent();
		intent.setClass(context, RtmpVideoActivity.class);
		intent.putExtra(RTMP_URL, rtmpUrl);
		return intent;
	}

	@Override
	public void onNetworkWeak() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNetworkResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEncodeIllegalArgumentException(IllegalArgumentException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecordPause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecordResume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecordStarted(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecordFinished(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecordIllegalArgumentException(IllegalArgumentException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRecordIOException(IOException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpConnecting(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpConnected(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpVideoStreaming() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpAudioStreaming() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpStopped() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpDisconnected() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpVideoFpsChanged(double fps) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpVideoBitrateChanged(double bitrate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpAudioBitrateChanged(double bitrate) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpSocketException(SocketException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpIOException(IOException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpIllegalArgumentException(IllegalArgumentException e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onRtmpIllegalStateException(IllegalStateException e) {
		// TODO Auto-generated method stub
		
	}

	

}
