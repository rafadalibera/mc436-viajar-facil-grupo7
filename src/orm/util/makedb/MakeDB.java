// Adaptado de
//http://www.developerfusion.com/code/2064/a-simple-way-to-read-an-xml-file-in-java/
package orm.util.makedb;

import java.io.File;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import entidades.Passeio;
import entidades.Pacote;
import entidades.GuiaTuristico;

public class MakeDB
{
    private static void criaPasseios(Document doc)
    {
        double valor;
        String local, info;
        int id, dia, mes, ano;

        NodeList listaPasseios = doc.getElementsByTagName("passeio");

        for (int i = 0; i < listaPasseios.getLength(); i++) {
            Node n = listaPasseios.item(i);
            Element e;
            NodeList listaPorTag;

            // id
            listaPorTag = ((Element) n).getElementsByTagName("id");

            // Pular tags passeio dentro de pacotes
            if (listaPorTag.getLength() == 0) {
                continue;
            }

            e = (Element) listaPorTag.item(0);
            id = Integer.parseInt(((Node) e.getChildNodes().item(0)).getNodeValue());

            // Data
            listaPorTag = ((Element) n).getElementsByTagName("data");
            e = (Element) listaPorTag.item(0);

            dia = Integer.parseInt(e.getAttribute("dia"));
            mes = Integer.parseInt(e.getAttribute("mes"));
            ano = Integer.parseInt(e.getAttribute("ano"));

            // Local
            listaPorTag = ((Element) n).getElementsByTagName("local");
            e = (Element) listaPorTag.item(0);
            local = ((Node) e.getChildNodes().item(0)).getNodeValue().trim();

            // Informações do passeio
            listaPorTag = ((Element) n).getElementsByTagName("info");
            e = (Element) listaPorTag.item(0);
            info = ((Node) e.getChildNodes().item(0)).getNodeValue().trim();

            // Preço
            listaPorTag = ((Element) n).getElementsByTagName("valor");
            e = (Element) listaPorTag.item(0);
            valor = Double.parseDouble(((Node) e.getChildNodes().item(0)).getNodeValue());

            Passeio p = new Passeio(id, local, ano, mes, dia, info, valor);
            p.salvar();
        }
    }

    private static void criaPacotes(Document doc)
    {
        double valor;
        String local, info;
        int id, diaIda, mesIda, anoIda, diaVolta, mesVolta, anoVolta;

        NodeList listaPasseios = doc.getElementsByTagName("pacote");

        for (int i = 0; i < listaPasseios.getLength(); i++) {
            Node n = listaPasseios.item(i);
            Element e;
            NodeList listaPorTag;

            // id
            listaPorTag = ((Element) n).getElementsByTagName("id");
            e = (Element) listaPorTag.item(0);
            id = Integer.parseInt(((Node) e.getChildNodes().item(0)).getNodeValue());

            // Data de ida
            listaPorTag = ((Element) n).getElementsByTagName("dataIda");
            e = (Element) listaPorTag.item(0);

            diaIda = Integer.parseInt(e.getAttribute("dia"));
            mesIda = Integer.parseInt(e.getAttribute("mes"));
            anoIda = Integer.parseInt(e.getAttribute("ano"));

            // Data de volta
            listaPorTag = ((Element) n).getElementsByTagName("dataVolta");
            e = (Element) listaPorTag.item(0);

            diaVolta = Integer.parseInt(e.getAttribute("dia"));
            mesVolta = Integer.parseInt(e.getAttribute("mes"));
            anoVolta = Integer.parseInt(e.getAttribute("ano"));

            // Local
            listaPorTag = ((Element) n).getElementsByTagName("local");
            e = (Element) listaPorTag.item(0);
            local = ((Node) e.getChildNodes().item(0)).getNodeValue().trim();

            // Informações do pacote
            listaPorTag = ((Element) n).getElementsByTagName("info");
            e = (Element) listaPorTag.item(0);
            info = ((Node) e.getChildNodes().item(0)).getNodeValue().trim();

            // Preço
            listaPorTag = ((Element) n).getElementsByTagName("valor");
            e = (Element) listaPorTag.item(0);
            valor = Double.parseDouble(((Node) e.getChildNodes().item(0)).getNodeValue());

            Pacote p = new Pacote(id, local, anoIda, mesIda, diaIda, anoVolta,
                                  mesVolta, diaVolta, valor, info);

            // Passeios
            listaPorTag = ((Element) n).getElementsByTagName("passeio");

            for (int j = 0; j < listaPorTag.getLength(); j++) {
                e = (Element) listaPorTag.item(j);
                int passeioId = Integer.parseInt(e.getAttribute("id"));

                p.addPasseio(Passeio.porId(passeioId).get(0));
            }

            p.salvar();
        }
    }

    private static void criaGuias(Document doc)
    {
        int id;
        String local, email, lingua, nome, telefone;

        NodeList listaPasseios = doc.getElementsByTagName("guia");

        for (int i = 0; i < listaPasseios.getLength(); i++) {
            Node n = listaPasseios.item(i);
            Element e;
            NodeList listaPorTag;

            // id
            listaPorTag = ((Element) n).getElementsByTagName("id");
            e = (Element) listaPorTag.item(0);
            id = Integer.parseInt(((Node) e.getChildNodes().item(0)).getNodeValue());

            // Nome
            listaPorTag = ((Element) n).getElementsByTagName("nome");
            e = (Element) listaPorTag.item(0);
            nome = ((Node) e.getChildNodes().item(0)).getNodeValue().trim();

            // Telefone
            listaPorTag = ((Element) n).getElementsByTagName("telefone");
            e = (Element) listaPorTag.item(0);
            telefone = ((Node) e.getChildNodes().item(0)).getNodeValue().trim();

            // Email
            listaPorTag = ((Element) n).getElementsByTagName("email");
            e = (Element) listaPorTag.item(0);
            email = ((Node) e.getChildNodes().item(0)).getNodeValue();

            // Local
            listaPorTag = ((Element) n).getElementsByTagName("local");
            e = (Element) listaPorTag.item(0);
            local = ((Node) e.getChildNodes().item(0)).getNodeValue().trim();

            // Local
            listaPorTag = ((Element) n).getElementsByTagName("lingua");
            e = (Element) listaPorTag.item(0);
            lingua = ((Node) e.getChildNodes().item(0)).getNodeValue().trim();

            GuiaTuristico g = new GuiaTuristico(id, nome, telefone, email, local, lingua);
            g.salvar();
        }
    }

    public static void main (String args []){
        if (args.length < 1) {
            System.err.println("Você precisa especificar um xml!");
            return;
        }

        try {
            DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(new File(args[0]));

            doc.getDocumentElement().normalize();

            // criaPasseios deve ser chamado antes de criaPacotes
            criaPasseios(doc);
            criaPacotes(doc);
            criaGuias(doc);

        } catch (SAXParseException err) {
            System.out.println ("Erro ao parsear html, linha " + err.getLineNumber());
            System.out.println(" " + err.getMessage ());
        } catch (SAXException e) {
            Exception x = e.getException ();
            ((x == null) ? e : x).printStackTrace();
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
