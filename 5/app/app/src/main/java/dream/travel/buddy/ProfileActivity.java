package dream.travel.buddy;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.*;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import java.util.HashMap;
import android.widget.ScrollView;
import android.widget.LinearLayout;
import android.widget.Button;
import de.hdodenhof.circleimageview.*;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.EditText;
import android.app.Activity;
import android.content.SharedPreferences;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ChildEventListener;
import android.content.Intent;
import android.content.ClipData;
import com.google.firebase.storage.FileDownloadTask;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.OnProgressListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Continuation;
import android.net.Uri;
import java.io.File;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Timer;
import java.util.TimerTask;
import android.view.View;
import com.bumptech.glide.Glide;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.DialogFragment;
import androidx.core.content.ContextCompat;
import androidx.core.app.ActivityCompat;
import android.Manifest;
import android.content.pm.PackageManager;


public class ProfileActivity extends  AppCompatActivity  { 
	
	public final int REQ_CD_F = 101;
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	private FirebaseStorage _firebase_storage = FirebaseStorage.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String path = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String photo = "";
	private String name = "";
	
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout linear49;
	private LinearLayout linear14;
	private LinearLayout linear5;
	private LinearLayout linear22;
	private Button button1;
	private CircleImageView circleimageview1;
	private LinearLayout linear50;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private ImageView imageview1;
	private TextView textview12;
	private ImageView imageview2;
	private TextView textview13;
	private TextView textview5;
	private EditText edittext_n;
	private LinearLayout linear6;
	private LinearLayout linear7;
	private TextView textview2;
	private TextView textview11;
	private LinearLayout linear30;
	private LinearLayout linear31;
	private TextView textview10;
	private EditText edittext_address;
	
