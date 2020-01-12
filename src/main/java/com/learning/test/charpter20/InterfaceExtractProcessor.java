package com.learning.test.charpter20;

import javax.annotation.processing.*;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import java.util.Set;
@SupportedSourceVersion(SourceVersion.RELEASE_8)
@SupportedAnnotationTypes("annotation.ExtractInterface")
public class InterfaceExtractProcessor extends AbstractProcessor {

    private TypeElement extractElement;

    public synchronized  void init(ProcessingEnvironment processEnv){
        super.init(processEnv);
        Elements elements = processingEnv.getElementUtils();

    }

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        return false;
    }
}
