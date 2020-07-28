package com.syncupdate;

import android.util.Log;
import android.widget.Toast;

import com.facebook.react.ReactActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "syncUpdate";
  }
}
