package com.mobilemocap.ahmadriza.apik.Calculator;

import com.mobilemocap.ahmadriza.apik.Model.Human;

/**
 * Created by Ahmad Riza on 18/06/2017.
 */
/**
 * RUMUS-RUMUS
    Rumus untuk mengetahui BMR laki-laki = 66,4730 + (13,7516 x BB kg) + (5,0033 x TB cm) – (6,7550 x usia)
    Rumus untuk mengetahui BMR perempuan = 655,0955 + (9,5634 x BB kg) + (1,8496 x TB cm) – (4,6756 x usia)
    ringan = 1,3
    sedang = 1.5
    berat = 1.7
    kalori = BMR*aktivitas
 */

public class CalorieNeed extends Human{

    public CalorieNeed(int weight, int height, int age, char gender, String activ) {
        super(weight, height, age, gender, activ);
    }

    private double getBmr(){
        //menghitung basal metabolic rate
        if (gender=='L'){
            return 66.4730 + (13.7516 * weight) + (5.0033 * height) - (6.7550 * age);
        }else{
            return 655.0955 + (9.5634 * weight) + (1.8496 * height) - (4.6756 * age);
        }
    }

    public String getCalorieNeed(){
        double bmr = getBmr();
        double calorieNeed;
        String result ="0";

        if (activ.equals("ringan")){
            calorieNeed = 1.3 * bmr;
        }else if (activ.equals("sedang")){
            calorieNeed = 1.5 * bmr;
        }else{
            calorieNeed = 1.7 * bmr;
        }
        result = String.format("%.0f",calorieNeed);
        return result;
    }

    public String getBodyCategory(){
        double bbr = getBbr();
        if (bbr>100){
            //GEMUK
            return "Gemuk";
        }else if (bbr>=90){
            //NORMAL
            return "Normal";
        }else{
            //KURUS
            return "Kurus";
        }
    }

    private double getBbr(){
        //ini untuk mengetahui kategori tubuh
        return (weight/(height-100)*100);
    }
}
