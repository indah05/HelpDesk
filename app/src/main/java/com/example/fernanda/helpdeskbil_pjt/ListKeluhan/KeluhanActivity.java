package com.example.fernanda.helpdeskbil_pjt.ListKeluhan;

import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.fernanda.helpdeskbil_pjt.ListKeluhan.FragmentListKeluhan;
import com.example.fernanda.helpdeskbil_pjt.ListKeluhan.FragmentListSelesai;
import com.example.fernanda.helpdeskbil_pjt.ListKeluhan.FragmentTambahKeluhan;
import com.example.fernanda.helpdeskbil_pjt.Model.KeluhanModel;
import com.example.fernanda.helpdeskbil_pjt.R;

import java.util.ArrayList;
import java.util.List;

public class KeluhanActivity extends AppCompatActivity {

    public static final String URL = "http://36.66.205.251/report1/";
    private List<KeluhanModel> results = new ArrayList<>();

    TextView tv_jml_selesai, tv_jml_progres;

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keluhan);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

//        loadStatus();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_keluhan, menu);
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

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    FragmentListKeluhan tab1 = new FragmentListKeluhan();
                    return tab1;
                case 1:
                    FragmentListSelesai tab2 = new FragmentListSelesai();
                    return tab2;
                case 2:
                    FragmentTambahKeluhan tab3 = new FragmentTambahKeluhan();
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }


    }

//    private void loadStatus(){
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl(URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//        RegisterAPI api = retrofit.create(RegisterAPI.class);
//        Call<Value> call = api.count_progres();
//        call.enqueue(new Callback<Value>() {
//            @Override
//            public void onResponse(Call<Value> call, Response<Value> response) {
//                String value = response.body().getValue();
//                int jml = response.body().getJml_progres();
//                System.out.print("++++JML+++++"+jml);
//                if(value.equals("1")){
////                    results = response.body().getResult();
////                    tv_jml_progres.setText(jml);
//                    System.out.print("++++JML+++++"+jml);
//                }
//            }
//
//            @Override
//            public void onFailure(Call<Value> call, Throwable t) {
//
//            }
//        });
//    }

}
