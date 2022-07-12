import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManagement {
    //存放学生信息的数组列表
    private static final ArrayList<Student> students = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("学生信息管理系统");
            System.out.println("=============");
            System.out.println("1.Log");
            System.out.println("2.Exit");
            System.out.println("=============");
            System.out.println("Please choice 1 and 0!");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> login();
                case 2 -> {
                    System.out.println("谢谢使用");
                    isRunning = false;
                }
                default -> System.out.println("输入的选项有误!");
            }
        }
    }

    //登录方法,登录成功进入菜单
    private static void login() {
        String user;
        String password;

        System.out.print("请输入用户名:");
        user = scanner.next();
        System.out.print("请输入密码:");
        password = scanner.next();

        if (user.equals("秦政") || password.equals("111111111")) {
            System.out.println("登录成功!");
            menu();
        } else {
            System.out.println("登录失败!");
        }
    }

    private static void menu() {
        int choice;
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("  菜单选项  ");
            System.out.println("===========");
            System.out.println("1.增加学生信息");
            System.out.println("2.修改学生信息");
            System.out.println("3.查询学生信息");
            System.out.println("4.删除学生信息");
            System.out.println("5.读取学生信息");
            System.out.println("6.保存学生信息");
            System.out.println("7.查看所有学生信息");
            System.out.println("8.返回上一级");
            System.out.println("===========");
            System.out.println("菜单选项[1,2,3,4,5,6,7]");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("请输入学生信息:");
                    addStudent();
                }
                case 2->{
                    System.out.println("正在修改·······");
                    modifyStudent();
                }
                case 3->{
                    System.out.println("执行查询");
                    findStudent();
                }
                case  4->{
                    System.out.println("执行删除中");
                    deleteStudent();
                }
                case 5->{
                    System.out.println("读取中·····");
                    readStudentFile();
                }
                case 6->{
                    System.out.println("保存中·····");
                    saveStudents();
                }
                case 7 -> {
                    System.out.println("所有信息如下:");
                    all();
                }
                case 8->{
                    isRunning=false;
                    System.out.println("退出程序");
                }
                default -> System.out.println("输入错误!");
            }
        }

    }

    private static void addStudent() {
        String id;
        String name;
        String classes;
        String major;
        String telephone;

        System.out.print("学号:");
        id = scanner.next();
        System.out.print("姓名:");
        name = scanner.next();
        System.out.print("班级:");
        classes = scanner.next();
        System.out.print("专业:");
        major = scanner.next();
        System.out.print("电话:");
        telephone = scanner.next();

        //定义对象
        Student student = new Student(id, name, classes, major, telephone);
        //将对象添加至列表中
        students.add(student);
    }

    //查看所有学生信息
    private static void all() {
        for (Student student : students
        ) {
            System.out.println(student.toString());
        }
    }

    /**
     * 保存学生信息到文件
     */
    private static void saveStudents() {
        try {
            // 创建文件字符输出流
            FileWriter fw = new FileWriter("students.txt");
            // 创建学生容器字符串缓冲对象
            StringBuilder cardsBuffer = new StringBuilder();
            // 用增强for循坏遍历学生数组列表
            for (Student student : students) {
                // 输出学生对象
                System.out.println(student);
                // 创建学生字符串缓冲对象
                // 添加学生字段信息（空格作为分隔符）
                String buffer = student.getId() + " " +
                        student.getName() + " " +
                        student.getClasses() + " " +
                        student.getMajor() + " " +
                        student.getTelephone();
                // 将学生信息写入名片容器字符串缓冲对象
                cardsBuffer.append(buffer).append("\n");
            }
            // 将学生容器字符串缓冲对象的数据写入文件
            fw.write(students.toString());
            // 关闭文件字符输出流
            fw.close();
            // 提示用户写入成功
            System.out.println("恭喜，学生信息数据写入文件成功~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 读取学生信息文件，保存到学生数组列表
     */
    private static void readStudentFile() {
        // 创建文件字符输入流
        try {
            FileReader fr = new FileReader("students.txt");
            // 创建缓冲字符输入流
            BufferedReader br = new BufferedReader(fr);
            // 定义行变量
            String nextLine;
            // 通过循坏读取名片文件
            while ((nextLine = br.readLine()) != null) {
                // 拆分行字符串得到字段数值
                String[] fields = nextLine.split(" ");
                // 创建学生对象
                Student student = new Student();
                // 用字段数值设置对象属性
                student.setId(fields[0]);
                student.setName(fields[1]);
                student.setClasses(fields[2]);
                student.setMajor(fields[3]);
                student.setTelephone(fields[4]);
                // 输出学生对象
                System.out.println("添加"  + student + "到学生数组列表");
                // 将学生对象添加到学生数组列表
                students.add(student);
            }
            // 关闭缓冲字符输入流
            br.close();
            // 关闭文件字符输入流
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("温馨提示：学生文件不存在~");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //Bug1  查询出来的结果是对的，但是else条件也执行了  ⭐ --------已解决
    private static void findStudent(){
        int choice;
        boolean isRunning=true;
        String id;
        String name;

        while(isRunning){
            System.out.println("查询菜单");
            System.out.println("1.按学号查找");
            System.out.println("2.按姓名查找");
            System.out.println("3.退出查询");

            choice=scanner.nextInt();
            switch (choice){
                case 1->{
                    System.out.print("请输入学号:");
                    id=scanner.next();
                    for (Student student:students
                    ) {
                        if(id.equals(student.getId())){
                            System.out.println("存在此人");
                            System.out.println(student);
                            break;
                        }
                        else{
                            System.out.println("查无此人");
                        }
                    }
                }
                case 2->{
                    System.out.println("请输入姓名:");
                    name=scanner.next();
                    for (Student student:students
                    ) {
                        if(name.equals(student.getName())){
                            System.out.println("存在此人");
                            System.out.println(student);
                            break;
                        }else {
                            System.out.println("查无此人");
                        }
                    }
                }
                case 3-> isRunning=false;
                default -> System.out.println("输入错误选项，请重新输入");
            }
        }
    }

    //Bug2  回车不出结果，改需求换成输入—"-"  ⭐ --------已解决
    private static void modifyStudent(){
        String id;
        String name;
        String classes;
        String major;
        String telephone;

        boolean isRunning=false;

        System.out.println("请输入修改学生的学号:");
        id=scanner.next();
        for (Student student:students
        ) {
            if(student.getId().equals(id)){
                isRunning=true;
                System.out.println("学生信息:"+"\n"+student);
                break;
            }
        }
        if (isRunning){
            System.out.println("输入修改的信息，不需要修改的输入“-”!");
            for(int i=0;i<students.size();i++){
                Student student=students.get(i);
                if(student.getId().equals(id)){
                    System.out.print("姓名:");
                    name=scanner.next();
                    if(!name.equals("-")){
                        student.setName(name);
                    }
                    System.out.print("班级:");
                    classes=scanner.next();
                    if(!classes.equals("-")){
                        student.setClasses(classes);
                    }
                    System.out.print("专业:");
                    major=scanner.next();
                    if(!major.equals("-")){
                        student.setMajor(major);
                    }
                    System.out.print("电话:");
                    telephone=scanner.next();
                    if(!telephone.equals("-")){
                        student.setTelephone(telephone);
                    }
                    students.set(i,student);
                    System.out.println(students.get(i));
                    break;
                }
            }
        }else{
            System.out.println("查无此人!");
        }
    }

    private static void deleteStudent(){
        System.out.print("请输入删除学生的id:");
        String id=scanner.next();

        int index=-1;
        for(int i=0;i<students.size();i++){
            Student student=students.get(i);
            if(student.getId().equals(id)){
                index=i;
                break;
            }
        }

        if(index==-1){
            System.out.println("学号不存在!");
        }else {
            students.remove(index);
            System.out.println("删除成功!");
        }
    }
}