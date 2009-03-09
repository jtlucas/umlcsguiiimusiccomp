/*
 * File: XMLUtilities.java
 * Project Location: /public_html/91.462/91.462-2007-08s/462-lecs/code/XMLDemo
 * Copyright (c) 2008 by Jesse M. Heines.  All rights reserved.  May be freely 
 *   copied or excerpted for educational purposes with credit to the author.
 * created by JMH on February 28, 2008 at 11:07 AM
 */

package edu.uml.cs.GUIProgramming.rcaisse;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

/**
 * This class contains a collection of methods used to process XML files.
 * @author Jesse Heines, UMass Lowell Computer Science
 * @author <a href="mailto:heines@cs.uml.edu">heines@cs.uml.edu</a>
 */
public class XMLUtilities {

  /**
   * This method creates an empty <code>Document</code> object that can be used to store
   * data that will later be written out as an XML file.  It is adapted from 
   * code posted at 
   * <a href="http://www.exampledepot.com/egs/javax.xml.parsers/CreateDom.html"
   *    target="_top">
   * http://www.exampledepot.com/egs/javax.xml.parsers/CreateDom.html</a>.
   * @return an empty <code>Document</code> object
   * @see http://www.exampledepot.com/egs/javax.xml.parsers/CreateDom.html
   */
  public static Document createDomDocument() {
    try {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document localDoc = builder.newDocument() ;
      return localDoc ;
    } catch ( ParserConfigurationException pce ) {
      System.err.println( pce ) ;
    }
    return null ;    
  }


  
  /**
   * This method does the actual parsing of an XML file.  It is adapted from 
   * code posted at 
   * <a href="http://www.exampledepot.com/egs/javax.xml.parsers/BasicDom.html"
   *    target="_top">http://www.exampledepot.com/egs/javax.xml.parsers/BasicDom.html</a>.
   * @param url the URL of the file to read, as returned by the <code>getClass().getResource()</code> method
   * @param validating true if the XML file should be validated against its DTD (Document Type Definition)
   * @return a valid <code>Document</code> object or <code>null</code> if parsing fails
   */
  public static Document parseXmlFile( URL url, boolean validating ) {
    File file = null;  // initialize in method scope
    try {
      file = new File( url.toURI() );
      if ( !file.exists() ) {
        return null;
      }
    } catch ( URISyntaxException urise ) {
      System.err.println( urise );
    }

    // source: http://www.exampledepot.com/egs/javax.xml.parsers/BasicDom.html
    try {
      // Create a builder factory
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setValidating( validating );

      // Create the builder and parse the file
      return  factory.newDocumentBuilder().parse( file );
    } catch ( SAXException e ) {
      // A parsing error occurred; the XML input is not valid
    } catch ( ParserConfigurationException e ) {
    } catch ( IOException e ) {
    }

    return null;
  }
  
  
  /**
   * This method does the actual parsing of an XML file.  It is adapted from 
   * code posted at 
   * <a href="http://www.exampledepot.com/egs/javax.xml.parsers/BasicDom.html"
   *    target="_top">http://www.exampledepot.com/egs/javax.xml.parsers/BasicDom.html</a>.
   * @param url the URL of the file to read, as returned by the <code>getClass().getResource()</code> method
   * @param validating true if the XML file should be validated against its DTD (Document Type Definition)
   * @return a valid <code>Document</code> object or <code>null</code> if parsing fails
   */
  public static Document parseXmlFile( String strOpenFilePath ) 
      throws MalformedURLException {
    // replace backslashes in Windows file paths with forward slashes
    strOpenFilePath = strOpenFilePath.replaceAll( "\\\\", "/" ) ;
    // replace spaces in file paths with %20
    strOpenFilePath = strOpenFilePath.replaceAll( " ", "%20" ) ;
    
    URL url = new URL( "file", "/", strOpenFilePath ) ;
    return XMLUtilities.parseXmlFile( url, false ) ;
  }


  
  
  /** Return a <code>String</code> containing an XML file in serialized form.
   *  @param  doc  the <code>Document</code> object for the XML file to list
   *  @return (<code>String</code>) the XML file in serialized form
   */
  public static String getXMLListing( Document doc ) {
    // make a serializable version of the XML Document object
    // reference:  www-106.ibm.com/developerworks/xml/library/x-injava2/?dwzone=xml
    OutputFormat of = new OutputFormat( doc ) ;
    of.setIndenting( true ) ;   // setIndenting must preceed setIndent
    of.setIndent( 2 ) ;
    of.setLineSeparator( System.getProperty( "line.separator" ) ) ;
    // of.setPreserveSpace( true ) ;
    StringWriter sw = new StringWriter() ;
      // use a StringWriter instead of serializing directly to the 
      //  ObjectOutputStream because serializing directly yields a 
      //  java.io.OptionalDataException when reading the data with 
      //  ObjectInputStream.readObject()
    XMLSerializer xmlser = new XMLSerializer( sw, of ) ;
    try {
      xmlser.serialize( doc ) ;
    } catch ( IOException ioe ) {
        return "<p>IOException Error in getXMLListing( Document ):<br/>" +
               "&nbsp;&nbsp;&nbsp;" + ioe.toString() ;
    }
    
    return sw.toString() ;
  }

  
  
  /** 
   * Write the <code>Document</code> in memory out to a standard XML file.
   * @param  doc  the <code>Document</code> object for the XML file to list
   * @param  strFilePath  the XML file to write to
   * @throws custom custom exception if file is not writeable
   * @throws ioe IOException if an error occurs on file creation
   * @throws fnfe FileNotFoundException if PrintWriter constructor fails
   */
  public static void WriteXMLFile2( Document doc, String strFilePath ) 
      throws Exception {
    // open file for writing
    File file = new File( strFilePath ) ;
    
    // ensure that file is writeable
    try {
      file.createNewFile();
      if ( ! file.canWrite() ) { throw new Exception( "FileNotWriteable" ) ; }
    } catch ( IOException ioe ) {
      throw ioe ;
    }
    
    // create a PrintWriter to write the XML file to
    PrintWriter pw = null ;
    try {
      pw = new PrintWriter( file ) ;
    } catch ( FileNotFoundException fnfe ) {
      throw fnfe ;
    }
    
    // write out the serialized form
    pw.print( getXMLListing( doc ) ) ;
    pw.close() ;
  }
  
}
