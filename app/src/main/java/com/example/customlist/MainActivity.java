package com.example.customlist;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.view.View;
import java.util.ArrayList;
import android.widget.Toast;
import android.widget.AdapterView;
public class MainActivity extends AppCompatActivity {
    ListView lv;
    ListViewBaseAdapter datamodals;
    ArrayList<modal> datamodal;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        datamodal = new ArrayList<modal>();
        datamodal.add(new modal(R.drawable.onepice, "One Piece"));
        datamodal.add(new modal(R.drawable.conan, "Conan"));
        datamodal.add(new modal(R.drawable.doraemon, "Doraemon"));
        datamodal.add(new modal(R.drawable.th, "Naruto"));
        datamodal.add(new modal(R.drawable.linhvuthienha, "Linh vũ thiên hạ"));
        datamodal.add(new modal(R.drawable.tucam, "Tự cẩm"));
        datamodals = new ListViewBaseAdapter(datamodal,this);
        lv.setAdapter(datamodals);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <? > parent, View view, int position, long id)
            {
                modal data= datamodal.get(position);
                Toast.makeText(MainActivity.this, data.getLangName() , Toast.LENGTH_SHORT).show();
            }
        });
    }
}