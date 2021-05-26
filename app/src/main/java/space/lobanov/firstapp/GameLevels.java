package space.lobanov.firstapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GameLevels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gamelevels);

        //объявляем переменную level
        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
        final int level = save.getInt("Level",1);

        //очистка окна от тайтл бара, который можно вытянуть пальцем
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button_back = (Button)findViewById(R.id.button_back);
        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//здесь будет команда
                try {
                    Intent intent = new Intent(GameLevels.this,MainActivity.class);
                    startActivity(intent);finish(); //переключиться на новую страницу и закрыть старую

                }catch (Exception e){
                }
            }
        });

        //кнопка для перехода на первый уровень начало
        TextView textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {
              if(level>=1){
                  Intent intent = new Intent(GameLevels.this, Level1.class);
                  startActivity(intent);
                  finish();
              }else {

              }

             }catch (Exception e){
            }}
        });
        //кнопка для перехода на первый уровень конец

        //кнопка для перехода на  второй уровень начало
        TextView textView2 = (TextView)findViewById(R.id.textView2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=2) {
                        Intent intent = new Intent(GameLevels.this, Level2.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){
                }}
        });
        //кнопка для перехода на второй уровень конец

        //кнопка для перехода на  третий уровень начало
        TextView textView3 = (TextView)findViewById(R.id.textView3);
        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=3) {
                        Intent intent = new Intent(GameLevels.this, Level3.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){
                }}
        });
        //кнопка для перехода на третий уровень конец

        //кнопка для перехода на  4 уровень начало
        TextView textView4 = (TextView)findViewById(R.id.textView4);
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    if (level>=3) {
                        Intent intent = new Intent(GameLevels.this, Level4.class);
                        startActivity(intent);
                        finish();
                    }else {

                    }
                }catch (Exception e){
                }}
        });
        //кнопка для перехода на 4 уровень конец

        //массив для того, чтобы цифры в кнопках прописывались
        final int []x={
          R.id.textView1,
          R.id.textView2,
          R.id.textView3,
          R.id.textView4,
          R.id.textView5,
          R.id.textView6,
          R.id.textView7,
          R.id.textView8,
          R.id.textView9,
          R.id.textView10,
          R.id.textView11,
          R.id.textView12,
          R.id.textView13,
          R.id.textView14,
          R.id.textView15,
          R.id.textView16,
          R.id.textView17,
          R.id.textView18,
          R.id.textView19,
          R.id.textView20,
          R.id.textView21,
          R.id.textView22,
          R.id.textView23,
          R.id.textView24,
          R.id.textView25,
          R.id.textView26,
          R.id.textView27,
          R.id.textView28,
          R.id.textView29,
          R.id.textView30,
        };
        //цикл. который будет расставлять цифры по порядку
        for(int i=1;i<level;i++){
            TextView tv = findViewById(x[i]);
            tv.setText(""+(i+1));
        }
    }
        //системная кнопка назад-начало (будет работать только на этой странице)

        //системная кнопка назад-конец

}
