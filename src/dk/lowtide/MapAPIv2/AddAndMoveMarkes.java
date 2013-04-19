package dk.lowtide.MapAPIv2;


import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class AddAndMoveMarkes extends FragmentActivity{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_and_move_markes);
		
		//get map
		SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		final GoogleMap map = mapFrag.getMap();

		map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
		
		//add maplisteners
		map.setOnMapClickListener(new OnMapClickListener() {
			
			@Override
			public void onMapClick(LatLng point) {
				map.addMarker(new MarkerOptions().position(point).draggable(true));	
			}
		});

		// show a dialog to set title on the marker
		map.setOnMarkerClickListener(new OnMarkerClickListener() {
			
			@Override
			public boolean onMarkerClick(Marker marker) {
				MyCustomDialog dialog = new MyCustomDialog();
				dialog.setMarker(marker);
				dialog.show(getSupportFragmentManager(), "CustomDialog");
				return false;
			}
		});
	
		// drag marker to new position
		map.setOnMarkerDragListener(new OnMarkerDragListener() {
			
			@Override
			public void onMarkerDragStart(Marker marker) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onMarkerDragEnd(Marker marker) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onMarkerDrag(Marker marker) {
				// TODO Auto-generated method stub
				marker.showInfoWindow();
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_and_move_markes, menu);
		return true;
	}

}
