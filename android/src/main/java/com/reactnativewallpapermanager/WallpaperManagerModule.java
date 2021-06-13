package com.reactnativewallpapermanager;

import androidx.annotation.NonNull;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


@ReactModule(name = WallpaperManagerModule.NAME)
public class WallpaperManagerModule extends ReactContextBaseJavaModule {
      final WallpaperManager wallpaperManager = WallpaperManager.getInstance(getReactApplicationContext());
    public static final String NAME = "WallpaperManager";

    public WallpaperManagerModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    @NonNull
    public String getName() {
        return NAME;
    }

    @Override
    public Map<String, Object> getConstants(){
      final Map<String, Object> constants = new HashMap<>();
      constants.put("FLAG_LOCK", wallpaperManager.FLAG_LOCK);
      constants.put("FLAG_SYSTEM", wallpaperManager.FLAG_SYSTEM);
      return constants;
    }

    @ReactMethod
    public void setWallpaper(String uri, int flag, Promise promise) {
      try {
        File imgFile = new File(uri);
        Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
        Log.d("WallpaperModule", imgFile.getAbsolutePath());
        if(myBitmap == null){
          Log.d("WallpaperModule", "Bitmap é null");
        }
        if (android.os.Build.VERSION.SDK_INT >= 24){
          wallpaperManager.setBitmap(myBitmap, null, true, flag);
        } else{
          wallpaperManager.setBitmap(myBitmap);
        }

        promise.resolve("Wallpaper definition complete");
      } catch (Exception e) {
        Log.d("WallpaperModule", e.getMessage());
        promise.reject(e);
      }
    }

    public static native int nativeMultiply(int a, int b);
}
