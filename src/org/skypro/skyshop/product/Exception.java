package org.skypro.skyshop.product;

public class Exception extends IllegalArgumentException {

    public Exception() {
        super();
    }

    @Override
    public String toString() {
        return "Exception - вы пытаетесь добавить продукт с некорректным значением поля";
    }


}



