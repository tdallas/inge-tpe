package com.ingeapp.util;


import com.ingeapp.view.activity.IngeActivity;

import java.util.Date;

/**
 * here goes the commonUtils methods that many clases may use
 */

public class CommonUtils {
    //I should ask for needed permissions here
    public static void verificoYPidoPermisos(IngeActivity ingeActivity) {
    }

    public static String getFechaValida(Date date) {
        String dateString = date.getDay() + "/" + date.getMonth() + "/2018" + " " +
                date.getHours()+":" +date.getMinutes();
        return dateString;
    }
}
