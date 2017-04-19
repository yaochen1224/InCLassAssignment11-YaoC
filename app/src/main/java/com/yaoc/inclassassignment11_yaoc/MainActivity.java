package com.yaoc.inclassassignment11_yaoc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyAdapter mAdapter;
    private ArrayList<MathQuiz> mDataset;
    private Random rand;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        rand = new Random();
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.addmenu, menu);

        mDataset = new ArrayList<MathQuiz>();
        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new MyAdapter(mDataset, (TextView) findViewById(R.id.count));
        mRecyclerView.setAdapter(mAdapter);

//        mRecyclerView.addOnItemTouchListener();
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private String[] operators = {"+", "*", "-"};
    public void addQuiz(MenuItem menuItem) {
        int a = getRandomNumber(1, 100);
        int b = getRandomNumber(1, 100);
        int ans = 0;
        int op = getRandomNumber(0, 2);
        if (op == 0) ans = a + b;
        else if (op == 1) ans = a * b;
        else if (op == 2) {
            if (a < b) {
                int c = a; a = b; b = c;
            }
            ans = a - b;
        }
        mDataset.add(new MathQuiz(operators[op], Integer.valueOf(a).toString(), Integer.valueOf(b).toString(), Integer.valueOf(ans).toString()));
        mAdapter.notifyDataSetChanged();
    }

    private int getRandomNumber(int min, int max) {
        return rand.nextInt(max - min + 1) + min;
    }
}
