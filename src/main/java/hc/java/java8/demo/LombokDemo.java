package hc.java.java8.demo;


import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Data
@Accessors(chain = true) // 链式调用
public class LombokDemo implements Serializable {

    private String sky;

    @Getter
    @Setter
    @EqualsAndHashCode(of = {"name", "age"})
    @ToString(of = {"name", "age"})
    public static class Stu1{
        private String name;
        private String age;
        private String sex;
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE) // 指定生成的构造器 access level
    @AllArgsConstructor
    public static class Stu2{
        private String name;
        private String age;
    }

    @Data
    @Value
    @Accessors(chain = true, fluent = true)
    public static class Stu3{
        private String name;
        private String age;
    }

    @Builder
    @Data
    public static class Stu4{
        private String name;
        private String age;

        @Singular("addHobby")
        private List<String> hobby;

        public static void main(String[] args) {
            Stu4 hc = Stu4.builder().age("18").name("hc").addHobby("11").addHobby("22").build();
            System.out.println(hc);
        }

    }

    @Data
    @Accessors(chain = true, fluent = true) // 链式调用，直接用名字赋值
    @FieldNameConstants // 获取字段的原始名字
    public static class Stu5{
        private String name;
        private String age;

        public static void main(String[] args) {
            Stu5 stu5 = new Stu5();
            stu5.age("1").name("12");
            System.out.println(stu5);
        }
    }

    @Data
    @Accessors(chain = true, fluent = true) // 链式调用，直接用名字赋值
    @FieldNameConstants // 获取字段的原始名字
    public static class Stu6{
        private String name;
        private String age;

        public static void main(String[] args) {
            Stu6 stu6 = new Stu6();
            System.out.println(Fields.name);
            System.out.println(Fields.age);
        }
    }

    @SneakyThrows // 自动添加 try catch
    public void sleep(){
        TimeUnit.SECONDS.sleep(1);
    }

    @Synchronized // 自动添加同步方法
    public void Currency(){
    }

    public void copyFile(String in, String out) throws IOException {
        // 自动关闭
        @Cleanup FileInputStream inputStream = new FileInputStream(in);
        @Cleanup FileOutputStream outputStream = new FileOutputStream(out);

        byte[] b = new byte[65536];
        while (true) {
            int r = inputStream.read(b);
            if (r == -1) {
                break;
            }
            outputStream.write(b, 0, r);
        }

    }
}
