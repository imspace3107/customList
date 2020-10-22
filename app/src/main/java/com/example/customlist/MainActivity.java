package com.example.customlist;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import java.util.ArrayList;

import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView;
public class MainActivity extends AppCompatActivity {
    ListView lv;
    Button btn;
    Button btn1;
    TextView tx;
    ListViewBaseAdapter datamodals;
    ArrayList<modal> datamodal;
    Integer index_;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.listview);
        btn = (Button) findViewById(R.id.additem);
        btn1 = (Button) findViewById(R.id.updateitem);
        tx = (TextView) findViewById(R.id.editTextTextPersonName);
        datamodal = new ArrayList<modal>();
        datamodal.add(new modal(R.drawable.doraemon, "Hồ Duy Khoa"));
        datamodals = new ListViewBaseAdapter(datamodal,this);
        lv.setAdapter(datamodals);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datamodal.add(new modal(R.drawable.doraemon, tx.getText().toString()));
                datamodals.notifyDataSetChanged();
            }
        });
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView <? > parent, View view, int position, long id)
            {
                Toast.makeText(MainActivity.this, "select update", Toast.LENGTH_SHORT).show();
                index_ = position;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                datamodal.set(new modal(index_, tx.getText().toString()));
                datamodals.notifyDataSetChanged();
            }
        });
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final int which_item = position;
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Xóa")
                        .setMessage("Bạn chắc chắc muốn xóa")
                        .setPositiveButton("có", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                datamodal.remove(which_item);
                                datamodals.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("không",null)
                        .show();
                return true;
            }
        });
    }
}