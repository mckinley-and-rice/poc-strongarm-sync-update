package com.syncupdate;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableArray;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AthleteModule extends ReactContextBaseJavaModule {
    ReactApplicationContext mReactContext;
    private APIadapter retrofitCall;

    public AthleteModule(ReactApplicationContext reactContext) {
        super(reactContext);
        mReactContext = reactContext;
        OkHttpClient client = new OkHttpClient.Builder().readTimeout(180000, TimeUnit.SECONDS).connectTimeout(5000, TimeUnit.SECONDS).build();
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dock.strongarmtech.com/").addConverterFactory(GsonConverterFactory.create()).client(client).build();
        retrofitCall = retrofit.create(APIadapter.class);
    }

    @NonNull
    @Override
    public String getName() {
        return "AthleteModule";
    }

    @ReactMethod
    void loadFromServer(Promise promise){
        Log.d("MainApplication", "Call Api ");
        Call<List<GetAthleteModel>> call = retrofitCall.getAthletes("application/json", 33, 45, 722);
        call.enqueue(new Callback<List<GetAthleteModel>>() {
            @Override
            public void onResponse(Call<List<GetAthleteModel>> call, Response<List<GetAthleteModel>> response) {
                Log.d("MainApplication", "no Error ");
                Log.d("MainApplication", "Response: " + response.body().get(0).getFirstName());
                if(response.isSuccessful()) {
                    List<GetAthleteModel> listAthlete = response.body();
                    Realm realm = Realm.getDefaultInstance();
                    realm.beginTransaction();
                    RealmList<GetAthleteModel> _athList = new RealmList<>();
                    _athList.addAll(listAthlete);
                    realm.insertOrUpdate(_athList);
                    realm.commitTransaction();
                    Toast.makeText(mReactContext, "Success!!", Toast.LENGTH_SHORT).show();
                }
                promise.resolve(null);
            }

            @Override
            public void onFailure(Call<List<GetAthleteModel>> call, Throwable t) {
                Log.d("MainApplication", "Error: "+ t);
                t.printStackTrace();
                Toast.makeText(mReactContext, "Error!!", Toast.LENGTH_SHORT).show();
                promise.reject(t);
            }
        });
    }

    @ReactMethod
    private void getAthletes(Promise promise) {
        Realm realm = Realm.getDefaultInstance();
        try {
            RealmResults<GetAthleteModel> athletes = realm.where(GetAthleteModel.class).findAll();
            List<GetAthleteModel> athleteList = realm.copyFromRealm(athletes);
            WritableArray array = Arguments.fromList(athleteList);
            promise.resolve(array);
        }catch(Exception e){
            e.printStackTrace();
            promise.reject(e);
        }
    }


}
