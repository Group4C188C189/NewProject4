package com.my.newproject4;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.graphics.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.text.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.view.View;

public class MainActivity extends Activity {
	
	
	private LinearLayout linear3;
	private TextView textview2;
	private EditText username_login;
	private EditText password_login;
	private Button login_btn;
	private TextView register_page;
	
	private Intent intent = new Intent();

	// yun unique name ng sharedpreferences ay file
	private SharedPreferences file;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		textview2 = (TextView) findViewById(R.id.textview2);
		username_login = (EditText) findViewById(R.id.username_login);
		password_login = (EditText) findViewById(R.id.password_login);
		login_btn = (Button) findViewById(R.id.login_btn);
		register_page = (TextView) findViewById(R.id.register_page);


		file = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		login_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (username_login.getText().toString().equals(file.getString("username", ""))) {
					if (password_login.getText().toString().equals(file.getString("password", ""))) {
						intent.setClass(getApplicationContext(), LogginginActivity.class);
						startActivity(intent);
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "Invalid Username or Password");
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Invalid Username or Password");
				}
			}
		});
		
		register_page.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), RegisterActivity.class);
				startActivity(intent);
			}
		});
	}
	private void initializeLogic() {
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input){
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels(){
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels(){
		return getResources().getDisplayMetrics().heightPixels;
	}
	
}
