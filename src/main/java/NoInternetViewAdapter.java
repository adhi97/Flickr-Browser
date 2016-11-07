package org.example.android.flickrbrowser;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by arujmaheshwari on 14/08/16.
 */
public class NoInternetViewAdapter extends RecyclerView.Adapter<NoInternetViewHolder> {
    private Context mContext;

    @Override
    public NoInternetViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        if (!isOnline()){
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.no_internet, null);
            NoInternetViewHolder noInternetViewHolder = new NoInternetViewHolder(view);
            return noInternetViewHolder;
        } else {return null;}
    }

    @Override
    public void onBindViewHolder(NoInternetViewHolder holder, int position) {

    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}

