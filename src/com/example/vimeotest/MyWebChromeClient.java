package com.example.vimeotest;

import android.util.Log;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage.QuotaUpdater;
import android.webkit.WebView;

public class MyWebChromeClient extends WebChromeClient {
	private final String TAG = "MyWebChromeClient";
	
	@Override
	public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
//		Log.d(TAG,"> "+consoleMessage.message());
		return super.onConsoleMessage(consoleMessage);
	}
	
	@Override
	public void onReachedMaxAppCacheSize(long requiredStorage, long quota,
			QuotaUpdater quotaUpdater) {
		Log.d(TAG, "onReachedMaxAppCacheSize. requiredStorage: "+requiredStorage+", quota: "+quota);
		super.onReachedMaxAppCacheSize(requiredStorage, quota, quotaUpdater);
	}

	@Override
	public void onHideCustomView() {
		Log.d(TAG, "onHideCustomView");
		super.onHideCustomView();
	}

	@Override
	public boolean onJsBeforeUnload(WebView view, String url, String message,
			JsResult result) {
		Log.d(TAG,"onJsBeforeUnload. Msg: "+message);
		return super.onJsBeforeUnload(view, url, message, result);
	}

	
	
}
