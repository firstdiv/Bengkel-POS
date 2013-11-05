package com.airsystem.pos.bengkel.util;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

import org.apache.log4j.Logger;

/**
 * @author Budi Oktaviyan
 */
public class TextUtil extends PlainDocument {
	private static final Logger LOG = Logger.getLogger(TextUtil.class.getSimpleName());

	private int limit;
	private int type;

	public static final int LETTER = 1;
	public static final int CAPITAL = 2;
	public static final int NUMBER = 3;
	public static final int ALPHANUMERIC = 4;
	public static final int ALPHASPACE = 5;
	public static final int PASSWORD = 6;

	public TextUtil(int limit, int type) {
		super();
		this.limit = limit;
		this.type = type;
	}

	public void insertString(int offs, String str, AttributeSet attr) throws BadLocationException {
		try {
			if ((getLength() + str.length()) <= limit) {
				if (type == 1 && str.matches("[a-zA-Z\\s]*")) {
					super.insertString(offs, str, attr);
					return;
				}

				if (type == 2) {
					str = str.toUpperCase();

					if (str.matches("[A-Z\\s]*")) {
						super.insertString(offs, str, attr);
						return;
					}
				}

				if (type == 3 && str.matches("\\d*")) {
					super.insertString(offs, str, attr);
					return;
				}

				if (type == 4 && str.matches("\\w*")) {
					super.insertString(offs, str, attr);
					return;
				}

				if (type == 5 && str.matches("[\\w\\s]*")) {
					super.insertString(offs, str, attr);
					return;
				}

				if (type == 6) {
					super.insertString(offs, str, attr);
					return;
				}
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
	}
}