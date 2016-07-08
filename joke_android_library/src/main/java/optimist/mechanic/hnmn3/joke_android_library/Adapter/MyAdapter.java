package optimist.mechanic.hnmn3.joke_android_library.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import optimist.mechanic.hnmn3.joke_android_library.R;

/**
 * Created by Manish Menaria on 08-Jul-16.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private String[] jokes;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView tvJoke;
        public ViewHolder(View v) {
            super(v);
            tvJoke = (TextView) v.findViewById(R.id.tvJoke);
        }
    }

    public MyAdapter(String[] jokes) {
        this.jokes = jokes;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvJoke.setText(jokes[position]);

    }

    @Override
    public int getItemCount() {
        return jokes.length;
    }
}
