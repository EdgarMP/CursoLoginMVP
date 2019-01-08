package com.edgarmarcopolo.cursologinmvp.views;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.edgarmarcopolo.cursologinmvp.R;
import com.edgarmarcopolo.cursologinmvp.adapters.ListAdapter;
import com.edgarmarcopolo.cursologinmvp.interfaces.ListPresenter;
import com.edgarmarcopolo.cursologinmvp.interfaces.ListView;
import com.edgarmarcopolo.cursologinmvp.listeners.RecyclerItemClickListener;
import com.edgarmarcopolo.cursologinmvp.models.Notice;
import com.edgarmarcopolo.cursologinmvp.presenters.ListPresenterImpl;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements ListView {


    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    private ListPresenter mListPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mRecyclerView = findViewById(R.id.recycler_view);
        mProgressBar = findViewById(R.id.progress_bar_list);
        mListPresenter = new ListPresenterImpl(this);
        mListPresenter.attemptRetrieveList();

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(ListActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);
    }

    @Override
    public void showProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void requestCompleted(ArrayList<Notice> arrayList) {
        ListAdapter adapter = new ListAdapter(arrayList , recyclerItemClickListener);
        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public void requestFailed() {

    }

    /**
     * RecyclerItem click event listener
     * */
    private RecyclerItemClickListener recyclerItemClickListener = new RecyclerItemClickListener() {
        @Override
        public void onItemClick(Notice notice) {

            Toast.makeText(ListActivity.this,
                    "List title:  " + notice.getTitle(),
                    Toast.LENGTH_LONG).show();

        }
    };
}
