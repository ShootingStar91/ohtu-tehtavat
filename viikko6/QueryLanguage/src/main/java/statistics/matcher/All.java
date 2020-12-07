
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Arttu Kangas
 */
public class All implements Matcher {
    
    @Override
    public boolean matches(Player p) {
        return true;
    }
}
