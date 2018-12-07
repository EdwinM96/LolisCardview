package com.example.max00.loliscardview.Activities;

import android.app.Fragment;
import android.app.FragmentManager;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;

import com.example.max00.loliscardview.Fragments.TabFragment;
import com.example.max00.loliscardview.R;
import com.example.max00.loliscardview.Adapters.ViewPagerAdapter;
import com.example.max00.loliscardview.Classes.Lolis;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TabFragment.OnFragmentInteractionListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private ArrayList<Lolis> LolisArrayList;
    private ArrayList<Lolis> LolisFavorites;
    private FragmentManager fragmentManager;
    private TabFragment tabFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FillLolis();
        Favorites();
        tabLayout = findViewById(R.id.TabLayoutID);
        viewPager = findViewById(R.id.view_pagerID);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        //anadiendo Fragmentos al adaptador viewpager
        viewPagerAdapter.addFragment(TabFragment.newInstance(LolisArrayList, false),"Lolis");
        viewPagerAdapter.addFragment(TabFragment.newInstance(LolisFavorites, true),"Favourites");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void FillLolis(){
        LolisArrayList = new ArrayList<>();
        LolisArrayList.add(new Lolis("Shiro", R.drawable.shiro,false));
        LolisArrayList.add(new Lolis("Kafuu Chino", R.drawable.chino_kafuu,false));
        LolisArrayList.add(new Lolis("Toujou Koneko", R.drawable.koneko_toujou,false));
        LolisArrayList.add(new Lolis("Aihara Enju", R.drawable.enju_aihara,false));
        LolisArrayList.add(new Lolis("Yoshino", R.drawable.yoshino,false));
        LolisArrayList.add(new Lolis("Takanashi Rikka", R.drawable.takanashi_rikka,false));
        LolisArrayList.add(new Lolis("Tsutsukakushi Tsukiko", R.drawable.tsutsukakushi_tsukiko,false));
        LolisArrayList.add(new Lolis("Aisaka Taiga",R.drawable.taiga_aisaka,false));
        LolisArrayList.add(new Lolis("Oshino Shinobu",R.drawable.shinobu_oshino,false));
    }

    private void Favorites(){
        LolisFavorites = new ArrayList<>();
    }

    @Override
    public void onFragmentInteraction(boolean a, int pos) {
        if(a){
            LolisArrayList.get(pos).setaBoolean(a);
            LolisFavorites.add(LolisArrayList.get(pos));
            viewPagerAdapter.notifyDataSetChanged();
        }
        else if(!a){
            LolisArrayList.get(pos).setaBoolean(a);
            LolisFavorites.remove(pos);
            viewPagerAdapter.notifyDataSetChanged();
        }
    }

/*
    @Override
    public void onClicko(int position, boolean apretado) {
        if(apretado){
            System.out.println("APRETADOSSSSSSSSSSSSSSSSSSSSSSSSSssss");
        }
        else if(!apretado){
            System.out.println("NELLLLLLL PEROOOOOOOOOOOOOO");
        }
    }*/
}
