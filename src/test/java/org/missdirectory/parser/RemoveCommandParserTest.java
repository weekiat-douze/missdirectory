package org.missdirectory.parser;

import org.junit.jupiter.api.Test;
import org.missdirectory.commands.Command;
import org.missdirectory.commands.RemoveCommand;
import org.missdirectory.exceptions.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCommandParserTest {
    @Test
    void parseMkdirCommand() {
        assertDoesNotThrow(() -> {
            Command test = RemoveCommandParser.parse("abcABC0123@_-");
            assertEquals(RemoveCommand.class, test.getClass());
        });
    }

    @Test
    void parseMkdirCommand_throwsParseException() {
        String[] illegalCharactersList = {"/", "\\", "<", ">", "|", "\"", "\0", "*", "?"};
        for(String character: illegalCharactersList) {
            assertThrows(ParseException.class, () -> {
                RemoveCommandParser.parse(character);
            });
        }
        for(String character: illegalCharactersList) {
            assertThrows(ParseException.class, () -> {
                RemoveCommandParser.parse("abcABC0123@_-" + character);
            });
        }
    }

}
