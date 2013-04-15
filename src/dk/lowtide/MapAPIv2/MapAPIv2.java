package dk.lowtide.MapAPIv2;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.app.Activity;
import android.content.Intent;

public class MapAPIv2 extends FragmentActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_map_apiv2);
	}
	
	//button clicked
	public void nextExample(View view){
		startActivity(new Intent(getApplicationContext(), UsingPins.class));
	}
}
