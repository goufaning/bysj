package com.goufaning.bysj.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import java.io.File;
import java.io.IOException;

/**
 * 读取pdf文档内容
 */
public class PDFReader {

    public static String getText(String path) {
        String text = "";
        File file = new File(path);
        try {
            PDDocument document = PDDocument.load(file);
            PDFTextStripper pdfStripper = new PDFTextStripper();
            text = pdfStripper.getText(document);
//            PDDocumentInformation pdfInfo = document.getDocumentInformation();
//            text = pdfInfo.getSubject();
            document.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return text;
    }
}
