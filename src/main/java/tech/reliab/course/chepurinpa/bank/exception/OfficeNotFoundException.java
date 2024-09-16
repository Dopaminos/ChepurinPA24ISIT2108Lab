package tech.reliab.course.chepurinpa.bank.exception;

public class OfficeNotFoundException extends Exception {
    private static final String DEFAULT_MESSAGE = "Не найден подходящий офис.";

    public OfficeNotFoundException() { super(DEFAULT_MESSAGE); }

}