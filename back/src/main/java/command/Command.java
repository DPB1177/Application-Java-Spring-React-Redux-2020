package command;

/**
 * The Command interface.
 * @param <T> return parameter.
 */
public interface Command<T> {
    T execute();
}
