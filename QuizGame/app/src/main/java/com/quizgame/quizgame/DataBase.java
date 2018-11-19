package com.quizgame.quizgame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class DataBase {
    private ArrayList countries;
    int next =0;
    public DataBase() {
        this.countries = new ArrayList(){{
            add(new Country(R.drawable.ar,"ARGENTYNA"));
            add(new Country(R.drawable.at,"AUSTRIA"));
            add(new Country(R.drawable.ad,"ANDORA"));
            add(new Country(R.drawable.af,"AFGANISTAN"));
            add(new Country(R.drawable.ag,"ANTIGUA"));
            add(new Country(R.drawable.ai,"ANGUILLA"));
            add(new Country(R.drawable.al,"ALBANIA"));
            add(new Country(R.drawable.am,"ARMENIA"));
            add(new Country(R.drawable.ao,"ANGOLA"));
            add(new Country(R.drawable.aq,"ANTARKTYDA"));
            add(new Country(R.drawable.as,"SAMOA"));
            add(new Country(R.drawable.au,"AUSTRALIA"));
            add(new Country(R.drawable.aw,"ARUBA"));
            add(new Country(R.drawable.az,"AZERBEJDŻAN"));
            add(new Country(R.drawable.bb,"BARBADOS"));
            add(new Country(R.drawable.bd,"BANGLADESZ"));
            add(new Country(R.drawable.bg,"BULGARIA"));
            add(new Country(R.drawable.bh,"BAHRAJN"));
            add(new Country(R.drawable.bi,"BURUNDI"));



        }};
    }
    public Country getCountry(){
        Random random = new Random();
        int x = random.nextInt(countries.size());
        return (Country)countries.remove(x);

    }
}
