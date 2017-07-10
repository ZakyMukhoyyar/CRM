package com.agit.crm.infrastructure.component.pdf;

import java.io.InputStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.edit.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDTrueTypeFont;

/**
 *
 * @author bayutridewanto
 */


public class CreatePDFA
{
    /**
     * Constructor.
     */
    public CreatePDFA()
    {
        super();
    }

    /**
     * 
     * @param file
     * @param message
     * @throws Exception 
     */
    public void doIt( String file, String message) throws Exception
    {
        // the document
        PDDocument doc = null;
        try
        {
            doc = new PDDocument();
            PDPage page = new PDPage();
            doc.addPage( page );
            InputStream fontStream = CreatePDFA.class.getResourceAsStream("/org/apache/pdfbox/resources/ttf/ArialMT.ttf");
            PDFont font = PDTrueTypeFont.loadTTF(doc, fontStream);
            PDPageContentStream contentStream = new PDPageContentStream(doc, page);
            contentStream.beginText();
            contentStream.setFont( font, 12 );
            contentStream.moveTextPositionByAmount( 100, 700 );
            contentStream.drawString( message );
            contentStream.endText();
            contentStream.saveGraphicsState();
            contentStream.close();
            doc.save( file );
           
        }
        finally
        {
            if (doc != null) {
                doc.close();
            }
        }
    }

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        CreatePDFA app = new CreatePDFA();
        app.doIt("test.pdf", "hello world");
    }

}
