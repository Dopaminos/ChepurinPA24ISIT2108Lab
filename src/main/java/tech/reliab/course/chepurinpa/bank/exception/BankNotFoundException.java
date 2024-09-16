package tech.reliab.course.chepurinpa.bank.exception;

public class BankNotFoundException extends Exception {
    private static final String DEFAULT_MESSAGE = "Не найден подходящий банк.";

    public BankNotFoundException() { super(DEFAULT_MESSAGE); }

}