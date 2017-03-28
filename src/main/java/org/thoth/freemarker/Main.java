/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.thoth.freemarker;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author h1mjr01
 */
public class Main {

    public static void main(String[] args) throws Exception {
        // -------------------- Create a configuration instance
        // Create your Configuration instance, and specify if up to what FreeMarker
        // version (here 2.3.25) do you want to apply the fixes that are not 100%
        // backward-compatible. See the Configuration JavaDoc for details.
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_25);

        // Specify the source where the template files come from. Here I set a
        // plain directory for it, but non-file-system sources are possible too:
        cfg.setDirectoryForTemplateLoading(new File("./src/main/freemarker"));

        // Set the preferred charset template files are stored in. UTF-8 is
        // a good choice in most applications:
        cfg.setDefaultEncoding("UTF-8");

        // Sets how errors will appear.
        // During web page *development* TemplateExceptionHandler.HTML_DEBUG_HANDLER is better.
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);

        // Don't log exceptions inside FreeMarker that it will thrown at you anyway:
        cfg.setLogTemplateExceptions(false);

        // --------------- Create a data-model
        // Create the root hash. We use a Map here, but it could be a JavaBean too.
        Map<String, Object> root = new HashMap<>();

        // Put string "user" into the root
        root.put("user", "Big Joe");

        // Create the "latestProduct" hash. We use a JavaBean here, but it could be a Map too.
        Product latest = new Product();
        latest.setUrl("products/greenmouse.html");
        latest.setName("green mouse");
        // and put it into the root
        root.put("latestProduct", latest);
        
        List<House> houses = new LinkedList<>();
        houses.add(new House("123 Main St., Belleville, IL 62221"));
        houses.add(new House("866 Fooz Blv., O'Fallon, IL 12345"));
        houses.add(new House("90723 Bozz Ct., St. Louis, MO 78230-9877"));
        houses.add(new House("65824 Forest Road, Shiloh, IL 62220"));
        root.put("houses", houses);
        
        
        // ---------------------- Get the template
        Template temp = cfg.getTemplate("test.ftlt");
        
        // ---------------------- Merging the template with the data-model
        Writer out = new OutputStreamWriter(System.out);
        temp.process(root, out);
            
        
    }
}
