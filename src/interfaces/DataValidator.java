package interfaces;

interface DataValidator<T> {
    boolean isValid(T data);
}