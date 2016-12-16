package com.example.jianhuayang.mysqlite;

import android.support.test.InstrumentationRegistry;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by jianhuayang on 13/12/2016.
 */

//@RunWith(AndroidJUnit4.class)
public class DbTest {

    @Test
    public void testDatabase() throws Exception {

        Contact contact = new Contact(10, "name", "phone");
        DatabaseHandler databaseHandler = new DatabaseHandler(InstrumentationRegistry.getInstrumentation().getTargetContext());
        int oldCount = databaseHandler.getWritableDatabase().rawQuery("SELECT  * FROM contactTable", null).getCount();
        databaseHandler.addContact(contact);

        int newCount = databaseHandler.getWritableDatabase().rawQuery("SELECT  * FROM contactTable", null).getCount();

        assertEquals(oldCount +1 , newCount);
    }
}
