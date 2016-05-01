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
System.out.println("**********��ʦ����ϵͳ**********");
System.out.println("*1.��ѯ���н�ʦ��Ϣ");
System.out.println("*2.¼���ʦ��Ϣ");
System.out.println("*3.ɾ����ʦ��Ϣ");
System.out.println("*4.��ѯ������ʦ��Ϣ");
System.out.println("*5.�޸Ľ�ʦ��Ϣ");
System.out.println("*exit.�˳�");
System.out.println("*help.����");
System.out.println("********************************");
}

public static void main(String[] args){
Tms tms=new Tms();
tms.menu();
Scanner sc=new Scanner(System.in);
while(true){
System.out.print("�����빦�ܱ�ţ�");
String option=sc.nextLine();
switch(option){
case "1":
System.out.println("�����ǽ�ʦ����Ϣ��");
    Teacher[] arr=tms.queryAll();
for(int i=0;i<arr.length;i++){
System.out.println(arr[i]);
}
System.out.println("�ܼ�"+tms.index+"��");
    break;
case "2":
    while(true){
    System.out.println("�������ʦ����Ϣ��id#name#age����������break������һ��Ŀ¼");
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
System.out.println("����ɹ���");
}
    break;
case "3":
    
    break;
case "4":
    while(true){
    System.out.println("�������ʦid��������break������һ��Ŀ¼");
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
    System.out.println("������Ҫ�޸ĵĽ�ʦid��������break������һ��Ŀ¼");
String idStr=sc.nextLine();
if(idStr.equals("break")){
break;
}
long id=Long.parseLong(idStr[0]);
Teacher oldTch=tms.queryById(id);
if(oldTch==null){
System.out.println("��Ҫ�޸ĵĽ�ʦ�����ڣ�");
continue;
}
System.out.println("ԭ����ϢΪ��"+oldTch);
System.out.println("��������Ϣ��name#age��");
String newStr=sc.nextLine();
String[] newArr=newTch.split("#");
String name=newArr[0];
int age=integer.parseIntnewArr[1];
Teacher newTch=new Teacher(id,name,age);
tms.update(newTch);
System.out.println("�޸ĳɹ���");
}
    break;
case "exit":
    System.out.println("bye bye,��ӭ�ٴ�ʹ�ã�");
System.exit(0);
    break;
case "help":
    tms.menu();
    break;
default:
System.out.println("���Ϸ����룡");
}
}
}
}


