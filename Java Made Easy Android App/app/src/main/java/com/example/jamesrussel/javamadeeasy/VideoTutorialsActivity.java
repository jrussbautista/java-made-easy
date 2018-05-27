package com.example.jamesrussel.javamadeeasy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class VideoTutorialsActivity extends AppCompatActivity {
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_tutorials);
        Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle(R.string.video_title);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv = (ListView) findViewById(R.id.listview1);

      VideoAdapter adapter = new VideoAdapter(this);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                switch (pos) {
                    case 0:
                        new Video1();
                        Intent i = new Intent(getApplicationContext(), Video1.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        break;
                    case 1:
                        new Video2();
                        Intent a = new Intent(getApplicationContext(),Video2.class);
                        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(a);
                        break;
                    case 2:
                        new Video3();
                        Intent b = new Intent(getApplicationContext(), Video3.class);
                        b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(b);
                        break;
                    case 3:
                        new Video4();
                        Intent c = new Intent(getApplicationContext(),Video4.class);
                        c.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(c);
                        break;
                    case 4:
                        new Video5();
                        Intent d = new Intent(getApplicationContext(),Video5.class);
                        d.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(d);
                        break;
                    case 5:
                        new Video6();
                        Intent e = new Intent(getApplicationContext(),Video6.class);
                        e.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(e);
                        break;
                    case 6:
                        new Video7();
                        Intent f = new Intent(getApplicationContext(),Video7.class);
                        f.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(f);
                        break;
                    case 7:
                        new Video8();
                        Intent g = new Intent(getApplicationContext(),Video8.class);
                        g.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(g);
                        break;
                    case 8:
                        new Video9();
                        Intent h = new Intent(getApplicationContext(), Video9.class);
                        h.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(h);
                        break;
                    case 9:
                        new Video10();
                        Intent j = new Intent(getApplicationContext(),Video10.class);
                        j.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(j);
                        break;
                    case 10:
                        new Video11();
                        Intent k = new Intent(getApplicationContext(), Video11.class);
                        k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(k);
                        break;
                    case 11:
                        new Video12();
                        Intent l = new Intent(getApplicationContext(), Video12.class);
                        l.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(l);
                        break;
                    case 12:
                        new Video13();
                        Intent m = new Intent(getApplicationContext(), Video13.class);
                        m.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(m);
                        break;
                    case 13:
                        new Video14();
                        Intent n = new Intent(getApplicationContext(), Video14.class);
                        n.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(n);
                        break;
                    case 14:
                        new Video15();
                        Intent o = new Intent(getApplicationContext(), Video15.class);
                        o.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(o);
                        break;
                    case 15:
                        new Video16();
                        Intent p = new Intent(getApplicationContext(), Video16.class);
                        p.  addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(p);
                        break;
                    case 16:
                        new Video17();
                        Intent q = new Intent(getApplicationContext(), Video17.class);
                        q.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(q);
                        break;
                    case 17:
                        new Video18();
                        Intent r = new Intent(getApplicationContext(), Video18.class);
                        r.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(r);
                        break;
                    case 18:
                        new Video19();
                        Intent s = new Intent(getApplicationContext(), Video19.class);
                        s.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(s);
                        break;
                    case 19:
                        new Video20();
                        Intent t = new Intent(getApplicationContext(), Video20.class);
                        t.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(t);
                        break;
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        return super.onOptionsItemSelected(item);

    }


}
