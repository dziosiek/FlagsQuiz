package com.quizgame.quizgame;

import android.content.Context;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class GameEngine{
    protected NewGame game;
    protected int score = 0;
    protected DataBase dataBase;
    protected ImageView countryFlag;
    protected  TextView countryName, currentCharacter,numOfTries;
    protected  Characters characters;
    protected  ImageButton leftArray, rightArray;
    protected CurrentRound currentRound;
    public GameEngine(ImageView countryFlag,TextView countryName, ImageButton leftArray, ImageButton rightArray,
                      TextView currentCharacter, TextView numOfTries,NewGame game) {
        this.game = game;
        this.numOfTries = numOfTries;
        this.countryFlag = countryFlag;
        this.countryName = countryName;
        this.dataBase = new DataBase();
        this.leftArray = leftArray;
        this.rightArray = rightArray;
        this.currentCharacter = currentCharacter;
        this.characters = new Characters() {
            ListIterator iterator = CHARACTERS.listIterator();
            char c;
            {
                next();
            }


            @Override
            public void prev() {
                Log.w("myApp", "prev function");
                if(iterator.hasPrevious()){
                    Log.w("myApp", "hasPrevious=true");
                    c = (char)iterator.previous();
                    Log.w("myApp","c:"+c);
                    set();

                }

            }

            @Override
            public void next() {
                Log.w("myApp", "next function");
                if(iterator.hasNext()) {
                    Log.w("myApp", "hasNext=true");
                    c = (char)iterator.next();
                    Log.w("myApp","c:"+c);
                    set();
                }

            }

            @Override
            public char get() {
                return c;
            }


            @Override
            public void set() {
                GameEngine.this.currentCharacter.setText(String.valueOf(c));

            }
        };
        currentRound = new CurrentRound() {
            char[] emptyTextBox;
            int numOfTries = 3;
            String text;
            @Override
            public void init(String text) {

                this.text = text;
                Log.w("MyApp", "textName:"+text);

                emptyTextBox = new char[this.text.length()];
                Log.w("MyApp", "EmptyTextBox:"+emptyTextBox.length);
                Arrays.fill(emptyTextBox,'_');
                this.fill();

            }

            @Override
            public void fill() {
                StringBuilder stringBuilder = new StringBuilder();

                for (char c:emptyTextBox) {
                    stringBuilder.append(String.valueOf(c+" "));

                }

                GameEngine.this.countryName.setText(stringBuilder);
                if(numOfTries>0){
                    String showNumOfTries = "Liczba prób:"+numOfTries;
                    GameEngine.this.numOfTries.setText(showNumOfTries);

                }
                else{
                    String end = "Koniec gry";
                    GameEngine.this.numOfTries.setText(end);
                    GameEngine.this.game.gameOver(score);



                }
            }

            @Override
            public boolean check() {
                boolean soundFlag=true;
                Log.w("myApp", "check function");
                int index = this.text.indexOf(characters.get());
                if(index==-1){
                    numOfTries--;
                    soundFlag=false;
                }


                while (index >=0){
                    this.emptyTextBox[index] = characters.get();
                    Log.w("myApp", "index:"+index);
                    index = this.text.indexOf(characters.get(), index+1);
                }
                this.fill();
                if(String.valueOf(emptyTextBox).equals(text)){
                    score++;
                    numOfTries=3;
                    getCountry();
                }
                return soundFlag;
            }
        };
        this.getCountry();
    }
    void getCountry(){
        Country country= dataBase.getCountry();
        countryFlag.setImageResource(country.getId());
        this.currentRound.init(country.getName());

    }
    boolean letter(String action){
        Log.w("myApp", "letter function");
        if(action.equals("left")){
            Log.w("myApp", "left");
            this.characters.prev();
        }
        else if(action.equals("right")){
            Log.w("myApp", "right");
            this.characters.next();
        }
        else if(action.equals("check")) return this.currentRound.check();
        return false;
    }
}
