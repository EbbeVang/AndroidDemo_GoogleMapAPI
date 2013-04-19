package dk.lowtide.MapAPIv2;

import java.util.ArrayList;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMarkerDragListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import android.os.Bundle;
import android.app.Activity;
import android.graphics.Point;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.widget.Toast;

public class MarkersConnectedWithLines extends FragmentActivity implements OnMapClickListener, OnMarkerDragListener {

	private GoogleMap map;
	ArrayList<Marker> markers = new ArrayList<Marker>();
	Polyline polyline;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_markers_connected_with_lines);
		
		//get map
		SupportMapFragment mapFrag = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
		map = mapFrag.getMap();
		
		map.setOnMapClickListener(this);
		map.setOnMarkerDragListener(this);
	
		polyline = map.addPolyline(new PolylineOptions());
	}

	// onMapClickListener
	@Override
	public void onMapClick(LatLng point) {
		Marker marker = map.addMarker(new MarkerOptions().position(point).draggable(true));
		markers.add(marker);
		Toast.makeText(getApplicationContext(), "Number of markers: "+markers.size(), Toast.LENGTH_SHORT).show();
		
		//draw poly line between markers
		ArrayList<LatLng> latlngs = new ArrayList<LatLng>();
		for (Marker m: markers){
			latlngs.add(m.getPosition());
		}
		
		polyline.setPoints(latlngs);
		
		
	}

	@Override
	public void onMarkerDrag(Marker marker) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onMarkerDragEnd(Marker marker) {
		// redraw polyline after moving a marker
		//markers.add(marker);
		ArrayList<LatLng> latlngs = new ArrayList<LatLng>();
		for (Marker m: markers){
			latlngs.add(m.getPosition());
		}
		polyline.setPoints(latlngs);
		
	}

	@Override
	public void onMarkerDragStart(Marker marker) {
		// TODO Auto-generated method stub
		/*
		LatLng position =  marker.getPosition();
		for (LatLng latlng: markerLatLngs){
			if (latlng.equals(position)){
				markerLatLngs.remove(latlng);
				break;
			}
		}
		*/
	}

}
