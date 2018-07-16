package ranger.one;

/**
 * proxy class
 */
public class DBQueryProxy implements  IDBQuery {
    private IDBQuery query;

    @Override
    public String request() {
        if (query == null) {
            query = new DBQuery();
        }
        return query.request();
    }
}
