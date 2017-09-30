package cr.ac.ucr.ecci.ci1330.IoC;

import cr.ac.ucr.ecci.ci1330.IoC.AnnotationBased.AnnotationBeanFactory;
import cr.ac.ucr.ecci.ci1330.IoC.XMLBased.XMLBeanFactory;
import cr.ac.ucr.ecci.ci1330.IoC.annotadedClasses.Mascota;
import cr.ac.ucr.ecci.ci1330.IoC.annotadedClasses.Persona;
import cr.ac.ucr.ecci.ci1330.IoC.AnnotationBased.testAnnotations;

import java.util.LinkedList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        AbstractBeanFactory hybridTeste= new XMLBeanFactory("src/main/resources/hybridBeans.xml");
     //   AbstractBeanFactory annotationTest = new AnnotationBeanFactory("src/main/resources/xmlAnnotations.xml");
        Persona persona= (Persona) hybridTeste.getBean("Persona");
        System.out.println(persona.getEdad());
        Mascota mascota= (Mascota) hybridTeste.getBean("Mascota");
        System.out.println(mascota.getName());
        Estudiante estudiante= (Estudiante) hybridTeste.getBean("Estudiante");
        System.out.println(estudiante.getName());
     //   Persona persona = (Persona) hybridTeste.getBean("persona");
      //  System.out.println(persona.getNombre());
       // String path = "SpringContainer/src/main/resources/beans.xml";
//        AbstractBeanFactory abstractBeanFactory= new XMLBeanFactory(path);

     //   System.out.println("beanHashMap.size()= "+abstractBeanFactory.beanHashMap.size());

      //  Persona persona= (Persona) abstractBeanFactory.getBean("Persona");
        //System.out.println(persona.getNombre());

     //   testeReflection testeReflection= (cr.ac.ucr.ecci.ci1330.IoC.testeReflection) abstractBeanFactory.getBean("teste");

       // System.out.println(testeReflection.getMascota().getName());
        //System.out.println(testeReflection.getEstudiante().getName());

       // System.out.println();
     /*   System.out.println(testeReflection.getEst().getName());
        System.out.println(testeReflection.getEstudiante().getName());
        System.out.println(testeReflection.getMascota().getName());
      //  System.out.println(testeReflection.);
/*
        testeReflection.setNum(9);
        System.out.println(testeReflection.getP().getName());
        testeReflection testeReflection2= (cr.ac.ucr.ecci.ci1330.IoC.testeReflection) abstractBeanFactory.getBean("teste");
        System.out.println(testeReflection2.getNum());
        testeReflection.setNum(3);
        System.out.println(testeReflection.getNum());
*/
        //errores: al constructor no se le puede poner mas de un parametro


    }
}
