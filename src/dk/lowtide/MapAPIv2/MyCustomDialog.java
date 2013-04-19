package dk.lowtide.MapAPIv2;

import com.google.android.gms.maps.model.Marker;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.widget.EditText;

public class MyCustomDialog extends DialogFragment {

	Marker marker;
	
	public void setMarker(Marker marker) {
		this.marker = marker;
	}
	
	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		final EditText markerName = new EditText(getActivity());
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Add name to marker");
		builder.setPositiveButton("OK", new OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				marker.setTitle(markerName.getText().toString());
				
			}
		});

        builder.setNegativeButton("NO", null);
	   
		builder.setView(markerName);
        
        return builder.create();
	}
}
