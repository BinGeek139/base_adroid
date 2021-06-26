package com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.helpper.SQLHelper;
import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model3_B17DCCN511;
import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model4_B17DCCN511;

import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    private ListView listView;
    private Button btnAdd;
    private EditText editText1,editText2,editText3,editText4;
    private List<Model4_B17DCCN511> list;
    private SQLHelper sqlHelper;
    ArrayAdapter<Model4_B17DCCN511> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
        sqlHelper=new SQLHelper(this);
        list=sqlHelper.getAll2();
        adapter=new ArrayAdapter<Model4_B17DCCN511>(this,R.layout.activity_listview,R.id.textView,
                list);
        listView.setAdapter(adapter);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();
                String text3 = editText3.getText().toString();
                String text4 = editText4.getText().toString();

                Model4_B17DCCN511 model=new Model4_B17DCCN511(text1,text2,text3,text4);
                sqlHelper.themModel4(model);
                adapter.add(model);
            }
        });
    }
    private void init(){
        editText1=findViewById(R.id.a3_edit1);
        editText2=findViewById(R.id.a3_edit2);
        editText3=findViewById(R.id.a3_edit3);
        editText4=findViewById(R.id.a3_edit4);
        listView=findViewById(R.id.recycler_a3);
        btnAdd=findViewById(R.id.btn_add_a3);
    }
}