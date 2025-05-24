package org.skypro.skyshop.product;

import java.lang.Exception;

public class BestResultNotFound extends Exception {
    //string
    public BestResultNotFound(String textException) {
        super(textException);
        //this.textException = textException;
    }

    @Override
    public String toString() {
        return "Exception - ничего не найдено";
    }

}
