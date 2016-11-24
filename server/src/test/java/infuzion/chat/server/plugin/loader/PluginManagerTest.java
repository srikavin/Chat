/*
 *
 *  *  Copyright 2016 Infuzion
 *  *
 *  *    Licensed under the Apache License, Version 2.0 (the "License");
 *  *    you may not use this file except in compliance with the License.
 *  *    You may obtain a copy of the License at
 *  *
 *  *        http://www.apache.org/licenses/LICENSE-2.0
 *  *
 *  *    Unless required by applicable law or agreed to in writing, software
 *  *    distributed under the License is distributed on an "AS IS" BASIS,
 *  *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  *    See the License for the specific language governing permissions and
 *  *    limitations under the License.
 *
 */

package infuzion.chat.server.plugin.loader;

import infuzion.chat.server.mock.FakeServer;
import org.junit.Test;

import java.io.File;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class PluginManagerTest {
    @Test
    public void addPlugin() throws Exception {
    }

    @Test
    public void addAllPlugins() throws Exception {
        PluginManager pl = new PluginManager(new FakeServer());
        pl.addAllPlugins(new File(getClass().getClassLoader().getResource("plugins/").toURI()));

        System.setProperty("test", "1");
        pl.enable();
        for (Map.Entry<Object, Object> e : System.getProperties().entrySet()) {
            System.out.print(e.getKey() + " : ");
            System.out.println(e.getValue());
        }
        assertTrue(System.getProperty("enabled").equals("1"));
    }

    @Test
    public void getPlugins() throws Exception {

    }

}