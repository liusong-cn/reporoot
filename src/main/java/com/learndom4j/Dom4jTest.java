package com.learndom4j;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.util.Iterator;
import java.util.List;

/**
 * @author: ls
 * @date: 2020/3/31 0031 14:32
 */
public class Dom4jTest {
    public static void main(String[] args) throws DocumentException {
        Document dom = DocumentHelper.parseText("<LIST>\n" +
                "\t<ZD_XM>\n" +
                "\t\t<STARDATE>\n" +
                "\t\t启动时间\n" +
                "\t\t</STARDATE>\n" +
                "\t\t<ENDDATE>\n" +
                "\t\t计划完成时间\n" +
                "\t\t</ENDDATE>\n" +
                "\t\t<PROJECTCTG_NAME>\n" +
                "\t\t项目分类名称\n" +
                "\t\t</PROJECTCTG_NAME>\n" +
                "\t\t<PROJECTCODE>\n" +
                "\t\t项目代号\n" +
                "\t\t</PROJECTCODE>\n" +
                "\t\t<PROJECTNAME>\n" +
                "\t\t项目名称\n" +
                "\t\t</PROJECTNAME>\n" +
                "\t\t<PROJECTSTA_NAME>\n" +
                "\t\t项目状态名称\n" +
                "\t\t</PROJECTSTA_NAME>\n" +
                "\t\t<RESDEP_DEPTFULLNAME>\n" +
                "\t\t责任部门名称\n" +
                "\t\t</RESDEP_DEPTFULLNAME>\n" +
                "\t\t<OWNER_USERNAME>\n" +
                "\t\t责任人姓名\n" +
                "\t\t</OWNER_USERNAME>\n" +
                "\t\t<SECURITY_NAME>\n" +
                "\t\t项目密级名称\n" +
                "\t\t</SECURITY_NAME>\n" +
                "\t\t<PROJECTGRADE_NAME>\n" +
                "\t\t项目定级名称\n" +
                "\t\t</PROJECTGRADE_NAME>\n" +
                "\t\t<PLAT_NAME>\n" +
                "\t\t项目平台名称\n" +
                "\t\t</PLAT_NAME>\n" +
                "\t\t<MILITARYBRANCH_NAME>\n" +
                "\t\t军种\n" +
                "\t\t</MILITARYBRANCH_NAME>\n" +
                "\t\t<DEVICEGRADE_NAME>\n" +
                "\t\t器材质量等级名称\n" +
                "\t\t</DEVICEGRADE_NAME>\n" +
                "\t\t<PLANMANAGER_USERNAME>\n" +
                "\t\t项目经理名称\n" +
                "\t\t</PLANMANAGER_USERNAME>\n" +
                "\t\t<CUSTOMPROJECTSTATE>\n" +
                "\t\t项目阶段\n" +
                "\t\t</CUSTOMPROJECTSTATE>\n" +
                "\t\t<CREATEDEPT>\n" +
                "\t\t创建部门\n" +
                "\t\t</CREATEDEPT>\n" +
                "\t\t<DATAID>\n" +
                "\t\t数据id\n" +
                "\t\t</DATAID>\n" +
                "\t</ZD_XM>\n" +
                "</LIST>");
        Element root = dom.getRootElement();
        List<Element> projectList = root.elements();
        for (Element e : projectList ) {
            for (Iterator it = e.elementIterator(); it.hasNext();) {
                Element field = (Element) it.next();
                System.out.println(field.getQName().getName());
                System.out.println(field.getName());
            }
        }
    }
}
