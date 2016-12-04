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

package infuzion.chat.server.mock;

import infuzion.chat.server.IChatClient;
import infuzion.chat.server.command.Command;
import infuzion.chat.server.permission.IPermissionManager;
import infuzion.chat.server.permission.Permission;
import infuzion.chat.server.permission.PermissionAttachment;

public class FakePermissionManager implements IPermissionManager {
    @Override
    public boolean hasPermission(Permission permission, IChatClient chatClient) {
        return false;
    }

    @Override
    public void registerPermission(Command command, Permission permission) {

    }

    @Override
    public PermissionAttachment getPermissionAttachment(IChatClient chatClient) {
        return null;
    }
}