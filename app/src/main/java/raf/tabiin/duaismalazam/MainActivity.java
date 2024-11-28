package raf.tabiin.duaismalazam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.splashscreen.SplashScreen;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.google.android.material.color.DynamicColors;

import raf.tabiin.duaismalazam.databinding.ActivityMainBinding;
import raf.tabiin.duaismalazam.ui.about_app.AppAboutFragment;
import raf.tabiin.duaismalazam.ui.counter.MainSwipeFragment;
import raf.tabiin.duaismalazam.ui.dua.DuaIsmAlAzamFragment;
import raf.tabiin.duaismalazam.util.SharedPreferencesUtils;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DuaIsmAlAzamFragment duaismalazamFragment;
    AppAboutFragment appAboutFragment;
    Boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int nightIcon = SharedPreferencesUtils.getInteger(this, "nightIcon", R.drawable.vectornightpress);

        App.instance.setNightMode();

        SplashScreen splashScreen = SplashScreen.installSplashScreen(this);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.containerFragment, new DuaIsmAlAzamFragment())
                    .commit();
        }

        if (SharedPreferencesUtils.getBoolean(this, "useDynamicColors"))
            DynamicColors.applyToActivityIfAvailable(this);

        if (SharedPreferencesUtils.getBoolean(this, "addFollowSystemIcon"))
            flag = true;

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        appAboutFragment = new AppAboutFragment();
        duaismalazamFragment = new DuaIsmAlAzamFragment();

        binding.navView.setSelectedItemId(R.id.duaforreachness);

        binding.navView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {

                case R.id.duaforreachness:

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.containerFragment, new DuaIsmAlAzamFragment())
                            .commit();

                    return true;

                case R.id.counter:

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.containerFragment, new MainSwipeFragment())
                            .commit();

                    return true;

                case R.id.about_app:

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.containerFragment, new AppAboutFragment())
                            .commit();
                    return true;
            }
            return false;
        });
    }

}