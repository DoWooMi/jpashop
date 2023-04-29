package jpabook.jpashop.exception;

public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException() {
        super();
    }

    //메세지 넘겨줌
    public NotEnoughStockException(String message) {
        super(message);
    }

    //메세지 + 문제가 발생한 근원 exception 넘겨줌
    public NotEnoughStockException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEnoughStockException(Throwable cause) {
        super(cause);
    }
}
