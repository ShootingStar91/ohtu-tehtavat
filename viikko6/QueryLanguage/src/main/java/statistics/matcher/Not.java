
package statistics.matcher;

import statistics.Player;

/**
 *
 * @author Arttu Kangas
 */
public class Not implements Matcher {
    Matcher matcher;
    public Not (Matcher matcher) {
        this.matcher = matcher;
    }
    
    @Override
    public boolean matches(Player player) {
        return !matcher.matches(player);
    }
}
