package com.automation.zerocell;

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

    private static List<TestData> testDataList = null;

    static {
        testDataList = Reader.of(TestData.class)
                .from(new File(FrameworkConstants.getExcelPath()))
                .sheet(FrameworkConstants.getIterationDataSheet())
                .skipHeaderRow(true)
                .list();
    }

}
