package space.lobanov.firstapp;

import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level2 extends AppCompatActivity {

    //вызываем диалоговое окно
    Dialog dialog;
    Dialog dialogEnd;

    public int numLeft; //переменная для левой картинки
    public int numRight; //переменная для правой картинки
    Array array = new Array();//создали новый объект из класса Array
    Random random = new Random();//для генерации случайных чисел
    public int count = 0;//счетчик правильных ответов


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);
        //создаём переменную text_levels
        TextView textView = findViewById(R.id.text_levels);//установили текст

        //сообщаем о том, что разместили картинку с именем img_left
        final ImageView img_left = (ImageView)findViewById(R.id.img_left);
        //скругляем углы у левой картинки
        img_left.setClipToOutline(true);
        //сообщаем о том, что разместили картинку с именем img_right
        final ImageView img_right = (ImageView)findViewById(R.id.img_right);
        //скругляем углы у правой картинки
        img_right.setClipToOutline(true);

        //путь к левой TextView
        final TextView  text_left =findViewById(R.id.text_left);
        //путь к правой TextView
        final TextView text_right = findViewById(R.id.text_right);

        //развернуть игру на весь экран начало
        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        //развернуть игру на весь экран конец

        //вызов диалогового окга в начале игры
        dialog = new Dialog(this);//создаем новое диалоговое окно
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialog.setContentView(R.layout.previewdialog);//путь к макету диалогового окна
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialog.setCancelable(false);//окно нельзя закрыть кнопкой назад

        //Устанавливаем картинку в диалоговое окно начало
        ImageView previewimg = (ImageView) dialog.findViewById(R.id.previewimg);
        previewimg.setImageResource(R.drawable.previewimg);
        //Устанавливаем картинку в диалоговое окно конец

        //устанавливаем описание задания начало
        TextView textdescription = (TextView) dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.leveltwo);
        //устанавливаем описание задания конец


        //кнопка которая закрывает диалоговое окно начало
        TextView btnClose = (TextView) dialog.findViewById(R.id.btnclose);
        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки начало
                try {
                 //вернуться назад к выбору уровня начало
                    Intent intent= new Intent(Level2.this,GameLevels.class);//создали намерение для перехода
                    startActivity(intent);//запустили намерение
                    finish();//закрыть класс
                    //вернуться назад к выбору уровня конец
                }catch (Exception e){

                }
                dialog.dismiss();//закрываем диалоговое окно
                //обрабатываем нажатие кнопки конец
            }
        });
        //кнопка которая закрывает диалоговое окно конец

        //кнопка продолжить начало
        Button btncontinue =(Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();//закрываем диалоговое окно
            }
        });
        //кнопка продолжить конец

        dialog.show();//показываем диалоговое окно

        //---------------------
        //вызов диалогового окна в конце игры

        dialogEnd = new Dialog(this);//создаем новое диалоговое окно
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);//скрываем заголовок
        dialogEnd.setContentView(R.layout.dialogend);//путь к макету диалогового окна
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));//прозрачный фон диалогового окна
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.MATCH_PARENT);//разворачивает окно на весь экран
        dialogEnd.setCancelable(false);//окно нельзя закрыть кнопкой назад

        //интересный факт начало
        TextView textdescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.leveltwoEnd);
        //интересный факт конец

        //кнопка которая закрывает диалоговое окно начало
        TextView btnClose2 = (TextView) dialogEnd.findViewById(R.id.btnclose);
        btnClose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Обрабатываем нажатие кнопки начало
                try {
                    //вернуться назад к выбору уровня начало
                    Intent intent= new Intent(Level2.this,GameLevels.class);//создали намерение для перехода
                    startActivity(intent);//запустили намерение
                    finish();//закрыть класс
                    //вернуться назад к выбору уровня конец
                }catch (Exception e){

                }
                dialogEnd.dismiss();//закрываем диалоговое окно
                //обрабатываем нажатие кнопки конец
            }
        });
        //кнопка которая закрывает диалоговое окно конец

        //кнопка продолжить начало
        Button btncontinue2 =(Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    Intent intent = new Intent(Level2.this, Level3.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

                dialogEnd.dismiss();//закрываем диалоговое окно
            }
        });
        //кнопка продолжить конец

        //---------------------

        //Кнопака "назад" начало
        Button btn_back = (Button)findViewById(R.id.button_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //обрабатываем нажатие кнопки -начало
                try {
            //вернуться назад к выбору уровня начало
                    Intent intent = new Intent(Level2.this,GameLevels.class); //создали намерение для перехода
                    startActivity(intent);//старт намерения
                    finish();//закрыть этот класс
            //вернуться назад к выбору уровня крнец
                }catch (Exception e){

                }
                //обрабатываем нажатие кнопки -конец
            }
        });
        //Кнопка назад-конец

        //массив для прогресса игры начало
        final int [] progress = {
                R.id.point1, R.id.point2, R.id.point3,
                R.id.point4, R.id.point5, R.id.point6,
                R.id.point7, R.id.point8, R.id.point9,
                R.id.point10, R.id.point11, R.id.point12,
                R.id.point13, R.id.point14, R.id.point15,
                R.id.point16, R.id.point17, R.id.point18,
                R.id.point19, R.id.point20,
        };
        //массив для прогресса игры конец

        //Поключаем анимацию начало
        final Animation animation = AnimationUtils.loadAnimation(Level2.this,R.anim.alpha);
        //Поключаем анимацию конец

        numLeft = random.nextInt(10);//генерирум случайное число от 0 до 9
        img_left.setImageResource(array.images2[numLeft]);//достаем из массива картинку
        text_left.setText(array.texts2[numLeft]);//достаем из массива текст

        numRight = random.nextInt(10);//генерируем случайное число от 0-9

        //цикл с предусловием, проверяющие равенство чисел начало
        while (numLeft==numRight){
            numRight = random.nextInt(10);
        }
        //цикл с предусловием, проверяющие равенство чисел конец

         img_right.setImageResource(array.images2[numRight]);//достаем из массива картинку
         text_right.setText(array.texts2[numRight]);//достаем из массива текст

        //обрабатываем нажатие на левую картинку начало
        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                 //если коснулся картинки начало
                    img_right.setEnabled(false);//блокируем правую картинку
                    if (numLeft>numRight) {
                        img_left.setImageResource(R.drawable.true_otv);
                    } else{
                       img_left.setImageResource(R.drawable.false_otv);
                    }
                    //если коснулся картинки конец
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                  //если отпустил палец начало
                    if (numLeft>numRight){
                        //если левая картинка больше
                        if (count<20){
                            count=count+1;
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i =0;i<20;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец

                        //определяем правильные ответы и закрашиваем зеленым цветом начало
                           for (int i=0;i<count;i++){
                               TextView tv = findViewById(progress[i]);
                               tv.setBackgroundResource(R.drawable.style_points_green);
                           }
                        //определяем правильные ответы и закрашиваем зеленым цветом конец
                    }else{
                        //если левая картинка меньше
                        if (count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count= count-2;
                            }
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i =0;i<19;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец

                        //определяем правильные ответы и закрашиваем зеленым цветом начало
                        for (int i=0;i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым цветом конец
                    }
                    //если отпустил палец конец
                    if (count==20){
                        //ВЫХОД ИЗ УРОВНЯ

                        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                        final int level = save.getInt("Level",1);
                        if(level >2 ){

                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",3);
                            editor.commit();
                        }
                        dialogEnd.show();

                    }else {
                        numLeft = random.nextInt(10);//генерирум случайное число от 0 до 9
                        img_left.setImageResource(array.images2[numLeft]);//достаем из массива картинку
                        img_left.startAnimation(animation);
                        text_left.setText(array.texts2[numLeft]);//достаем из массива текст

                        numRight = random.nextInt(10);//генерируем случайное число от 0-9

                        //цикл с предусловием, проверяющие равенство чисел начало
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        //цикл с предусловием, проверяющие равенство чисел конец

                        img_right.setImageResource(array.images2[numRight]);//достаем из массива картинку
                        img_right.startAnimation(animation);
                        text_right.setText(array.texts2[numRight]);//достаем из массива текст

                        img_right.setEnabled(true);//включаем вновь правую картинку
                    }
                }
                //условие касания картинки конец
                return true;
            }
        });
        //обрабатываем нажатие на левую картинку конец

        //обрабатываем нажатие на правую картинку начало
        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //условие касания картинки начало
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    //если коснулся картинки начало
                    img_left.setEnabled(false);//блокируем левую картинку
                    if (numLeft<numRight) {
                        img_right.setImageResource(R.drawable.true_otv);
                    } else{
                        img_right.setImageResource(R.drawable.false_otv);
                    }
                    //если коснулся картинки конец
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    //если отпустил палец начало
                    if (numLeft<numRight){
                        //если правая картинка больше
                        if (count<20){
                            count=count+1;
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i =0;i<20;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец

                        //определяем правильные ответы и закрашиваем зеленым цветом начало
                        for (int i=0;i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым цветом конец
                    }else{
                        //если правая картинка меньше
                        if (count>0){
                            if(count==1){
                                count=0;
                            }else{
                                count= count-2;
                            }
                        }
                        //закрашиваем прогресс серым цветом начало
                        for (int i =0;i<19;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        //закрашиваем прогресс серым цветом конец

                        //определяем правильные ответы и закрашиваем зеленым цветом начало
                        for (int i=0;i<count;i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                        //определяем правильные ответы и закрашиваем зеленым цветом конец
                    }
                    //если отпустил палец конец
                    if (count==20){
                        //ВЫХОД ИЗ УРОВНЯ
                        SharedPreferences save = getSharedPreferences("Save",MODE_PRIVATE);
                        final int level = save.getInt("Level",1);
                        if(level >2 ){

                        }else {
                            SharedPreferences.Editor editor = save.edit();
                            editor.putInt("Level",3);
                            editor.commit();
                        }

                        dialogEnd.show();

                    }else {
                        numLeft = random.nextInt(10);//генерирум случайное число от 0 до 9
                        img_left.setImageResource(array.images2[numLeft]);//достаем из массива картинку
                        img_left.startAnimation(animation);
                        text_left.setText(array.texts2[numLeft]);//достаем из массива текст

                        numRight = random.nextInt(10);//генерируем случайное число от 0-9

                        //цикл с предусловием, проверяющие равенство чисел начало
                        while (numLeft==numRight){
                            numRight = random.nextInt(10);
                        }
                        //цикл с предусловием, проверяющие равенство чисел конец

                        img_right.setImageResource(array.images2[numRight]);//достаем из массива картинку
                        img_right.startAnimation(animation);
                        text_right.setText(array.texts2[numRight]);//достаем из массива текст

                        img_left.setEnabled(true);//включаем вновь ЛЕВУЮ картинку
                    }
                }
                //условие касания картинки конец
                return true;
            }
        });
        //обрабатываем нажатие на правую картинку конец
    }
    //системная кнопка начало
    @Override
    public void onBackPressed () {
        //обрабатываем нажатие кнопки -начало
        try {
            //вернуться назад к выбору уровня начало
            Intent intent = new Intent(Level2.this,GameLevels.class); //создали намерение для перехода
            startActivity(intent);//старт намерения
            finish();//закрыть этот класс
            //вернуться назад к выбору уровня крнец
        }catch (Exception e){

        }
        //обрабатываем нажатие кнопки -конец
    }
    //ситсемная кнопка конец
}