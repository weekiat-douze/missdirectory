package org.missdirectory.parser;

import org.junit.jupiter.api.Test;
import org.missdirectory.commands.*;
import org.missdirectory.exceptions.ParseException;
import org.missdirectory.viewcommands.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    @Test
    void parseEditorInput() {
        assertDoesNotThrow(() -> {
            Command mkdirCommand = Parser.parseEditorInput("mkdir test");
            assertEquals(MkdirCommand.class, mkdirCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            Command changeDirectory = Parser.parseEditorInput("cd test");
            assertEquals(ChangeDirectoryCommand.class, changeDirectory.getClass());
        });
        assertDoesNotThrow(() -> {
            Command listCommand = Parser.parseEditorInput("ls");
            assertEquals(ListCommand.class, listCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            Command treeCommand = Parser.parseEditorInput("tree");
            assertEquals(TreeCommand.class, treeCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            Command removeCommand = Parser.parseEditorInput("rm test");
            assertEquals(RemoveCommand.class, removeCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            Command helpCommand = Parser.parseEditorInput("help");
            assertEquals(HelpCommand.class, helpCommand.getClass());
        });
    }

    @Test
    void parseEditorInput_throwsParseException() {
        assertThrows(ParseException.class, () -> Parser.parseEditorInput("abcd"));
        assertThrows(ParseException.class, () -> Parser.parseEditorInput(""));
    }

    @Test
    void parseViewInput() {
        ArrayList<String> testListString = new ArrayList<>();
        testListString.add("test_template");
        assertDoesNotThrow(() -> {
            ViewCommand showViewCommand = Parser.parseViewInput("tree 1", testListString);
            assertEquals(ShowViewCommand.class, showViewCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            ViewCommand deleteViewCommand = Parser.parseViewInput("delete 1", testListString);
            assertEquals(DeleteViewCommand.class, deleteViewCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            ViewCommand editViewCommand = Parser.parseViewInput("edit 1", testListString);
            assertEquals(EditViewCommand.class, editViewCommand.getClass());
        });
        assertDoesNotThrow(() -> {
            ViewCommand helpViewCommand = Parser.parseViewInput("help", testListString);
            assertEquals(HelpViewCommand.class, helpViewCommand.getClass());
        });
    }

    @Test
    void parseViewInput_throwsParseException() {
        ArrayList<String> testListString = new ArrayList<>();
        testListString.add("test_template");
        assertThrows(ParseException.class, () -> Parser.parseViewInput("abcd", testListString));
        assertThrows(ParseException.class, () -> Parser.parseViewInput("", testListString));
    }
}
