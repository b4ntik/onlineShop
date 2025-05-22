package org.skypro.skyshop.product;

import java.lang.Exception;

public class BestResultNotFound extends Exception {

    public BestResultNotFound() {
        super();
    }

    @Override
    public String toString() {
        return "Exception - ничего не найдено";
    }
}
