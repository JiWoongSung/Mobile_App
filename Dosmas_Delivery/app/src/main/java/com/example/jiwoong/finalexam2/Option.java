package com.example.jiwoong.finalexam2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Option extends AppCompatActivity {

    Button add,order;
    CheckBox c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14;
    int total=0;
    int money4,money5,money6,money7,money8,money9,money10,money11,money12,money13,money14=0;
    TextView totalmoney;
    DbHelper dbHelper = null;
    String menu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
        setTitle("옵션");



        dbHelper = new DbHelper(getApplicationContext(), "RECIPE.db", null, 2);
      //  dbHelper.deleteTable();
        c1=(CheckBox)findViewById(R.id.c1);
        c2=(CheckBox)findViewById(R.id.c2);
        c3=(CheckBox)findViewById(R.id.c3);
        c4=(CheckBox)findViewById(R.id.c4);
        c5=(CheckBox)findViewById(R.id.c5);
        c6=(CheckBox)findViewById(R.id.c6);
        c7=(CheckBox)findViewById(R.id.c7);
        c8=(CheckBox)findViewById(R.id.c8);
        c9=(CheckBox)findViewById(R.id.c9);
        c10=(CheckBox)findViewById(R.id.c10);
        c11=(CheckBox)findViewById(R.id.c11);
        c12=(CheckBox)findViewById(R.id.c12);
        c13=(CheckBox)findViewById(R.id.c13);
        c14=(CheckBox)findViewById(R.id.c14);
        totalmoney=(TextView)findViewById(R.id.totalmoney);
        add=(Button)findViewById(R.id.add);
        order=(Button)findViewById(R.id.Order);

        Intent intent = getIntent();
        menu = intent.getExtras().getString("menu");
        total = intent.getExtras().getInt("price");



        Log.i("haha","intent : " + menu);
        Log.i("haha","intent : " + total);

        totalmoney.setText(total+"원");





        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);


    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                // NavUtils.navigateUpFromSameTask(this);
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    };



    public void onClick(View v) {

        if(v.getId() == R.id.Order){
            Intent intent5 =  new Intent(Intent.ACTION_DIAL, Uri.parse("tel:031-409-6969"));
            startActivity(intent5);
        }
        if(v.getId()==R.id.basic) {

            Intent intentst = new Intent(this, MainActivity.class);
            startActivity(intentst);

        }

        if (v.getId() == R.id.c1) {
            c2.setChecked(false);
            c3.setChecked(false);
        }
        if (v.getId() == R.id.c2) {
            c1.setChecked(false);
            c3.setChecked(false);
        }
        if (v.getId() == R.id.c3) {
            c1.setChecked(false);
            c2.setChecked(false);
        }


        if (v.getId() == R.id.add) {
            List<String> subMenu = new ArrayList<String>();


            if (c1.isChecked() == false && c2.isChecked() == false && c3.isChecked() == false) {
                Toast.makeText(getApplicationContext(), "매운맛 정도를 체크해주세요", Toast.LENGTH_SHORT).show();
            } else {

               /* if(dbHelper.isAlreadyFavorite(menu)) {
                    //이미 같은 메뉴로 등록되어있을 경우
                    Log.i("haha", "isAlreadyFavorite");
                    Toast.makeText(getApplication(),"이미 같은 레시피가 있습니다",Toast.LENGTH_SHORT).show();
                }*/

                        Log.i("haha", "insert go");
                        if (c1.isChecked()) {
                            subMenu.add(c1.getText().toString());
                        }
                        if (c2.isChecked()) {
                            subMenu.add(c2.getText().toString());
                        }
                        if (c3.isChecked()) {
                            subMenu.add(c3.getText().toString());
                        }
                        if (c4.isChecked()) {
                            subMenu.add(c4.getText().toString());
                        }
                        if (c5.isChecked()) {
                            subMenu.add(c5.getText().toString());
                        }
                        if (c6.isChecked()) {
                            subMenu.add(c6.getText().toString());
                        }
                        if (c7.isChecked()) {
                            subMenu.add(c7.getText().toString());
                        }
                        if (c8.isChecked()) {
                            subMenu.add(c8.getText().toString());
                        }
                        if (c9.isChecked()) {
                            subMenu.add(c9.getText().toString());
                        }
                        if (c10.isChecked()) {
                            subMenu.add(c10.getText().toString());
                        }
                        if (c11.isChecked()) {
                            subMenu.add(c11.getText().toString());
                        }
                        if (c12.isChecked()) {
                            subMenu.add(c12.getText().toString());
                        }
                        if (c13.isChecked()) {
                            subMenu.add(c13.getText().toString());
                        }
                        if (c14.isChecked()) {
                            subMenu.add(c14.getText().toString());
                        }


                        int orderNum = dbHelper.getLastOrderNum() + 1;
                        Log.i("haha", "subMenu Size : " + subMenu.size());
                        for (String sMenu : subMenu) {

                            dbHelper.insert(orderNum, menu, sMenu);
                        }


                        Intent ListIntent = new Intent(this, MyRecipe.class);
                        startActivity(ListIntent);
                    }



        }


            if (v.getId() == R.id.c4) {
                if (money4 == 0) {
                    total = total + 500;
                    totalmoney.setText(total + "원");
                    money4++;
                } else if (money4 == 1) {
                    total = total - 500;
                    totalmoney.setText(total + "원");
                    money4--;
                }
            }
            if (v.getId() == R.id.c5) {
                if (money5 == 0) {
                    total = total + 500;
                    totalmoney.setText(total + "원");
                    money5++;
                } else if (money5 == 1) {
                    total = total - 500;
                    totalmoney.setText(total + "원");
                    money5--;
                }
            }
            if (v.getId() == R.id.c6) {
                if (money6 == 0) {
                    total = total + 500;
                    totalmoney.setText(total + "원");
                    money6++;
                } else if (money6 == 1) {
                    total = total - 500;
                    totalmoney.setText(total + "원");
                    money6--;
                }
            }
            if (v.getId() == R.id.c7) {
                if (money7 == 0) {
                    total = total + 500;
                    totalmoney.setText(total + "원");
                    money7++;
                } else if (money7 == 1) {
                    total = total - 500;
                    totalmoney.setText(total + "원");
                    money7--;
                }
            }
            if (v.getId() == R.id.c8) {
                if (money8 == 0) {
                    total = total + 500;
                    totalmoney.setText(total + "원");
                    money8++;
                } else if (money8 == 1) {
                    total = total - 500;
                    totalmoney.setText(total + "원");
                    money8--;
                }
            }
            if (v.getId() == R.id.c9) {
                if (money9 == 0) {
                    total = total + 500;
                    totalmoney.setText(total + "원");
                    money9++;
                } else if (money9 == 1) {
                    total = total - 500;
                    totalmoney.setText(total + "원");
                    money9--;
                }
            }
            if (v.getId() == R.id.c10) {
                if (money10 == 0) {
                    total = total + 500;
                    totalmoney.setText(total + "원");
                    money10++;
                } else if (money10 == 1) {
                    total = total - 500;
                    totalmoney.setText(total + "원");
                    money10--;
                }
            }
            if (v.getId() == R.id.c11) {
                if (money11 == 0) {
                    total = total + 1000;
                    totalmoney.setText(total + "원");
                    money11++;
                } else if (money11 == 1) {
                    total = total - 1000;
                    totalmoney.setText(total + "원");
                    money11--;
                }
            }
            if (v.getId() == R.id.c12) {
                if (money12 == 0) {
                    total = total + 1000;
                    totalmoney.setText(total + "원");
                    money12++;
                } else if (money12 == 1) {
                    total = total - 1000;
                    totalmoney.setText(total + "원");
                    money12--;
                }
            }
            if (v.getId() == R.id.c13) {
                if (money13 == 0) {
                    total = total + 1000;
                    totalmoney.setText(total + "원");
                    money13++;
                } else if (money13 == 1) {
                    total = total - 1000;
                    totalmoney.setText(total + "원");
                    money13--;
                }
            }
            if (v.getId() == R.id.c14) {
                if (money14 == 0) {
                    total = total + 1000;
                    totalmoney.setText(total + "원");
                    money14++;
                } else if (money14 == 1) {
                    total = total - 1000;
                    totalmoney.setText(total + "원");
                    money14--;
                }
            }





    }




}
