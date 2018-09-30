package com.kitabxana_sb.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.AbstractView;

public abstract class AbstractITextPdfView extends AbstractView {

    public AbstractITextPdfView() {
        setContentType("application/pdf");
    }

    @Override
    protected boolean generatesDownloadContent() {
        return true;
    }

    @Override
    protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        /* 37 */ ByteArrayOutputStream baos = createTemporaryOutputStream();

        /* 40 */ Document document = newDocument();
        /* 41 */ PdfWriter writer = newWriter(document, baos);
        /* 42 */ prepareWriter(model, writer, request);
        /* 43 */ buildPdfMetadata(model, document, request);

        /* 46 */ document.open();
        /* 47 */ buildPdfDocument(model, document, writer, request, response);
        /* 48 */ document.close();

        /* 51 */ writeToResponse(response, baos);
    }

    protected Document newDocument() {
        /* 55 */ return new Document(PageSize.A4);
    }

    protected PdfWriter newWriter(Document document, OutputStream os) throws DocumentException {
        /* 59 */ return PdfWriter.getInstance(document, os);
    }

    protected void prepareWriter(Map<String, Object> model, PdfWriter writer, HttpServletRequest request)
            throws DocumentException {
        /* 65 */ writer.setViewerPreferences(getViewerPreferences());
    }

    protected int getViewerPreferences() {
        /* 69 */ return 2053;
    }

    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
    }

    protected abstract void buildPdfDocument(Map<String, Object> paramMap, Document paramDocument, PdfWriter paramPdfWriter, HttpServletRequest paramHttpServletRequest, HttpServletResponse paramHttpServletResponse)
            throws Exception;
}
