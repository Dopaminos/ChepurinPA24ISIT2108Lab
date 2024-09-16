package tech.reliab.course.chepurinpa.bank.exception;

public class EmployeeNotFoundException extends Exception {
    private static final String DEFAULT_MESSAGE = "Не найден подходящий сотрудник.";

    public EmployeeNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public EmployeeNotFoundException(String message) {
        super(message);
    }
}