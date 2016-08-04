package fr.nawrasg.jumper.activities;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import fr.nawrasg.jumper.R;
import fr.nawrasg.jumper.fragments.ServicesFragment;

/**
 * Created by Nawras on 04/08/2016.
 */

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        loadFragment(new ServicesFragment(), true);
    }

    private void removeFragments() {
        Fragment nFragment = getFragmentManager().findFragmentByTag("f1");
        if (nFragment != null) {
            getFragmentManager().beginTransaction().remove(nFragment).commit();
        }
    }

    public void loadFragment(Fragment fragment, boolean first) {
        removeFragments();
        if (first) {
            getFragmentManager().beginTransaction().replace(R.id.frameSettings, fragment, "f1").commit();
        } else {
            /*if (findViewById(R.id.main_fragment2) != null) {
                getFragmentManager().beginTransaction().replace(R.id.main_fragment2, fragment, "f2").commit();
            }*/
        }
    }
}
