package com.wordpress.actualizateya.randomdominionstarwars.Cards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.wordpress.actualizateya.randomdominionstarwars.R;

import java.util.ArrayList;

public class CardListAdapter extends BaseAdapter {
    private ArrayList<Card> listData;
    private LayoutInflater layoutInflater;

    public CardListAdapter(Context context, ArrayList<Card> listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listview_item, null);
            holder = new ViewHolder();
            holder.nombre = (TextView) convertView.findViewById(R.id.tvField);
            holder.imagen = (ImageView) convertView.findViewById(R.id.image);
            holder.imagen_money = (ImageView) convertView.findViewById(R.id.imgAnimal2);
            convertView.setTag(holder);

        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Card newsItem = listData.get(position);
        holder.nombre.setText(newsItem.getTitle());
        holder.imagen_money.setImageResource(newsItem.getDrawableImageIDcost());
        if (holder.imagen!= null) {
            new ImageDownloaderTask(holder.imagen).execute(newsItem.getDrawableImageID());
        }

        return convertView;
    }

    static class ViewHolder {
        ImageView imagen;
        TextView nombre;
        ImageView imagen_money;
    }
}
