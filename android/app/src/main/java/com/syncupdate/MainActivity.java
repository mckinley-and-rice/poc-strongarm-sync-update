package com.syncupdate;

import android.os.Bundle;
import android.util.Log;

import com.facebook.react.ReactActivity;

import io.realm.Realm;
import io.realm.RealmResults;

public class MainActivity extends ReactActivity {
  private static final String TAG = "MainActivity";
  Realm realm;

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "syncUpdate";
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    realm = Realm.getDefaultInstance();

//    Log.d(TAG,"onCreate:process started");
//    realm.beginTransaction();
//    realm.deleteAll();
//    realm.commitTransaction();

//    this.saveData("name1",1,1,1);
//    this.saveData("name2",2,2,2);
//    this.saveData("name3",3,3,3);
//    this.saveData("name4",4,4,4);
//    this.saveData("name5",5,5,5);
//
////    this.readData();
//
//    new android.os.Handler().postDelayed(
//        new Runnable() {
//          public void run() {
//            Log.i("tag", "This'll run 300 milliseconds later");
//            readData();
//          }
//        },
//        10000);
//


  }

  private void readData(){
    RealmResults<GetAthleteModel> atheletes = realm.where(GetAthleteModel.class).findAll();
    for(GetAthleteModel ath:atheletes){
      try{
        Log.d(TAG,ath.getFirstName());
      }
      catch(Exception e){
        e.printStackTrace();
      }
    }
  }
  private void saveData(String str1,int a,int b, int c){
    realm.executeTransactionAsync(new Realm.Transaction() {
      @Override
      public void execute(Realm bgRealm) {
        GetAthleteModel athelete = new GetAthleteModel();
        athelete.setFirstName(str1);
        athelete.setId(a);
        athelete.setWarehouseId(b);
        athelete.setLastName(""+c);
        bgRealm.insertOrUpdate(athelete);
      }
    }, new Realm.Transaction.OnSuccess() {
      @Override
      public void onSuccess() {
        // Transaction was a success.
        Log.d(TAG,"onSuccess: Data Written Successfully");
      }
    }, new Realm.Transaction.OnError() {
      @Override
      public void onError(Throwable error) {
        error.printStackTrace();
        // Transaction failed and was automatically canceled.
        Log.d(TAG,"onError:error occured");
      }
    });
  }
}

