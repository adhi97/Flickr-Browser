package org.example.android.flickrbrowser;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by dev on 17/02/2016.
 */
public class FlickrRecyclerViewAdapter extends RecyclerView.Adapter<FlickrImageViewHolder> {
    private List<Photo> mPhotosList;
    private Context mContext;
    private final String LOG_TAG = FlickrRecyclerViewAdapter.class.getSimpleName();

    public FlickrRecyclerViewAdapter(Context context, List<Photo> photosList) {
        mContext = context;
        this.mPhotosList = photosList;
    }

    @Override
    public FlickrImageViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.browse, null);
        FlickrImageViewHolder flickrImageViewHolder = new FlickrImageViewHolder(view);
        return flickrImageViewHolder;
    }


    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = connectivityManager.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }

    @Override
    public void onBindViewHolder(FlickrImageViewHolder flickrImageViewHolder, int i) {
        if ((mPhotosList == null || mPhotosList.size() == 0) && isOnline()) {
            flickrImageViewHolder.thumbnail.setImageResource(R.drawable.placeholder);
            flickrImageViewHolder.title.setText("NO PHOTOS MATCH YOUR SEARCH");
            flickrImageViewHolder.title.setTextSize(18);
        }
        else if (!isOnline()) {
            flickrImageViewHolder.thumbnail.setImageResource(R.drawable.phto);
            flickrImageViewHolder.title.setText("CHECK YOUR INTERNET CONNECTION");
            flickrImageViewHolder.title.setTextSize(18);
        }
        else {
            Photo photoItem = mPhotosList.get(i);
            Log.d(LOG_TAG, "Processing: " + photoItem.getTitle() + " --> " + Integer.toString(i));

            Picasso.with(mContext).load(photoItem.getImage())
                    .error(R.drawable.placeholder)
                    .placeholder(R.drawable.placeholder)
                    .into(flickrImageViewHolder.thumbnail);
            flickrImageViewHolder.title.setText(photoItem.getTitle());
            flickrImageViewHolder.title.setTextSize(16);
        }
    }

    @Override
    public int getItemCount() {
        return (mPhotosList != null && mPhotosList.size() != 0 ? mPhotosList.size() : 1);
    }

    public void loadNewData(List<Photo> newPhotos) {
        mPhotosList = newPhotos;
        notifyDataSetChanged();
    }

    public Photo getPhoto(int position) {
        return (mPhotosList != null && mPhotosList.size() != 0 ? mPhotosList.get(position) : null);
    }
}