package com.example.android.listapps;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AppDataAdapter extends BaseAdapter {
	
	private static final String LOG_TAG = AppDataAdapter.class.getSimpleName();
	private Context context;
	public static ArrayList<AppData> appsData;
	
	/**
	 * This is our own custom constructor (it doesn't mirror a superclass constructor).
	 * The context is used to inflate the layout file, and the list is the data we want
	 * to populate into the lists.
	 *  @param context        The current context. Used to inflate the layout file.
	 * @param appsData A List of AndroidFlavor objects to display in a list*/
	public AppDataAdapter (Context context, ArrayList<AppData> appsData) {
		this.context = context;
		this.appsData = appsData;
	}
	
	@Override
	public int getViewTypeCount() {
		return getCount();
	}
	@Override
	public int getItemViewType(int position) {
		
		return position;
	}
	
	@Override
	public int getCount() {
		return appsData.size();
	}
	
	@Override
	public Object getItem(int position) {
		return appsData.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return 0;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		final ViewHolder holder;
		
		if (convertView == null) {
			holder = new ViewHolder();
			LayoutInflater inflater = (LayoutInflater) context
							.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			convertView = inflater.inflate(R.layout.list_item, null, true);
			
			holder.checkBox = (CheckBox) convertView.findViewById(R.id.checkBox);
			holder.tvAppName = (TextView) convertView.findViewById(R.id.app_name);
			holder.tvPackageName = (TextView) convertView.findViewById(R.id.package_name);
			holder.iconView = (ImageView) convertView.findViewById(R.id.list_item_icon);
			
			convertView.setTag(holder);
		}else {
			// the getTag returns the viewHolder object set as a tag to the view
			holder = (ViewHolder)convertView.getTag();
		}
		
		
		//holder.checkBox.setText(position);
		holder.checkBox.setChecked(appsData.get(position).getSelected());
		holder.tvAppName.setText(appsData.get(position).getAppName());
		holder.tvPackageName.setText(appsData.get(position).getPackageName());
		holder.iconView.setImageDrawable(appsData.get(position).getAppIconId());
		
		
		//holder.checkBox.setTag(R.integer.btnplusview, convertView);
		holder.checkBox.setTag( position);
		holder.checkBox.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				
				//View tempview = (View) holder.checkBox.getTag(R.integer.btnplusview);
				//TextView tv = (TextView) tempview.findViewById(R.id.app_name);
				Integer pos = (Integer)  holder.checkBox.getTag();
				//Toast.makeText(context, "Checkbox "+pos+" clicked!", Toast.LENGTH_SHORT).show();
				
				if(appsData.get(pos).getSelected()){
					appsData.get(pos).setSelected(false);
				}else {
					appsData.get(pos).setSelected(true);
				}
				
			}
		});
		
		return convertView;
	}
	
	private class ViewHolder {
		
		protected CheckBox checkBox;
		private TextView tvAppName;
		private TextView tvPackageName;
		private ImageView iconView;
		
	}
	
	
	
	
}
