package org.missdirectory.parser;

import org.junit.jupiter.api.Test;
import org.missdirectory.commands.Command;
import org.missdirectory.commands.TreeCommand;
import org.missdirectory.exceptions.ParseException;

import static org.junit.jupiter.api.Assertions.*;

class TreeCommandParserTest {
    @Test
    void parseTreeCommand() {
        assertDoesNotThrow(() -> {
            Command testCommand = TreeCommandParser.parse("");
            assertEquals(TreeCommand.class, testCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            Command testCommand = TreeCommandParser.parse(null);
            assertEquals(TreeCommand.class, testCommand.getClass());
        });
    }

    @Test
    void parseTreeCommand_throwsParseException() {
        assertThrows(ParseException.class, () -> TreeCommandParser.parse("test"));
        assertThrows(ParseException.class, () -> TreeCommandParser.parse("test test2"));
        assertThrows(ParseException.class, () -> TreeCommandParser.parse("\0"));
    }
}
