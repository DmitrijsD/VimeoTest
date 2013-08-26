package com.example.vimeotest;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebSettings.PluginState;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	private final String TAG = "MainActivity";
	private WebView mWebView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mWebView = (WebView) findViewById(R.id.WebView);
		//Auto playing vimeo videos in Android webview
		mWebView.getSettings().setJavaScriptEnabled(true);
		mWebView.getSettings().setAppCacheEnabled(true);
		mWebView.getSettings().setDomStorageEnabled(true);
		mWebView.getSettings().setPluginState(PluginState.ON);
		mWebView.getSettings().setAllowFileAccess(true);
		
		mWebView.setWebChromeClient(new MyWebChromeClient());
		mWebView.setWebViewClient(new WebViewClient(){
	        @Override
	        public boolean shouldOverrideUrlLoading(WebView view, String url) {
	            return false;
	        }
	        @Override
	        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
	        	Log.e(TAG,"Error. Msg: "+description);
	          }
	    });
//		mWebView.loadUrl("http://player.vimeo.com/video/24577973?player_id=player&autoplay=1&title=0&byline=0&portrait=0&api=1&maxheight=480&maxwidth=800");
//		mWebView.loadUrl("file:///android_asset/simple.html");
		mWebView.loadUrl("file:///android_asset/1_0.html");
//		mWebView.loadUrl("http://192.168.1.4:9090/1_0.html");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		if(item.getItemId() == R.id.reload){
			mWebView.destroyDrawingCache();
			Log.d(TAG,"Reloading..");
			mWebView.reload();
		}
		return super.onMenuItemSelected(featureId, item);
	}

	
}
