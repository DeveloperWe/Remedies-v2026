package com.app.eunice.remedies;

import android.app.Activity;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by eunice on 5/30/16.
 */
public class CustomList extends ArrayAdapter<String> {
    private String[] names;
    private String[] desc;
    private Integer[] imageid;
    private Activity context;
    private Typeface tf;

    public CustomList(Activity context, String[] names, String[] desc, Integer[] imageid){
        super(context, com.app.eunice.remedies.R.layout.list, names);
        this.context = context;
        this.names = names;
        this. desc = desc;
        this.imageid = imageid;
        this.tf = Typeface.createFromAsset(context.getAssets(), "Strawberry Muffins.ttf");
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View listViewItem = inflater.inflate(com.app.eunice.remedies.R.layout.list, null, true);
        TextView textViewName = (TextView) listViewItem.findViewById(com.app.eunice.remedies.R.id.textViewName);
        textViewName.setTypeface(tf);
        TextView textViewDesc = (TextView) listViewItem.findViewById(com.app.eunice.remedies.R.id.textViewDesc);
        textViewDesc.setTypeface(tf);
        ImageView image = (ImageView) listViewItem.findViewById(com.app.eunice.remedies.R.id.imageView);

        textViewName.setText(names[position]);
        textViewDesc.setText(desc[position]);
        image.setImageResource(imageid[position]);
        return listViewItem;
    }



}
