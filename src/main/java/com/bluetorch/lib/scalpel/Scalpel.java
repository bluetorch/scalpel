package com.bluetorch.lib.scalpel;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;
import java.util.Map;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Scalpel {

    private static Scalpel scalpel;

    private Scalpel() {
    }

    public static Scalpel getInstance() {
        if (scalpel == null) {
            scalpel = new Scalpel();
        }
        return scalpel;
    }

    public String replace(File html, List<Replacement> replacements) throws IOException {
        Document doc = Jsoup.parse(html, "utf-8");
        return replace(doc, replacements);
    }

    public String replace(String html, List<Replacement> replacements) {
        Document doc = Jsoup.parse(html);
        return replace(doc, replacements);
    }

    public String replace(InputStream html, List<Replacement> replacements) throws IOException {
        Document doc = Jsoup.parse(html, "utf-8", null);
        return replace(doc, replacements);
    }

    public String replace(URL url, List<Replacement> replacements) throws IOException {
        Document doc = Jsoup.parse(url, 5000);
        return replace(doc, replacements);
    }

    private String replace(Document html, List<Replacement> replacements) {
        for (Replacement r : replacements) {
            Elements found = html.select(r.getSelector());
            if (found.size() > 0) {                
                switch (r.getType()) {
                    case AFTER:
                        for (Element e: found) {
                            e.after(r.getFragment().getHtml());
                        }
                        break;
                    case APPEND:
                        for (Element e: found) {
                            e.append(r.getFragment().getHtml());
                        }
                        break;
                    case PREPEND:
                        for (Element e: found) {
                            e.prepend(r.getFragment().getHtml());
                        }
                        break;
                    case ATTRIBUTE:
                        Map<String,String> attributes = r.getFragment().getAttributes();
                        for (Element e: found) {
                            for (String name : attributes.keySet()) {
                                e.attr(name, attributes.get(name));
                            }
                        }
                        break;
                    case CONTENTS:
                        for (Element e: found) {
                            e.empty();
                            e.append(r.getFragment().getHtml());
                        }
                        break;
                    case NODE:
                        for (Element e: found) {
                            e.after(r.getFragment().getHtml());
                            e.remove();
                        }
                        break;
                    case TEXT:
                        for (Element e: found) {
                            e.empty();
                            e.appendText(r.getFragment().getHtml());
                        }
                        break;
                    default:
                        break;
                }
            }
        }
        return html.outerHtml();
    }

}
