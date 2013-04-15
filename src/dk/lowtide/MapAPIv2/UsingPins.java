package dk.lowtide.MapAPIv2;

import java.util.zip.Inflater;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.Menu;

public class UsingPins extends FragmentActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_using_pins);
		
		SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		GoogleMap map = mapFrag.getMap();
		map.addMarker(new MarkerOptions().position(new LatLng(55.703946,12.537493)).title("Copenhagen School of Design and Technology"));

		map.addMarker(new MarkerOptions().position(new LatLng(52.336924,4.928485)).title("Hogeschool van Amsterdam").);
		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		
		map.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(52.336924,4.928485)));
		map.moveCamera(CameraUpdateFactory.zoomTo(6));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.using_pins, menu);
		return true;
	}

}
