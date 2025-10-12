package Interfaces;

/**
 * @author Eran Shalev Hamdani
 * this interface notify when a hit accours.
 */
public interface HitNotifier {
    /**
     * Add hl as a listener to hit events.
     * @param hl hl.
     */
    void addHitListener(HitListener hl);

    /**
     * Remove hl from the list of listeners to hit events.
     * @param hl hl.
     */
    void removeHitListener(HitListener hl);
}