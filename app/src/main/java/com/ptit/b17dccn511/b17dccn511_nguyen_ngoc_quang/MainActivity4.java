package com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.helpper.SQLHelper;
import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model3_B17DCCN511;
import com.ptit.b17dccn511.b17dccn511_nguyen_ngoc_quang.model.Model4_B17DCCN511;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MainActivity4 extends AppCompatActivity {
      Spinner spinner1;;
      Spinner spinner2;
    private Button btnAdd;
    private SQLHelper sqlHelper;
    private ListView listView;
    List<Model3_B17DCCN511> list1;
    ArrayAdapter<Model4_B17DCCN511> adapter;
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        sqlHelper = new SQLHelper(this);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        listView=findViewById(R.id.recycler_a4);
        btnAdd =findViewById(R.id.btn_add_a4);

        list1= sqlHelper.getAll();
        ArrayAdapter<Model3_B17DCCN511> adapter1 = new ArrayAdapter<Model3_B17DCCN511>(this, android.R.layout.simple_list_item_1,
                list1);
        adapter1.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Model3_B17DCCN511 model= list1.get(position);
                loadData(model);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        List<Model4_B17DCCN511> list2 =  sqlHelper.getAll2();
        ArrayAdapter<Model4_B17DCCN511> adapter2 = new ArrayAdapter<Model4_B17DCCN511>(this,android.R.layout.simple_list_item_1,
                list2);
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        spinner2.setAdapter(adapter2);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Model3_B17DCCN511 model1= (Model3_B17DCCN511) spinner1.getSelectedItem();
                Model4_B17DCCN511 model2= (Model4_B17DCCN511) spinner2.getSelectedItem();
                sqlHelper.themModelBroker(model2,model1);
                loadData(model1);
            }
        });

    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void loadData(Model3_B17DCCN511 model){
        List<Model4_B17DCCN511> data = sqlHelper.getData(model);
        if(!Objects.isNull(adapter)){
            adapter.clear();
        }
        adapter=new ArrayAdapter<Model4_B17DCCN511>(this,R.layout.activity_listview,R.id.textView,
                data);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}