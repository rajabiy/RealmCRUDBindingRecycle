package uz.samtuit.realmbindingrecycle.activities;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;
import uz.samtuit.realmbindingrecycle.R;
import uz.samtuit.realmbindingrecycle.databinding.ActivityUserBinding;
import uz.samtuit.realmbindingrecycle.models.User;

public class UserActivity extends AppCompatActivity {
    Realm realm;
    ActivityUserBinding binding;
    String id;

    public void setUser(User user) {
        this.user = user;
    }

    public User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        ActivityUserBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user);

        realm = Realm.getDefaultInstance();
        id = getIntent().getStringExtra("id");

        if (id == null) {
            user = new User();
        }
        else {
            user = realm.where(User.class).equalTo("id", id).findFirst();
        }
        binding.setUser(user);
        realm.beginTransaction();

    }

    @Override
    protected void onStop() {

        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();
        super.onStop();
    }
}
