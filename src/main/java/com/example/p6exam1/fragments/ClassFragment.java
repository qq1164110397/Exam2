package com.example.p6exam1.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.p6exam1.R;
import com.example.p6exam1.adapters.RlvAdapter2;
import com.example.p6exam1.beans.ClassBean;
import com.example.p6exam1.beans.NavBean;
import com.example.p6exam1.concate.Concate;
import com.example.p6exam1.presenter.MainPresenterimp3;

import java.util.ArrayList;

public class ClassFragment extends Fragment implements Concate.MainView3 {

    private RecyclerView rlv;
    private ArrayList<ClassBean.StudenlistBean> classlist;
    private RlvAdapter2 rlvAdapter2;
    private MainPresenterimp3 mainPresenterimp3;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.rlv_item1, null);
        rlv = view.findViewById(R.id.rlv);
        rlv.setLayoutManager(new LinearLayoutManager(getActivity()));
        classlist = new ArrayList<>();
        rlvAdapter2 = new RlvAdapter2(classlist,getActivity());
        rlv.setAdapter(rlvAdapter2);

        mainPresenterimp3 = new MainPresenterimp3(this);
        mainPresenterimp3.getData();
        return view;
    }

    @Override
    public void OnScuress3(ClassBean classBean) {
        classlist.addAll(classBean.getStudenlist());
        rlvAdapter2.notifyDataSetChanged();
    }

    @Override
    public void OnFail3(String error) {
        Log.i("TAG", "网络错误: "+error);
    }
}
