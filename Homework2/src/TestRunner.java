import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CollectionAdapterTest.class, ListAdapterTest.class, MapAdapterTest.class, SetAdapterTest.class })
public class TestRunner {

}
