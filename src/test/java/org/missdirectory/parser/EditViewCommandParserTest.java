package org.missdirectory.parser;

import org.junit.jupiter.api.Test;
import org.missdirectory.exceptions.ParseException;

import org.missdirectory.viewcommands.EditViewCommand;
import org.missdirectory.viewcommands.ViewCommand;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class EditViewCommandParserTest {
    @Test
    void parseEditViewCommand() {
        ArrayList<String> templateListString = new ArrayList<>();
        templateListString.add("Some_template");
        assertDoesNotThrow(() -> {
            ViewCommand test = EditViewCommandParser.parse("1", templateListString);
            assertEquals(EditViewCommand.class, test.getClass());
        });
    }

    @Test
    void nonIntegerArgument_throwsParseException() {
        ArrayList<String> templateListString = new ArrayList<>();
        templateListString.add("Some_template");
        assertThrows(ParseException.class, () -> EditViewCommandParser.parse("abc", templateListString));
    }
    @Test
    void indexOutOfBounds_throwsParseException() {
        ArrayList<String> templateListString = new ArrayList<>();
        templateListString.add("Some_template");
        assertThrows(ParseException.class, () -> EditViewCommandParser.parse("2", templateListString));
        assertThrows(ParseException.class, () -> EditViewCommandParser.parse("-1", templateListString));
        assertThrows(ParseException.class, () -> EditViewCommandParser.parse("0", templateListString));
        assertThrows(ParseException.class, () -> EditViewCommandParser.parse("20", templateListString));
    }
}
