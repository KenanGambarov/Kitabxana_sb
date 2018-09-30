package com.kitabxana_sb.view;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.kitabxana_sb.tables.Book;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PDFBuilder extends AbstractITextPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        List<Book> list = (List) model.get("book_list");

        for (Book book : list) {
            doc.add(new Paragraph(book.getAuthor()));
            doc.add(new Paragraph(book.getTitle()));
        }
    }
}
