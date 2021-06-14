package identifier;

import models.tree.DataTree;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Identifier.
 */
public final class IdentifierLong {
    private IdentifierLong() {
        throw new IllegalStateException("IdentifierLong class");
    }

    private static AtomicLong idCounter = new AtomicLong();

    public static String createID() {
        return String.valueOf(idCounter.getAndIncrement());
    }

    public static long createLongID() {
        return idCounter.getAndIncrement();
    }
    public static AtomicLong getLongID() {
        return idCounter;
    }

    public static void newValueLongID(long value) {
        idCounter = new AtomicLong(value);
        idCounter.getAndIncrement();
    }

    public static void setValueLongID(long value) {
        idCounter = new AtomicLong(value);
    }

    public static long getLastIDFromTree(DataTree tree) {
        if (tree == null) {
            return 0;
        } else {
            return tree.amountNodes();
        }
    }

}
