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

package org.lwes.emitter;
/**
 * @author fmaritato
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.lwes.Event;
import org.lwes.EventSystemException;
import org.lwes.db.EventTemplateDB;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class MulticastEventEmitterTest {

    @Test
    public void testMulticastEmitter() throws Exception {
        MockMulticastEventEmitter emitter = new MockMulticastEventEmitter();
        emitter.setEmitHeartbeat(true);
        emitter.setFrequency(1000l);
        emitter.setMulticastAddress(InetAddress.getByName("224.0.0.69"));
        emitter.setMulticastPort(9191);

        emitter.initialize();
        emitter.emit(createTestEvent());
        Thread.sleep(1000);
        emitter.emit(createTestEvent());
        emitter.emit(createTestEvent());
        emitter.emit(createTestEvent());
        Thread.sleep(1000);
        emitter.emit(createTestEvent());
        emitter.shutdown();

        List<Event> events = emitter.getEvents();
        assertNotNull(events);

        for (int i = 0; i < events.size(); i++) {
            Event e = events.get(i);
            if (i == 0) {
                assertEquals("First event was not startup.",
                             "System::Startup", e.getEventName());
            }
            else if (i == events.size() - 1) {
                assertEquals("Second to last event was not shutdown",
                             "System::Shutdown", e.getEventName());
                Long l = e.getInt64("count");
                assertNotNull(l);
                assertEquals("Shutdown count was incorrect", 0L, l.longValue());
                l = e.getInt64("total");
                assertNotNull(l);
                assertEquals("Shutdown total was incorrect", 6L, l.longValue());
            }
            else if ("System::Heartbeat".equals(e.getEventName())) {
                if (e.getInt64("seq") == 1l) {
                    Long l = e.getInt64("count");
                    assertNotNull(l);
                    assertEquals("Heartbeat count was incorrect", 3l, l.longValue());
                    l = e.getInt64("total");
                    assertNotNull(l);
                    assertEquals("Heartbeat total was incorrect", 3l, l.longValue());
                }
            }
        }

    }

    public Event createTestEvent()
            throws EventSystemException,
                   UnknownHostException {

        EventTemplateDB evtDb = new EventTemplateDB();
        evtDb.initialize();
        Event evt = new Event("TestEvent", false, evtDb);
        evt.setIPAddress("SenderIP", InetAddress.getByName("192.168.1.1"));
        evt.setUInt16("SenderPort", 9191);
        evt.setInt64("ReceiptTime", System.currentTimeMillis());
        evt.setUInt16("SiteID", 0);
        evt.setString("field1", "testing");
        evt.setInt32("intField1", 256);
        return evt;
    }
}
