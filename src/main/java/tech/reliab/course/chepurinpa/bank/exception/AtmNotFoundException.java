package tech.reliab.course.chepurinpa.bank.exception;

public class AtmNotFoundException extends Exception {
    private static final String DEFAULT_MESSAGE = "Не найден подходящий банкомат.";

    public AtmNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

}