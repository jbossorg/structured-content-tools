/*
 * JBoss, Home of Professional Open Source
 * Copyright 2012 Red Hat Inc. and/or its affiliates and other contributors
 * as indicated by the @authors tag. All rights reserved.
 */
package org.jboss.elasticsearch.tools.content;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Utility functions for values manipulation.
 * 
 * @author Vlastimil Elias (velias at redhat dot com)
 */
public class ValueUtils {

  /**
   * Trim String value, return null if empty after trim.
   * 
   * @param src value
   * @return trimmed value or null
   */
  public static String trimToNull(String src) {
    if (src == null || src.length() == 0) {
      return null;
    }
    src = src.trim();
    if (src.length() == 0) {
      return null;
    }
    return src;
  }

  /**
   * Check if String value is null or empty.
   * 
   * @param src value
   * @return <code>true</code> if value is null or empty
   */
  public static boolean isEmpty(String src) {
    return (src == null || src.length() == 0 || src.trim().length() == 0);
  }

  /**
   * Parse comma separated string into list of tokens. Tokens are trimmed, empty tokens are not in result.
   * 
   * @param toParse String to parse
   * @return List of tokens if at least one token exists, null otherwise.
   */
  public static List<String> parseCsvString(String toParse) {
    if (toParse == null || toParse.length() == 0) {
      return null;
    }
    String[] t = toParse.split(",");
    if (t.length == 0) {
      return null;
    }
    List<String> ret = new ArrayList<String>();
    for (String s : t) {
      if (s != null) {
        s = s.trim();
        if (s.length() > 0) {
          ret.add(s);
        }
      }
    }
    if (ret.isEmpty())
      return null;
    else
      return ret;
  }

  /**
   * Create string with comma separated list of values from input collection. Ordering by used Collection implementation
   * iteration order is used.
   * 
   * @param in collection to format
   * @return <code>null</code> if <code>in</code> is <code>null</code>, CSV string in other cases (empty id in is empty)
   */
  public static String createCsvString(Collection<String> in) {
    if (in == null)
      return null;
    if (in.isEmpty()) {
      return "";
    }
    boolean first = true;
    StringBuilder sb = new StringBuilder();
    for (String s : in) {
      if (first)
        first = false;
      else
        sb.append(",");
      sb.append(s);
    }
    return sb.toString();
  }

}
