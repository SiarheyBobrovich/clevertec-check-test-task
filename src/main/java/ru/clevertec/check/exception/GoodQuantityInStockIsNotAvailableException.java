package main.java.ru.clevertec.check.exception;

public class GoodQuantityInStockIsNotAvailableException extends AbstractPrintableException {

    public GoodQuantityInStockIsNotAvailableException() {
        super(BAD_REQUEST);
    }
}
