package org.nucleus8583.core.util;

import java.io.IOException;
import java.io.OutputStream;

import org.nucleus8583.core.charset.CharsetEncoder;

public abstract class StringUtils {

	public static boolean isEmpty(String value) {
		if (value == null) {
			return true;
		}

		return value.length() == 0;
	}

	public static void pad(OutputStream out, CharsetEncoder enc, String value, int valueLength, int expectedLength, char align, char[] padder) throws IOException {
		if (valueLength == 0) {
			enc.write(out, padder, 0, expectedLength);
		} else if (valueLength == expectedLength) {
			enc.write(out, value, 0, valueLength);
		} else {
			switch (align) {
			case 'l':
				enc.write(out, value, 0, valueLength);
				enc.write(out, padder, 0, expectedLength - valueLength);

				break;
			case 'r':
				enc.write(out, padder, 0, expectedLength - valueLength);
				enc.write(out, value, 0, valueLength);

				break;
			default: // 'n'
				enc.write(out, value, 0, valueLength);
				enc.write(out, padder, 0, expectedLength - valueLength);

				break;
			}
		}
	}

	public static char[] unpad(char[] value, int valueLength, char align, char padder, char[] defaultValue) {
		char[] cbuf;
		int cbufLength;

		switch (align) {
		case 'l':
			cbufLength = 0;

			for (int i = valueLength - 1; i >= 0; --i) {
				if (value[i] != padder) {
					cbufLength = i + 1;
					break;
				}
			}

			if (cbufLength == 0) {
				cbuf = defaultValue;
			} else if (cbufLength == valueLength) {
				cbuf = value;
			} else {
				cbuf = new char[cbufLength];
				System.arraycopy(value, 0, cbuf, 0, cbufLength);
			}

			break;
		case 'r':
			int padLength = valueLength;

			for (int i = 0; i < valueLength; ++i) {
				if (value[i] != padder) {
					padLength = i;
					break;
				}
			}

			if (padLength == 0) {
				cbuf = value;
			} else if (padLength == valueLength) {
				cbuf = defaultValue;
			} else {
				cbufLength = valueLength - padLength;

				cbuf = new char[cbufLength];
				System.arraycopy(value, padLength, cbuf, 0, cbufLength);
			}

			break;
		default: // 'n'
			cbuf = value;
			break;
		}

		return cbuf;
	}
}