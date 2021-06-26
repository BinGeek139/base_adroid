package com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.helpper.SQLHelper;
import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model3_B17DCCN511;

import java.lang.reflect.Array;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    private ListView listView;
    private Button btnAdd;
    private EditText editText1,editText2,editText3;
    private List<Model3_B17DCCN511> list;
    private SQLHelper sqlHelper;
    ArrayAdapter<Model3_B17DCCN511> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
        sqlHelper=new SQLHelper(this);
        list=sqlHelper.getAll();
        adapter=new ArrayAdapter<Model3_B17DCCN511>(this,R.layout.activity_listview,R.id.textView,
                list);
        listView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();

                Model3_B17DCCN511 model=new Model3_B17DCCN511(text1,text2,text3);
                sqlHelper.themModel3(model);
                adapter.add(model);
            }
        });
    }
    private void init(){
        editText1=findViewById(R.id.a2_edit1);
        editText2=findViewById(R.id.a2_edit2);
        editText3=findViewById(R.id.a2_edit3);
        listView=findViewById(R.id.recycler_a2);
        btnAdd=findViewById(R.id.btn_add);
    }

}