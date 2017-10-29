package io;

import java.io.*;
import java.util.*;

/**
 * 读取a.TXT中的数据 计算出课程的总分 还要按总分排序
 */
public class CountGradeAndSort {
    //记录所有学生
    static List<Map<String,Object>>  studentList = new ArrayList<>();
    // 记录学号和总分,用于排序
    static List<Map<String, Object>> sortList = new ArrayList<Map<String, Object>>();
    //源文件中的列名
    static String[] columnName = {"学号","姓名","语文","数学","英语"};

    public static void main(String[] args) throws Exception {
        //读取文件内容, 每次读一行数据
        BufferedReader bufferedReader = new BufferedReader(new FileReader("D:\\a.txt"));
        bufferedReader.readLine();//去除标题

        String line;//保存每一行的记录
        while ((line = bufferedReader.readLine()) != null) {
            //提取出一行记录的各个列的值
            Map<String, Object> studentMap = new HashMap<>();
            String[] lineSpilt = line.split(" ");
            int count=0;
            for(int i=0; i < lineSpilt.length; i++) {
                if("".equals(lineSpilt[i])) {
                    continue;
                }
                if(count >= columnName.length) {
                    continue;
                }
                studentMap.put(columnName[count],lineSpilt[i]);
                count++;
            }

          //计算语文,数学, 英语的总分
            double total = 0;
            //取出 columnName 语文, 数学, 英语的下标
            for (int i=2; i<5; i++) {
                total += Double.parseDouble((String) studentMap.get(columnName[i]));
            }
            studentMap.put("总分",total);

            //添加学生
            studentList.add(studentMap);

            //添加排序
            Map<String, Object> sortMap = new HashMap<String, Object>();
            sortMap.put("学号", studentMap.get("学号")); //学号
            sortMap.put("总分", studentMap.get("总分"));
            sortList.add(sortMap);
        }
        bufferedReader.close();
        sort();
        printA();

    }

    //输出都文件中
     public static void printA() throws Exception{
         PrintWriter pw = new PrintWriter("D:\\b.txt");
         pw.println("Id\tName\tLan\tMath\tEnglish\tTotal\tSort");
         int cIndex;
         for (int i = 0; i < studentList.size(); i++){
             Map<String, Object> st = studentList.get(i);
             cIndex = 0;
             pw.println(st.get(columnName[cIndex++]) + "\t"
                     + st.get(columnName[cIndex++]) + "\t"
                     + st.get(columnName[cIndex++]) + "\t"
                     + st.get(columnName[cIndex++]) + "\t"
                     + st.get(columnName[cIndex++]) + "\t"
                     + st.get("总分") + "\t"
                     + st.get("总分排名"));
         }
         pw.flush();
         pw.close();
     }

    //排序
    public static void sort() {
        for (int i = 0; i < sortList.size(); i++) {
            for (int j = i + 1; j < sortList.size(); j++) {
                if ((Double) sortList.get(i).get("总分") < (Double) sortList.get(j).get("总分")){
                    Map<String, Object> temp = sortList.get(i);
                    sortList.set(i, sortList.get(j));
                    sortList.set(j, temp);
                }
            }
        }

        //记录学号和总分排名
        Map<Object, Integer> sortedID = new HashMap<Object, Integer>();
        for (int i = 0; i <sortList.size() ; i++) {
            sortedID.put(sortList.get(i).get("学号"),i+1);
        }

        //每个学生添加学号对应的总分排名
        for (int i = 0; i < studentList.size(); i++) {
            studentList.get(i).put("总分排名",sortedID.get(studentList.get(i).get("学号")));
        }
    }



}
