package sg.edu.rp.c346.id18004536.mylocalbanks;

import androidx.annotation.MenuRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        tvUOB = findViewById(R.id.textViewUOB);

        registerForContextMenu(tvDBS);
        registerForContextMenu(tvOCBC);
        registerForContextMenu(tvUOB);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvDBS) {
            menu.add(0,0,0,"Website");
            menu.add(0,1,1,"Contact the bank");
            if()
        } else if (v == tvOCBC) {
            menu.add(0,2,0,"Website");
            menu.add(1,3,1,"Contact the bank");
        } else if (v == tvUOB) {
            menu.add(0,4,0,"Website");
            menu.add(2,5,1,"Contact the bank");
        }

    }



    public boolean onContextItemSelected(MenuItem item) {

        if(item.getItemId()==0){
            Intent gowebsite =new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
            startActivity(gowebsite);
            return true;
        }
        else if(item.getItemId()==1){
            String number = "18001111111";
            Intent call =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(call);
            return true;
        }
        else if(item.getItemId()==2) {
            Intent gowebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
            startActivity(gowebsite);
            return true;
        }
        else if(item.getItemId()==3 && item.getGroupId()==1){
            String number = "18003633333";
            Intent call =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(call);
            return true;
        }
        else if(item.getItemId()==4) {
            Intent gowebsite = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
            startActivity(gowebsite);
            return true;
        }
        else if(item.getItemId()==5 && item.getGroupId()==2){
            String number = "18002222121";
            Intent call =new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + number));
            startActivity(call);
            return true;
        }

        return super.onContextItemSelected(item);
    }




    //for menu language
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("关于我们");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);
    }


}
