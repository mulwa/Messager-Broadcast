package com.example.cj_sever.messagealert;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by cj-sever on 8/16/16.
 */
public class Adapter extends ArrayAdapter<smsData> {
    // List context
    private final Context context;
    // List values
    private final List<smsData> smsList;
    private LayoutInflater inflater;


    public Adapter(Context context,List<smsData> smsList) {
        super(context,R.layout.custom_layout,smsList);
        this.context = context;
        this.smsList = smsList;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.custom_layout,parent,false);

            final ViewHolder viewHolder = new ViewHolder();
//            viewHolder.imageView = (ImageView) convertView.findViewById(R.id.thumbnail);
            viewHolder.callerId = (TextView) convertView.findViewById(R.id.callerNo);
            viewHolder.smsBody = (TextView) convertView.findViewById(R.id.message);

            //assign values
            viewHolder.callerId.setText(smsList.get(position).getSenderNo());
            viewHolder.smsBody.setText(smsList.get(position).getSmsBody());
//            viewHolder.imageView.setImageResource(g);

        }
        return convertView;
    }
    public  class ViewHolder{
//        private ImageView imageView;
        private TextView callerId;
        private TextView smsBody;

    }
}
