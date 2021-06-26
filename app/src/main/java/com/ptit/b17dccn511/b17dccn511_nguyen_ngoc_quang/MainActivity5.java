package com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.helpper.SQLHelper;
import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model3_B17DCCN511;
import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model4_B17DCCN511;

import java.util.List;

public class MainActivity5 extends AppCompatActivity {
    private ListView listView;
    private SQLHelper sqlHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        listView=findViewById(R.id.recycler_a5);
        sqlHelper=new SQLHelper(this);
        List<Model4_B17DCCN511> list=sqlHelper.thongke1();
        ArrayAdapter<Model4_B17DCCN511> adapter=new ArrayAdapter<Model4_B17DCCN511>(this,R.layout.activity_listview,R.id.textView,
                list);
        listView.setAdapter(adapter);
    }
}