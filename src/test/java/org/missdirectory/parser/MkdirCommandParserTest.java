package org.missdirectory.parser;

import org.junit.jupiter.api.Test;
import org.missdirectory.commands.Command;
import org.missdirectory.commands.MkdirCommand;
import org.missdirectory.exceptions.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class MkdirCommandParserTest {

    @Test
    void parseMkdirCommand() {
        assertDoesNotThrow(() -> {
            Command test = MkdirCommandParser.parse("abcABC0123@_-");
            assertEquals(MkdirCommand.class, test.getClass());
        });
    }

    @Test
    void parseMkdirCommand_throwsParseException() {
        String[] illegalCharactersList = {"/", "\\", "<", ">", "|", "\"", "\0", "*", "?"};
        for(String character: illegalCharactersList) {
            assertThrows(ParseException.class, () -> {
                MkdirCommandParser.parse(character);
            });
        }
        for(String character: illegalCharactersList) {
            assertThrows(ParseException.class, () -> {
                MkdirCommandParser.parse("abcABC0123@_-" + character);
            });
        }
    }
}
