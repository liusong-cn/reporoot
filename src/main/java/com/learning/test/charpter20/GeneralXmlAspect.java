package com.learning.test.charpter20;

import com.common.util.ApplicationContextUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author: ls
 * @date: 2020/4/9 0030 14:56
 */
@Aspect
@Component
public class GeneralXmlAspect {

    //private static Logger log = LogManager.getLogger(GeneralXmlAspect.class);

    private static List<String> eleNames = Arrays.asList("STARDATE","ENDDATE","PROJECTCTG_NAME"
            ,"PROJECTCODE","PROJECTNAME","PROJECTSTA_NAME","RESDEP_DEPTFULLNAME","OWNER_USERNAME","SECURITY_NAME",
            "PROJECTGRADE_NAME","PLAT_NAME","MILITARYBRANCH_NAME","DEVICEGRADE_NAME","PLANMANAGER_USERNAME",
            "CUSTOMPROJECTSTATE","CREATEDEPT","DATAID");

    @Around("@annotation(xmlStructure)")
    public void doAround(ProceedingJoinPoint joinPoint, XmlStructure xmlStructure) throws Throwable {
        System.out.println("around");
        Map<String,Object> map = ApplicationContextUtil.getContext().getBeansWithAnnotation(xmlStructure.getClass());
//        Class clazz = joinPoint.getSignature().getClass();
//        //判断类实例是否相等，同一个classloader加载的使用 == 或 equals均可
//        if(clazz == ProjectInfoSupportImpl.class){
//            ProjectInfoSupportImpl p = (ProjectInfoSupportImpl) joinPoint.getTarget();
//            Object[] xmlInfo = joinPoint.getArgs();
//            String xmlStr = (String)xmlInfo[0];
//            try {
//                if(checkStructure(xmlStr)) joinPoint.proceed();
//            } catch (DocumentException e) {
//                log.error("xml初始化失败");
//                e.printStackTrace();
//            } catch (Throwable throwable) {
//                throwable.printStackTrace();
//            }
//
//        }
        joinPoint.proceed();
    }


    private boolean checkStructure(String xmlStr) throws DocumentException {
        Document dom = DocumentHelper.parseText(xmlStr);
        Element root = dom.getRootElement();
        List<Element> projectList = root.elements("ZD_XM");
        boolean match = true;
        if (projectList == null || projectList.size() == 0){
            //log.error("xml格式不正确,缺少节点ZD_XM");
            match = false;
            return match;
        }
        List<String> elementNames = new ArrayList<>();
        for (Element e :projectList ) {
            for (Iterator i = e.elementIterator(); i.hasNext();) {
                Element field = (Element) i.next();
                elementNames.add(field.getName());
            }
            match = eleStrictMartch(elementNames);
            elementNames.clear();
            if(!match) {
                //log.error("xml正文内容格式不匹配,xml:" + xmlStr);
                break;
            }

        }
        return match;
    }

    private boolean eleStrictMartch(List<String> elementNames){
        if(elementNames.size() != eleNames.size()){
            return false;
        }
        if(!(elementNames.containsAll(eleNames) && eleNames.containsAll(elementNames))){
            return false;
        }
        return true;
    }
}
