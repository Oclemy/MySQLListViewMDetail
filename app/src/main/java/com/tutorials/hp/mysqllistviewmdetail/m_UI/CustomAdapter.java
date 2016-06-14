package com.tutorials.hp.mysqllistviewmdetail.m_UI;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.tutorials.hp.mysqllistviewmdetail.R;
import com.tutorials.hp.mysqllistviewmdetail.m_DataObject.Spacecraft;
import com.tutorials.hp.mysqllistviewmdetail.m_DetailActivity.DetailActivity;

import java.util.ArrayList;

/**
 * Created by Oclemy on 6/6/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class CustomAdapter extends BaseAdapter {

    Context c;
    ArrayList<Spacecraft> spacecrafts;

    public CustomAdapter(Context c, ArrayList<Spacecraft> spacecrafts) {
        this.c = c;
        this.spacecrafts = spacecrafts;
    }

    @Override
    public int getCount() {
        return spacecrafts.size();
    }

    @Override
    public Object getItem(int position) {
        return spacecrafts.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,parent,false);
        }

        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        ImageView img= (ImageView) convertView.findViewById(R.id.spacecraftImage);

        final Spacecraft s= (Spacecraft) this.getItem(position);

        nameTxt.setText(s.getName());
        PicassoClient.downloadImage(c,s.getImageUrl(),img);

        //ITEM CLICK
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN DETAIL ACTIVITY
                openDetailActivity(s.getName(),s.getPropellant(),s.getDescription(),s.getImageUrl());
            }
        });

        return convertView;
    }

    //OPEN DETAIL ACTIVITY
    private void openDetailActivity(String name,String propellant,String desc,String imageUrl)
    {
        Intent i=new Intent(c, DetailActivity.class);

        //DATA
        i.putExtra("NAME_KEY",name);
        i.putExtra("PROPELLANT_KEY",propellant);
        i.putExtra("DESCRIPTION_KEY",desc);
        i.putExtra("IMAGEURL_KEY",imageUrl);

        c.startActivity(i);

    }
}













