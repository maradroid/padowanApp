package com.padowan.app.activites.pager.add_remove_replace_pager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.padowan.app.R;
import com.padowan.app.activites.pager.fragment.FragmentA;
import com.padowan.app.activites.pager.fragment.FragmentB;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class PagerActivity extends AppCompatActivity {

    public static  final String TAG_KEY_PAGER = "key1";

    FragmentA fA ;
    FragmentB fB ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);
        ButterKnife.bind(this);


        fA = new FragmentA();
        fB = new FragmentB();
    }

    @OnClick(R.id.button_add_a)
    public void onAddA(){
        if(getSupportFragmentManager().findFragmentByTag(FragmentA.TAG) == null)
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_containter, fA, FragmentA.TAG).commit();
    }

    @OnClick(R.id.button_add_b)
    public void onAddB(){
        if(getSupportFragmentManager().findFragmentByTag(FragmentB.TAG) == null)
        getSupportFragmentManager().beginTransaction().add(R.id.fragment_containter, fB, FragmentB.TAG).commit();
    }

    @OnClick(R.id.button_replace_a)
    public void onReplaceA(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter, fA, FragmentA.TAG).commit();
    }

    @OnClick(R.id.button_replace_b)
    public void onReplaceB(){
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_containter, fB, FragmentB.TAG).commit();
    }

    @OnClick(R.id.button_remove_a)
    public void onRemoveA(){
        getSupportFragmentManager().beginTransaction().remove(fA).commit();
    }

    @OnClick(R.id.button_remove_b)
    public void onRemoveB(){
        getSupportFragmentManager().beginTransaction().remove(fB).commit();
    }
}
