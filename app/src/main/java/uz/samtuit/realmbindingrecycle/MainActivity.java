package uz.samtuit.realmbindingrecycle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.View;

import io.realm.Realm;
import uz.samtuit.realmbindingrecycle.activities.UserActivity;
import uz.samtuit.realmbindingrecycle.adapters.UserAdapter;
import uz.samtuit.realmbindingrecycle.models.User;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Realm.init(this);
        Realm realm = Realm.getDefaultInstance();

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new UserAdapter(realm.where(User.class).findAll(), true);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("asdsdf");
        menu.add("asdasfsdfsd");
        return super.onCreateOptionsMenu(menu);
    }

    public void add_record(View v)
    {
        Intent intent;
        intent = new Intent(this, UserActivity.class);
        startActivity(intent);
    }
}
