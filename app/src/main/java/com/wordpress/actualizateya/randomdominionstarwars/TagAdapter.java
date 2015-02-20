package com.wordpress.actualizateya.randomdominionstarwars;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

class Tag {
	
	String name;
	boolean selected = false;
	
	public Tag(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
}

class PlanetAdapter extends ArrayAdapter<Tag>{

	private List<Tag> planetList;
	private Context context;
	
	public PlanetAdapter(List<Tag> planetList, Context context) {
		super(context, R.layout.row_tag, planetList);
		this.planetList = planetList;
		this.context = context;
	}

	private static class PlanetHolder {
		public TextView planetName;
		public CheckBox chkBox;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
	
		View v = convertView;
		
		PlanetHolder holder = new PlanetHolder();
		
		if(convertView == null) {
			
			LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = inflater.inflate(R.layout.row_tag, null);
			
			holder.planetName = (TextView) v.findViewById(R.id.label);
			holder.chkBox = (CheckBox) v.findViewById(R.id.check);
			
			//holder.chkBox.setOnCheckedChangeListener((MainActivity) context);
			
		} else {
			holder = (PlanetHolder) v.getTag();
		}
		
		Tag t = planetList.get(position);
		holder.planetName.setText(t.getName());
		holder.chkBox.setChecked(t.isSelected());
		holder.chkBox.setTag(t);
		
		return v;
	}
}
