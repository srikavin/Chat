/*
 *  Copyright 2016 Infuzion
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */

package infuzion.chat.server.plugin.event.chat;

import infuzion.chat.server.IChatClient;
import infuzion.chat.server.plugin.event.Cancelable;
import infuzion.chat.server.plugin.event.Event;

public abstract class ChatEvent extends Event implements Cancelable {
    private IChatClient sender;
    private String message;
    private boolean canceled = false;

    public ChatEvent(IChatClient sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    public IChatClient getSender() {
        return sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isCanceled() {
        return canceled;
    }

    @Override
    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }
}
