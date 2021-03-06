package com.example.jstoandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class MainActivity extends Activity {

	WebView webview;
	Button button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		webview = (WebView) findViewById(R.id.webview);
		button  = (Button)findViewById(R.id.button);
		button.setVisibility(View.GONE);
		
		webview.getSettings().setJavaScriptEnabled(true);
		
		webview.loadUrl("file:///android_asset/test.html");
		// 注册baobao和JSInterface的对应关系
		webview.addJavascriptInterface(new JSInterface(), "baobao");
		
	}
	
	// 调用原生方法
	class JSInterface {
		public void callAndroidMethod(int a,int b,String c,boolean d){
			if(d){
				String strMessage = "-"+(a+1)+"-"+(b+1)+"-"+c+"-"+d;
				new AlertDialog.Builder(MainActivity.this).setTitle("title").setMessage(strMessage).show();
			}
		}
	}
}
