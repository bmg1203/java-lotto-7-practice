package formatter;

import java.text.NumberFormat;
import java.util.Locale;

public class Formatter {
    public static NumberFormat getNumberFormatWithOneDecimal() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        numberFormat.setMinimumFractionDigits(1);
        numberFormat.setMaximumFractionDigits(1);
        return numberFormat;

    }

    public static NumberFormat getNumberFormatWithoutDecimal() {
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.KOREA);
        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setMaximumFractionDigits(0);
        return numberFormat;

    }
}
