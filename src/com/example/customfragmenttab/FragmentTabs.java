package com.example.customfragmenttab;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.tabbedfragui.R;

public class FragmentTabs extends FragmentActivity {

	private FragmentTabHost mTabHost;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		mTabHost = (FragmentTabHost) findViewById(R.id.dochecktabhost);
		mTabHost.setup(this, getSupportFragmentManager(), android.R.id.tabcontent);

        
        mTabHost.addTab(mTabHost.newTabSpec("simple").setIndicator("Simple"),
        		SimpleFrag.class, null);
        
        mTabHost.addTab(mTabHost.newTabSpec("detailed").setIndicator("Detailed"),
        		DetailedFrag.class, null);
        
        TabWidget widget = mTabHost.getTabWidget();
		for(int i=0; i < widget.getChildCount(); i++){
			//custom indicator's color
			widget.getChildAt(i).setBackgroundResource(R.drawable.apptheme_tab_indicator_holo);
			TextView tv = (TextView) mTabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title);
			tv.setTextColor(Color.BLUE);
		}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
