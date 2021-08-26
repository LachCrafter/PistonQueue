/*
 * #%L
 * PistonQueue
 * %%
 * Copyright (C) 2021 AlexProgrammerDE
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package net.pistonmaster.pistonqueue.velocity.utils;

import com.velocitypowered.api.proxy.Player;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import net.pistonmaster.pistonqueue.shared.SharedChatUtils;

import java.util.List;

public class ChatUtils {
    private ChatUtils() {
    }

    public static void sendMessage(Player p, String str) {
        sendMessage(MessageType.CHAT, p, str);
    }

    public static void sendMessage(MessageType type, Player p, String str) {
        if (!str.equalsIgnoreCase("/")) {
            switch (type) {
                case CHAT:
                    p.sendMessage(parseToComponent(str));
                    break;
                case ACTION_BAR:
                    p.sendActionBar(parseToComponent(str));
                    break;
            }
        }
    }

    public static TextComponent parseToComponent(String str) {
        return LegacyComponentSerializer.legacySection().deserialize(parseToString(str));
    }

    public static String parseToString(String str) {
        return LegacyComponentSerializer.legacySection().serialize(LegacyComponentSerializer.legacyAmpersand().deserialize(SharedChatUtils.parseText(str)));
    }

    public static TextComponent parseTab(List<String> tab) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < tab.size(); i++) {
            builder.append(parseToString(tab.get(i)));

            if (i != (tab.size() - 1)) {
                builder.append("\n");
            }
        }

        return LegacyComponentSerializer.legacySection().deserialize(builder.toString());
    }
}
