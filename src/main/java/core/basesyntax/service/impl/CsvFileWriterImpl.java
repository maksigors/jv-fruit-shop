package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CsvFileWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvFileWriterImpl implements CsvFileWriter {
    private static final String FRUIT = "fruit";
    private static final String AMOUNT = "amount";
    private static final String COMA = ",";

    @Override
    public void writeFile(String filePath) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filePath))) {
            StringBuilder builder = new StringBuilder();
            builder.append(FRUIT)
                    .append(COMA)
                    .append(AMOUNT)
                    .append(System.lineSeparator());
            bufferedWriter.write(builder.toString());
            for (Map.Entry<String, Integer> data : Storage.fruitStorageMap.entrySet()) {
                //StringBuilder builder = new StringBuilder();
                builder.append(data.getKey())
                        .append(COMA)
                        .append(data.getValue())
                        .append(System.lineSeparator());
                bufferedWriter.write(builder.toString());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
