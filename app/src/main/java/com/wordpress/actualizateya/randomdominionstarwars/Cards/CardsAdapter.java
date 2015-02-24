package com.wordpress.actualizateya.randomdominionstarwars.Cards;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wordpress.actualizateya.randomdominionstarwars.R;

public class CardsAdapter extends ArrayAdapter<Card> {
	private Context context;
	private ArrayList<Card> datos;

	/**
	 * Constructor del Adapter.
	 * 
	 * @param context
	 *            context de la Activity que hace uso del Adapter.
	 * @param datos
	 *            Datos que se desean visualizar en el ListView.
	 */
	public CardsAdapter(Context context, ArrayList<Card> datos) {
		super(context, R.layout.listview_item, datos);
		// Guardamos los par�metros en variables de clase.
		this.context = context;
		this.datos = datos;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// En primer lugar "inflamos" una nueva vista, que ser� la que se
		// mostrar� en la celda del ListView.
		View item = LayoutInflater.from(context).inflate(
				R.layout.listview_item, null);

		// A partir de la vista, recogeremos los controles que contiene para
		// poder manipularlos.
		// Recogemos el ImageView y le asignamos una foto.
		ImageView imagen = (ImageView) item.findViewById(R.id.image);
		imagen.setImageResource(datos.get(position).getDrawableImageID());

		// Recogemos el TextView para mostrar el nombre y establecemos el
		// nombre.
		TextView nombre = (TextView) item.findViewById(R.id.tvField);
		nombre.setText(datos.get(position).getTitle());

        ImageView imagen2 = (ImageView) item.findViewById(R.id.imgAnimal2);
        imagen2.setImageResource(datos.get(position).getDrawableImageIDcost());

		// Devolvemos la vista para que se muestre en el ListView.
		return item;
	}

}
