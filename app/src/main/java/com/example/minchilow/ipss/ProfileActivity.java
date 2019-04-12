package com.example.minchilow.ipss;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Locale;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth firebaseAuth;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    String str1, str2, str3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //Toast.makeText(this,""+ (getResources().getConfiguration().locale).toString(),Toast.LENGTH_LONG).show();
        checkLanguage();

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        NavigationView nvDrawer = (NavigationView) findViewById(R.id.nv);
        setupDrawerContent(nvDrawer);
        getSupportFragmentManager().beginTransaction().replace(R.id.content,new fragment1()).commit();

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() == null) {
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        FirebaseUser user = firebaseAuth.getCurrentUser();

        View header = nvDrawer.getHeaderView(0);
        TextView tv_name = (TextView) header.findViewById(R.id.tv_username);
        tv_name.setText(user.getEmail());

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToggle.onOptionsItemSelected(item)) { return true; }

        switch (item.getItemId()){
            case R.id.mlanguage:
                showChangeLanguageWarning();
                return true;
            case R.id.logout:
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(this, SplashScreen.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void selectItemDrawer (MenuItem menuItem) {
        android.support.v4.app.Fragment myFragment = null;
        Class fragmentClass;
        switch (menuItem.getItemId()) {
            case R.id.obj1:
                fragmentClass = fragment1.class;
                break;
            case R.id.obj2:
                fragmentClass = fragment2.class;
                break;
            case R.id.obj3:
                fragmentClass = fragment3.class;
                break;
            default:
                fragmentClass = fragment1.class;
        }
        try {
            myFragment = (android.support.v4.app.Fragment) fragmentClass.newInstance();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content,myFragment).commit();
        menuItem.setChecked(true);
        setTitle(menuItem.getTitle());
        if (menuItem.getTitle().toString().equals("Homepage") || menuItem.getTitle().toString().equals("主页") || menuItem.getTitle().toString().equals("Laman Utama") ) {
            setTitle("IPSS");
        }
        mDrawerLayout.closeDrawers();
    }

    private void setupDrawerContent (NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                selectItemDrawer(item);
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);

        return true;
    }

    private void showChangeLanguageDialog() {
        final String[] listItems = {"English", "中文", "Malay"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProfileActivity.this);
        mBuilder.setTitle(str1);
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0){
                    setLocale("en_US");
                    recreate();
                }
                if (i == 1){
                    setLocale("zh");
                    recreate();
                }
                if (i == 2){
                    setLocale("ms");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void showChangeLanguageWarning() {
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(ProfileActivity.this);
        mBuilder.setTitle(str2);
        mBuilder.setMessage(str3);

        mBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                showChangeLanguageDialog();
            }
        });

        mBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My_Lang", lang);
        editor.apply();
    }

    public void loadLocale() {
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My_Lang", "");
        setLocale(language);
    }

    public void checkLanguage(){
        if (((getResources().getConfiguration().locale).toString()).equals("en_US") || ((getResources().getConfiguration().locale).toString()).equals("en_us")){
            str1 = "Choose Language";
            str2 = "Warning";
            str3 = "Changing language will cause you back to homepage. Are you sure want to change it ?";
        }
        else if (((getResources().getConfiguration().locale).toString()).equals("zh")){
            str1 = "选择语言";
            str2 = "警告";
            str3 = "改变语言会让你回到主页，你确定要改变它吗？";
        }
        else if (((getResources().getConfiguration().locale).toString()).equals("ms")){
            str1 = "Pilih Bahasa";
            str2 = "Amaran";
            str3 = "Mengubah bahasa akan menyebabkan anda kembali ke laman utama. Adakah anda pasti ingin mengubahnya?";
        }
    }

}