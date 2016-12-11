package com.jason.exercises.search.analyzer.ansj;

import java.io.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jason on 30/11/2016.
 */
public class Filters {
    public static void main(String[] args) throws Exception {
        String inputActivityTenantIds = "/Users/jason/Workspace/exercises/data/activity_tenant_ids_30_online.txt";
        String inputTestTenantIds = "/Users/jason/Workspace/exercises/data/test_tenant_ids_online.txt";
        String finallyTenantIds = "/Users/jason/Workspace/exercises/data/finally_tenant_ids_online.txt";
        filter(inputActivityTenantIds, inputTestTenantIds, finallyTenantIds);
    }

    private static void filter(final String inputActivityTenantIds, final String inputTestTenantIds, final String finallyTenantIds) throws Exception {
        try (BufferedReader activityTenantIdsReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputActivityTenantIds), "UTF-8"));
             BufferedReader testTenantIdsReader = new BufferedReader(new InputStreamReader(new FileInputStream(inputTestTenantIds), "UTF-8"));
             BufferedWriter finallyWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(finallyTenantIds), "UTF-8"))) {
            Stream<String> testLines = testTenantIdsReader.lines();

            Set<String> testTenantIds = testLines.collect(Collectors.toSet());

            Stream<String> activityTenantIdStream = activityTenantIdsReader.lines();

            Stream<String> stringStream = activityTenantIdStream.distinct().filter(s -> !testTenantIds.contains(s));


            stringStream.forEach(s -> {
                write(finallyWriter, s);
            });


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void write(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
