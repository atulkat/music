package com.example.epaisa;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.epaisa.Model.SongResponse;
import com.example.epaisa.Presenter.MVPDemoPresenter;
import com.example.epaisa.View.MVPDemoView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity implements MVPDemoView {

    //Declarations
    RecyclerView list_myProducts;
    OrderDiscountAdapter orderHistoryAdapter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ProgressDialog intialization
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getString(R.string.please_wait));
        progressDialog.show();

        if (isNetworkAvailable()) {

            MVPDemoPresenter countryPresenter = new MVPDemoPresenter(MainActivity.this);
            countryPresenter.getSongList();

        } else {
            Toast.makeText(MainActivity.this, "Internet connections seems to be offline", Toast.LENGTH_SHORT).show();
        }

        list_myProducts = findViewById(R.id.list_myProducts);
        list_myProducts.setHasFixedSize(true);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.this);
        list_myProducts.setLayoutManager(mLayoutManager);
        list_myProducts.setItemAnimator(new DefaultItemAnimator());
        orderHistoryAdapter = new OrderDiscountAdapter(MainActivity.this);
        list_myProducts.setAdapter(orderHistoryAdapter);

    }

    //check internet connection
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    //API data calling
    @Override
    public void notificationData(List<SongResponse.Result> notificationList) {

        progressDialog.dismiss();

        orderHistoryAdapter.getData().addAll(notificationList);
        orderHistoryAdapter.notifyDataSetChanged();
    }

    //shows error dialog when data not available
    @Override
    public void LoginError(String data) {

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage(data)
                .setCancelable(false)
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                        progressDialog.dismiss();

                        finish();
                        System.exit(0);
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }


    //Set list data adapter
    public class OrderDiscountAdapter extends RecyclerView.Adapter<OrderDiscountAdapter.ViewHolder> {

        private List<SongResponse.Result> data = new ArrayList<SongResponse.Result>();

        public List<SongResponse.Result> getData() {
            return data;
        }

        private Context context;


        public OrderDiscountAdapter(Context context) {
            //  this.data = list;
            this.context = context;
        }

        @Override
        public OrderDiscountAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem_songs, viewGroup, false);
            return new OrderDiscountAdapter.ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(final OrderDiscountAdapter.ViewHolder holder, final int position) {

            try {
                final SongResponse.Result objSongs = data.get(position);

                if (objSongs.getArtworkUrl100() != null) {

                    ImageLoader.getInstance().init(ImageLoaderConfiguration.createDefault(MainActivity.this));

                    ImageLoader imageLoader = ImageLoader.getInstance();

                    DisplayImageOptions options = new DisplayImageOptions.Builder().cacheInMemory(true)
                            .resetViewBeforeLoading(true) //ic_shop
                            .showImageForEmptyUri(R.color.gray) //ic_group_defaulting
                            .showImageOnFail(R.color.gray)
                            .showImageOnLoading(R.color.gray).build();


                    imageLoader.displayImage(objSongs.getArtworkUrl100(), holder.edit_profile, options);

                } else {
                    holder.edit_profile.setImageResource(R.color.gray);
                }

                if (objSongs.getArtistName() != null) {
                    holder.txt_ArtistName.setText(objSongs.getArtistName());
                }

                if (objSongs.getCollectionCensoredName() != null) {

                    holder.txt_collectioncensoredname.setText(objSongs.getCollectionCensoredName());
                }

                if (objSongs.getTrackCensoredName() != null) {
                    holder.txt_trackcensorname.setText(objSongs.getTrackCensoredName());
                }

                holder.allLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        //Passing data whole data using GSON to another activity
                       SongResponse.Result objSong;
                        Gson gson = new Gson();
                        objSong = data.get(position);
                        String json = gson.toJson(objSong);

                        Intent intent = new Intent(MainActivity.this, SongDetailsActivity.class);
                        intent.putExtra("songDetails", json);
                        startActivity(intent);

                    }
                });

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemViewType(int position) {
            return position;
        }


        @Override
        public int getItemCount() {
            return data.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

            //Declaration
            CircleImageView edit_profile;
            TextView txt_ArtistName, txt_collectioncensoredname, txt_trackcensorname;
            LinearLayout allLayout;

            View view;


            public ViewHolder(View view) {
                super(view);

                //Intiliazation
                edit_profile = view.findViewById(R.id.edit_profile);
                txt_ArtistName = view.findViewById(R.id.txt_ArtistName);
                txt_collectioncensoredname = view.findViewById(R.id.txt_collectioncensoredname);
                txt_trackcensorname = view.findViewById(R.id.txt_trackcensorname);

                allLayout = view.findViewById(R.id.allLayout);

            }
        }
    }

}
