package com.Super.util;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;

import static org.junit.jupiter.api.Assertions.*;

class ClipboardUtilsTest {

  @Test
  void copyToClipboard_copiedCorrectly() throws Exception {
    String text = "text";
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    ClipboardUtils.copyToClipboard(text);

    Object ClipboardContent = clipboard.getData(DataFlavor.stringFlavor);
    assertEquals(ClipboardContent, text);
  }

}