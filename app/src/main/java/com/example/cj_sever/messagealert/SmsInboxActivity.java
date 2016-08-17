package com.example.cj_sever.messagealert;

import android.app.ListActivity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class SmsInboxActivity extends AppCompatActivity {
    private ListView listView;
    private Adapter adapter;
    private Cursor c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.smsList);

        List<smsData> smsList = new ArrayList<smsData>();

        Uri uri = Uri.parse("content://sms/inbox");
         c= getContentResolver().query(uri, null, null ,null,null);
        startManagingCursor(c);

        // Read the sms data and store it in the list
        if(c.moveToFirst()) {
            for(int i=0; i < c.getCount(); i++) {
                smsData sms = new smsData();
                sms.setSmsBody(c.getString(c.getColumnIndexOrThrow("body")).toString());
                sms.setSenderNo(c.getString(c.getColumnIndexOrThrow("address")).toString());
                smsList.add(sms);

                c.moveToNext();
            }
        }


        // Set smsList in the ListAdapter
        adapter = new Adapter(this,smsList);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }

    @Override
    protected void onStop() {
        super.onStop();

    }
}



