package redtech.cancerclicker;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static String PACKAGE_NAME;
    private TextView mTextMessage;
    private TextView disCells;

    public HomeFragment getHomeFragment() {
        return homeFragment;
    }

    HomeFragment homeFragment = new HomeFragment();
    private Context context = this;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    transaction.replace(R.id.content, homeFragment).commit();
                    return true;
                case R.id.navigation_characters:
                    transaction.replace(R.id.content, new CharactersFragment()).commit();
                    return true;
                case R.id.navigation_operations:
                    transaction.replace(R.id.content, new OperationsFragment()).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_home);
        game.Main.Game.start(this);
        PACKAGE_NAME = getApplicationContext().getPackageName();

    }


}
