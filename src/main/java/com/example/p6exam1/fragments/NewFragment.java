package com.example.p6exam1.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p6exam1.R;
import com.example.p6exam1.adapters.RlvAdapter;
import com.example.p6exam1.beans.NavBean;
import com.example.p6exam1.concate.Concate;
import com.example.p6exam1.presenter.MainPresenterimp2;

import java.util.ArrayList;

public class NewFragment extends Fragment implements Concate.MainView2 {

    private RecyclerView rlv;
    private ArrayList<NavBean.NewsBean> navlist;
    private RlvAdapter rlvAdapter;
    private MainPresenterimp2 mainPresenterimp2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.rlv_item1, null);
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        navlist = new ArrayList<>();
        rlvAdapter = new RlvAdapter(navlist,getActivity());
        rlv.setAdapter(rlvAdapter);

        mainPresenterimp2 = new MainPresenterimp2(this);
        mainPresenterimp2.getData();
        return view;
    }


    @Override
    public void OnScuress2(NavBean navBean) {
        navlist.addAll(navBean.getNews());
        rlvAdapter.notifyDataSetChanged();
    }

    @Override
    public void OnFail2(String error) {

    }
}
