package com.juaracoding.cucumber.utils;


/*
IntelliJ IDEA 2024.3.5 (Community Edition)
Build #IC-243.26053.27, built on March 16, 2025
@Author 2024 a.k.a. Wirawan Rio Renaldi
Java Developer
Created on 4/15/2025 9:24 AM
@Last Modified 4/15/2025 9:24 AM
Version 1.0
*/

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    public static String getTodayDateFolder() {
        return new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    }

    public static String getTimestamp() {
        return new SimpleDateFormat("ddMMyyyyHHmmss").format(new Date());
    }

}
