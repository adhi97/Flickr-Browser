package org.example.android.flickrbrowser;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by arujmaheshwari on 14/08/16.
 */
public class NoInternetViewHolder extends RecyclerView.ViewHolder {
    protected TextView no_internet;

    public NoInternetViewHolder(View view) {
        super(view);
        this.no_internet = (TextView) view.findViewById(R.id.no_internet);
    }
}
