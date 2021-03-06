/*======================================================================*
 * Copyright (c) 2010, Frank Maritato All rights reserved.              *
 *                                                                      *
 * Licensed under the New BSD License (the "License"); you may not use  *
 * this file except in compliance with the License.  Unless required    *
 * by applicable law or agreed to in writing, software distributed      *
 * under the License is distributed on an "AS IS" BASIS, WITHOUT        *
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.     *
 * See the License for the specific language governing permissions and  *
 * limitations under the License. See accompanying LICENSE file.        *
 *======================================================================*/

package org.lwes.db;
/**
 * @author fmaritato
 */

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.lwes.AttributeRequiredException;
import org.lwes.Event;
import org.lwes.EventSystemException;
import org.lwes.ValidationExceptions;

import java.io.File;
import java.util.Enumeration;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class RequiredTest {

    private static transient Log log = LogFactory.getLog(RequiredTest.class);

    private static final String ESF = "src/test/java/org/lwes/db/RequiredTest.esf";
    private static final String TEST_EVENT = "TestEvent";

    @Test
    public void testRequired() throws EventSystemException {
        EventTemplateDB template = new EventTemplateDB();
        template.setESFFile(new File(ESF));
        assertTrue("Template did not initialize", template.initialize());
        Enumeration<String> eventNames = template.getEventNames();
        assertNotNull("Event names enum was null", eventNames);

        assertTrue("TestEvent was not known to the template",
                   template.checkForEvent(TEST_EVENT));

        assertTrue("field1 attribute not known to the template",
                   template.checkForAttribute(TEST_EVENT, "field1"));

        boolean exceptionThrown = false;

        // Verify that an exception is thrown when a required field is not present.
        Event evt = new Event("TestEvent", true, template);
        try {
            evt.validate();
        }
        catch (ValidationExceptions e) {
            if (log.isDebugEnabled()) {
                log.debug(e.getMessage());
            }
            exceptionThrown = true;
            List<EventSystemException> exceps = e.getAllExceptions();
            assertEquals("number of exceptions", 1, exceps.size());
            for (EventSystemException ex : exceps) {
                assertEquals("Exception type", AttributeRequiredException.class, ex.getClass());
            }
        }
        assertTrue(exceptionThrown);

        exceptionThrown = false;
        // Verify no exception when all required fields are set.
        evt.setString("field1", "value");
        if (log.isDebugEnabled()) {
            log.debug(evt.toString());
        }
        try {
            evt.validate();
        }
        catch (EventSystemException e) {
            if (log.isDebugEnabled()) {
                log.debug(e.getMessage());
            }
            exceptionThrown = true;
        }
        assertFalse(exceptionThrown);

    }
}
