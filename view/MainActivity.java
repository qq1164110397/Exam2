package com.example.exam2.view;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.exam2.R;
import com.example.exam2.beans.ListBean;
import com.example.exam2.concate.Concate;
import com.example.exam2.net.INetCallBack;
import com.example.exam2.presrent.MainPresrent;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Concate.IMainModel {


    private RecyclerView rlv;
    private ArrayList<ListBean.NewsBean> list;
    private MainPresrent mainPresrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initp();
    }

    private void initp() {
        mainPresrent = new MainPresrent(this);
        mainPresrent.getData();
    }

    private void initView() {
        rlv = (RecyclerView) findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(this));
        list = new ArrayList<>();

    }

    @Override
    public <T> void getLoginData(String url, INetCallBack<T> callBack) {

    }
}