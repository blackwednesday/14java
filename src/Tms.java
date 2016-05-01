package com.java.ch14;

import java.util.Scanner;

public class Tms{
private Teacher[] tchs=new Teacher[3];
private int index=0;

public void add(Teacher tch){
if(index>=tchs.length){
Teacher[] demo=new Teacher[tchs.length+3];
System.arraycopy(tchs,0,demo,0,index);
tchs=demo;
}
tchs[index++]=tch;
}

public void deleteById(long id){

}

public Teacher[] queryAll(){
Teacher[] demo=new Teacher[index];
System.arraycopy(tchs,0,demo,0,index);
return demo;
}


public Teacher queryById(long id){
int num=getIndexById(id);
return num==-1?null:tchs[num];
}

public int getIndexById(long id){
int num=-1;
for(int i=0;i<index;i++){
if(tchs[i].getId()==id){
num=i;
break;
}
}
return num;
}

public void update(Teacher tch){
for(int i=0;i<index;i++){
if(newTch.getId()==oldTch[i].getId()){
tchs[i].setName(newTch.getName());
tchs[i].setAge(newTch.getAge());
}
}
}

public void menu(){
System.out.println("**********教师管理系统**********");
System.out.println("*1.查询所有教师信息");
System.out.println("*2.录入教师信息");
System.out.println("*3.删除教师信息");
System.out.println("*4.查询单个教师信息");
System.out.println("*5.修改教师信息");
System.out.println("*exit.退出");
System.out.println("*help.帮助");
System.out.println("********************************");
}

public static void main(String[] args){
Tms tms=new Tms();
tms.menu();
Scanner sc=new Scanner(System.in);
while(true){
System.out.print("请输入功能编号：");
String option=sc.nextLine();
switch(option){
case "1":
System.out.println("以下是教师的信息：");
    Teacher[] arr=tms.queryAll();
for(int i=0;i<arr.length;i++){
System.out.println(arr[i]);
}
System.out.println("总计"+tms.index+"人");
    break;
case "2":
    while(true){
    System.out.println("请输入教师的信息【id#name#age】或者输入break返回上一级目录");
String tchStr=sc.nextLine();
if(tchStr.equals("break")){
break;
}
    String[] tchArr=tchStr.split("#");
long id=Long.parseLong(tchArr[0]);
String name=tchArr[1];
int age=Integer.parseInt(tchArr[2]);
Teacher tch=new Teacher(id,name,age);
tms.add(tch);
System.out.println("保存成功！");
}
    break;
case "3":
    
    break;
case "4":
    while(true){
    System.out.println("请输入教师id或者输入break返回上一级目录");
String idStr=sc.nextLine();
if(idStr.equals("break")){
break;
}
    String[] tchArr=idStr.split("#");
long id=Long.parseLong(tchArr[0]);
Teacher tch=tms.queryById(id);
System.out.println(tch==null?"sorry,not found!":tch);
}
    break;
case "5":
while(true){
    System.out.println("请输入要修改的教师id或者输入break返回上一级目录");
String idStr=sc.nextLine();
if(idStr.equals("break")){
break;
}
long id=Long.parseLong(idStr[0]);
Teacher oldTch=tms.queryById(id);
if(oldTch==null){
System.out.println("您要修改的教师不存在！");
continue;
}
System.out.println("原有信息为："+oldTch);
System.out.println("请输入信息【name#age】");
String newStr=sc.nextLine();
String[] newArr=newTch.split("#");
String name=newArr[0];
int age=integer.parseIntnewArr[1];
Teacher newTch=new Teacher(id,name,age);
tms.update(newTch);
System.out.println("修改成功！");
}
    break;
case "exit":
    System.out.println("bye bye,欢迎再次使用！");
System.exit(0);
    break;
case "help":
    tms.menu();
    break;
default:
System.out.println("不合法输入！");
}
}
}
}


