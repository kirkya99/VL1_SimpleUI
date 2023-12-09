package de.rwu.ws2021_vl1;

import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.KeyEvent;
import android.view.View;

import androidx.navigation.ui.AppBarConfiguration;

import de.rwu.ws2021_vl1.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        binding.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Button anotherButton = findViewById(R.id.anotherButton);
        anotherButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Switch textSwitch = (Switch) findViewById(R.id.textSwitch);
//                textSwitch.setChecked(false);
                if (textSwitch.isChecked()) {
                    anotherButton.setText("Switch on");
                    textSwitch.setChecked(false);
                } else {
                    anotherButton.setText("Switch off");
                    textSwitch.setChecked(true);
                }
                Snackbar.make(view, "Another Button", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        anotherButton.setText("Hallo");

        ToggleButton toggleButton = findViewById(R.id.toggleButton);

        toggleButton.setOnClickListener(view -> {
            boolean isOn = ((ToggleButton) view).isChecked();
            if (isOn) {
                Snackbar.make(view, "On", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            } else {
                Snackbar.make(view, "Off", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Spinner spinner = (Spinner) findViewById(R.id.theSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.names_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Snackbar.make(view, "Name Nr." + position + parent.getItemAtPosition(position), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        EditText editText = (EditText) findViewById(R.id.editTextPersonName);
//        editText.setOnKeyListener(new View.OnKeyListener() {
//            public boolean onKey(View view, int keyCode, KeyEvent event) {
//                if ((event.getAction() == KeyEvent.ACTION_DOWN)
//                        && (keyCode == KeyEvent.KEYCODE_ENTER)) {
//                    Snackbar.make(view, editText.getText(), Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//
//                return false;
//            }
//        });

        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND) {
                    Snackbar.make(v, editText.getText(), Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
                return false;
            }
        });
    }

    public void switchOn(View view) {
        boolean isOn = ((CheckBox) view).isChecked();
        if (isOn) {
            Snackbar.make(view, "Checkbox on", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else {
            Snackbar.make(view, "Checkbox off", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    public void switchRadioOptions(View view) {
        boolean isChecked = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.radioOption1:
                if (isChecked) {
                    Snackbar.make(view, "Radio option 1", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Action", null).show();
                }
                break;
            case R.id.radioOption2:
                if (isChecked) {
                    Snackbar.make(view, "Radio option 2", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Action", null).show();
                }
                break;
        }
    }

    public void buttonClicked(View view) {
        Snackbar.make(view, "Button", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
    }

    public void switchTextClicked(View view) {
        boolean isOn = ((Switch) view).isChecked();
        if (isOn) {
            Snackbar.make(view, "On", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        } else {
            Snackbar.make(view, "Off", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}