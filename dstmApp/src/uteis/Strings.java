package br.com.leandersonandre.readings.app.uteis;

import java.util.Objects;

public class Strings {

    public static boolean isNullOrEmpty(String aString){
        return Objects.isNull(aString) || aString.isEmpty();
    }

}
