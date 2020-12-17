package com.example.p6exam1.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.example.p6exam1.R;
import com.example.p6exam1.beans.BannerBean;
import com.example.p6exam1.beans.ClassBean;
import com.example.p6exam1.beans.NavBean;
import com.example.p6exam1.concate.Concate;
import com.example.p6exam1.fragments.ClassFragment;
import com.example.p6exam1.fragments.NewFragment;
import com.example.p6exam1.presenter.MainPresenterimp;
import com.example.p6exam1.presenter.MainPresenterimp2;
import com.example.p6exam1.presenter.MainPresenterimp3;
import com.google.android.material.tabs.TabLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements Concate.MainView {

    private Banner banner;
    private TabLayout tab;
    private ViewPager vp;
    private String[] names = {"学校新闻","班级成绩查询"};
    private VpAdapter adapter;
    private MainPresenterimp mainPresenterimp;
    private ArrayList<BannerBean.BannerlistBean> bannerlist;
    private ArrayList<NavBean.NewsBean> newsBeans;
    private ArrayList<ClassBean.StudenlistBean> studenlistBeans;
    private MainPresenterimp2 mainPresenterimp2;
    private MainPresenterimp3 mainPresenterimp3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
        initBan();
        initVp();
    }

    private void initBan() {
        mainPresenterimp = new MainPresenterimp(this);
        mainPresenterimp.getData();


    }

    private void initVp() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new NewFragment());
        fragments.add(new ClassFragment());

        adapter = new VpAdapter(getSupportFragmentManager(), fragments, names);
        vp.setAdapter(adapter);

        tab.getTabAt(0);
        tab.getTabAt(1);
        tab.setupWithViewPager(vp);
    }

    private void initView() {
        banner = (Banner) findViewById(R.id.banner);
        tab = (TabLayout) findViewById(R.id.tab);
        vp = (ViewPager) findViewById(R.id.vp);

        bannerlist = new ArrayList<>();
        newsBeans = new ArrayList<>();
        studenlistBeans = new ArrayList<>();
    }

    @Override
    public void OnScuress(BannerBean bannerBean) {
        bannerlist.addAll(bannerBean.getBannerlist());
        banner.setImages(bannerlist).setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                BannerBean.BannerlistBean ban = (BannerBean.BannerlistBean) path;
                Glide.with(context).load(ban.getImageurl()).into(imageView);
            }
        }).start();
    }

    @Override
    public void OnFail(String error) {

    }



    private class VpAdapter extends FragmentStatePagerAdapter {

        private ArrayList<Fragment> fragments;
        private String[] names;

        public VpAdapter(@NonNull FragmentManager fm, ArrayList<Fragment> fragments, String[] names) {
            super(fm);
            this.fragments = fragments;
            this.names = names;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return names[position];
        }
    }


}