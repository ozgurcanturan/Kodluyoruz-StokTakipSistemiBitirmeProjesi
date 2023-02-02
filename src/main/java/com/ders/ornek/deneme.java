package com.ders.ornek;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Clock;
import java.time.LocalDate;
import java.util.Date;

public class deneme {
    public static void main(String[] args) {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        Date date = new Date();
        System.out.println(dateFormat.format(date));

    }
}
