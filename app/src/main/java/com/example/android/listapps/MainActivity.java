package com.example.android.listapps;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
	
	private static final String LOG_TAG = MainActivity.class.getSimpleName();
	
	private ListView listView;
	private TextView text_allapp;
	private Drawable icon;
	private Button btnselect, btndeselect, btngetallapp;
	private ArrayList<AppData> appsData;
	private AppDataAdapter appAdapter;
	
	// Create an ArrayList of Appdata objects
	//ArrayList<AppData> appsData = new ArrayList<AppData>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// initialise layout
		// Get a reference to the ListView
		listView = findViewById(R.id.listview);
		text_allapp = findViewById(R.id.totalapp);
		btnselect = (Button) findViewById(R.id.select);
		btndeselect = (Button) findViewById(R.id.deselect);
		btngetallapp = (Button) findViewById(R.id.getallapp);
		
		appsData = new ArrayList<>();

		
		btngetallapp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				// Return PackageManager instance to find global package information.
				final PackageManager pm = getPackageManager();
				//get a list of installed apps.
				List<ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);
				
				text_allapp.setText(packages.size() + " Apps are installed");
				
				for (ApplicationInfo packageInfo : packages) {
					
					icon = packageInfo.loadIcon(getPackageManager());
					appsData.add(new AppData(packageInfo.loadLabel(getPackageManager()).toString(),
									packageInfo.packageName, icon, false));
				}
				
				// Create an AppDataAdapter, whose data source is a list of AppData
				AppDataAdapter appAdapter = new AppDataAdapter(MainActivity.this, appsData);
				
				// Attach the adapter to the listView.
				listView.setAdapter(appAdapter);
			}
		});
		
		btnselect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				for (int i = 0; i < appsData.size(); i++){
					appsData.get(i).setSelected(true);
				}
				appAdapter = new AppDataAdapter(MainActivity.this,appsData);
				listView.setAdapter(appAdapter);
			}
		});
		btndeselect.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				for (int i = 0; i < appsData.size(); i++){
					appsData.get(i).setSelected(false);
				}
				appAdapter = new AppDataAdapter(MainActivity.this,appsData);
				listView.setAdapter(appAdapter);
			}
		});
		
		
		
		
		
		
	}

	
}
