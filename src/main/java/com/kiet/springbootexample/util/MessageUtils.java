package com.kiet.springbootexample.util;

import org.slf4j.helpers.FormattingTuple;
import org.slf4j.helpers.MessageFormatter;

import dev.akkinoc.util.*;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class MessageUtils {

  static ResourceBundle messageBundle = ResourceBundle.getBundle("messages.messages", YamlResourceBundle.Control.INSTANCE);

  public static String getMessage(String errorCode, Object... var2) {
    String message;
    try {
      message = messageBundle.getString(errorCode);
    } catch (MissingResourceException ex) {
      message = errorCode;
    }
    FormattingTuple formattingTuple = MessageFormatter.arrayFormat(message, var2);
    return formattingTuple.getMessage();
  }
}
