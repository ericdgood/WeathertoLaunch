package com.example.edgoo.whatsgoingup;

        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.view.View;

        import com.example.edgoo.whatsgoingup.Utilities.FetchRocketData;
        import com.example.edgoo.whatsgoingup.Utilities.RocketInfo;

public class MainActivity extends AppCompatActivity {

    private RocketAdapter mRocketAdapter;
    RocketInfo[] mRockets;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mRocketAdapter = new RocketAdapter(this, mRockets);
        recyclerView.setAdapter(mRocketAdapter);
        View loadingIndicator = findViewById(R.id.progree_layout);
        loadRocketData(loadingIndicator);
    }

    private void loadRocketData(View loadingIndicator) {
        new FetchRocketData(mRocketAdapter, loadingIndicator).execute();
    }
}
