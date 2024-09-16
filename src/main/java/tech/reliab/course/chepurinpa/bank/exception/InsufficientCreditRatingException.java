package tech.reliab.course.chepurinpa.bank.exception;

public class InsufficientCreditRatingException extends Exception {
    private static final String DEFAULT_MESSAGE = "Кредитный рейтинг клиента слишком низкий для получения кредита.";

    public InsufficientCreditRatingException() {
        super(DEFAULT_MESSAGE);
    }

}