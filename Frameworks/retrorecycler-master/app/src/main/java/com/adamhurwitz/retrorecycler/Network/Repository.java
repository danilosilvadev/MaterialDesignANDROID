package com.adamhurwitz.retrorecycler.Network;

import com.adamhurwitz.retrorecycler.Model;
import com.adamhurwitz.retrorecycler.RetroRecyclerApplication;

import javax.inject.Inject;

import rx.Observable;

/**
 * Created by ahurwitz on 1/24/17.
 */

public class Repository {

    @Inject
    Service service;

    public Repository() {

        RetroRecyclerApplication.getApp().getDataComponent().inject(this);

    }

    public Observable<Model> getNetworkItems(){

        return service.getData();

    }

}
