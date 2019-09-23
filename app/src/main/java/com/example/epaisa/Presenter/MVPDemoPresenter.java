package com.example.epaisa.Presenter;


import com.example.epaisa.Model.SongResponse;
import com.example.epaisa.Service.MVPDemoService;
import com.example.epaisa.View.MVPDemoView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MVPDemoPresenter {

    private MVPDemoService countryService;
    private MVPDemoView countryView;


    public MVPDemoPresenter(MVPDemoView view) {
        this.countryView = view;

        if (this.countryService == null) {
            this.countryService = new MVPDemoService();
        }
    }

    public void getSongList() {

        countryService
                .getAPIS()
                .getSongList()
                .enqueue(new Callback<SongResponse>() {
                    @Override
                    public void onResponse(Call<SongResponse> call, Response<SongResponse> response) {
                        SongResponse data = response.body();


                            if (data.getResults().size() > 0){

                              //  countryView.uninstallMessage("Notification sent");
                                countryView.notificationData(data.getResults());

                            }else {

                                countryView.LoginError("Notification not available");

                                /*AlertDialog.Builder builder = new AlertDialog.Builder(view);
                                builder.setMessage("Notification not available")
                                        .setCancelable(false)
                                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                            }
                                        });
                                AlertDialog alert = builder.create();
                                alert.show();*/

                              //  countryView.uninstallMessage("Notification not available");

                            }


                   //     }
                    }

                    @Override
                    public void onFailure(Call<SongResponse> call, Throwable t) {
                        try {
                            throw new InterruptedException("Something went wrong!");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
}
