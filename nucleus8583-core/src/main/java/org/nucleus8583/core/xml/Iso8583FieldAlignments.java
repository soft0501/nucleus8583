package org.nucleus8583.core.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlEnum(String.class)
public enum Iso8583FieldAlignments {
	@XmlEnumValue("left") LEFT,
	@XmlEnumValue("right") RIGHT,
	@XmlEnumValue("none") NONE;

	public char symbolicValue() {
		if (this == LEFT) {
			return 'l';
		}
		if (this == RIGHT) {
			return 'r';
		}
		return 'n';
	}

	public static Iso8583FieldAlignments enumValueOf(String str) {
		if ("left".equalsIgnoreCase(str)) {
			return LEFT;
		}

		if ("right".equalsIgnoreCase(str)) {
			return RIGHT;
		}

		if ("none".equalsIgnoreCase(str)) {
			return NONE;
		}

		return null;
	}
}
