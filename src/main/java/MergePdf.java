import org.apache.pdfbox.io.MemoryUsageSetting;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;

import java.io.File;
import java.io.IOException;

public class MergePdf {
    public static void main(String[] args){
        try {
            //ADD PAGES TO DOC
            PDDocument document = new PDDocument();
            for (int i=0; i<2; i++) {
                //Creating a blank page
                PDPage blankPage = new PDPage();
                //Adding the blank page to the document
                document.addPage( blankPage );
            }
            document.save("docs//output//generated.pdf");
            document.close();

            //MERGE FILES
            PDFMergerUtility PDFmerger = new PDFMergerUtility();
            File file = new File("docs//input//file1.pdf");
            PDFmerger.addSource(file);
            file = new File("docs//input//file2.pdf");
            PDFmerger.addSource(file);
            PDFmerger.setDestinationFileName("docs//output//merged.pdf");
            PDFmerger.mergeDocuments(MemoryUsageSetting.setupMainMemoryOnly());

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("OLA");
    }
}
