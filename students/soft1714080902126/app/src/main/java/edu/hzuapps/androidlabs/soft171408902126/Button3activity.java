package edu.hzuapps.androidlabs.soft171408902126;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Button3activity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    private void initFruits() {
        for (int i = 0; i < 2; i++) {
            Fruit cd1 = new Fruit("鱼香肉丝  45元/份", R.drawable.cd1);
            fruitList.add(cd1);
            Fruit cd2 = new Fruit("宫保鸡丁  60元/份", R.drawable.cd2);
            fruitList.add(cd2);
            Fruit cd3 = new Fruit("水煮鱼    60元/份", R.drawable.cd3);
            fruitList.add(cd3);
            Fruit cd4 = new Fruit("水煮肉片  40元/份", R.drawable.cd4);
            fruitList.add(cd4);
            Fruit cd5 = new Fruit("回锅肉    30元/份", R.drawable.cd4);
            fruitList.add(cd5);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.button3);
        initFruits();//初始化水果列表
        RecyclerView recyclerView = findViewById(R.id.recycler_view);//创建RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //使用一个线性布局管理器
        recyclerView.setLayoutManager(layoutManager);
        //为RecyclerView添加线性布局管理器

        //设置RecyclerView的适配器
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);
    }
}
