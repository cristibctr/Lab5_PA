/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5_pa;

import java.io.File;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static lab5_pa.Main.catalog;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;
import java.io.IOException;
import java.util.Locale;
/**
 *
 * @author crist
 */
public class ReportCommand extends Commands{

    public ReportCommand() throws IOException, TemplateException {
        System.out.println("Report()");
        Configuration cfg = new Configuration();
        //cfg.setClassForTemplateLoading(ReportCommand.class, "templates");
        cfg.setDirectoryForTemplateLoading(new File("D:/Facultate/An2 Sem2/PA/Lab5_PA/src/main/java/lab5_pa/templates"));
        cfg.setIncompatibleImprovements(new Version(2, 3, 20));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setLocale(Locale.US);
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        
        Map<String, Object> input = new HashMap<>();
        input.put("title", "Catalog report");
        input.put("catalog", catalog);
        input.put("items", catalog.getItems());
        
        Template template = cfg.getTemplate("report.ftl");
        
        Writer fileWriter = new FileWriter(new File("report.html"));
        try {
            template.process(input, fileWriter);
        } finally {
            fileWriter.close();
        }

    }
    
}
