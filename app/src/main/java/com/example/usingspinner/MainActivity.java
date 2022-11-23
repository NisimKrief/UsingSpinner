package com.example.usingspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemSelectedListener {
    ListView lv;
    TextView NtV;
    TextView StV;
    TextView DtV;
    TextView PNtV;
    Spinner spin;
    int shomer;

    String[][] Names = {{"Moshe", "Yaakov", "Albert", "James", "Idan", "Shay", "Yonatan", "Ester", "Dorel", "Yarin"}
            ,{"Charles", "Itzik", "Sans", "Papyrus", "Josef", "Albert", "Katzav", "Doron", "Timtam", "Guy"}
            ,{"Albert", "Harel", "Bar", "Makat", "Mistraim", "Mohammed", "Dave", "Dani", "Shay", "Orel"}
            ,{"Kirito", "Luffy", "Naruto", "Goku", "Saitama", "Tai", "Ash", "Ichigo", "Zoro", "Sanji"}};

    String[][] Surname = {{"Krief", "Bunkin", "Levi", "Fathi", "Iluz", "Odlo", "Gabay", "Zhurvaliov", "Menahem", "Shteyman"},
            {"Pixelim", "Bashiri", "Riboa", "Godel", "MagilMeod", "Aplikatzia", "Sheyesh", "Arov", "Tkoim", "Tikfotz"},
            {"LoLirotbo","Natsnatsim","EifoZeNimtza","Aene","Shemetz","Zimon","Mitgaisim","Rashombadaf","Beereh","Beotoyom"},
            {"ShavoaLefney", "Ahri", "Yodbet", "Dilagti", "Simanti", "Stoma", "Maze", "Marina", "Adhamesh", "Nostalgia"}};

    String[][] Dates = {{"30/11/2006", "26/10/2006", "21/5/2006", "13/2/2006", "30/1/2006", "28/4/2006", "31/5/2006", "12/2/2006", "06/6/2006", "25/4/2006"},
            {"05/11/2006", "20/10/2006", "25/5/2006", "18/2/2006", "10/1/2006", "28/4/2006", "21/5/2006", "14/2/2006", "16/6/2006", "28/4/2006"},
            {"9/11/2006", "21/10/2006", "22/5/2006", "15/2/2006", "10/1/2006", "22/4/2006", "26/5/2006", "16/2/2006", "06/6/2006", "25/4/2006"},
            {"17/11/2006", "04/10/2006", "28/5/2006", "19/2/2006", "15/1/2006", "25/4/2006", "18/5/2006", "14/2/2006", "26/6/2006", "27/4/2006"}};

    String[][] Number = {{"0542509918", "0522509918", "0502509918", "0549356310", "05428637456", "0524921062", "0506931582", "0523682193", "0547931026", "0526981254"},
            {"0542509912", "0522509912", "0502509912", "0549356312", "05428637452", "0524921063", "0506931583", "0523682194", "0547931022", "0526981252"},
            {"0542509913", "0522509913", "0502509913", "0549356313", "05428637453", "0524921064", "0506931584", "0523682195", "0547931024", "0526981255"},
            {"0542509914", "0522509914", "0502509914", "0549356314", "05428637454", "0524921065", "0506931585", "0523682196", "0547931027", "0526981257"}};

    String[] spinner = {"Choose Class: ", "Class 1: ", "Class 2: ", "Class 3: ", "Class 4: "};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv = (ListView) findViewById(R.id.lv);
        spin = (Spinner) findViewById(R.id.spinner);
        NtV = (TextView) findViewById(R.id.NtV);
        StV = (TextView) findViewById(R.id.StV);
        DtV = (TextView) findViewById(R.id.BtV);
        PNtV = (TextView) findViewById(R.id.PNtV);



        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(this);
        spin.setOnItemSelectedListener(this);
        ArrayAdapter<String> Spinneradp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, spinner);

        spin.setAdapter(Spinneradp);
    }


    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        NtV.setText(Names[shomer][i]);
        StV.setText(Surname[shomer][i]);
        DtV.setText(Dates[shomer][i]);
        PNtV.setText(Number[shomer][i]);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(i > 0) {
            shomer = i -1;
            ArrayAdapter<String> adp = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Names[i - 1]);
            lv.setAdapter(adp);
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        Toast.makeText(this, "Choose a Class", Toast.LENGTH_SHORT).show();

    }
}

