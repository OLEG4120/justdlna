/*
 * Copyright (C) 2013 ENTERTAILION, LLC. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package su.litvak.justdlna.chromecast;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * Map Android style logging to Java style logging
 * 
 * @author leon_nicholls
 */
public class Log {
	private static Logger Log = LoggerFactory.getLogger("anynote");
	private static boolean verbose = false;

	public static void setVerbose(boolean enabled) {
		verbose = enabled;
	}

	public static boolean getVerbose() {
		return verbose;
	}

	public static void e(String tag, String message, Throwable e) {
		if (verbose) {
			Log.error(tag + ": " + message, e);
		}
	}

	public static void e(String tag, String message) {
		if (verbose) {
			Log.error(tag + ": " + message);
		}
	}

	public static void i(String tag, String message, Throwable e) {
		if (verbose) {
			Log.info(tag + ": " + message, e);
		}
	}

	public static void i(String tag, String message) {
		if (verbose) {
			Log.info(tag + ": " + message);
		}
	}

	public static void d(String tag, String message, Throwable e) {
		if (verbose) {
			Log.debug(tag + ": " + message, e);
		}
	}

	public static void d(String tag, String message) {
		if (verbose) {
			Log.debug(tag + ": " + message);
		}
	}

	public static void v(String tag, String message, Throwable e) {
		if (verbose) {
			Log.trace(tag + ": " + message, e);
		}
	}

	public static void v(String tag, String message) {
		if (verbose) {
			Log.trace(tag + ": " + message);
		}
	}

	public static void w(String tag, String message, Throwable e) {
		if (verbose) {
			Log.warn(tag + ": " + message, e);
		}
	}

	public static void w(String tag, String message) {
		if (verbose) {
			Log.warn(tag + ": " + message);
		}
	}
}
