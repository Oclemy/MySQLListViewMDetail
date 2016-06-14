package com.tutorials.hp.mysqllistviewmdetail.m_UI;

import android.content.Context;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.tutorials.hp.mysqllistviewmdetail.R;

/**
 * Created by Oclemy on 6/6/2016 for ProgrammingWizards Channel and http://www.camposha.com.
 */
public class PicassoClient {

    public static void downloadImage(Context c,String imagUrl,ImageView img)
    {
        if(imagUrl != null && imagUrl.length()>0)
        {
            Picasso.with(c).load(imagUrl).placeholder(R.drawable.placeholder).into(img);
        }else {
            Picasso.with(c).load(R.drawable.placeholder).into(img);
        }
    }
}
