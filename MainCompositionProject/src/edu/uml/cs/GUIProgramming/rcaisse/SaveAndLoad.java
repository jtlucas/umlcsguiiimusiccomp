/*
 * SaveAndLoad.java
 *
 * This is the class that performs all the reading and writing for XML.
 *
 * Created on March 1, 2009, 11:57 PM
 */

package edu.uml.cs.GUIProgramming.rcaisse;

// the com.sun.org.apache.xml.internal.serialize classes produced
//    warnings such as:
//       .../462-lecs/code/XMLDemo/src/edu/uml/cs/GUIProgramming/XMLDemo1.java:8:
//       warning: com.sun.org.apache.xml.internal.serialize.OutputFormat is Sun
//       proprietary API and may be removed in a future release
// an alternative source of these classes may be found at:
//    http://xml.apache.org/xalan-j/downloads.html
//    This is on the website for the Apache XML Project: Xalan-J:
//       http://xalan.apache.org/index.html
//       Xalan-Java Version 2.7.1
// if the Xalan-J classes are used, the required import statement is:
//    import org.apache.xml.serializer.*;

import org.w3c.dom.Document;
import org.w3c.dom.*;
import java.io.*;           // Needed for File I/O as well as other I/O utilities
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import java.util.LinkedList;
import javax.swing.JFileChooser;

/**
 *
 * This is class handles all save and loading of compositions.
 *
 * @author  Ross Caisse, UMass Lowell Computer Science, <a href="mailto:rcaisse@gmail.com">rcaisse@gmail.com</a>
 * @version 1.0, 2009-3-01
 */
public class SaveAndLoad {

    private static JFileChooser fc;

    // Default constructor
    public SaveAndLoad() {
    }

    /**
     * Load a composition from a file and return the MusicComposition instance.
     * Some XML reading code was received from:
     * http://www.developerfusion.com/code/2064/a-simple-way-to-read-an-xml-file-in-java/
     *
     * @param path
     * @return the composition
     */
    public static MusicComposition LoadComposition() {

        // Create a new composition
        MusicComposition myComp = new MusicComposition();
        String path = setupFileChooser();

        try {

            // Load the XML file into memory
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse (new File(path));

            // normalize text representation
            doc.getDocumentElement ().normalize ();

            // Get the list of "notes"
            NodeList listOfNotes = doc.getElementsByTagName("note");
            int totalNotes = listOfNotes.getLength();

            // Check to see if there are notes in this file
            if( totalNotes == 0 ) {
                System.out.println("No notes. Must be an error.");
                return null;
            }

            // Loop through all the notes
            for(int s=0; s<listOfNotes.getLength() ; s++){

                // Get the first note
                Node firstNoteNode = listOfNotes.item(s);

                if(firstNoteNode.getNodeType() == Node.ELEMENT_NODE){
                    Element firstNoteElement = (Element)firstNoteNode;

                    // Get the x coordinate
                    NodeList xList = firstNoteElement.getElementsByTagName("x");
                    Element xElement = (Element)xList.item(0);
                    NodeList textXList = xElement.getChildNodes();
                    int x = Integer.parseInt(((Node)textXList.item(0)).getNodeValue().trim());

                    // Get the y coordinate
                    NodeList yList = firstNoteElement.getElementsByTagName("y");
                    Element yElement = (Element)yList.item(0);
                    NodeList textYList = yElement.getChildNodes();
                    int y = Integer.parseInt(((Node)textYList.item(0)).getNodeValue().trim());

                    // Get the shape type
                    NodeList typeList = firstNoteElement.getElementsByTagName("type");
                    Element typeElement = (Element)typeList.item(0);
                    NodeList textTypeList = typeElement.getChildNodes();
                    String type = new String(((Node)textTypeList.item(0)).getNodeValue().trim());

                    // Get the height of the object
                    NodeList heightList = firstNoteElement.getElementsByTagName("height");
                    Element heightElement = (Element)heightList.item(0);
                    NodeList textHeightList = heightElement.getChildNodes();
                    int height = Integer.parseInt(((Node)textHeightList.item(0)).getNodeValue().trim());

                    // Get the widht of the object
                    NodeList widthList = firstNoteElement.getElementsByTagName("width");
                    Element widthElement = (Element)widthList.item(0);
                    NodeList textWidthList = widthElement.getChildNodes();
                    int width = Integer.parseInt(((Node)textWidthList.item(0)).getNodeValue().trim());

                    // Add the note to the composition
                    myComp.addNote(new MusicNote(x,y,height,width,type));

                }//end of if clause

            }//end of for loop with s var

        }catch (SAXParseException err) {
            System.out.println ("** Parsing error" + ", line "
                 + err.getLineNumber () + ", uri " + err.getSystemId ());
            System.out.println(" " + err.getMessage ());

        }catch (SAXException e) {
            Exception x = e.getException ();
            ((x == null) ? e : x).printStackTrace ();

        }catch (Throwable t) {
            t.printStackTrace ();
        }

        // Return the loaded composition
        return myComp;
    }

    /**
     * Save a composition to the file specified by path
     *
     * @param myComp
     * @param path
     */
    public static int SaveComposition(MusicComposition myComp) {
        String path = setupFileChooser();

        if( path.equals("")) {
            System.out.println("No file selected");
            return 0;
        }

        // TODO: make sure you ask about overwrite
        if(path.endsWith(".xml") == false) {
            path = path + ".xml";
        }

        // Write the notes to a file
        try {
            // Used to write to the XML file
            BufferedWriter out = new BufferedWriter(new FileWriter(path)); // For writing the file
            LinkedList noteList = myComp.getNotes();

            out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            out.write("<composition>\n");
            // Traverse through the list
            for(int i = 0, n = noteList.size(); i < n; i++) {
                // Get the next entry
                MusicNote temp = (MusicNote) noteList.get(i);

                // Write the specific pieces
                out.write("\t<note>\n");
                out.write("\t\t<x>" + temp.getX() + "</x>\n");
                out.write("\t\t<y>" + temp.getY() + "</y>\n");
                out.write("\t\t<type>" + temp.getShape() + "</type>\n");
                out.write("\t\t<height>" + temp.getHeight() + "</height>\n");
                out.write("\t\t<width>" + temp.getWidth() + "</width>\n");
                out.write("\t</note>\n");
            }

            out.write("</composition>");
            out.close(); // Close the file

        } catch (IOException e){
            System.err.println("Error writing to file");
            return -1;
        }

        return 0;
    }

    private static String setupFileChooser() {

        String path;
        String strRootDirectory;

        fc = new JFileChooser();

        //Add a custom file filter and disable the default
        //(Accept All) file filter.
        fc.addChoosableFileFilter(new XMLFileFilter());
        fc.setAcceptAllFileFilterUsed(false);

        //Show it.
        // TODO creating a label everytime you call this is an
        // extremely bad way of doing this, but it'll do for now.
        int returnVal = fc.showDialog(new java.awt.Label(),
                                      "Select Composition");

        //Process the results.
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            path = file.getAbsolutePath();
        } else {
            path = "";
        }

        //Reset the file chooser for the next time it's shown.
        fc.setSelectedFile(null);

        return path;
    }
}
