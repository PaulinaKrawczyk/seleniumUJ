package selenium.test.automation.utils.generators;

import selenium.test.automation.utils.BaseConfiguration;

import java.util.Date;

public class TagDataGenerator {

    public Object[][] generateTagData() {
        Object[][] data = new Object[BaseConfiguration.TAG_DATA_SIZE][];

        for (int i = 0; i < BaseConfiguration.TAG_DATA_SIZE; i++) {
            Object[] tagData = new Object[1];
            tagData[0] = new Date().getTime() + "_" + i + "_" + new BaseGenerator().generateString(6) + "_tag";
            data[i] = tagData;

        }
        return data;
    }
}
