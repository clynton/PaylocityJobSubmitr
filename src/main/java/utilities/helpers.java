package utilities;

import org.openqa.selenium.Keys;

public class helpers {

	public static void pauseThread(int delayAfterClick_ms) {

		// if need to wait after the click
		if (delayAfterClick_ms > 0) {
			try {
				Thread.sleep(delayAfterClick_ms);
			} catch (InterruptedException e) {
			} catch (Exception ex) {
			}
		}		
	}
	
	// sweet hack - set the value, tab away and back to reset that same value...
	// TODO: check for tab, because this will break something if the value already has tab actions in it...
	public static String getStringToDoubleSetValuesIntoField(String value)
	{
		return value + comboKeys.TabThenShiftTabKeys + value;
	}

	public static class comboKeys {
			
		public static final String TabThenEnterKeys = "" + Keys.TAB + Keys.ENTER;
		public static final String ShiftTabKeys = Keys.chord(Keys.SHIFT,Keys.TAB);
		public static final String ShiftTabThenEnterKeys = Keys.chord(Keys.SHIFT,Keys.TAB) + Keys.ENTER;
		public static final String TabThenShiftTabKeys = Keys.TAB + Keys.chord(Keys.SHIFT,Keys.TAB);
		public static final String ShiftTabThenTabKeys = Keys.chord(Keys.SHIFT,Keys.TAB) + Keys.TAB;
		
	}
}
