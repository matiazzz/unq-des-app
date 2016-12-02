package appdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import model.events.Event;
import org.aspectj.weaver.ast.Test;
import org.joda.time.LocalDate;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import static model.builders.EventBuilder.anyEvent;

public class XMLParser {

    public List<Event> events = new ArrayList<>();
    String title = "";
    String descripcion = "";
    String fecha = "";
    String hora = "";
    String minutos = "";
    String imagen = "";

    public void parseEvents(String filePath){
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();

            DefaultHandler handler = new DefaultHandler() {
                boolean btitulo = false;
                boolean bdescripcion = false;
                boolean bfechainicio = false;
                boolean bimagen = false;
                boolean bhora = false;
                boolean bminutos = false;

                public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
                    if (qName.equalsIgnoreCase("Titulo")) { btitulo = true; }
                    if (qName.equalsIgnoreCase("Descripcion")) { bdescripcion = true; }
                    if (qName.equalsIgnoreCase("FechaInicio")) { bfechainicio = true; }
                    if (qName.equalsIgnoreCase("Imagen")) { bimagen = true; }
                    if (qName.equalsIgnoreCase("Hora")) { bhora = true; }
                    if (qName.equalsIgnoreCase("Minutos")) { bminutos = true; }
                }

                public void endElement(String uri, String localName,  String qName) throws SAXException {
                    if(qName.equalsIgnoreCase("item")){
                        if(fecha != "") {
                            Event event = anyEvent()
                                    .withTitle(title)
                                    .withDescription(descripcion)
                                    .withDate(new LocalDate(fecha))
                                    .withImgUrl("http://disfrutemosba.buenosaires.gob.ar/imagenes/imagegallery/"+imagen)
                                    .build();
                            events.add(event);
                        }
                    }
                }

                public void characters(char ch[], int start, int length) throws SAXException {
                    if (btitulo) {
                        btitulo = false;
                        title = new String(ch, start, length);
                    }
                    if (bdescripcion) {
                        bdescripcion = false;
                        descripcion = new String(ch, start, length);
                    }
                    if (bfechainicio) {
                        bfechainicio = false;
                        fecha = new String(ch, start, length);
                    }
                    if (bhora) {
                        bhora = false;
                        hora = new String(ch, start, length);
                    }
                    if (bminutos) {
                        bminutos = false;
                        minutos = new String(ch, start, length);
                    }
                    if (bimagen) {
                        bimagen = false;
                        imagen = new String(ch, start, length);
                    }
                }
            };

            File here = new File("");
            File file = new File(here.getAbsolutePath() + filePath);
            InputStream inputStream= new FileInputStream(file);
            Reader reader = new InputStreamReader(inputStream,"UTF-8");

            InputSource is = new InputSource(reader);
            is.setEncoding("UTF-8");

            saxParser.parse(is, handler);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}