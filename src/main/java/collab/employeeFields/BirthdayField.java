package collab.employeeFields;

import java.time.LocalDate;
import java.time.chrono.IsoEra;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.ResolverStyle;
import java.time.temporal.ChronoField;
import java.util.Locale;

public class BirthdayField extends InputField {

    private static final DateTimeFormatter DATE_PARSER
        = new DateTimeFormatterBuilder().appendPattern("yyyyMMdd")
        .parseDefaulting(ChronoField.ERA, IsoEra.CE.getValue())
        .toFormatter(Locale.ROOT)
        .withResolverStyle(ResolverStyle.STRICT);

    private String birthYearOnly;
    private String birthMonthOnly;
    private String birthDayOnly;

    public BirthdayField(String inputColumn, String inputData) {
        super(inputColumn, inputData);
    }

    @Override
    public void validateData() {
        int currentYear = LocalDate.now().getYear();

        try {
            LocalDate.parse(data, DATE_PARSER);
        } catch (Exception e) {
            throw new RuntimeException("Employee birth day input is not valid");
        }

        if (Integer.parseInt(data.substring(0, 4)) > currentYear) {
            throw new RuntimeException("Employee birth day input is not valid");
        }
    }

    @Override
    public void processData() {
        birthYearOnly = data.substring(0, 4);
        birthMonthOnly = data.substring(4, 6);
        birthDayOnly = data.substring(6);
    }

    public String getBirthYearOnly() {
        return birthYearOnly;
    }

    public String getBirthMonthOnly() {
        return birthMonthOnly;
    }

    public String getBirthDayOnly() {
        return birthDayOnly;
    }
}
