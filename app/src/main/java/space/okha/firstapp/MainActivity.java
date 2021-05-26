package space.lobanov.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonStart = (Button) findViewById(R.id.buttonStart);
        //нажимаем кнопку и происходит
        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              try { //переход на другой уровень
                  Intent intent = new Intent(MainActivity.this,GameLevels.class);
                  startActivity(intent);finish();
              }catch (Exception e){

               }
            }
        });

        //очистка окна от тайтл бара, который можно вытянуть пальцем
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//растягивают игру на весь экран
    }
}
    //системная кнопка начало
   // @Override
   // public void onBackPressed(){


   // if (backPressedTime + 2000>System.currentTimeMillis()){
    //    super.onBackPressed();
     //   return;
 //   }else {
   //     Toast.makeText(getBaseContext(),"Нажмите ещё раз, чтобы выйти",Toast.LENGTH_SHORT).show();

  //      backPressedTime = System.currentTimeMillis();
  //  }
    //системная кнопка конец
//}