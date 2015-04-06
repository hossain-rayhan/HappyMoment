package iit.du.edu.happymoment;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import iit.du.edu.happymoment.adapter.UrlListAdapter;
import iit.du.edu.happymoment.model.Url;


public class MainActivity extends ActionBarActivity {

    private ListView lvUrl;
    private List<Url> urlList = new ArrayList<Url>();

    private Button btnCollage;
    private Button startDate;
    private Button lastDate;
    static final int DATE_DIALOG_ID_START = 998;
    static final int DATE_DIALOG_ID_END = 999;

    private int year;
    private int month;
    private int day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startDate = (Button)findViewById(R.id.btn_start);
        lastDate = (Button) findViewById(R.id.btn_end);
        setCurrentDateOnDatePicker();
        addListenerOnDateField();



        urlList.add(new Url("www.facebook.com","www.facebook.com"));
        urlList.add(new Url("www.google.com","www.google.com"));
        urlList.add(new Url("www.yahoo.com","www.yahoo.com"));
        urlList.add(new Url("www.facebook.com","www.facebook.com"));
        urlList.add(new Url("www.google.com","www.google.com"));
        urlList.add(new Url("www.yahoo.com","www.yahoo.com"));
        urlList.add(new Url("www.facebook.com","www.facebook.com"));
        urlList.add(new Url("www.google.com","www.google.com"));
        urlList.add(new Url("www.yahoo.com","www.yahoo.com"));
        urlList.add(new Url("www.facebook.com","www.facebook.com"));
        urlList.add(new Url("www.google.com","www.google.com"));
        urlList.add(new Url("www.yahoo.com","www.yahoo.com"));

        lvUrl = (ListView) findViewById(R.id.lv_url);
        final UrlListAdapter urlListAdapter = new UrlListAdapter(this,R.layout.list_item_url,urlList);
        lvUrl.setAdapter(urlListAdapter);

        lvUrl.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Url url = urlListAdapter.getItem(position);
                Intent i = new Intent(MainActivity.this, WebViewActivity.class);
                i.putExtra("url",url.getUrl());
                startActivity(i);
            }
        });

        btnCollage = (Button) findViewById(R.id.btn_collage);
        btnCollage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, GalaryActivity.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void addListenerOnDateField() {

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_START);

            }

        });

        lastDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DATE_DIALOG_ID_END);

            }

        });

    }



    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_DIALOG_ID_START:
                // set date picker as current date
                return new DatePickerDialog(this, datePickerListenerStart, year, month,
                        day);
            case DATE_DIALOG_ID_END:
                return new DatePickerDialog(this, datePickerListenerEnd, year, month,
                        day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListenerStart = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            startDate.setText(new StringBuilder().append(day).append("/").append(month + 1)
                    .append("/").append(year)
                    .append(" "));
        }
    };

    private DatePickerDialog.OnDateSetListener datePickerListenerEnd = new DatePickerDialog.OnDateSetListener() {

        // when dialog box is closed, below method will be called.
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            year = selectedYear;
            month = selectedMonth;
            day = selectedDay;

            lastDate.setText(new StringBuilder().append(day).append("/").append(month + 1)
                    .append("/").append(year)
                    .append(" "));
        }
    };

    private void setCurrentDateOnDatePicker() {
        final Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }
}