	private SharedPreferences user;
	private DatabaseReference db = _firebase.getReference("dbbb");
	private ChildEventListener _db_child_listener;
	private Intent f = new Intent(Intent.ACTION_GET_CONTENT);
	private StorageReference str = _firebase_storage.getReference("str");
	private OnCompleteListener<Uri> _str_upload_success_listener;
	private OnSuccessListener<FileDownloadTask.TaskSnapshot> _str_download_success_listener;
	private OnSuccessListener _str_delete_success_listener;
	private OnProgressListener _str_upload_progress_listener;
	private OnProgressListener _str_download_progress_listener;
	private OnFailureListener _str_failure_listener;
	private Calendar c = Calendar.getInstance();
	private TimerTask t;
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.profile);
		initialize(_savedInstanceState);
		com.google.firebase.FirebaseApp.initializeApp(this);
		if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED
		|| ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {
			ActivityCompat.requestPermissions(this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1000);
		}
		else {
			initializeLogic();
		}
	}
	@Override
	public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
		super.onRequestPermissionsResult(requestCode, permissions, grantResults);
		if (requestCode == 1000) {
			initializeLogic();
		}
	}
	
	private void initialize(Bundle _savedInstanceState) {
		
		_app_bar = (AppBarLayout) findViewById(R.id._app_bar);
		_coordinator = (CoordinatorLayout) findViewById(R.id._coordinator);
		_toolbar = (Toolbar) findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		vscroll1 = (ScrollView) findViewById(R.id.vscroll1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		linear49 = (LinearLayout) findViewById(R.id.linear49);
		linear14 = (LinearLayout) findViewById(R.id.linear14);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		linear22 = (LinearLayout) findViewById(R.id.linear22);
		button1 = (Button) findViewById(R.id.button1);
		circleimageview1 = (CircleImageView) findViewById(R.id.circleimageview1);
		linear50 = (LinearLayout) findViewById(R.id.linear50);
		linear15 = (LinearLayout) findViewById(R.id.linear15);
		linear16 = (LinearLayout) findViewById(R.id.linear16);
		linear51 = (LinearLayout) findViewById(R.id.linear51);
		linear52 = (LinearLayout) findViewById(R.id.linear52);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview12 = (TextView) findViewById(R.id.textview12);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		textview13 = (TextView) findViewById(R.id.textview13);
		textview5 = (TextView) findViewById(R.id.textview5);
		edittext_n = (EditText) findViewById(R.id.edittext_n);
		linear6 = (LinearLayout) findViewById(R.id.linear6);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview2 = (TextView) findViewById(R.id.textview2);
		textview11 = (TextView) findViewById(R.id.textview11);
		linear30 = (LinearLayout) findViewById(R.id.linear30);
		linear31 = (LinearLayout) findViewById(R.id.linear31);
		textview10 = (TextView) findViewById(R.id.textview10);
		edittext_address = (EditText) findViewById(R.id.edittext_address);
		user = getSharedPreferences("user", Activity.MODE_PRIVATE);
		f.setType("image/*");
		f.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (circleimageview1.getAlpha() == 1) {
					map.put("Address", edittext_address.getText().toString());
					map.put("Name", edittext_n.getText().toString());
					map.put("photo", photo);
					db.child("profile").updateChildren(map);
					user.edit().putString("Address", edittext_address.getText().toString()).commit();
					user.edit().putString("photo", photo).commit();
					user.edit().putString("Name", edittext_n.getText().toString()).commit();
					SketchwareUtil.showMessage(getApplicationContext(), "Profile Updated Successfully");
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Profile Image Is Uploading Please Wait");
				}
			}
		});
		
		circleimageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				c = Calendar.getInstance();
				startActivityForResult(f, REQ_CD_F);
				name = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss").format(c.getTime());
			}
		});
		
		_db_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		db.addChildEventListener(_db_child_listener);
		
		_str_upload_progress_listener = new OnProgressListener<UploadTask.TaskSnapshot>() {
			@Override
			public void onProgress(UploadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_str_download_progress_listener = new OnProgressListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onProgress(FileDownloadTask.TaskSnapshot _param1) {
				double _progressValue = (100.0 * _param1.getBytesTransferred()) / _param1.getTotalByteCount();
				
			}
		};
		
		_str_upload_success_listener = new OnCompleteListener<Uri>() {
			@Override
			public void onComplete(Task<Uri> _param1) {
				final String _downloadUrl = _param1.getResult().toString();
				photo = _downloadUrl;
				circleimageview1.setAlpha((float)(1));
			}
		};
		
		_str_download_success_listener = new OnSuccessListener<FileDownloadTask.TaskSnapshot>() {
			@Override
			public void onSuccess(FileDownloadTask.TaskSnapshot _param1) {
				final long _totalByteCount = _param1.getTotalByteCount();
				
			}
		};
		
		_str_delete_success_listener = new OnSuccessListener() {
			@Override
			public void onSuccess(Object _param1) {
				
			}
		};
		
		_str_failure_listener = new OnFailureListener() {
			@Override
			public void onFailure(Exception _param1) {
				final String _message = _param1.getMessage();
				
			}
		};
	}
	
	private void initializeLogic() {
		edittext_address.setText(user.getString("Address", ""));
		edittext_n.setText(user.getString("Name", ""));
		textview11.setText(user.getString("Email", ""));
		Glide.with(getApplicationContext()).load(Uri.parse(user.getString("photo", ""))).into(circleimageview1);
		db.removeEventListener(_db_child_listener);
		
		path = "data/users/".concat(user.getString("Email", "").replace("@", "").replace(".", "").replace("-", ""));
		
		db = _firebase.getReference(path);
		db.addChildEventListener(_db_child_listener);
		photo = user.getString("photo", "");
		edittext_address.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFFF5F5F5));
		edittext_n.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFFF5F5F5));
		textview11.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)90, (int)0, Color.TRANSPARENT, 0xFFF5F5F5));
		linear51.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, Color.TRANSPARENT, 0xFF673AB7));
		linear52.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)20, (int)0, Color.TRANSPARENT, 0xFF673AB7));
		linear51.setElevation((float)30);
		linear52.setElevation((float)30);
		if (user.getString("events", "").equals("")) {
			textview12.setText("0 ".concat(" Events"));
		}
		else {
			textview12.setText(user.getString("events", "").concat(" Events"));
		}
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		
		super.onActivityResult(_requestCode, _resultCode, _data);
		
		switch (_requestCode) {
			case REQ_CD_F:
			if (_resultCode == Activity.RESULT_OK) {
				ArrayList<String> _filePath = new ArrayList<>();
				if (_data != null) {
					if (_data.getClipData() != null) {
						for (int _index = 0; _index < _data.getClipData().getItemCount(); _index++) {
							ClipData.Item _item = _data.getClipData().getItemAt(_index);
							_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _item.getUri()));
						}
					}
					else {
						_filePath.add(FileUtil.convertUriToFilePath(getApplicationContext(), _data.getData()));
					}
				}
				FileUtil.copyFile(_filePath.get((int)(0)), FileUtil.getExternalStorageDir().concat("/Travel Buddy/tmp.img"));
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								circleimageview1.setImageBitmap(FileUtil.decodeSampleBitmapFromPath(FileUtil.getExternalStorageDir().concat("/Travel Buddy/tmp.img"), 1024, 1024));
								circleimageview1.setAlpha((float)(0.5d));
								str.child(name).putFile(Uri.fromFile(new File(FileUtil.getExternalStorageDir().concat("/Travel Buddy/tmp.img")))).addOnFailureListener(_str_failure_listener).addOnProgressListener(_str_upload_progress_listener).continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
									@Override
									public Task<Uri> then(Task<UploadTask.TaskSnapshot> task) throws Exception {
										return str.child(name).getDownloadUrl();
									}}).addOnCompleteListener(_str_upload_success_listener);
							}
						});
					}
				};
				_timer.schedule(t, (int)(1000));
			}
			else {
				
			}
			break;
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