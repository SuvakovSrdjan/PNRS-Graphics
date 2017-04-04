package srdjan.suvakov.graphics;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainGraph extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main_graph);
        HouseView houseView = new HouseView(getApplicationContext());
        setContentView(houseView);
    }
}
