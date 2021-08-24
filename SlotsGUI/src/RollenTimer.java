import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Diese Klasse ist für die Animation der Rollen zuständig.
 *
 * @author Damian Grassi & Julian Wittmann
 * @version 1.0
 * @since 2020-07-10
 */
public class RollenTimer extends Timer {
    /**
     * Creates a {@code Timer} and initializes both the initial delay and
     * between-event delay to {@code delay} milliseconds. If {@code delay}
     * is less than or equal to zero, the timer fires as soon as it
     * is started. If <code>listener</code> is not <code>null</code>,
     * it's registered as an action listener on the timer.
     *
     * @param delay    milliseconds for the initial and between-event delay
     * @param listener an initial listener; can be <code>null</code>
     * @see #addActionListener
     * @see #setInitialDelay
     * @see #setRepeats
     */
    public RollenTimer(int delay, ActionListener listener) {
        super(delay, listener);
    }


}
