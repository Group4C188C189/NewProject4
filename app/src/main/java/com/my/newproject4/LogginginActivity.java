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
import android.widget.Button;
import android.content.Intent;
import android.net.Uri;
import android.content.SharedPreferences;
import android.view.View;

public class LogginginActivity extends Activity {
	
	
	private LinearLayout linear1;
	private TextView textview2;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private Button logout_btn;
	private TextView textview3;
	private TextView name_registered;
	private TextView textview4;
	private TextView username_registered;
	private TextView textview5;
	private TextView password_registered;
	
	private Intent intent = new Intent();
	// yun unique name ng sharedpreferences ay file
	private SharedPreferences file;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.loggingin);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		textview2 = (TextView) findViewById(R.id.textview2);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear4 = (LinearLayout) findViewById(R.id.linear4);
		logout_btn = (Button) findViewById(R.id.logout_btn);
		textview3 = (TextView) findViewById(R.id.textview3);
		name_registered = (TextView) findViewById(R.id.name_registered);
		textview4 = (TextView) findViewById(R.id.textview4);
		username_registered = (TextView) findViewById(R.id.username_registered);
		textview5 = (TextView) findViewById(R.id.textview5);
		password_registered = (TextView) findViewById(R.id.password_registered);

		// remember yun unique name ng sharedprefrences ? andito na siya
		// bakit siya andito? kasi dineclare na siya dito para macollect niya yun data at lahat ng data
		// mapupunta kay file
		file = getSharedPreferences("data", Activity.MODE_PRIVATE);
		
		logout_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				intent.setClass(getApplicationContext(), MainActivity.class);
				startActivity(intent);
			}
		});
		
		name_registered.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
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
	
	@Override
	public void onStart() {
		super.onStart();
		name_registered.setText(file.getString("name", ""));
		username_registered.setText(file.getString("username", ""));
		password_registered.setText(file.getString("password", ""));
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
