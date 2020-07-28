package com.syncupdate;

import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.PackageList;
import com.facebook.react.ReactApplication;
import com.facebook.react.ReactInstanceManager;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.soloader.SoLoader;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import io.realm.Realm;
import io.realm.RealmConfiguration;

import io.realm.RealmList;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainApplication extends Application implements ReactApplication {
    OkHttpClient client = new OkHttpClient.Builder().readTimeout(180000, TimeUnit.SECONDS).connectTimeout(5000, TimeUnit.SECONDS).build();
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://dock.strongarmtech.com/").addConverterFactory(GsonConverterFactory.create()).client(client).build();
    private APIadapter retrofitCall = retrofit.create(APIadapter.class);

    private final ReactNativeHost mReactNativeHost =
            new ReactNativeHost(this) {
                @Override
                public boolean getUseDeveloperSupport() {
                    return BuildConfig.DEBUG;
                }

                @Override
                protected List<ReactPackage> getPackages() {
                    @SuppressWarnings("UnnecessaryLocalVariable")
                    List<ReactPackage> packages = new PackageList(this).getPackages();
                    // Packages that cannot be autolinked yet can be added manually here, for example:
                    // packages.add(new MyReactNativePackage());
                    return packages;
                }

                @Override
                protected String getJSMainModuleName() {
                    return "index";
                }
            };

    @Override
    public ReactNativeHost getReactNativeHost() {
        return mReactNativeHost;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        SoLoader.init(this, /* native exopackage */ false);
        initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
        getData();
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder().build();
        Realm.setDefaultConfiguration(config);
    }

    /**
     * Loads Flipper in React Native templates. Call this in the onCreate method with something like
     * initializeFlipper(this, getReactNativeHost().getReactInstanceManager());
     *
     * @param context
     * @param reactInstanceManager
     */
    private static void initializeFlipper(
            Context context, ReactInstanceManager reactInstanceManager) {
        if (BuildConfig.DEBUG) {
            try {
        /*
         We use reflection here to pick up the class that initializes Flipper,
        since Flipper library is not available in release mode
        */
                Class<?> aClass = Class.forName("com.syncupdate.ReactNativeFlipper");
                aClass
                        .getMethod("initializeFlipper", Context.class, ReactInstanceManager.class)
                        .invoke(null, context, reactInstanceManager);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
    private void getData()
    {
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
                    Toast.makeText(MainApplication.this, "Success!!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<GetAthleteModel>> call, Throwable t) {
                Log.d("MainApplication", "Error: "+ t);
                t.printStackTrace();
                Toast.makeText(MainApplication.this, "Error!!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}