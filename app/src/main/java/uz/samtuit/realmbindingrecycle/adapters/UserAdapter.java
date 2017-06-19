package uz.samtuit.realmbindingrecycle.adapters;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import uz.samtuit.realmbindingrecycle.databinding.UserItemBinding;
import uz.samtuit.realmbindingrecycle.holders.UserItemHolder;
import uz.samtuit.realmbindingrecycle.models.User;

/**
 * Created by amin on 04.06.17.
 */

public class UserAdapter extends RealmRecyclerViewAdapter<User, UserItemHolder> {

    public UserAdapter(@Nullable OrderedRealmCollection<User> data, boolean autoUpdate) {
        super(data, autoUpdate);
        setHasStableIds(true);
    }

    @Override
    public UserItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        UserItemBinding binding = UserItemBinding.inflate(inflater, parent, false);
        return new UserItemHolder(binding.getRoot());

    }

    @Override
    public void onBindViewHolder(UserItemHolder holder, int position) {
        User user = getItem(position);
        holder.binding.setUser(user);
    }

}
