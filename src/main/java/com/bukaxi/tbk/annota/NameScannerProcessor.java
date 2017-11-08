package com.bukaxi.tbk.annota;

import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.Diagnostic;

@SupportedAnnotationTypes("*")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class NameScannerProcessor extends AbstractProcessor {
	
	@Override
	public void init(ProcessingEnvironment processingEnv){
		super.init(processingEnv);
	}

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
		// TODO Auto-generated method stub
		if(!roundEnv.processingOver()){
			for(Element element : roundEnv.getElementsAnnotatedWith(NameScanner.class)){
				String name = element.getSimpleName().toString();
				System.out.println("===================dddd:" + name);
				if("name".equals(name)){
					throw new RuntimeException("dddddd");
				}
				processingEnv.getMessager().printMessage(Diagnostic.Kind.NOTE, "element name: " + name);
			}
		}
		return false;
	}

}
