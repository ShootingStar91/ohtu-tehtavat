
package statistics;

import java.util.ArrayList;
import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Not;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

/**
 *
 * @author Arttu Kangas
 */
public class QueryBuilder {
    ArrayList<Matcher> matchers;
    public QueryBuilder() {
        matchers = new ArrayList<>();
    }
    
    public Matcher build() {
        Matcher[] matcherArray = new Matcher[matchers.size()];
        for (int i = 0; i < matchers.size(); i++) {
            matcherArray[i] = matchers.get(i);
        }
       return new And(matcherArray);
    }
    
    public QueryBuilder hasAtLeast(int value, String category) {
        matchers.add(new HasAtLeast(value, category));
        return this;
    }
    
    public QueryBuilder hasFewerThan(int value, String category) {
        matchers.add(new HasFewerThan(value, category));
        return this;
    }
    
    public QueryBuilder and(Matcher... matchers) {
        this.matchers.add(new And(matchers));
        return this;
    }
    
    public QueryBuilder not(Matcher matcher) {
        this.matchers.add(new Not(matcher));
        return this;
    }
    
    public QueryBuilder or(Matcher... matchers) {
        this.matchers.add(new Or(matchers));
        return this;
    }
    
    public QueryBuilder playsIn(String team) {
        matchers.add(new PlaysIn(team));
        return this;
    }
    
    
    
    
    
}
