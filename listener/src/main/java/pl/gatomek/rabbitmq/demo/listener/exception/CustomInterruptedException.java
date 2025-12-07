package pl.gatomek.rabbitmq.demo.listener.exception;

/**
 * Exception thrown to indicate that message processing has been intentionally interrupted.
 * <p>
 * This exception is used as part of the control mechanism for message processing,
 * allowing handlers to signal that processing should be stopped or interrupted
 * under specific conditions (e.g., when a message cannot be processed further).
 * </p>
 */

public class CustomInterruptedException extends RuntimeException {
}
