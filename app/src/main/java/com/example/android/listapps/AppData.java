package com.example.android.listapps;

import android.graphics.drawable.Drawable;

/**
 * {@link AppData} represents data related to an installed app in android device
 * Each object has 4 properties: app name, package name, image resource ID, and checkbox status info
 */


public class AppData {
	
	// Name of the APP
	private String mAppName;
	
	// Name of the application package
	private String mPackageName;
	
	// Application icon
	private Drawable mAppIcon;
	
	// Checkbox value (true or false)
	private boolean mIsChecked;
	
	/**
	 * Create a new AppData object
	 * @param appName is the name of app
	 * @param packageName is the package name of the app
	 * @param appIcon is drawable object that corresponds to icon of the app
	 * @param isChecked is the boolean value for the checkbox that corresponds to the app
	 */
	
	public AppData(String appName, String packageName, Drawable appIcon, boolean isChecked)
	{
		mAppName = appName;
		mPackageName = packageName;
		mAppIcon = appIcon;
		mIsChecked = isChecked;
		
	}
	
	/**
	 * Set the app name
	 * @param mAppName
	 */
	public void setAppName(String mAppName) {
		this.mAppName = mAppName;
	}
	
	/**
	 * Set the package name
	 * @param mPackageName
	 */
	public void setPackageName(String mPackageName) {
		this.mPackageName = mPackageName;
	}
	
	/**
	 * Set the drawable reference ID for corresponding icon of the app
	 * @param mAppIconId
	 */
	public void setAppIconId(Drawable mAppIconId) {
		this.mAppIcon = mAppIconId;
	}
	
	/**
	 * Set the boolean value for the checkbox
	 * @param mIsChecked
	 */
	public void setSelected(boolean mIsChecked) {
		this.mIsChecked = mIsChecked;
	}
	
	/**
	 * Get the app name
	 * @return a string that corresponds to the app name
	 */
	public String getAppName() {
		return mAppName;
	}
	
	/**
	 * Get the package name of the app
	 * @return a string that corresponds to the package name
	 */
	public String getPackageName() {
		return mPackageName;
	}
	
	/**
	 * Get the drawable reference ID for the app icon
	 * @return
	 */
	
	public Drawable getAppIconId() {
		return mAppIcon;
	}
	
	/**
	 * Get the boolean value from the checkbox
	 * @return boolean value (true or false)
	 */
	public boolean getSelected() {
		return mIsChecked;
	}
}
