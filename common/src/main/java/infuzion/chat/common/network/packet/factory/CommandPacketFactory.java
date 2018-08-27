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

package infuzion.chat.common.network.packet.factory;

import infuzion.chat.common.network.packet.CommandPacket;

import java.nio.ByteBuffer;

public class CommandPacketFactory extends NetworkPacketFactory<CommandPacket> {
    private String command;

    @Override
    public CommandPacket parse(ByteBuffer packet) {
        return new CommandPacket(packet);
    }

    @Override
    public short getSignature() {
        return CommandPacket.signature.value;
    }

    @Override
    public CommandPacket build() {
        return new CommandPacket(command);
    }

    public String getCommand() {
        return command;
    }

    public CommandPacketFactory setCommand(String command) {
        this.command = command;
        return this;
    }
}
