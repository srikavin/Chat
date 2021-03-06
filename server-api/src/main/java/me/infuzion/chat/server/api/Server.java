/*
 * Copyright 2018 Srikavin Ramkumar
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.infuzion.chat.server.api;/*
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

import infuzion.chat.common.network.packet.NetworkPacket;
import me.infuzion.chat.server.api.command.ICommandManager;
import me.infuzion.chat.server.api.event.IEventManager;
import me.infuzion.chat.server.api.network.NetworkSource;
import me.infuzion.chat.server.api.permission.IPermissionManager;
import me.infuzion.chat.server.api.plugin.loader.IPluginManager;

import java.util.List;

public interface Server {
    void reload();

    void stop();

    IPluginManager getPluginManager();

    IEventManager getEventManager();

    ICommandManager getCommandManager();

    IPermissionManager getPermissionManager();

    void setPermissionManager(IPermissionManager permissionManager);

    void enqueue(NetworkPacket packet, IChatClient client, Class<? extends NetworkSource> source);

    IChatRoomManager getChatRoomManager();

    int getTps();

    long getTotalTps();

    List<IChatClient> getConnectedClients();
}
