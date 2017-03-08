package com.exercises.search.analyzer.ansj;

import com.chenlb.mmseg4j.*;
import org.ansj.domain.Result;
import org.ansj.domain.Term;
import org.ansj.splitWord.analysis.IndexAnalysis;
import org.ansj.splitWord.analysis.ToAnalysis;

import java.io.*;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by jason on 30/11/2016.
 */
public class Evaluation {

    public static void main(String[] args) throws Exception {
        String input = "/Users/jason/Workspace/exercises/data/names_30_days.txt";
//        String indexAnalysisOutput = "/Users/jason/Workspace/exercises/data/indexAnalysis.txt";
//        String toAnalysisOutput = "/Users/jason/Workspace/exercises/data/toAnalysis.txt";
//        seg(input, indexAnalysisOutput, toAnalysisOutput);

        Dictionary dic = Dictionary.getInstance();
        mmseg_seg(input, "/Users/jason/Workspace/exercises/data/mmseg_out.txt", new ComplexSeg(dic));

    }

    private static void mmseg_seg(final String input, final String output, final Seg seg) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));
        ) {
            Stream<String> lines = reader.lines();
            lines = lines.distinct();
            lines.forEach(line -> {
                if ("".equals(line.trim())) {
                    write(writer, "\n");
                } else {
                    String str = seg(line, seg);
                    if (!contain(line, str)) {
                        write(writer, line + "\t" + str, null);
                    }
                }
            });

        } catch (Exception e) {

        }

    }

    private static String seg(String text, Seg seg) {
        StringBuilder result = new StringBuilder();
        MMSeg mmSeg = new MMSeg(new StringReader(text), seg);
        Word word;
        try {
            while ((word = mmSeg.next()) != null) {
                result.append(word.getString()).append(" ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString().trim();
    }

    private static void seg(final String input, final String indexAnalysisOutput, final String toAnalysisOutput) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(input), "UTF-8"));
             BufferedWriter indexAnalysisWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(indexAnalysisOutput), "UTF-8"));
             BufferedWriter toAnalysisWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(toAnalysisOutput), "UTF-8"))) {
            Stream<String> lines = reader.lines();
            lines = lines.distinct();
            lines.forEach(line -> {
                if ("".equals(line.trim())) {
                    write(indexAnalysisWriter, "\n");
                    write(toAnalysisWriter, "\n");
                } else {
                    Result indexAnalysisResult = IndexAnalysis.parse(line);
                    Result toAnalysisResult = ToAnalysis.parse(line);
                    if (!contain(indexAnalysisResult, line)) {
                        write(indexAnalysisWriter, line + "\t" + indexAnalysisResult.toStringWithOutNature(" "), null);
                    }
                    if (!contain(toAnalysisResult, line)) {
                        write(toAnalysisWriter, line + "\t" + toAnalysisResult.toStringWithOutNature(" "), null);
                    }


                }

            });

        } catch (Exception e) {

        }

    }

    private static boolean contain(String line, String str) {
        if (str == null) return false;
        for (String s : str.split(" ")) {
            if (s != null && s.equals(line)) return true;
        }
        return false;
    }

    private static boolean contain(Result result, String line) {
        if (line == null) return false;
        if (result == null) return false;
        List<Term> terms = result.getTerms();
        if (terms == null || terms.size() < 1) return false;

        for (Term term : terms) {
            if (term == null) continue;
            String name = term.getName();
            if (line.trim().toLowerCase().equals(name.trim().toLowerCase())) return true;
        }
        return false;
    }

    private static void write(BufferedWriter writer, String line, Object object) {
        try {
            writer.write(line);
            writer.write("\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void write(BufferedWriter writer, String line) {
        try {
            writer.write(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
