package com.automation.utils.dataprovider;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import com.automation.constants.FrameworkConstants;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.testng.annotations.DataProvider;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class DataProviderUtils {

    private static List<Map<String, String>> list = new ArrayList<>();

    @DataProvider(parallel = false)
    public static Object[] getData(Method method) {
        String testName = method.getName();
        if (list.isEmpty()) {
            list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationDataSheet());
        }

        List<Map<String, String>> smallList = new ArrayList<>(list);

        Predicate<Map<String, String>> isTestNameNotMatching = map -> !map.get("TestName").equalsIgnoreCase(testName);
        Predicate<Map<String, String>> isExecuteColumnNo = map -> map.get("Execute").equalsIgnoreCase("no");
        smallList.removeIf(isTestNameNotMatching.or(isExecuteColumnNo));

        return smallList.toArray();
    }
}
