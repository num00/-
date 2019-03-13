package com.bawei.day02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private PullToRefreshListView pull;
    String str = "https://www.apiopen.top/novelApi";
    private ArrayList<Json01.data> list;
    private ListBean listBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pull = findViewById(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        pull.setPullToRefreshOverScrollEnabled(true);
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                WangLuo.dasfw("https://www.apiopen.top/novelApi", new WangLuo.getda() {
                    @Override
                    public void getdaa(String s) {
                        Gson gson = new Gson();
                        Json01 fromJson = gson.fromJson(s, Json01.class);
                        ArrayList<Json01.data> list = fromJson.getData();
                        ListBean listBean = new ListBean(list, MainActivity.this);
                        pull.setAdapter(listBean);
                        pull.onRefreshComplete();


                    }
                });
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                WangLuo.dasfw("https://www.apiopen.top/novelApi", new WangLuo.getda() {
                    @Override
                    public void getdaa(String s) {


                        Gson gson = new Gson();
                        Json01 fromJson = gson.fromJson(s, Json01.class);
                        ArrayList<Json01.data> list2 = fromJson.getData();
                        list.addAll(list2);
                        listBean.notifyDataSetChanged();
                        pull.onRefreshComplete();

                    }
                });
            }
        });

        WangLuo.dasfw("https://www.apiopen.top/novelApi", new WangLuo.getda() {


            @Override
            public void getdaa(String s) {
                Gson gson = new Gson();
                Json01 fromJson = gson.fromJson(s, Json01.class);
                list = fromJson.getData();
                listBean = new ListBean(list, MainActivity.this);
                pull.setAdapter(listBean);
            }
        });
//        WangLuo.getasd("https://www.apiopen.top/novelApi", new WangLuo.getsas() {
//            @Override
//            public void getsa(String s) {
//                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
//                Gson gson = new Gson();
//                Json01 fromJson = gson.fromJson(s, Json01.class);
//                ArrayList<Json01.data> list = fromJson.getData();
//                ListBean listBean = new ListBean(list, MainActivity.this);
//                pull.setAdapter(listBean);
//
//            }
//        });
//
    }
}
