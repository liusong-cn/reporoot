package com.learning.test.charpter20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {

    public static void main(String[] args) throws ClassNotFoundException {
        String[] targetNames = {"com.learning.test.charpter20.Member"};

        for (String className : targetNames ) {
            Class<?> cl = Class.forName(className);
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            if(dbTable == null){
                System.out.println("No DBTable annotations in class" + className);
                continue;
            }
            String tableName = dbTable.name();
            if(tableName.length() < 1){
                tableName = className.toUpperCase();
            }
            List<String> columnDefs = new ArrayList<String>();
            for (Field field : cl.getDeclaredFields()) {
                Annotation[] anns = field.getAnnotations();
                if(anns.length < 1){
                    continue;
                }
                String columnName = null;
                //假定每个field上只有一个注解的情况下
                if(anns[0] instanceof SQLInteger){
                    SQLInteger sqlInteger =(SQLInteger)anns[0];
                    if(sqlInteger.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sqlInteger.name();
                    }
                    columnDefs.add(columnName + " INT " + getConstraints(sqlInteger.constraints()) + "\n");
                }

                if(anns[0] instanceof SQLString){
                    SQLString sqlString = (SQLString) anns[0];
                    if(sqlString.name().length() < 1){
                        columnName = field.getName().toUpperCase();
                    }else {
                        columnName = sqlString.name();
                    }
                    columnDefs.add(columnName + " VARCHAR(" + sqlString.value() + ")" + getConstraints(sqlString.constraints()) + "\n");
                }
            }

            StringBuffer sb = new StringBuffer();
            sb.append("CREATE TABLE " + tableName + "(");
            for (String columndef : columnDefs) {
                sb.append(columndef + ",");
            }
            String tableCreate = sb.substring(0,sb.length()-1) + ")";
            System.out.println(tableCreate);
        }
    }

    public static String getConstraints(Constraints constraints){
        String result = "";
        if(!constraints.allowNull()){
            result += "NOT NULL";
        }
        if(constraints.primaryKey()){
            result += "PRIMARY KEY";
        }
        if(constraints.unique()){
            result += "UNIQUE";
        }
        return result;
    }
}
