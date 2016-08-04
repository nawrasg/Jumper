package fr.nawrasg.jumper.fragments;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.util.Log;

import java.util.ArrayList;
import java.util.Set;

import fr.nawrasg.jumper.R;

/**
 * Created by Nawras on 04/08/2016.
 */

public class ServicesFragment extends PreferenceFragment {
    ListPreference nBluetoothPreference;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference_services);
        nBluetoothPreference = (ListPreference) findPreference("btList");
        nBluetoothPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {

                return true;
            }
        });
        loadBluetoothDevices();
    }

    private void loadBluetoothDevices(){
        String nValue = nBluetoothPreference.getValue();
        String nName = "";
        BluetoothAdapter nAdapter = BluetoothAdapter.getDefaultAdapter();
        Set<BluetoothDevice> nDevices = nAdapter.getBondedDevices();
        ArrayList<String> nTitleList = new ArrayList<>();
        ArrayList<String> nAddressList = new ArrayList<>();
        for(BluetoothDevice nDevice : nDevices){
            nTitleList.add(nDevice.getName());
            nAddressList.add(nDevice.getAddress());
            if(nValue != null && nValue.equals(nDevice.getAddress())){
                nName = nDevice.getName();
            }
        }
        CharSequence[] nEntries = nTitleList.toArray(new CharSequence[nTitleList.size()]);
        CharSequence[] nValues = nAddressList.toArray(new CharSequence[nAddressList.size()]);
        nBluetoothPreference.setEntries(nEntries);
        nBluetoothPreference.setEntryValues(nValues);
        nBluetoothPreference.setSummary(nName);
    }
}
