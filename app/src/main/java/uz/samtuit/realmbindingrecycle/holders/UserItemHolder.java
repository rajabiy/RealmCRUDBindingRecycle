package uz.samtuit.realmbindingrecycle.holders;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;


import io.realm.Realm;
import uz.samtuit.realmbindingrecycle.activities.UserActivity;
import uz.samtuit.realmbindingrecycle.databinding.UserItemBinding;
import uz.samtuit.realmbindingrecycle.models.User;

/**
 * Created by amin on 03.06.17.
 */

public class UserItemHolder extends RecyclerView.ViewHolder implements
        MenuItem.OnMenuItemClickListener, View.OnCreateContextMenuListener{
    public UserItemBinding binding;

    public UserItemHolder(View itemView) {
        super(itemView);
        binding = DataBindingUtil.bind(itemView);
        itemView.setOnCreateContextMenuListener(this);
    }


    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(0,1,1,"Delete").setOnMenuItemClickListener(this);
        menu.add(0,0,1,"Edit").setOnMenuItemClickListener(this);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        int i = item.getItemId();
        if (i==0) {
            Intent intent;
            intent = new Intent(this.itemView.getContext(), UserActivity.class);
            intent.putExtra("id", binding.getUser().getId());
            itemView.getContext().startActivity(intent);
        }
        else {
            Realm realm = Realm.getDefaultInstance();
            realm.beginTransaction();
            User user = this.binding.getUser();
            user.deleteFromRealm();
            realm.commitTransaction();
        }
        return false;
    }
}
