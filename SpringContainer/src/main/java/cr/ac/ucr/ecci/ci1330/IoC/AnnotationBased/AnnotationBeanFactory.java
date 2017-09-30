package cr.ac.ucr.ecci.ci1330.IoC.AnnotationBased;


import com.sun.beans.finder.ClassFinder;
import cr.ac.ucr.ecci.ci1330.IoC.AbstractBeanFactory;
import cr.ac.ucr.ecci.ci1330.IoC.Bean.Bean;
import cr.ac.ucr.ecci.ci1330.IoC.ScopeType;
import nu.xom.Builder;
import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Elements;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AnnotationBeanFactory extends AbstractBeanFactory {

    private AnnotationParser annotationParser;
    private HashMap<String, Object> annotationsContent;


    public AnnotationBeanFactory(String xmlPath) {
        annotationsContent = new HashMap<>();
        List<Class> annotatedClasses = this.getClassesFromPackage(xmlPath);
        for (Class aClass: annotatedClasses) {
            this.annotationParser = new AnnotationParser(aClass, this);
        }
    }

    public HashMap<String, Object> getAnnotationsContent() {
        return annotationsContent;
    }

    @Override
    public HashMap<String, Object> obtainBeanAttributes(String id){
        return (HashMap<String, Object>) annotationsContent.get(id);
    }

    public List<Class> getClassesFromPackage(String configFile){
        Builder builder = new Builder();
        Document xmlDoc = null;
        List<Class> annotadedClasses = new ArrayList<>();
        try {
            xmlDoc = builder.build(configFile);
            Element root = xmlDoc.getRootElement();
            Elements classes = root.getChildElements();
            for (int i=0; i<classes.size(); i++){
                String packageName = classes.get(i).getAttribute("package").getValue();
                Class aClass = Class.forName(packageName);
                annotadedClasses.add(aClass);
            }
        } catch (Exception e) {
            System.out.println("El path es incorrecto");
            e.printStackTrace();
        }
        return annotadedClasses;
    }
}

