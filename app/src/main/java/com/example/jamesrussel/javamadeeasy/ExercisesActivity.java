package com.example.jamesrussel.javamadeeasy;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


public class ExercisesActivity extends AppCompatActivity{
    ListView lv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercises);
        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Exercises");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lv = (ListView) findViewById(R.id.listview1);

        ExercisesAdapter adapter = new ExercisesAdapter(this);
        lv.setAdapter(adapter);


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int pos, long id) {
                switch (pos) {
                    case 0:
                        new Exercises1();
                        Intent i = new Intent(getApplicationContext(), Exercises1.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                        break;
                    case 1:
                        new Exercises2();
                        Intent a = new Intent(getApplicationContext(), Exercises2.class);
                        a.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(a);
                        break;
                    case 2:
                        new Exercises3();
                        Intent b = new Intent(getApplicationContext(), Exercises3.class);
                        b.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(b);
                        break;
                    case 3:
                        new Exercises4Activity();
                        Intent c = new Intent(getApplicationContext(), Exercises4Activity.class);
                        c.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(c);
                        break;
                    case 4:
                        new Exercises5Activity();
                        Intent d = new Intent(getApplicationContext(), Exercises5Activity.class);
                        d.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(d);
                        break;
                    case 5:
                        new Exercises6Activity();
                        Intent e = new Intent(getApplicationContext(), Exercises6Activity.class);
                        e.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(e);
                        break;
                    case 6:
                        new Exercises7Activity();
                        Intent f = new Intent(getApplicationContext(), Exercises7Activity.class);
                        f.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(f);
                        break;
                    case 7:
                        new Exercises8Activity();
                        Intent g = new Intent(getApplicationContext(), Exercises8Activity.class);
                        g.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(g);
                        break;
                    case 8:
                        new Exercises9Activity();
                        Intent h = new Intent(getApplicationContext(), Exercises9Activity.class);
                        h.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(h);
                        break;
                    case 9:
                        new Exercies10Activity();
                        Intent j = new Intent(getApplicationContext(), Exercies10Activity.class);
                        j.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(j);
                        break;
                    case 10:
                        new Exercises11Activity();
                        Intent k = new Intent(getApplicationContext(), Exercises11Activity.class);
                        k.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(k);
                        break;
                    case 11:
                        new Exercises12Activity();
                        Intent l = new Intent(getApplicationContext(), Exercises12Activity.class);
                        l.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(l);
                        break;
                    case 12:
                        new Exercises13Activity();
                        Intent m = new Intent(getApplicationContext(), Exercises13Activity.class);
                        m.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(m);
                        break;
                    case 13:
                        new Exercises14Activity();
                        Intent n = new Intent(getApplicationContext(), Exercises14Activity.class);
                        n.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(n);
                        break;
                    case 14:
                        new Exercises15Activity();
                        Intent o = new Intent(getApplicationContext(), Exercises15Activity.class);
                        o.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(o);
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