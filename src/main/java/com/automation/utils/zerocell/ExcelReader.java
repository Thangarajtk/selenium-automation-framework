package com.automation.utils.zerocell;

import com.automation.constants.FrameworkConstants;
import com.creditdatamw.zerocell.Reader;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.File;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExcelReader {

    public static List<TestData> getTestDataList() {
        return testDataList;
    }

    private static final List<TestData> testDataList;

    static {
        testDataList = Reader.of(TestData.class)
                .from(new File(FrameworkConstants.TEST_DATA_EXCEL_PATH))
                .sheet(FrameworkConstants.DATA_SHEET)
                .skipHeaderRow(true)
                .list();
    }

}
