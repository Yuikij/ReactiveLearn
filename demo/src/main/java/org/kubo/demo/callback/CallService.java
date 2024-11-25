package org.kubo.demo.callback;

public class CallService {
    public void call(Callable callable) {
        callable.call();
    }

    public static void main(String[] args) {
        CallService callService = new CallService();
        callService.call(() -> System.out.println("callback"));
    }
}
