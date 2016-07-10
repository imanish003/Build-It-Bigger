package optimist.mechanic.hnmn3.build_it_bigger;

import android.content.Context;
import android.test.AndroidTestCase;

import org.mockito.Mock;

import java.util.List;
import java.util.concurrent.TimeUnit;

import Utils.AsyncTask_FetchJoke;

/**
 * Created by Manish Menaria on 10-Jul-16.
 */
public class MyAsyncTaskTest extends AndroidTestCase {
    AsyncTask_FetchJoke task;
    String result;
    @Mock
    Context mockContext;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        result = null;
        task = new AsyncTask_FetchJoke() {
        };
    }

    public void testAsyncReturnType() {

        try {

            //Default timeout for the GCM server is 20 seconds
            //If the .get can't get the result in 10 seconds, something is wrong anyway
            //Greater than 20 seconds results in an error string returned and requires further interpretation
            task.execute(mockContext);
            List<String> strings = task.get(10, TimeUnit.SECONDS);
            assertNotNull(strings);

        } catch (Exception e) {
            fail("Timed out");
        }
    }
}
